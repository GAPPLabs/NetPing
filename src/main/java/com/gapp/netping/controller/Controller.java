package com.gapp.netping.controller;

import com.gapp.netping.controller.util.Backend;
import com.gapp.netping.core.Command;
import com.gapp.netping.data.Data;
import com.gapp.netping.data.Host;
import com.gapp.netping.data.Setting;
import com.gapp.netping.thread.Process;
import com.gapp.netping.data.structure.Connection;
import com.gapp.netping.data.structure.Constants;
import com.gapp.netping.data.structure.Params;
import com.gapp.netping.thread.Listener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Controller {

  private final Params setting;
  private final Constants contants;
  private final Map<String, Connection> host;
  private final Listener listener;

  private List<Process> listProcess;

  public Controller(Listener listener) throws IOException {
    String system = this.getSystem();
    this.setting = new Setting().compile().getData();
    this.contants = new Data().compile().getData(this.setting.getLanguage(), system);
    this.host = new Host().compile().getData();
    this.listProcess = new ArrayList<>();
    this.listener = listener;
  }

  public Controller compile() {
    if (this.listProcess.isEmpty()) {
      this.enlistHost();
    } else {
      this.actionConnections("stop").enlistHost();
    }
    return this;
  }

  public Controller actionConnections(String action) {
    for (Process process : this.listProcess) {
      if (this.host.get(process.getIdentify()).isEnable()) {
        switch (action) {
          case "run" -> {
            process.startProcess();
          }
          case "stop" -> {
            process.stopProcess();
          }
          default ->
            throw new AssertionError();
        }
      }
    }
    return this;
  }

  private Controller enlistHost() {
    this.listProcess = new LinkedList<Process>() {{
      for (Map.Entry<String, Connection> entry : host.entrySet()) {
        add(createProcess(entry.getKey(), entry.getValue()));
      }
    }};
    return this;
  }

  private Process createProcess(String identify, Connection connect) {
    Command command = new Command(contants, connect.getMetrics());
    return new Process(command, identify, connect.getHost(), connect.getShipments(), connect.getExtra(), connect.getIntermittence()).addListener(listener);
  }

  private String getSystem() {
    for (Backend backend : Backend.values()) {
      if (System.getProperty("os.name").contains(backend.getPlatform())) {
        return backend.getSystem();
      }
    }
    return null;
  }

//  public static void main(String[] args) {
//    try {
//      Controller ab = new Controller().compile();
//      ab.actionConnections("run");
//    } catch (IOException ex) {
//      Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//    }
//  }
}
