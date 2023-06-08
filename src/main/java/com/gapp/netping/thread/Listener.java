package com.gapp.netping.thread;

import java.util.EventListener;

public interface Listener extends EventListener {
  
  public void generateRequest(Process process);
  
}
