package com.gapp.netping.view.controller;

import com.gapp.netping.alert.Alert;
import com.gapp.netping.core.Command;
import com.gapp.netping.data.structure.Connection;
import com.gapp.netping.data.structure.Constants;
import com.gapp.netping.data.structure.Params;
import com.gapp.netping.thread.Listener;
import com.gapp.netping.thread.Process;
import com.gapp.netping.view.View;
import com.gapp.netping.view.panel.Monitor;
import com.gapp.netping.view.panel.util.Metric;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import org.apache.commons.lang3.tuple.Pair;

public class ControllerMonitor implements Listener {

  private static final int RUN = 0;
  private static final int UPDATE = 1;
  private static final int STOP = 2;
  private static final int FORCE = 3;

  private final View view;
  private final Monitor monitor;
  private final Params setting;
  private final Constants contants;
  private final Map<String, Connection> host;
  private final Alert alert;
  
  private boolean resume;

  Map<String, Pair<Process, ControllerMetric>> listMonitor;

  public ControllerMonitor(View view, Monitor monitor, Params setting, Constants contants, Map<String, Connection> host, Alert alert) {
    this.view = view;
    this.monitor = monitor;
    this.setting = setting;
    this.contants = contants;
    this.host = host;
    this.alert = alert;
    this.resume = false;
  }

  public ControllerMonitor compile() {
    if (this.listMonitor == null || this.listMonitor.isEmpty()) {
      this.enlistConnections();
      this.addListenersEvent();
    } else {
      this.actionConnections(ControllerMonitor.FORCE);
      this.eventButton(false);
      this.enlistConnections();
      this.resume = false;
    }
    return this;
  }

  public ControllerMonitor actionConnections(int action) {
    if (action == ControllerMonitor.UPDATE) {
      this.updateMonitors();
      this.actionConnections(ControllerMonitor.RUN);
    } else {
      for (Pair<Process, ControllerMetric> monitor : this.listMonitor.values()) {
        switch (action) {
          case ControllerMonitor.RUN -> {
            monitor.getLeft().startProcess();
          }
          case ControllerMonitor.STOP -> {
            monitor.getLeft().stopProcess();
          }
          case ControllerMonitor.FORCE -> {
            monitor.getLeft().stop();
          }
          default ->
            throw new AssertionError();
        }
      }
      if (action == ControllerMonitor.STOP) {
        this.view.getEventConnection().setText("En espera");
        this.resetIndicatorColor();
      }
      if (action == ControllerMonitor.FORCE) {
        this.view.getEventConnection().setText("Reiniciado");
        this.resetIndicatorColor();
      }
    }

    return this;
  }

  public ControllerMonitor addMonitors() {
    JTabbedPane tabbed = this.monitor.getTabbed();
    if (tabbed.getTabCount() > 0) {
      tabbed.removeAll();
    }
    for (Map.Entry<String, Pair<Process, ControllerMetric>> entry : listMonitor.entrySet()) {
      tabbed.addTab(entry.getKey(), entry.getValue().getRight().getMetric());
    }
    tabbed.repaint();
    return this;
  }

  private void updateMonitors() {
    for (String identify : this.listMonitor.keySet()) {
      ControllerMetric controller = this.listMonitor.get(identify).getRight();
      Connection connection = this.host.get(identify);
      this.listMonitor.put(identify, this.updateMonitor(controller, identify, connection));
    }
  }

  public Monitor getMonitor() {
    return monitor;
  }

  private void addListenersEvent() {
    this.monitor.getStart().addActionListener((ActionEvent e) -> {
      this.actionConnections(this.resume ? ControllerMonitor.UPDATE : ControllerMonitor.RUN);
      this.eventButton(true);
      this.resume = false;
    });

    this.monitor.getStop().addActionListener((ActionEvent e) -> {
      this.actionConnections(ControllerMonitor.STOP);
      this.eventButton(false);
      this.resume = true;
    });
  }
  
  private void eventButton(boolean start) {
    this.monitor.getStart().setEnabled(!start);
    this.monitor.getStop().setEnabled(start);
  }

  private void enlistConnections() {
    this.listMonitor = new LinkedHashMap<String, Pair<Process, ControllerMetric>>() {{
      for (Map.Entry<String, Connection> entry : host.entrySet()) {
        if (entry.getValue().isEnable()) {
          put(entry.getKey(), createMonitor(entry.getKey(), entry.getValue()));
        }
      }
    }};
  }

  private Pair<Process, ControllerMetric> createMonitor(String identify, Connection connect) {
    Process process = new Process(
            new Command(this.contants, connect.getMetrics()),
            identify,
            connect.getHost(),
            connect.getShipments(),
            connect.getExtra(),
            connect.getIntermittence(),
            connect.getPatience(),
            connect.isNotification()
    ).addListener(this);
    ControllerMetric controller = new ControllerMetric(new Metric()).compile().settingData(
            connect.getHost(),
            connect.getShipments(),
            connect.getIntermittence(),
            connect.getMetrics(),
            connect.getMetricUse(),
            this.setting.getHistory()
    );
    return Pair.of(process, controller);
  }

  private Pair<Process, ControllerMetric> updateMonitor(ControllerMetric controller, String identify, Connection connect) {
    Process process = new Process(
            new Command(this.contants, connect.getMetrics()),
            identify,
            connect.getHost(),
            connect.getShipments(),
            connect.getExtra(),
            connect.getIntermittence(),
            connect.getPatience(),
            connect.isNotification()
    ).addListener(this);
    return Pair.of(process, controller);
  }
  
  private void actionIndicatorColor(boolean connect) {    
    this.view.getConnect().setIcon(new ImageIcon("icon/connection" + (connect ? "On" : "Off") +".png"));
    this.view.getDisconnect().setIcon(new ImageIcon("icon/error" + (!connect ? "On" : "Off") + ".png"));
  }
  
  private void resetIndicatorColor() {
    this.view.getConnect().setIcon(new ImageIcon("icon/connectionOff.png"));
    this.view.getDisconnect().setIcon(new ImageIcon("icon/errorOff.png"));
  }

  @Override
  public void generateRequest(Process process) {
    ControllerMetric controller = this.listMonitor.get(process.getIdentify()).getRight();
    controller.processingData(process.getRequest());
    if (process.getRequest().isConnect()) {
      this.actionIndicatorColor(true);
      if (!this.resume) {
        this.view.getEventConnection().setText(process.getIdentify());
      }
    }
  }

  @Override
  public void eventPatienceConnect(Process process) {
    System.out.println("Error de " + process.getIdentify());
    this.alert.showAlert(process.getIdentify());
    this.actionIndicatorColor(false);
    if (!this.resume) {
      this.view.getEventConnection().setText(process.getIdentify());
    }
  }
  
  @Override
  public void startProcess(Process process) {
    ControllerMetric controller = this.listMonitor.get(process.getIdentify()).getRight();
    controller.changeStatus("Iniciando");
  }
  
  @Override
  public void stopProcess(Process process) {
    ControllerMetric controller = this.listMonitor.get(process.getIdentify()).getRight();
    controller.changeStatus("Detenido");
    this.resetIndicatorColor();
  }
}
