package com.gapp.netping.data.structure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Params {
  
  @JsonProperty("language")
  private String language;

  @JsonProperty("path_sound")
  private String path_sound;

  @JsonProperty("repetead")
  private int repetead;

  public String getLanguage() {
    return language;
  }

  public String getPath_sound() {
    return path_sound;
  }

  public int getRepetead() {
    return repetead;
  }
}
