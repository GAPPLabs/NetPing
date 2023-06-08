package com.gapp.netping.core.util;

import java.util.Map;

public class Request {
  
  private final String command;
  private final boolean connect;
  private final Map<String, Double> data;

  public Request(String command, boolean connect, Map<String, Double> data) {
    this.command = command;
    this.connect = connect;
    this.data = data;
  }

  public String getCommand() {
    return this.command;
  }

  public boolean isConnect() {
    return this.connect;
  }

  public Map<String, Double> getData() {
    return this.data;
  }
  
  public void printData() {
    System.out.println(this.command);
    System.out.println(this.connect);
    
    for (Map.Entry<String, Double> entry : this.data.entrySet()) {
      String clave = entry.getKey();
      Double valor = entry.getValue();
      System.out.println("Clave: " + clave + ", Valor: " + valor);
    }
  }
}
