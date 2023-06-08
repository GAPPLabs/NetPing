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
  
  @JsonProperty("metric_use")
  private String metricUse;
  
  @JsonProperty("enable")
  private boolean enable;
  
  @JsonProperty("notification")
  private boolean notification;

  public String getHost() {
    return this.host;
  }

  public int getShipments() {
    return this.shipments;
  }

  public String getExtra() {
    return this.extra;
  }

  public long getIntermittence() {
    return this.intermittence;
  }

  public int getPatience() {
    return this.patience;
  }

  public String[] getMetrics() {
    return this.metrics;
  }
  
  public String getMetricUse() {
    return this.metricUse;
  }

  public boolean isEnable() {
    return this.enable;
  }

  public boolean isNotification() {
    return notification;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public void setShipments(int shipments) {
    this.shipments = shipments;
  }

  public void setExtra(String extra) {
    this.extra = extra;
  }

  public void setIntermittence(long intermittence) {
    this.intermittence = intermittence;
  }

  public void setPatience(int patience) {
    this.patience = patience;
  }

  public void setMetrics(String[] metrics) {
    this.metrics = metrics;
  }
  
  public void setMetricUse(String metricUse) {
    this.metricUse = metricUse;
  }
  
  public void setEnable(boolean enable) {
    this.enable = enable;
  }

  public void setNotification(boolean notification) {
    this.notification = notification;
  }
  
}
