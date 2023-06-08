package com.gapp.netping.data.structure;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Constants {
  @JsonProperty("command")
  private String command;
  
  @JsonProperty("shipment")
  private String shipment;
  
  @JsonProperty("regex")
  private Regex regex;

  public String getCommand() {
    return this.command;
  }

  public String getShipment() {
    return this.shipment;
  }

  public Regex getRegex() {
    return this.regex;
  }
}
