package com.gapp.netping.data.structure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Text {
  
  @JsonProperty("test")
  private String test;

  public String getTest() {
    return test;
  }
}
