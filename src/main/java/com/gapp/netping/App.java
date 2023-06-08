package com.gapp.netping;

import com.gapp.netping.controller.Controller;
import com.gapp.netping.thread.Listener;
import com.gapp.netping.thread.Process;
import java.io.IOException;

public class App implements Listener {

  @Override
  public void generateRequest(Process process) {
    System.out.println(process.getIdentify());
    process.getRequest().printData();
    System.out.println("-------------------");
  }

  public static void main(String[] args) {
    try {
      App app = new App();
      Controller controller = new Controller(app).compile();
      controller.actionConnections("run");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
