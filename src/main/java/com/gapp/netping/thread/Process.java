package com.gapp.netping.thread;

import com.gapp.netping.core.Command;
import com.gapp.netping.core.util.Request;
import java.io.IOException;

public class Process extends Thread {

  private final Command command;
  private final String identify;
  private final String host;
  private final int shipments;
  private final String extra;
  private final long intermittence;

  private Request request;
  private Listener listener;
  private boolean run = false;

  public Process(Command command, String identify, String host, int shipments, String extra, long intermittence) {
    this.command = command;
    this.identify = identify;
    this.host = host;
    this.shipments = shipments;
    this.extra = extra;
    this.intermittence = intermittence;
  }

  @Override
  public void run() {
    while (run) {
      try {
        request = command.isReachable(host, shipments, extra);
        listener.generateRequest(this);
        Thread.sleep(intermittence);
      } catch (IOException | InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }
  
  public void startProcess() {
    this.run = true;
    this.start();
  }
  
  public void stopProcess() {
    this.run = false;
  }
  
  public Process addListener(Listener listener) {
    this.listener = listener;
    return this;
  }
  
  public boolean isRun() {
    return this.run;
  }

  public String getIdentify() {
    return identify;
  }

  public Request getRequest() {
    return this.request;
  }
}
