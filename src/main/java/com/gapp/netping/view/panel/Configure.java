/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.gapp.netping.view.panel;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;

public class Configure extends javax.swing.JPanel {

  public Configure() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    optionsGroup = new ButtonGroup();
    labelGeneral = new JLabel();
    labelLanguage = new JLabel();
    language = new JComboBox<>();
    separatorFirst = new JSeparator();
    labelMonitor = new JLabel();
    labelNotification = new JLabel();
    path = new JLabel();
    customAudio = new JRadioButton();
    defaultAudio = new JRadioButton();
    labelPathAudio = new JLabel();
    repeat = new JSpinner();
    labelRepeatNotifications = new JLabel();
    separatorSecond = new JSeparator();
    labelHistory = new JLabel();
    history = new JSpinner();
    labelSoundEnable = new JLabel();
    enableSound = new JComboBox<>();
    accept = new JButton();
    cancel = new JButton();

    labelGeneral.setText("Configuraciones generales:");

    labelLanguage.setText("Idioma de la aplicación:");

    language.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    labelMonitor.setText("Configuración de monitoreo:");

    labelNotification.setText("Configuración de notificación:");

    path.setText("...");
    path.setEnabled(false);

    optionsGroup.add(customAudio);
    customAudio.setText("Personalizado");

    optionsGroup.add(defaultAudio);
    defaultAudio.setSelected(true);
    defaultAudio.setText("Por defecto");

    labelPathAudio.setText("Audio de notificación:");

    repeat.setModel(new SpinnerNumberModel(1, 1, 600, 1));

    labelRepeatNotifications.setText("Repetir notificación (segundos):");

    labelHistory.setText("Intervalo historico:");

    history.setModel(new SpinnerNumberModel(15, 15, 60, 1));

    labelSoundEnable.setText("Notificación con audio:");

    enableSound.setModel(new DefaultComboBoxModel<>(new String[] { "Habilitar", "Deshabilitar" }));

    accept.setText("Aceptar");

    cancel.setText("Cancelar");

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addComponent(enableSound, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelGeneral, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(language, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(separatorFirst)
          .addComponent(labelMonitor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelNotification, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(repeat)
          .addGroup(layout.createSequentialGroup()
            .addComponent(defaultAudio)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(customAudio)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(path, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
          .addComponent(separatorSecond)
          .addComponent(history)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(labelLanguage)
              .addComponent(labelPathAudio)
              .addComponent(labelRepeatNotifications)
              .addComponent(labelHistory)
              .addComponent(labelSoundEnable))
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(accept)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cancel)))
        .addContainerGap())
    );
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(7, 7, 7)
        .addComponent(labelGeneral)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelLanguage)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(language, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(separatorFirst, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelMonitor)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelHistory)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(history, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addGap(7, 7, 7)
        .addComponent(separatorSecond, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelNotification)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelRepeatNotifications)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(repeat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelSoundEnable)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(enableSound, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelPathAudio)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(defaultAudio)
          .addComponent(customAudio)
          .addComponent(path))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(accept)
          .addComponent(cancel))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  public JButton getAccept() {
    return accept;
  }

  public JButton getCancel() {
    return cancel;
  }

  public JRadioButton getCustomAudio() {
    return customAudio;
  }

  public JRadioButton getDefaultAudio() {
    return defaultAudio;
  }

  public JComboBox<String> getLanguage() {
    return language;
  }

  public JLabel getPath() {
    return path;
  }

  public JSpinner getRepeat() {
    return repeat;
  }

  public JSpinner getHistory() {
    return history;
  }

  public JComboBox<String> getEnableSound() {
    return enableSound;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private JButton accept;
  private JButton cancel;
  private JRadioButton customAudio;
  private JRadioButton defaultAudio;
  private JComboBox<String> enableSound;
  private JSpinner history;
  private JLabel labelGeneral;
  private JLabel labelHistory;
  private JLabel labelLanguage;
  private JLabel labelMonitor;
  private JLabel labelNotification;
  private JLabel labelPathAudio;
  private JLabel labelRepeatNotifications;
  private JLabel labelSoundEnable;
  private JComboBox<String> language;
  private ButtonGroup optionsGroup;
  private JLabel path;
  private JSpinner repeat;
  private JSeparator separatorFirst;
  private JSeparator separatorSecond;
  // End of variables declaration//GEN-END:variables
}
