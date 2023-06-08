package com.gapp.netping.view.controller;

import com.gapp.netping.data.Host;
import com.gapp.netping.data.Language;
import com.gapp.netping.data.structure.Connection;
import com.gapp.netping.view.View;
import com.gapp.netping.view.panel.Network;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

public class ControllerNetwork {
  
  private final View view;
  private final Network network;
  private final Language language;
  private final Host host;

  public ControllerNetwork(View view, Network network, Language language, Host host) {
    this.view = view;
    this.network = network;
    this.language = language;
    this.host = host;
  }
  
  public ControllerNetwork compile() {
    this.initConfigure();
    this.updateSelect();
    this.addListenersEvent();
    return this;
  }
  
  private void initConfigure() {
    String [] connection = this.host.getHosts().toArray(String[]::new);
    this.network.getConnection().setModel(new DefaultComboBoxModel<>(connection));
    this.network.getConnection().setSelectedIndex(0);
    long count = this.host.getData().values().stream().filter(Connection::isEnable).count();
    this.network.getActive().setText(String.valueOf(count));
  }
  
  private void createConnection() {
    this.network.getConnection().clearSelection();
    this.network.getIdentify().setText("");
    this.network.getAddress().setText("");
    this.network.getShipments().setValue(1);
    this.network.getExtra().setText("");
    this.network.getInterval().setValue(1000L);
    this.network.getPatience().setValue(1);

    for (JCheckBox checkbox : this.network.getMetricsDefault()) {
      checkbox.setSelected(true);
    }

    this.network.getNotification().setSelected(true);
    this.network.getUsed().setSelected(true);
    this.network.getIdentify().requestFocus();
  }
  
  private void updateSelect() {
    String connection = this.network.getConnection().getSelectedValue();
    if (connection != null) {
      Connection data = this.host.getData().get(connection);

      this.network.getIdentify().setText(connection);
      this.network.getAddress().setText(data.getHost());
      this.network.getShipments().setValue(data.getShipments());
      this.network.getExtra().setText(data.getExtra());
      this.network.getInterval().setValue(data.getIntermittence());
      this.network.getPatience().setValue(data.getPatience());

      List<String> metrics = Arrays.asList(data.getMetrics());
      for (JCheckBox checkbox : this.network.getMetrics()) {
        if (metrics.contains(checkbox.getText())) {
          checkbox.setSelected(true);
        } else {
          checkbox.setSelected(false);
        }
      }

      this.network.getNotification().setSelected(data.isNotification());
      this.network.getUsed().setSelected(data.isEnable());
      validMetricsSelect();
      this.network.getMetricMain().setSelectedItem(data.getMetricUse());
    }
  }
  
  private void addListenersEvent() {
    this.network.getConnection().addListSelectionListener((ListSelectionEvent evt) -> {
      updateSelect();
    });
    
    this.network.getAdd().addActionListener((ActionEvent e) -> {
      this.createConnection();
    });
    
    this.network.getShipments().addChangeListener((ChangeEvent e) -> {
      this.validMetricsOnly();
    });
    
    for (JCheckBox checkbox : this.network.getMetrics()) {
      checkbox.addActionListener((ActionEvent evt) -> {
        validMetricsSelect();
      });
    }
    
    this.network.getRemove().addActionListener((ActionEvent e) -> {
      this.removeConnection();
    });
    
    this.network.getSave().addActionListener((ActionEvent e) -> {
      this.saveHost();
    });

    this.network.getCancel().addActionListener((ActionEvent e) -> {
      if (this.network.getConnection().getSelectedValue() == null) {
        this.network.getConnection().setSelectedIndex(0);
      }
      this.updateSelect();
    });
  }
  
  private void validMetricsOnly() {
    boolean enable = ((int)this.network.getShipments().getValue()) > 1;
    for (JCheckBox checkbox : this.network.getMetricsOnly()) {
      if (!enable) {
        checkbox.setSelected(false);
      }
      checkbox.setEnabled(enable);
    }
  }
  
  private void validMetricsSelect() {
    List<String> metrics = new ArrayList<>() {{
      for (JCheckBox checkbox : network.getMetrics()) {
        if (checkbox.isSelected()) {
          add(checkbox.getText());
        }
      }
    }};
    this.network.getMetricMain().setModel(
      new DefaultComboBoxModel<>(metrics.toArray(String[]::new))
    );
  }
  
  private void saveHost() {
    String title = "Advertencia de guardado:";
    String message = "Se reiniciarán los monitoreos actuales ¿Continuar?";
    int option = JOptionPane.showConfirmDialog(this.view, message, title, JOptionPane.YES_NO_OPTION);
    if (option == JOptionPane.YES_OPTION) {
      String identify = this.network.getIdentify().getText();
      String connection =  this.network.getConnection().getSelectedValue();
      Connection data = connection == null ? new Connection() : this.host.getData().get(connection);

      data.setHost(this.network.getAddress().getText());
      data.setShipments((Integer) this.network.getShipments().getValue());
      data.setExtra(this.network.getExtra().getText());
      data.setIntermittence((Long) this.network.getInterval().getValue());
      data.setPatience((Integer) this.network.getPatience().getValue());

      List<String> metrics = new ArrayList<>() {{
        for (JCheckBox checkbox : network.getMetrics()) {
          if (checkbox.isSelected()) {
            add(checkbox.getText());
          }
        }
      }};

      data.setMetrics(metrics.toArray(String[]::new));
      data.setMetricUse((String) this.network.getMetricMain().getSelectedItem());
      data.setNotification(this.network.getNotification().isSelected());
      data.setEnable(this.network.getUsed().isSelected());

      try {
        if (connection == null) {
          this.host.getData().remove(connection);
        }

        this.host.getData().put(identify, data);
        this.host.saveData();
        this.initConfigure();
        this.network.getConnection().setSelectedValue(identify, true);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
  
  private void removeConnection() {
    String title = "Advertencia de eliminación:";
    String identify = this.network.getIdentify().getText();
    String message = "Se reiniciarán los monitoreos actuales ¿Eliminar " + identify + "?";
    int response = JOptionPane.showConfirmDialog(this.view, message, title, JOptionPane.YES_NO_OPTION);
    if (response == JOptionPane.YES_OPTION) {
      try {
        this.host.getData().remove(identify);
        this.host.saveData();
        this.initConfigure();
        this.updateSelect();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  public Network getNetwork() {
    return this.network;
  }
  
}
