package com.gapp.netping.alert;

import com.gapp.netping.alert.system.ListenerAlert;
import com.gapp.netping.alert.system.Notification;
import com.gapp.netping.data.structure.Params;
import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Alert {
  
  private final Params setting;
  private final Notification notification;
  
  private Map<String, Long> times;
  
  public Alert(Params setting, ListenerAlert listener) throws FileNotFoundException, IOException, AWTException {
    this.setting = setting;
    this.notification = new Notification(setting).addListener(listener).compile().execute();
  }
  
  public Alert compile() {
    this.times = new HashMap<>();
    return this;
  }
  
  public void showAlert(String identify) {
    if (this.times.containsKey(identify)) {
      Long time = this.setting.getRepetead() * 1000L;
      Long elapsed = System.currentTimeMillis() - this.times.get(identify);
      System.out.println(time + " " + elapsed);
      if (elapsed > time) {
        this.times.put(identify, System.currentTimeMillis());
        this.notification.showNotification(identify);
      }
    } else {
      this.times.put(identify, System.currentTimeMillis());
      this.notification.showNotification(identify);
    }
  }
}
