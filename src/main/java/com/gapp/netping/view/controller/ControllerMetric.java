package com.gapp.netping.view.controller;

import com.gapp.netping.core.util.Request;
import com.gapp.netping.view.panel.util.Metric;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.ArrayUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

public class ControllerMetric {

  private final Metric metric;
  
  private JFreeChart chart;
  private DefaultXYDataset dataset;
  private String [] metrics;
  private int history;
  private Map<String, List<Double>> data;
  private List<Double> time;
  private DefaultTableModel model;

  public ControllerMetric(Metric metric) {
    this.metric = metric;
  }
  
  public ControllerMetric compile() {
    this.model = new DefaultTableModel();
    this.dataset = new DefaultXYDataset();
    this.chart = ChartFactory.createXYLineChart(
            "Monitoreo",  
            "Intervalo", 
            "Unidades", 
            this.dataset
    );
    this.chart.getXYPlot().getDomainAxis().setInverted(true);
    this.chart.getXYPlot().setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
    this.chart.getXYPlot().setRenderer(new XYLineAndShapeRenderer());
    this.chart.setNotify(true);
    
    StandardChartTheme darkTheme = (StandardChartTheme) org.jfree.chart.StandardChartTheme.createDarknessTheme();
    darkTheme.setPlotBackgroundPaint(new Color(50, 51, 51));
    darkTheme.setChartBackgroundPaint(new Color(50, 51, 51));
    darkTheme.setLabelLinkPaint(Color.WHITE);
    darkTheme.setAxisLabelPaint(Color.WHITE);
    darkTheme.setTickLabelPaint(Color.WHITE);
    darkTheme.setItemLabelPaint(Color.WHITE);
    darkTheme.apply(this.chart);
    
    this.metric.getTableRegisterMetric().setModel(this.model);
    
    this.metric.getMonitor().removeAll();
    this.metric.getMonitor().setLayout(new BorderLayout());
    this.metric.getMonitor().add(new ChartPanel(this.chart), BorderLayout.CENTER);
    return this;
  }

  public ControllerMetric settingData(String host, int send, long interval, String[] metrics, String metricMain, int history) {
    this.metrics = metrics;
    this.metric.getAddress().setText(host);
    this.metric.getInterval().setText(String.valueOf(interval) + "@" + String.valueOf(send) + " ms/envios");
    this.metric.getMetrics().setModel(new DefaultListModel<String>() {{
      for (String metric : metrics) {
        addElement(metric);
      }}
    });
    this.metric.getMetrics().setSelectedValue(metricMain, true);
    this.history = history;
    this.generateData(metrics, interval);
    this.generateGraphic();
    this.addListenersEvent();
    return this;
  }
  
  private void addListenersEvent() {
    this.metric.getMetrics().addListSelectionListener((ListSelectionEvent evt) -> {
      this.generateGraphic();
    });
  }

  private void generateData(String[] metrics, long interval) {
    this.data = new LinkedHashMap<String, List<Double>>() {{
      for (String metric : metrics) {
        put(metric, new ArrayList<>() {{
          for (int i = 0; i < history; i++) {
            add(0d);
          }}
        });
      }
    }};
    
    this.time = new ArrayList<>() {{
      for (int i = 0; i < history; i++) {
        add((Double) (interval * i / 1000d));
      }}
    };
  }

  private void updateData(Map<String, Double> request) {
    for (Map.Entry<String, Double> entry : request.entrySet()) {
      List<Double> values = this.data.get(entry.getKey());
      values.add(0, entry.getValue());
      values.remove(values.size() - 1);
    }
  }
  
  private void disconnectUpdateData() {
    for (Map.Entry<String, List<Double>> entry : this.data.entrySet()) {
      List<Double> values = entry.getValue();
      values.add(0, 0d);
      values.remove(values.size() - 1);
    }
  }
  
  public void processingData(Request request) {
    if (request.isConnect()) {
      this.updateData(request.getData());
      this.metric.getStatus().setText("Conectado");
    } else {
      this.disconnectUpdateData();
      this.metric.getStatus().setText("Desconectado");
    }
    generateGraphic();
  } 
  
  public void generateGraphic() {
    DefaultTableModel model = new DefaultTableModel();
    List<String> metrics = this.metric.getMetrics().getSelectedValuesList();

    for (String metric : this.metrics) {
      this.dataset.removeSeries(metric);
    }

    for (int i = 0; i < metrics.size(); i ++) {
      double[] times = ArrayUtils.toPrimitive(this.time.toArray(Double[]::new));
      double[] values = ArrayUtils.toPrimitive(this.data.get(metrics.get(i)).toArray(Double[]::new));
      model.addColumn(metrics.get(i), new Double [] {values[0]});
      this.dataset.addSeries(metrics.get(i), new double[][] {times, values});
    }
    
    SwingUtilities.invokeLater(() -> {
      this.model.setDataVector(model.getDataVector(), new Vector<>(metrics));
      this.centeringRegisterMetric(metrics);
      this.createGraphic();
    });
  }
  
  private void centeringRegisterMetric (List<String> metrics) {
    JTable table = this.metric.getTableRegisterMetric();
    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
    tcr.setHorizontalAlignment(SwingConstants.CENTER);

    for (String metric : metrics) {
        table.getColumn(metric).setCellRenderer(tcr);  
    }
  }
  
  private void createGraphic() {
    this.metric.getTableRegisterMetric().revalidate();
    this.metric.getTableRegisterMetric().repaint();
    this.metric.getScrollRegisterMetric().revalidate();
    this.metric.getScrollRegisterMetric().repaint();
    this.metric.getMonitor().revalidate();
    this.metric.getMonitor().repaint();
    this.metric.getPanelGraphic().revalidate();
    this.metric.getPanelGraphic().repaint();
    this.metric.revalidate();
    this.metric.repaint();
  }
  
  public Metric getMetric() {
    return metric;
  }
  
  public void changeStatus(String status) {
    this.metric.getStatus().setText(status);
  }
}
