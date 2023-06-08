package com.gapp.netping.view.controller;

import com.gapp.netping.data.Language;
import com.gapp.netping.data.Setting;
import com.gapp.netping.view.View;
import com.gapp.netping.view.panel.Configure;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControllerConfigure {
  
  private final View view;
  private final Configure configure;
  
  private final Language language;
  private final Setting setting;

  public ControllerConfigure(View view, Configure configure, Language language, Setting setting) {
    this.view = view;
    this.configure = configure;
    this.language = language;
    this.setting = setting;
  }
  
  public ControllerConfigure compile() {
    initConfigure();
    addListenersEvent();
    return this;
  }
  
  private void initConfigure() {
    String [] languages = this.language.getLanguages().toArray(String[]::new);
    this.configure.getLanguage().setModel(new DefaultComboBoxModel<>(languages));
    this.configure.getLanguage().setSelectedItem(this.setting.getData().getLanguage());
    this.configure.getHistory().setValue(this.setting.getData().getHistory());
    this.configure.getRepeat().setValue(this.setting.getData().getRepetead());
    this.configure.getEnableSound().setSelectedIndex(this.setting.getData().isEnableSound() ? 0 : 1);
    
    if (this.setting.getData().isCustomSound()) {
      this.configure.getCustomAudio().setSelected(true);
      this.configure.getPath().setText(this.setting.getData().getPathSound());
    } else {
      this.configure.getDefaultAudio().setSelected(true);
      this.configure.getPath().setText("");
    }
  }
  
  private void addListenersEvent() {
    this.configure.getDefaultAudio().addActionListener((ActionEvent evt) -> {
      this.configure.getPath().setText("");
    });
    
    this.configure.getCustomAudio().addActionListener((ActionEvent evt) -> {
      String path = this.selectionFile();
      if (path != null) {
        this.configure.getPath().setText(path);
      }
    });
    
    this.configure.getAccept().addActionListener((ActionEvent e) -> {
      this.saveSetting();
    });

    this.configure.getCancel().addActionListener((ActionEvent e) -> {
      this.initConfigure();
    });
  }
  
  private void saveSetting() {
    String title = "Advertencia de guardado:";
    String message = "Se reiniciarán los monitoreos actuales ¿Continuar?";
    int option = JOptionPane.showConfirmDialog(this.view, message, title, JOptionPane.YES_NO_OPTION);
    if (option == JOptionPane.YES_OPTION) {
      this.setting.getData().setLanguage((String) this.configure.getLanguage().getSelectedItem());
      this.setting.getData().setRepetead((int) this.configure.getRepeat().getValue());
      this.setting.getData().setHistory((int) this.configure.getHistory().getValue());
      this.setting.getData().setEnableSound(this.configure.getEnableSound().getSelectedIndex() == 0);

      if (this.configure.getDefaultAudio().isSelected()) {
        this.setting.getData().setCustomSound(false);
        this.setting.getData().setPathSound("sound/notifications.mp3");
      } else {
        this.setting.getData().setCustomSound(true);
        this.setting.getData().setPathSound(this.configure.getPath().getText());
      }

      try {
        this.setting.saveData();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
  
  public String selectionFile() {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filterFile = new FileNameExtensionFilter("MPEG-2 Audio Layer III (.mp3)", "mp3");
    fileChooser.setDialogTitle("Seleccionar audio:");
    fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
    fileChooser.setApproveButtonText("Seleccionar");
    fileChooser.setMultiSelectionEnabled(false);
    fileChooser.setFileFilter(filterFile);
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

    if (fileChooser.showOpenDialog(this.view) == JFileChooser.APPROVE_OPTION) {
      return fileChooser.getSelectedFile().getAbsolutePath();
    } else {
      return null;
    }
  }

  public Configure getConfigure() {
    return configure;
  }
  
}
