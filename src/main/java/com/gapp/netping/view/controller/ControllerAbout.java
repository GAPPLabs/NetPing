package com.gapp.netping.view.controller;

import com.gapp.netping.view.util.About;
import javax.swing.ImageIcon;

public class ControllerAbout {
  
  private final About about;

  public ControllerAbout(About about) {
    this.about = about;
  }
  
  public ControllerAbout compile() {
    this.about.getLogo().setIcon(new ImageIcon("icon/logo.png"));
    return this;
  }
  
  public void showAbout() {
    this.about.setVisible(true);
  }
}
