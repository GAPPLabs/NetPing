package com.gapp.netping.data.listener;

import com.gapp.netping.data.Host;
import java.util.EventListener;

public interface ListenerHost extends EventListener {
  
  public void saveDataHost(Host host);
  
}
