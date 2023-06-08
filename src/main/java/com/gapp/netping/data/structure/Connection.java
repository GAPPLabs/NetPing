package com.gapp.netping.data.structure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Connection {
  
  @JsonProperty("host")
  private String host;

  @JsonProperty("shipments")
  private int shipments;

  @JsonProperty("extra")
  private String extra;
  
  @JsonProperty("intermittence")
  private long intermittence;
  
  @JsonProperty("patience")
  private int patience;
  
  @JsonProperty("metrics")
  private String [] metrics;
  
  @JsonProperty("enable")
  private boolean enable;
  
  @JsonProperty("notification")
  private boolean notification;
  
  @JsonProperty("sound")
  private boolean sound;

  public String getHost() {
    return host;
  }

  public int getShipments() {
    return shipments;
  }

  public String getExtra() {
    return extra;
  }

  public long getIntermittence() {
    return intermittence;
  }

  public int getPatience() {
    return patience;
  }

  public String[] getMetrics() {
    return metrics;
  }

  public boolean isEnable() {
    return enable;
  }

  public boolean isNotification() {
    return notification;
  }

  public boolean isSound() {
    return sound;
  }
}
