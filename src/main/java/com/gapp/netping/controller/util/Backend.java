package com.gapp.netping.controller.util;

public enum Backend {
  WINDOWS("Windows", "windows"),
  LINUX("Linux", "linux");
  
  private final String platform;
  private final String system;

  private Backend(String platform, String system) {
    this.platform = platform;
    this.system = system;
  }

  public String getPlatform() {
    return platform;
  }

  public String getSystem() {
    return system;
  }
}
