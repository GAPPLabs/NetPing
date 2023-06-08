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
  private final int patience;
  private final boolean notification;

  private Request request;
  private Listener listener;
  private boolean run = false;
  private int countPatience;

  public Process(Command command, String identify, String host, int shipments, String extra, long intermittence, int patience, boolean notification) {
    this.command = command;
    this.identify = identify;
    this.host = host;
    this.shipments = shipments;
    this.extra = extra;
    this.intermittence = intermittence;
    this.patience = patience;
    this.notification = notification;
  }

  @Override
  public void run() {
    this.listener.startProcess(this);
    while (run) {
      try {
        this.request = this.command.isReachable(this.host, this.shipments, this.extra);
        this.listenerEvent();
        Thread.sleep(this.intermittence);
      } catch (IOException | InterruptedException ex) {
        ex.printStackTrace();
      }
    }
    this.listener.stopProcess(this);
  }
  
  private void listenerEvent() {
    if (this.request.isConnect()) {
      this.countPatience = 0;
    } else {
      if (this.notification) {
        if (this.countPatience == this.patience) {
          this.listener.eventPatienceConnect(this);
        } else {
          this.countPatience ++;
        }
      }
    }
    this.listener.generateRequest(this);
  }
  
  public void startProcess() {
    this.run = true;
    this.countPatience = 0;
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
