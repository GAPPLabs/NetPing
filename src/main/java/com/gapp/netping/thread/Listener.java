package com.gapp.netping.thread;

import java.util.EventListener;

public interface Listener extends EventListener {
  
  public void generateRequest(Process process);
  
  public void eventPatienceConnect(Process process);
  
  public void startProcess(Process process);
  
  public void stopProcess(Process process);
  
}
