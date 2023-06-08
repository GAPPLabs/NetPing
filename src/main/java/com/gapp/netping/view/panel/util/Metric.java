package com.gapp.netping.view.panel.util;

import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class Metric extends javax.swing.JPanel {

  public Metric() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    splitPanel = new JSplitPane();
    panelMetrics = new JPanel();
    labelMetrics = new JLabel();
    scrollMetrics = new JScrollPane();
    metrics = new JList<>();
    labelAddress = new JLabel();
    address = new JLabel();
    interval = new JLabel();
    labelInterval = new JLabel();
    status = new JLabel();
    labelStatus = new JLabel();
    labelInformation = new JLabel();
    panelGraphic = new JPanel();
    labelMonitor = new JLabel();
    monitor = new JPanel();
    labelRegisterMetric = new JLabel();
    scrollRegisterMetric = new JScrollPane();
    tableRegisterMetric = new JTable();

    splitPanel.setDividerLocation(180);

    labelMetrics.setText("Métricas:");

    metrics.setModel(new AbstractListModel<String>() {
      String[] strings = { "mean_bytes", "mean_times", "mean_ttfs" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    scrollMetrics.setViewportView(metrics);

    labelAddress.setText("Dirección:");

    address.setText("...");

    interval.setText("...");

    labelInterval.setText("Intervalo:");

    status.setText("Listo");

    labelStatus.setText("Estado:");

    labelInformation.setText("Información:");

    GroupLayout panelMetricsLayout = new GroupLayout(panelMetrics);
    panelMetrics.setLayout(panelMetricsLayout);
    panelMetricsLayout.setHorizontalGroup(panelMetricsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(panelMetricsLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelMetricsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addComponent(scrollMetrics, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addComponent(labelMetrics, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(panelMetricsLayout.createSequentialGroup()
            .addComponent(labelStatus)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(status, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(panelMetricsLayout.createSequentialGroup()
            .addComponent(labelAddress)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(address, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(panelMetricsLayout.createSequentialGroup()
            .addComponent(labelInterval)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(interval, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addComponent(labelInformation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    panelMetricsLayout.setVerticalGroup(panelMetricsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(panelMetricsLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelMetrics)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrollMetrics, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelInformation)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelMetricsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(labelAddress)
          .addComponent(address))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelMetricsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
          .addComponent(labelInterval)
          .addComponent(interval, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelMetricsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(labelStatus)
          .addComponent(status))
        .addContainerGap())
    );

    splitPanel.setLeftComponent(panelMetrics);

    labelMonitor.setText("Gráfica de monitoreo:");

    GroupLayout monitorLayout = new GroupLayout(monitor);
    monitor.setLayout(monitorLayout);
    monitorLayout.setHorizontalGroup(monitorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    monitorLayout.setVerticalGroup(monitorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGap(0, 271, Short.MAX_VALUE)
    );

    labelRegisterMetric.setText("Registro de métricas:");

    scrollRegisterMetric.setDoubleBuffered(true);
    scrollRegisterMetric.setFocusCycleRoot(true);

    tableRegisterMetric.setModel(new DefaultTableModel(
      new Object [][] {
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    tableRegisterMetric.setDoubleBuffered(true);
    tableRegisterMetric.setEnabled(false);
    tableRegisterMetric.setFocusable(false);
    tableRegisterMetric.setRowSelectionAllowed(false);
    tableRegisterMetric.getTableHeader().setResizingAllowed(false);
    tableRegisterMetric.getTableHeader().setReorderingAllowed(false);
    tableRegisterMetric.setUpdateSelectionOnSort(false);
    tableRegisterMetric.setVerifyInputWhenFocusTarget(false);
    scrollRegisterMetric.setViewportView(tableRegisterMetric);

    GroupLayout panelGraphicLayout = new GroupLayout(panelGraphic);
    panelGraphic.setLayout(panelGraphicLayout);
    panelGraphicLayout.setHorizontalGroup(panelGraphicLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(panelGraphicLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelGraphicLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addComponent(labelRegisterMetric, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelMonitor, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
          .addComponent(monitor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(scrollRegisterMetric, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        .addContainerGap())
    );
    panelGraphicLayout.setVerticalGroup(panelGraphicLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(panelGraphicLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelMonitor)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(monitor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelRegisterMetric)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrollRegisterMetric, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    splitPanel.setRightComponent(panelGraphic);

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(splitPanel, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(splitPanel)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  public JLabel getAddress() {
    return address;
  }

  public JLabel getInterval() {
    return interval;
  }

  public JList<String> getMetrics() {
    return metrics;
  }

  public JPanel getMonitor() {
    return monitor;
  }

  public JLabel getStatus() {
    return status;
  }

  public JTable getTableRegisterMetric() {
    return tableRegisterMetric;
  }

  public JPanel getPanelGraphic() {
    return panelGraphic;
  }

  public JScrollPane getScrollRegisterMetric() {
    return scrollRegisterMetric;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private JLabel address;
  private JLabel interval;
  private JLabel labelAddress;
  private JLabel labelInformation;
  private JLabel labelInterval;
  private JLabel labelMetrics;
  private JLabel labelMonitor;
  private JLabel labelRegisterMetric;
  private JLabel labelStatus;
  private JList<String> metrics;
  private JPanel monitor;
  private JPanel panelGraphic;
  private JPanel panelMetrics;
  private JScrollPane scrollMetrics;
  private JScrollPane scrollRegisterMetric;
  private JSplitPane splitPanel;
  private JLabel status;
  private JTable tableRegisterMetric;
  // End of variables declaration//GEN-END:variables
}
