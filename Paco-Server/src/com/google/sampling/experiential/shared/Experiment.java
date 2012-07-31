/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
// Copyright 2010 Google Inc. All Rights Reserved.

package com.google.sampling.experiential.shared;

import com.google.common.collect.Lists;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import java.io.Serializable;
import java.util.List;

/**
 *
 * Definition of an Experiment (a tracker). This holds together a bunch of objects: * A list of
 * Input objects which are the data that will be gathered. Usually it is questions, but it could be
 * sensors as well (photos, audio, gps, accelerometer, compass, etc..) * A list of Feedback objects
 * that presents visualizations or interventions to the user. * A SignalSchedule object which
 * contains the frequency to gather data.
 *
 * @author Bob Evans
 *
 */
public class Experiment implements Serializable {
  private static String DEFAULT_TITLE = "";
  private static String DEFAULT_DESCRIPTION = "";
  private static String DEFAULT_CREATOR = "Unknown";
  private static String DEFAULT_CONSENT_FORM = "";

  private String title;
  private String description;
  private String creator;
  private String consentForm;
  @JsonIgnore
  private long version;
  @JsonIgnore
  private boolean published;
  @JsonIgnore
  private boolean deleted;
  @JsonIgnore
  private List<String> observers;
  @JsonIgnore
  private List<String> subjects;
  private List<Input> inputs;
  private SignalSchedule schedule;
  private List<Feedback> feedbacks;

  /**
   *
   */
  public Experiment() {
    super();

    this.subjects = Lists.newArrayList();
    this.observers = Lists.newArrayList();
    this.inputs = Lists.newArrayList();
    this.schedule = new SignalSchedule();
    this.feedbacks = Lists.newArrayList();
  }

  /**
   * @param version
   * @param title
   * @param description
   * @param consent
   * @param published
   * @param deleted
   * @param observers
   * @param subjects
   * @param inputs
   * @param schedule
   * @param feedbacks
   */
  public Experiment(long version,
      String title,
      String description,
      String consent,
      boolean published,
      boolean deleted,
      List<String> observers,
      List<String> subjects,
      List<Input> inputs,
      SignalSchedule schedule,
      List<Feedback> feedbacks) {
    super();
    this.version = version;
    this.title = title;
    this.description = description;
    this.consentForm = consent;
    this.published = published;
    this.deleted = deleted;
    this.observers = observers;
    this.subjects = subjects;
    this.inputs = inputs;
    this.schedule = schedule;
    this.feedbacks = feedbacks;
  }

  /**
   * @param version
   */
  public void setVersion(long version) {
    this.version = version;
  }

  /**
   * @return the version
   */
  public long getVersion() {
    return version;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    if (title == null) {
      this.title = DEFAULT_TITLE;
    } else {
      this.title = title;
    }
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    if (description == null) {
      this.description = DEFAULT_DESCRIPTION;
    } else {
      this.description = description;
    }
  }

  /**
   * @return the creator
   */
  public String getCreator() {
    return creator;
  }

  /**
   * @param creator the creator to set
   */
  public void setCreator(String creator) {
    if (creator == null) {
      this.creator = DEFAULT_CREATOR;
    } else {
      this.creator = creator;
    }
  }

  /**
   * @return the consentForm
   */
  public String getConsentForm() {
    return consentForm;
  }

  /**
   * @param consentForm the consent to set
   */
  public void setConsentForm(String consentForm) {
    if (consentForm == null) {
      this.consentForm = DEFAULT_CONSENT_FORM;
    } else {
      this.consentForm = consentForm;
    }
  }

  /**
   * @return whether the experiment is published
   */
  public boolean isPublished() {
    return published;
  }

  /**
   * @param published whether the experiment is published
   */
  public void setPublished(boolean published) {
    this.published = published;
  }

  /**
   * @return the deleted
   */
  public boolean isDeleted() {
    return deleted;
  }

  /**
   * @param deleted the deleted to set
   */
  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  /**
   * @return the observers
   */
  public List<String> getObservers() {
    return observers;
  }

  /**
   * @param observers the observers to set
   */
  public void setObservers(List<String> observers) {
    if (observers == null) {
      this.observers = Lists.newArrayList();
    } else {
      this.observers = observers;
    }
  }

  /**
   * @return the subjects
   */
  public List<String> getSubjects() {
    return subjects;
  }

  /**
   * @param subjects the subjects to set
   */
  public void setSubjects(List<String> subjects) {
    if (subjects == null) {
      this.subjects = Lists.newArrayList();
    } else {
      this.subjects = subjects;
    }
  }

  /**
   * @return the inputs
   */
  public List<Input> getInputs() {
    return inputs;
  }

  /**
   * @param inputs the inputs to set
   */
  public void setInputs(List<Input> inputs) {
    if (inputs == null) {
      this.inputs = Lists.newArrayList();
    } else {
      this.inputs = inputs;
    }
  }

  /**
   * @return the schedule
   */
  public SignalSchedule getSchedule() {
    return schedule;
  }

  /**
   * @param schedule the schedule to set
   */
  public void setSchedule(SignalSchedule schedule) {
    if (schedule == null) {
      this.schedule = new SignalSchedule();
    } else {
      this.schedule = schedule;
    }
  }

  /**
   * @return the feedbacks
   */
  public List<Feedback> getFeedbacks() {
    return feedbacks;
  }

  /**
   * @param feedbacks the feedbacks to set
   */
  public void setFeedbacks(List<Feedback> feedbacks) {
    if (feedbacks == null) {
      this.feedbacks = Lists.newArrayList();
    } else {
      this.feedbacks = feedbacks;
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (obj.getClass() != getClass()) {
      return false;
    }

    Experiment other = (Experiment) obj;

    if (getTitle().equals(other.getTitle()) == false) {
      return false;
    }

    if (getDescription().equals(other.getDescription()) == false) {
      return false;
    }

    if (getCreator().equals(other.getCreator()) == false) {
      return false;
    }

    if (getConsentForm().equals(other.getConsentForm()) == false) {
      return false;
    }

    if (getVersion() != other.getVersion()) {
      return false;
    }

    if (isPublished() != other.isPublished()) {
      return false;
    }

    if (isDeleted() != other.isDeleted()) {
      return false;
    }

    if (getObservers().equals(other.getObservers()) == false) {
      return false;
    }

    if (getSubjects().equals(other.getSubjects()) == false) {
      return false;
    }

    if (getInputs().equals(other.getInputs()) == false) {
      return false;
    }

    if (getSchedule().equals(other.getSchedule()) == false) {
      return false;
    }

    if (getFeedbacks().equals(other.getFeedbacks()) == false) {
      return false;
    }

    return true;
  }
}