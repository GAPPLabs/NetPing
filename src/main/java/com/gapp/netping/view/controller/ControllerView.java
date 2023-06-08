package com.gapp.netping.view.controller;

import com.gapp.netping.alert.Alert;
import com.gapp.netping.data.Host;
import com.gapp.netping.data.Language;
import com.gapp.netping.data.Setting;
import com.gapp.netping.data.structure.Constants;
import com.gapp.netping.view.View;
import com.gapp.netping.view.util.About;
import com.gapp.netping.view.panel.Configure;
import com.gapp.netping.view.panel.Monitor;
import com.gapp.netping.view.panel.Network;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControllerView {

  private static final int ADMINISTER = 0;
  private static final int CONNECTION = 1;
  private static final int CONFIGURE = 2;

  private final View view;
  private final Setting setting;
  private final Constants contants;
  private final Host host;
  private final Language language;
  private final Alert alert;

  private final ControllerMonitor controllerMonitor;
  private final ControllerNetwork controllerNetwork;
  private final ControllerConfigure controllerSetting;
  private final ControllerAbout controllerAbout;

  public ControllerView(View view, Setting setting, Constants contants, Host host, Language language, Alert alert) {
    this.view = view;
    this.setting = setting;
    this.contants = contants;
    this.host = host;
    this.language = language;
    this.alert = alert;

    this.controllerMonitor = new ControllerMonitor(view, new Monitor(), setting.getData(), contants, host.getData(), alert).compile().addMonitors();
    this.controllerNetwork = new ControllerNetwork(view, new Network(), language, host).compile();
    this.controllerSetting = new ControllerConfigure(view, new Configure(), language, setting).compile();
    this.controllerAbout = new ControllerAbout(new About(this.view, true)).compile();
  }

  public ControllerView compile() {
    this.addListenersEvent();
    this.changeAction(ControllerView.ADMINISTER);
    this.view.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    this.addIconInterface();
    return this;
  }

  public View getView() {
    return view;
  }
  
  private void addIconInterface() {
    this.view.getIcon().setIcon(new ImageIcon("icon/icon.png"));
    this.view.getAdminister().setIcon(new ImageIcon("icon/monitor.png"));
    this.view.getConnection().setIcon(new ImageIcon("icon/connection.png"));
    this.view.getConfigure().setIcon(new ImageIcon("icon/configure.png"));
    this.view.getConnect().setIcon(new ImageIcon("icon/connectionOff.png"));
    this.view.getDisconnect().setIcon(new ImageIcon("icon/errorOff.png"));
    this.view.getExit().setIcon(new ImageIcon("icon/exit.png"));
    this.view.getAbout().setIcon(new ImageIcon("icon/about.png"));
    this.view.setIconImage(new ImageIcon("icon/iconDesktop.png").getImage());
  }

  private void addListenersEvent() {
    this.view.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e)  {
        view.dispose();
      }
    });
    
    this.view.getExit().addActionListener((ActionEvent e) -> {
      System.exit(0);
    });
    
    this.view.getAbout().addActionListener((ActionEvent e) -> {
      this.controllerAbout.showAbout();
    });

    this.view.getAdminister().addActionListener((ActionEvent e) -> {
      changeAction(ControllerView.ADMINISTER);
    });

    this.view.getConnection().addActionListener((ActionEvent e) -> {
      changeAction(ControllerView.CONNECTION);
    });

    this.view.getConfigure().addActionListener((ActionEvent e) -> {
      changeAction(ControllerView.CONFIGURE);
    });
  }

  public void reloadHost() {
    this.controllerMonitor.compile().addMonitors();
  }

  private void changeAction(int action) {
    JPanel panel = this.view.getPanelMain();
    panel.removeAll();
    panel.setLayout(new BorderLayout());
    switch (action) {
      case ControllerView.ADMINISTER -> {
        panel.add(controllerMonitor.getMonitor(), BorderLayout.CENTER);
      }
      case ControllerView.CONNECTION -> {
        panel.add(controllerNetwork.getNetwork(), BorderLayout.CENTER);
      }
      case ControllerView.CONFIGURE -> {
        panel.add(controllerSetting.getConfigure(), BorderLayout.CENTER);
      }
      default ->
        throw new AssertionError();
    }
    panel.revalidate();
    panel.repaint();
  }
}
