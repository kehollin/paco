package com.google.android.apps.paco;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import android.content.Context;
import android.util.Log;

import com.google.paco.shared.comm.Outcome;
import com.google.paco.shared.model2.EventStore;
import com.google.paco.shared.model2.JsonConverter;
import com.pacoapp.paco.net.NetworkClient;
import com.pacoapp.paco.net.PacoBackgroundService;

public class EventUploader {

  private static final int UPLOAD_EVENT_GROUP_SIZE = 50;

  private EventStore eventStore;
  private String serverAddress;

  private Context context;

  public EventUploader(Context context, String serverAddress,
                       EventStore eventStore) {
    this.context = context;
    this.eventStore = eventStore;
    this.serverAddress = serverAddress;
  }

  public void uploadEvents(List<Event> allEvents) {
    if (allEvents.size() == 0) {
      Log.d(PacoConstants.TAG, "Nothing to sync");
      return;
    }
    boolean hasErrorOcurred = false;
    Log.d(PacoConstants.TAG, "Tasks found in db");

    int uploadGroupSize = UPLOAD_EVENT_GROUP_SIZE;
    int uploaded = 0;
    while (uploaded < allEvents.size() && !hasErrorOcurred) {
      int groupSize = Math.min(allEvents.size() - uploaded, uploadGroupSize);
      int end = uploaded + groupSize;
      List<Event> events = allEvents.subList(uploaded, end);
      ResponsePair response = sendToPaco(events);
      switch (response.overallCode) {
      case 200:
        final List<Outcome> outcomes = response.outcomes;
        markEventsAccordingToOutcomes(events, outcomes);
        uploaded = end;
        break;
      default:
        hasErrorOcurred = true;
        break;
      }
    }

    if (!hasErrorOcurred) {
      Log.d(PacoConstants.TAG, "syncing complete");
    } else {
      Log.d(PacoConstants.TAG, "could not complete upload of events");
    }
  }

  public void markEventsAccordingToOutcomes(List<Event> events, final List<Outcome> outcomes) {
    for (int i = 0; i < outcomes.size(); i++) {
      Outcome currentOutcome = outcomes.get(i);
      if (currentOutcome.succeeded()) {
        Event correspondingEvent = events.get((int) currentOutcome.getEventId());
        correspondingEvent.setUploaded(true);
        eventStore.updateEvent(correspondingEvent);
      }
    }
  }

  private static class ResponsePair {
    int overallCode;
    List<Outcome> outcomes;
  }

  private ResponsePair sendToPaco(List<Event> events) {
    final ResponsePair responsePair = new ResponsePair();

    String json = toJson(events, responsePair);
    if (responsePair.overallCode == 500) {
      return responsePair;
    }

    final CountDownLatch latch = new CountDownLatch(1);
    NetworkClient networkClient = new NetworkClient.BackgroundNetworkClient(context) {
      @Override
      public void showAndFinish(String msg) {
        if (msg != null) {
          responsePair.overallCode = 200;
          readOutcomesFromJson(responsePair, msg);
          latch.countDown();
        } else {
          responsePair.overallCode = 500;
        }
      }

    };

    Log.i("" + this, "Preparing to post.");
    final String completeServerUrl = ServerAddressBuilder.createServerUrl(serverAddress, "/events");
    new PacoBackgroundService(networkClient, completeServerUrl, json).execute()  ;

    try {
      latch.await();
    } catch (InterruptedException e) {
      Log.e(PacoConstants.TAG, "exception waiting for post of events", e);
      responsePair.overallCode = 500;
    }
    return responsePair;
  }

  private void readOutcomesFromJson(ResponsePair responsePair, String contentAsString) {
    if (contentAsString != null) {
      ObjectMapper mapper2 = JsonConverter.getObjectMapper();
      try {
        responsePair.outcomes = mapper2.readValue(contentAsString, new TypeReference<List<Outcome>>() {});
      } catch (JsonParseException e) {
        Log.e(PacoConstants.TAG, e.getMessage(), e);
        responsePair.overallCode = 500;
      } catch (JsonMappingException e) {
        Log.e(PacoConstants.TAG, e.getMessage(), e);
        responsePair.overallCode = 500;
      } catch (IOException e) {
        Log.e(PacoConstants.TAG, e.getMessage(), e);
        responsePair.overallCode = 500;
      }
    }
  }

  private String toJson(List<Event> events, ResponsePair responsePair) {
    ObjectMapper mapper = JsonConverter.getObjectMapper();
    StringWriter stringWriter = new StringWriter();
    Log.d(PacoConstants.TAG, "syncing events");
    try {
      mapper.writeValue(stringWriter, events);
    } catch (JsonGenerationException e) {
      Log.e(PacoConstants.TAG, e.getMessage(), e);
      responsePair.overallCode = 500;
    } catch (JsonMappingException e) {
      Log.e(PacoConstants.TAG, e.getMessage(), e);
      responsePair.overallCode = 500;
    } catch (IOException e) {
      Log.e(PacoConstants.TAG, e.getMessage(), e);
      responsePair.overallCode = 500;
    }
    return stringWriter.toString();
  }

}
