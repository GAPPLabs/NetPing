package com.gapp.netping.controller;

import com.gapp.netping.alert.Alert;
import com.gapp.netping.alert.system.ListenerAlert;
import com.gapp.netping.controller.util.Backend;
import com.gapp.netping.data.Data;
import com.gapp.netping.data.Host;
import com.gapp.netping.data.Language;
import com.gapp.netping.data.Setting;
import com.gapp.netping.data.listener.ListenerData;
import com.gapp.netping.data.listener.ListenerHost;
import com.gapp.netping.data.listener.ListenerSetting;
import com.gapp.netping.data.structure.Constants;
import com.gapp.netping.view.View;
import com.gapp.netping.view.controller.ControllerView;
import java.awt.AWTException;
import static java.awt.EventQueue.invokeLater;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller implements ListenerSetting, ListenerHost, ListenerAlert, ListenerData {

  private final Setting setting;
  private final Constants contants;
  private final Host host;
  private final Language language;
  private final Alert alert;
  
  private ControllerView controllerView;

  public Controller() throws IOException, FileNotFoundException, AWTException {
    this.setting = new Setting(this).readData();
    this.contants = new Data(this).readData().getData(this.setting.getData().getLanguage(), this.getSystem());
    this.host = new Host(this).readData();
    this.language = new Language(this).readData();
    this.alert = new Alert(setting.getData(), this).compile();
  }
  
  private String getSystem() {
    for (Backend backend : Backend.values()) {
      if (System.getProperty("os.name").contains(backend.getPlatform())) {
        return backend.getSystem();
      }
    }
    return null;
  }

  public Controller compile() {
    this.controllerView = new ControllerView(new View(), this.setting, this.contants, this.host, this.language, this.alert).compile();
    return this;
  }
  
  public void start() {
    invokeLater(() -> {
      this.controllerView.getView().setVisible(true);
    });
  }

  @Override
  public void saveDataSetting(Setting setting) {
    System.out.println("Hay cambios al guardar");
    this.controllerView.reloadHost();
    this.alert.compile();
  }

  @Override
  public void saveDataHost(Host host) {
    System.out.println("Hay cambios al guardar");
    this.controllerView.reloadHost();
    this.alert.compile();
  }

  @Override
  public void openApp() {
    if (!this.controllerView.getView().isVisible()) {
      this.controllerView.getView().setVisible(true);
    }
  }

  @Override
  public void closeApp() {
    System.exit(0);
  }

  @Override
  public void saveData(String identify) {
    System.out.println("Funcionaaaa " + identify);
    System.out.println("Hay cambios al guardar");
    this.controllerView.reloadHost();
    this.alert.compile();
  }
}
