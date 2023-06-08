package com.gapp.netping.data.structure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Params {
  
  @JsonProperty("language")
  private String language;
  
  @JsonProperty("history")
  private int history;
  
  @JsonProperty("enable_sound")
  private boolean enableSound;
  
  @JsonProperty("custom_sound")
  private boolean customSound;

  @JsonProperty("path_sound")
  private String pathSound;

  @JsonProperty("repetead")
  private int repetead;

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public int getHistory() {
    return history;
  }

  public void setHistory(int history) {
    this.history = history;
  }

  public boolean isEnableSound() {
    return enableSound;
  }

  public void setEnableSound(boolean enableSound) {
    this.enableSound = enableSound;
  }

  public boolean isCustomSound() {
    return customSound;
  }

  public void setCustomSound(boolean customSound) {
    this.customSound = customSound;
  }

  public String getPathSound() {
    return pathSound;
  }

  public void setPathSound(String pathSound) {
    this.pathSound = pathSound;
  }

  public int getRepetead() {
    return repetead;
  }

  public void setRepetead(int repetead) {
    this.repetead = repetead;
  }
  
}
