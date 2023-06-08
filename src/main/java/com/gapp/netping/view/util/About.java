package com.gapp.netping.view.util;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class About extends javax.swing.JDialog {

  public About(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    logo = new JLabel();
    scrollAbout = new JScrollPane();
    about = new JTextArea();

    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Acerca:");

    logo.setHorizontalAlignment(SwingConstants.CENTER);

    scrollAbout.setBorder(null);
    scrollAbout.setOpaque(false);

    about.setEditable(false);
    about.setColumns(30);
    about.setLineWrap(true);
    about.setRows(1);
    about.setText("Esta aplicación fue desarrollada por GAPP LABS, INC. una empresa desarrolladora de software, con expertos que ofrecen soluciones innovadoras y personalizadas.\n\nUtilizamos las librerias de Flatlaf, Jackson, JFreeChart, Apache commons y JLayer para realizar esta aplicación.");
    about.setWrapStyleWord(true);
    about.setBorder(null);
    about.setOpaque(false);
    scrollAbout.setViewportView(about);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addComponent(scrollAbout, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
          .addComponent(logo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(15, 15, 15))
    );
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addComponent(logo, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(scrollAbout, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        .addGap(15, 15, 15))
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  public JTextArea getAbout() {
    return about;
  }

  public JLabel getLogo() {
    return logo;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private JTextArea about;
  private JLabel logo;
  private JScrollPane scrollAbout;
  // End of variables declaration//GEN-END:variables
}
