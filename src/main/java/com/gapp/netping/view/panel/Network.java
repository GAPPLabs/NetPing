package com.gapp.netping.view.panel;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

public class Network extends javax.swing.JPanel {

  public Network() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    splitPanel = new JSplitPane();
    panelConnections = new JPanel();
    labelConnections = new JLabel();
    scrollPanelConnection = new JScrollPane();
    connection = new JList<>();
    labelActive = new JLabel();
    active = new JLabel();
    add = new JButton();
    panelSettings = new JPanel();
    labelSetting = new JLabel();
    labelIdentify = new JLabel();
    identify = new JTextField();
    labelAddress = new JLabel();
    address = new JTextField();
    labelShipments = new JLabel();
    shipments = new JSpinner();
    labelExtra = new JLabel();
    extra = new JTextField();
    labelInterval = new JLabel();
    interval = new JSpinner();
    labelPatience = new JLabel();
    patience = new JSpinner();
    separatorFirst = new JSeparator();
    labelSettiingMetric = new JLabel();
    minTimes = new JCheckBox();
    minBytes = new JCheckBox();
    minTtfs = new JCheckBox();
    meanTimes = new JCheckBox();
    meanBytes = new JCheckBox();
    meanTtfs = new JCheckBox();
    maxTimes = new JCheckBox();
    maxBytes = new JCheckBox();
    maxTtfs = new JCheckBox();
    lossTimes = new JCheckBox();
    lossBytes = new JCheckBox();
    lossTtfs = new JCheckBox();
    separatorSecond = new JSeparator();
    labelSettingExtra = new JLabel();
    used = new JCheckBox();
    notification = new JCheckBox();
    labelMetricMain = new JLabel();
    metricMain = new JComboBox<>();
    remove = new JButton();
    cancel = new JButton();
    save = new JButton();

    splitPanel.setDividerLocation(120);

    labelConnections.setText("Conexiones:");

