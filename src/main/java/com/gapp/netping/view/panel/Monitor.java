package com.gapp.netping.view.panel;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;

public class Monitor extends javax.swing.JPanel {

  public Monitor() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jSeparator1 = new JSeparator();
    stop = new JButton();
    start = new JButton();

    stop.setText("Detener");

    start.setText("Iniciar");

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addComponent(tabbed)
          .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING)
          .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 367, Short.MAX_VALUE)
            .addComponent(start)
            .addGap(5, 5, 5)
            .addComponent(stop)))
        .addContainerGap())
    );
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(tabbed, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(stop)
          .addComponent(start))
        .addGap(10, 10, 10))
    );
  }// </editor-fold>//GEN-END:initComponents
  
  public JTabbedPane getTabbed() {
    return tabbed;
  }

  public JButton getStart() {
    return start;
  }

  public JButton getStop() {
    return stop;
  }
   
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private JSeparator jSeparator1;
  private JButton start;
  private JButton stop;
  private final JTabbedPane tabbed = new JTabbedPane();
  // End of variables declaration//GEN-END:variables
}
