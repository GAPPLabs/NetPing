package com.gapp.netping.alert.system;

import com.gapp.netping.data.structure.Params;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import javax.swing.ImageIcon;
import javazoom.jl.decoder.JavaLayerException;

public class Notification {

  private final Params setting;

  private ListenerAlert listener;
  private SystemTray tray;
  private TrayIcon trayIcon;
  private PopupMenu menu;
  private Image image;

  public Notification(Params setting) {
    this.setting = setting;
  }

  public Notification addListener(ListenerAlert listener) {
    this.listener = listener;
    return this;
  }

  public Notification compile() throws IOException {
    this.tray = SystemTray.getSystemTray();
    this.menu = this.createMenu();
    this.image = new ImageIcon("icon/iconDesktop.png").getImage();
    return this;
  }

  public Notification execute() throws AWTException {
    this.trayIcon = new TrayIcon(this.image, "NetPing", this.menu);
    this.trayIcon.setImageAutoSize(true);
    this.tray.add(this.trayIcon);
    this.trayIcon.displayMessage("NetPing", "Bienvenido a NetPing", MessageType.INFO);
    return this;
  }
  public void showNotification(String identify) {
    Runnable runnable = () -> {
      try {
        this.trayIcon.displayMessage("NetPing", "Desconexión de " + identify, MessageType.ERROR);
        if (this.setting.isEnableSound()) {
          new Sound(this.setting).compile().playSound();
        }
      } catch (JavaLayerException | IOException ex) {
        ex.printStackTrace();
      }
    };
    new Thread(runnable).start();
  }

  private PopupMenu createMenu() {
    MenuItem menuOpen = new MenuItem("Abrir aplicación");
    MenuItem menuClose = new MenuItem("Cerrar aplicación");
    menuOpen.addActionListener((ActionEvent e) -> {
      this.listener.openApp();
    });
    menuClose.addActionListener((ActionEvent e) -> {
      this.listener.closeApp();
    });
    return new PopupMenu() {
      {
        add(menuOpen);
        add(menuClose);
      }
    };
  }
}
