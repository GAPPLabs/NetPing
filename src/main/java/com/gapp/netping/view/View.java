package com.gapp.netping.view;

import com.formdev.flatlaf.intellijthemes.FlatMonocaiIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatXcodeDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class View extends javax.swing.JFrame {

  public View() {
    initComponents();
    setLookAndFell();
  }

  private void setLookAndFell() {
    try {
      UIManager.setLookAndFeel(new FlatXcodeDarkIJTheme());
      SwingUtilities.updateComponentTreeUI(this);
    } catch (UnsupportedLookAndFeelException ex) {
      ex.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    group = new ButtonGroup();
    splitPanel = new JSplitPane();
    panelAction = new JPanel();
    icon = new JLabel();
    connection = new JToggleButton();
    configure = new JToggleButton();
    administer = new JToggleButton();
    labelAction = new JLabel();
    panelMain = new JPanel();
    enterprise = new JLabel();
    eventConnection = new JLabel();
    labelEventConnection = new JLabel();
    connect = new JLabel();
    disconnect = new JLabel();
    labelMonitor = new JLabel();
    menu = new JMenuBar();
    file = new JMenu();
    exit = new JMenuItem();
    help = new JMenu();
    about = new JMenuItem();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("NetPing");

    splitPanel.setDividerLocation(150);

    icon.setHorizontalAlignment(SwingConstants.CENTER);

    group.add(connection);
    connection.setText("Conexiones");
    connection.setHorizontalTextPosition(SwingConstants.CENTER);
    connection.setPreferredSize(new Dimension(111, 40));
    connection.setVerticalTextPosition(SwingConstants.BOTTOM);

    group.add(configure);
    configure.setText("Configurar");
    configure.setHorizontalTextPosition(SwingConstants.CENTER);
    configure.setPreferredSize(new Dimension(111, 40));
    configure.setVerticalTextPosition(SwingConstants.BOTTOM);

    group.add(administer);
    administer.setSelected(true);
    administer.setText("Monitorear");
    administer.setHorizontalTextPosition(SwingConstants.CENTER);
    administer.setPreferredSize(new Dimension(111, 40));
    administer.setVerticalTextPosition(SwingConstants.BOTTOM);

    labelAction.setHorizontalAlignment(SwingConstants.CENTER);
    labelAction.setText("Acciones:");

    GroupLayout panelActionLayout = new GroupLayout(panelAction);
    panelAction.setLayout(panelActionLayout);
    panelActionLayout.setHorizontalGroup(panelActionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(panelActionLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelActionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addComponent(icon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelAction, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(administer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(connection, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(configure, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    panelActionLayout.setVerticalGroup(panelActionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(panelActionLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(icon, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelAction)
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(administer, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(connection, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(configure, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        .addContainerGap(105, Short.MAX_VALUE))
    );

    splitPanel.setLeftComponent(panelAction);

    GroupLayout panelMainLayout = new GroupLayout(panelMain);
    panelMain.setLayout(panelMainLayout);
    panelMainLayout.setHorizontalGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGap(0, 680, Short.MAX_VALUE)
    );
    panelMainLayout.setVerticalGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGap(0, 467, Short.MAX_VALUE)
    );

    splitPanel.setRightComponent(panelMain);

    enterprise.setText("© GAPP LABS, 2023");

    eventConnection.setText("Listo");

    labelEventConnection.setText("Conexion:");

    connect.setHorizontalAlignment(SwingConstants.CENTER);
    connect.setPreferredSize(new Dimension(20, 20));

    disconnect.setHorizontalAlignment(SwingConstants.CENTER);
    disconnect.setPreferredSize(new Dimension(20, 20));

    labelMonitor.setText("Monitor:");

    file.setText("Archivo");

    exit.setText("Salir de la aplicación");
    file.add(exit);

    menu.add(file);

    help.setText("Ayuda");

    about.setText("Acerca de la aplicación");
    help.add(about);

    menu.add(help);

    setJMenuBar(menu);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(9, 9, 9)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addComponent(splitPanel, GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addComponent(labelMonitor)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(connect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(disconnect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(labelEventConnection)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(eventConnection, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(enterprise)
            .addGap(6, 6, 6)))
        .addGap(9, 9, 9))
    );
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(9, 9, 9)
        .addComponent(splitPanel)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
          .addComponent(disconnect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(connect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(enterprise, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
          .addComponent(labelMonitor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(labelEventConnection, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
          .addComponent(eventConnection, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(9, 9, 9))
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  public JToggleButton getAdminister() {
    return administer;
  }

  public JToggleButton getConfigure() {
    return configure;
  }

  public JToggleButton getConnection() {
    return connection;
  }

  public JPanel getPanelMain() {
    return panelMain;
  }

  public JMenuItem getAbout() {
    return about;
  }

  public JMenuItem getExit() {
    return exit;
  }

  public JLabel getEventConnection() {
    return eventConnection;
  }

  public JLabel getConnect() {
    return connect;
  }

  public JLabel getDisconnect() {
    return disconnect;
  }

  public JLabel getIcon() {
    return icon;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private JMenuItem about;
  private JToggleButton administer;
  private JToggleButton configure;
  private JLabel connect;
  private JToggleButton connection;
  private JLabel disconnect;
  private JLabel enterprise;
  private JLabel eventConnection;
  private JMenuItem exit;
  private JMenu file;
  private ButtonGroup group;
  private JMenu help;
  private JLabel icon;
  private JLabel labelAction;
  private JLabel labelEventConnection;
  private JLabel labelMonitor;
  private JMenuBar menu;
  private JPanel panelAction;
  private JPanel panelMain;
  private JSplitPane splitPanel;
  // End of variables declaration//GEN-END:variables
}
