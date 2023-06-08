package com.gapp.netping;

import com.gapp.netping.controller.Controller;
import java.awt.AWTException;
import java.io.IOException;

public class App {
  public static void main(String[] args) {
    try {
      Controller controller = new Controller().compile();
      controller.start();
    } catch (IOException | AWTException ex) {
      ex.printStackTrace();
    }
  }
}