    connection.setModel(new AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    connection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    scrollPanelConnection.setViewportView(connection);

    labelActive.setText("Activos:");

    active.setText("1 conexión");

    add.setText("Agregar");

    GroupLayout panelConnectionsLayout = new GroupLayout(panelConnections);
    panelConnections.setLayout(panelConnectionsLayout);
    panelConnectionsLayout.setHorizontalGroup(panelConnectionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(panelConnectionsLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelConnectionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addComponent(add, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelConnections, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(scrollPanelConnection)
          .addGroup(panelConnectionsLayout.createSequentialGroup()
            .addComponent(labelActive)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(active, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addContainerGap())
    );
    panelConnectionsLayout.setVerticalGroup(panelConnectionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(panelConnectionsLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelConnections)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrollPanelConnection, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelConnectionsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(labelActive)
          .addComponent(active))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(add)
        .addContainerGap())
    );

    splitPanel.setLeftComponent(panelConnections);

    labelSetting.setText("Configuraciones de conexión:");

    labelIdentify.setText("Nombre:");

    labelAddress.setText("Dirección:");

    labelShipments.setText("Solicitudes:");

    shipments.setModel(new SpinnerNumberModel(1, 1, 100, 1));

    labelExtra.setText("Comando adicional:");

    labelInterval.setText("Intervalo (ms):");

    interval.setModel(new SpinnerNumberModel(Long.valueOf(100L), Long.valueOf(100L), Long.valueOf(30000L), Long.valueOf(1L)));

    labelPatience.setText("Paciencia:");

    patience.setModel(new SpinnerNumberModel(1, 1, 100, 1));

    labelSettiingMetric.setText("Configuraciones de métricas:");

    minTimes.setText("min_times");

    minBytes.setText("min_bytes");

    minTtfs.setText("min_ttfs");

    meanTimes.setSelected(true);
    meanTimes.setText("mean_times");

    meanBytes.setSelected(true);
    meanBytes.setText("mean_bytes");

    meanTtfs.setSelected(true);
    meanTtfs.setText("mean_ttfs");

    maxTimes.setText("max_times");

    maxBytes.setText("max_bytes");

    maxTtfs.setText("max_ttfs");

    lossTimes.setText("loss_times");

    lossBytes.setText("loss_bytes");

    lossTtfs.setText("loss_ttfs");

    labelSettingExtra.setText("Configuraciones adicionales:");

    used.setSelected(true);
    used.setText("Usar esta conexión");

    notification.setSelected(true);
    notification.setText("Notificar desconexión");

    labelMetricMain.setText("Métrica principal:");

    metricMain.setModel(new DefaultComboBoxModel<>(new String[] { "mean_times", "mean_bytes", "mean_ttfs" }));

    remove.setText("Eliminar");

    cancel.setText("Cancelar");

    save.setText("Guardar");

    GroupLayout panelSettingsLayout = new GroupLayout(panelSettings);
    panelSettings.setLayout(panelSettingsLayout);
    panelSettingsLayout.setHorizontalGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(GroupLayout.Alignment.TRAILING, panelSettingsLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
          .addComponent(metricMain, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelSettingExtra, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(separatorFirst, GroupLayout.Alignment.LEADING)
          .addComponent(labelSetting, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelSettiingMetric, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(GroupLayout.Alignment.LEADING, panelSettingsLayout.createSequentialGroup()
            .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(minTimes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(panelSettingsLayout.createSequentialGroup()
                .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                  .addComponent(minTtfs, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(minBytes, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(meanTimes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(panelSettingsLayout.createSequentialGroup()
                .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                  .addComponent(meanTtfs, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(meanBytes, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(maxTimes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(panelSettingsLayout.createSequentialGroup()
                .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                  .addComponent(maxTtfs, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(maxBytes, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(lossTimes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(panelSettingsLayout.createSequentialGroup()
                .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                  .addComponent(lossTtfs, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(lossBytes, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))))
          .addGroup(GroupLayout.Alignment.LEADING, panelSettingsLayout.createSequentialGroup()
            .addComponent(separatorSecond)
            .addGap(1, 1, 1))
          .addGroup(GroupLayout.Alignment.LEADING, panelSettingsLayout.createSequentialGroup()
            .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
              .addComponent(interval, GroupLayout.Alignment.LEADING)
              .addComponent(labelInterval, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(shipments, GroupLayout.Alignment.LEADING)
              .addComponent(labelIdentify, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(labelShipments, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(identify, GroupLayout.Alignment.LEADING))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(address)
              .addComponent(labelAddress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(labelExtra, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(extra, GroupLayout.Alignment.TRAILING)
              .addComponent(labelPatience, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(patience)))
          .addGroup(GroupLayout.Alignment.LEADING, panelSettingsLayout.createSequentialGroup()
            .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addComponent(notification)
              .addComponent(labelMetricMain))
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(panelSettingsLayout.createSequentialGroup()
            .addComponent(used, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
            .addGap(37, 37, 37)
            .addComponent(save)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(remove)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cancel)))
        .addContainerGap())
    );
    panelSettingsLayout.setVerticalGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(GroupLayout.Alignment.TRAILING, panelSettingsLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelSetting)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(labelIdentify)
          .addComponent(labelAddress))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(identify, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(labelShipments)
          .addComponent(labelExtra))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(shipments, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addComponent(extra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(panelSettingsLayout.createSequentialGroup()
            .addComponent(labelInterval)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(interval, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGroup(panelSettingsLayout.createSequentialGroup()
            .addComponent(labelPatience)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(patience, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(separatorFirst, GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelSettiingMetric)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(panelSettingsLayout.createSequentialGroup()
            .addComponent(minTimes)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(minBytes)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(minTtfs))
          .addGroup(panelSettingsLayout.createSequentialGroup()
            .addComponent(maxTimes)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(maxBytes)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(maxTtfs))
          .addGroup(panelSettingsLayout.createSequentialGroup()
            .addComponent(meanTimes)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(meanBytes)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(meanTtfs))
          .addGroup(panelSettingsLayout.createSequentialGroup()
            .addComponent(lossTimes)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lossBytes)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lossTtfs)))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelMetricMain)
        .addGap(8, 8, 8)
        .addComponent(metricMain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(separatorSecond, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelSettingExtra)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(notification)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(used)
          .addGroup(panelSettingsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(remove)
            .addComponent(cancel)
            .addComponent(save)))
        .addContainerGap())
    );

    splitPanel.setRightComponent(panelSettings);

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(splitPanel)
        .addContainerGap())
    );
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(splitPanel))
    );
  }// </editor-fold>//GEN-END:initComponents

  public JLabel getActive() {
    return active;
  }

  public JButton getAdd() {
    return add;
  }

  public JTextField getAddress() {
    return address;
  }

  public JButton getCancel() {
    return cancel;
  }

  public JList<String> getConnection() {
    return connection;
  }

  public JTextField getExtra() {
    return extra;
  }
  
  public JCheckBox [] getMetrics() {
    return new JCheckBox [] { minTimes, minBytes, minTtfs,
                              meanTimes, meanBytes, meanTtfs,
                              maxTimes, maxBytes, maxTtfs,
                              lossTimes, lossBytes, lossTtfs };
  }
  
  public JCheckBox [] getMetricsOnly() {
    return new JCheckBox [] { minTimes, minBytes, minTtfs,
                              maxTimes, maxBytes, maxTtfs,
                              lossTimes, lossBytes, lossTtfs };
  }
  
  public JCheckBox [] getMetricsDefault() {
    return new JCheckBox [] { meanTimes, meanBytes, meanTtfs };
  }

  public JTextField getIdentify() {
    return identify;
  }

  public JSpinner getInterval() {
    return interval;
  }

  public JCheckBox getNotification() {
    return notification;
  }

  public JSpinner getPatience() {
    return patience;
  }

  public JButton getRemove() {
    return remove;
  }

  public JButton getSave() {
    return save;
  }

  public JSpinner getShipments() {
    return shipments;
  }

  public JCheckBox getUsed() {
    return used;
  }

  public JComboBox<String> getMetricMain() {
    return metricMain;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private JLabel active;
  private JButton add;
  private JTextField address;
  private JButton cancel;
  private JList<String> connection;
  private JTextField extra;
  private JTextField identify;
  private JSpinner interval;
  private JLabel labelActive;
  private JLabel labelAddress;
  private JLabel labelConnections;
  private JLabel labelExtra;
  private JLabel labelIdentify;
  private JLabel labelInterval;
  private JLabel labelMetricMain;
  private JLabel labelPatience;
  private JLabel labelSettiingMetric;
  private JLabel labelSetting;
  private JLabel labelSettingExtra;
  private JLabel labelShipments;
  private JCheckBox lossBytes;
  private JCheckBox lossTimes;
  private JCheckBox lossTtfs;
  private JCheckBox maxBytes;
  private JCheckBox maxTimes;
  private JCheckBox maxTtfs;
  private JCheckBox meanBytes;
  private JCheckBox meanTimes;
  private JCheckBox meanTtfs;
  private JComboBox<String> metricMain;
  private JCheckBox minBytes;
  private JCheckBox minTimes;
  private JCheckBox minTtfs;
  private JCheckBox notification;
  private JPanel panelConnections;
  private JPanel panelSettings;
  private JSpinner patience;
  private JButton remove;
  private JButton save;
  private JScrollPane scrollPanelConnection;
  private JSeparator separatorFirst;
  private JSeparator separatorSecond;
  private JSpinner shipments;
  private JSplitPane splitPanel;
  private JCheckBox used;
  // End of variables declaration//GEN-END:variables
}
