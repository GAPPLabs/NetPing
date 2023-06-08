package com.gapp.netping.data.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedHashMap;
import java.util.Map;

public class Regex {

  @JsonProperty("bytes")
  private String bytes;

  @JsonProperty("times")
  private String times;

  @JsonProperty("ttfs")
  private String ttfs;

  public String getBytes() {
    return this.bytes;
  }

  public String getTimes() {
    return this.times;
  }

  public String getTtfs() {
    return this.ttfs;
  }

  public Map<String, String> getRegexs() {
    return new LinkedHashMap<String, String>() {{
      put("bytes", bytes);
      put("times", times);
      put("ttfs", ttfs);
    }};
  }
}
