// Copyright 2012 Google Inc. All Rights Reserved.

package com.google.sampling.experiential.shared;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

/**
 * @author corycornelius@google.com (Cory Cornelius)
 *
 */
@JsonTypeName("likert")
public class LikertInput extends Input {
  public static final Integer DEFAULT_STEPS = 5;

  private String question;
  private List<String> labels;
  private boolean smileys;

  /**
   *
   */
  public LikertInput() {
    super(Input.LIKERT);
  }

  /**
   * @param name
   * @param required
   * @param conditionalExpression
   * @param question
   * @param labels
   * @param smileys
   */
  public LikertInput(String name,
      boolean required,
      String conditionalExpression,
      String question,
      List<String> labels,
      boolean smileys) {
    super(name, Input.LIKERT, required, conditionalExpression);
    this.question = question;
    this.labels = labels;
    this.smileys = smileys;
  }

  /**
   * @return the question
   */
  public String getQuestion() {
    return question;
  }

  /**
   * @param question the question to set
   */
  public void setQuestion(String question) {
    this.question = question;
  }

  /**
   * @return the labels
   */
  public List<String> getLabels() {
    return labels;
  }

  /**
   * @param labels the labels to set
   */
  public void setLabels(List<String> labels) {
    this.labels = labels;
  }

  /**
   * @return the useSmileys
   */
  public boolean isSmileys() {
    return smileys;
  }

  /**
   * @param smileys the useSmileys to set
   */
  public void setSmileys(boolean smileys) {
    this.smileys = smileys;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.google.sampling.experiential.shared.Input#equals(java.lang.Object)
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

    LikertInput other = (LikertInput) obj;

    if (getQuestion().equals(other.getQuestion()) == false) {
      return false;
    }

    if (isSmileys() != other.isSmileys()) {
      return false;
    }

    if (getLabels() == null) {
      if (other.getLabels() != null) {
        return false;
      }
    } else {
      if (getLabels().equals(other.getLabels()) == false) {
        return false;
      }
    }

    return super.equals(obj);
  }
}