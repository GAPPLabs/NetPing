package com.gapp.netping.data.listener;

import com.gapp.netping.data.Setting;
import java.util.EventListener;

public interface ListenerSetting extends EventListener {
  
  public void saveDataSetting(Setting setting);
  
}
