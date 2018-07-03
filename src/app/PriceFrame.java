package app;

import client.CurrencyHandler;
import client.SearchHandler;
import com.sun.glass.events.KeyEvent;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import model.Item;
import model.Search;

public class PriceFrame extends javax.swing.JFrame {

    JPanel cp = new JPanel();
    JPanel[] elPanel = new JPanel[50];
    Image[] imagen = new Image[50];
    JLabel[] label = new JLabel[50];
    JLabel[] precio = new JLabel[50];
    URL[] url = new URL[50];
    JCheckBox[] checks = new JCheckBox[50];
    JButton[] buttons = new JButton[50];
    Search search;
    Double promedioLocal, promedioUSD;
    int items = 0;
    Thread hiloA;
    Thread hiloB;
    Thread hiloC;

    public PriceFrame() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        jSP.getVerticalScrollBar().setUnitIncrement(16);
        this.setTitle("MeliPrice");
        jSP.setBounds(132, 155, 502, 311);
        jSP.setViewportView(cp);
        jSP.getViewport().setView(cp);
        jTxtPrecio.setText("");
        jPanel3.setVisible(false);

    }
    static PriceFrame obj = null;

    public static PriceFrame getInstance() {
        if (obj == null) {
            obj = new PriceFrame();
        }
        return obj;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        qText = new javax.swing.JTextField();
        site_id = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jRbNuevo = new javax.swing.JRadioButton();
        jRbUsado = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        PromedioLabel = new javax.swing.JLabel();
        PromedioUSDLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSP = new javax.swing.JScrollPane();
        jTxtPrecio = new javax.swing.JTextField();
        jLblPrecio = new javax.swing.JLabel();
        jLblCategorias = new javax.swing.JLabel();
        jPanelDatos = new javax.swing.JPanel();
        jLblMin = new javax.swing.JLabel();
        jLblMax = new javax.swing.JLabel();
        jLblMed = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBtnAbrir = new javax.swing.JButton();
        jChbTodo = new javax.swing.JCheckBox();
        jCmbModo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jCheckHoy = new javax.swing.JCheckBox();
        jTxtMin = new javax.swing.JTextField();
        jTxtMax = new javax.swing.JTextField();
        jTxtBuscar = new javax.swing.JButton();
        jBtnResetear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Titulo del Item:");

        qText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                qTextFocusLost(evt);
            }
        });
        qText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qTextActionPerformed(evt);
            }
        });
        qText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qTextKeyReleased(evt);
            }
        });

        site_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MLA", "MLV", "MLC", "MCO", "MPE", "MEC", "MLM", "MLU", "MLB" }));

        jLabel2.setText("Site:");

        buttonGroup1.add(jRbNuevo);
        jRbNuevo.setSelected(true);
        jRbNuevo.setText("Nuevo");
        jRbNuevo.setFocusPainted(false);
        jRbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbNuevoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRbUsado);
        jRbUsado.setText("Usado");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        PromedioLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N

        PromedioUSDLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setText("Precio:");

        jSP.setBackground(new java.awt.Color(255, 255, 255));

        jTxtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtPrecioKeyReleased(evt);
            }
        });

        jLblMin.setText("MIN:");

        jLblMax.setText("MAX:");

        jLblMed.setText("MED:");

        jLabel3.setText("# ITEMS:");

        jBtnAbrir.setText("Abrir");
        jBtnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblMin)
                    .addComponent(jLblMax)
                    .addComponent(jLblMed)
                    .addComponent(jLabel3))
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnAbrir)
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblMax)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblMed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jBtnAbrir))
        );

        jChbTodo.setSelected(true);
        jChbTodo.setText("Seleccionar todo");
        jChbTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChbTodoActionPerformed(evt);
            }
        });

        jCmbModo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fraud", "Moderation" }));
        jCmbModo.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jCmbModoHierarchyChanged(evt);
            }
        });
        jCmbModo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbModoActionPerformed(evt);
            }
        });

        jCheckHoy.setText("Publicado hoy");

        jTxtMin.setText("min");

        jTxtMax.setText("MAX");

        jTxtBuscar.setText("Filtrar");
        jTxtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckHoy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTxtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckHoy)
                    .addComponent(jTxtBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtnResetear.setText("Resetear");
        jBtnResetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnResetearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(53, 53, 53))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qText, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(site_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRbNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRbUsado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnResetear)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jCmbModo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PromedioLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PromedioUSDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChbTodo))
                    .addComponent(jSP))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(qText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(site_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jRbNuevo)
                                        .addComponent(jRbUsado)
                                        .addComponent(jBtnResetear)
                                        .addComponent(jButton1)))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jCmbModo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(PromedioUSDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(PromedioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jChbTodo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSP, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLblCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busquedaGeneral(String min, String max, boolean publicadoHoy) {
        String condicion = verEstado(jRbNuevo);
        jChbTodo.setSelected(true);
        inicializarChecks();

        search = SearchHandler.getInstance().getSearchwithUnirest(qText.getText(), site_id.getSelectedItem().toString(), condicion, min, max, publicadoHoy);
        cp.removeAll();
        if (!search.getItemList().isEmpty()) {
            promedioLocal = search.getPromedio(site_id.getSelectedItem().toString(), checks);
            if (!site_id.getSelectedItem().toString().equals("MLV")) {
                promedioUSD = search.getPromedioenUSD(site_id.getSelectedItem().toString(), checks);
            } else {
                promedioUSD = 0.0;
            }

            hiloA = new Thread(new hiloDatos());
            hiloB = new Thread(new hiloCategorias());
            hiloC = new Thread(new hiloResultados());

            hiloA.start();
            hiloB.start();
            hiloC.start();
        } else {
            JOptionPane.showMessageDialog(null, "Error de busqueda");
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!qText.getText().equals("")) {
            busquedaGeneral("*", "*", false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbNuevoActionPerformed
        if (jRbNuevo.isSelected()) {
            jRbUsado.setSelected(false);
        }
    }//GEN-LAST:event_jRbNuevoActionPerformed

    private void jChbTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChbTodoActionPerformed
        if (jChbTodo.isSelected()) {
            for (int i = 0; i < 50; i++) {
                checks[i].setSelected(true);
            }
        } else {
            for (int i = 0; i < 50; i++) {
                checks[i].setSelected(false);
            }
        }
    }//GEN-LAST:event_jChbTodoActionPerformed

    private void qTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qTextKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            busquedaGeneral("*", "*", false);
        }
    }//GEN-LAST:event_qTextKeyReleased

    private void jTxtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtPrecioKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) && !(qText.getText().equals(""))) {
            busquedaGeneral("*", "*", false);
        }
    }//GEN-LAST:event_jTxtPrecioKeyReleased

    private void jTxtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtBuscarActionPerformed
        if (!qText.getText().equals("")) {
            if (jTxtMin.getText().equals("")) {
                jTxtMin.setText("*");
            }
            if (jTxtMax.getText().equals("")) {
                jTxtMax.setText("*");
            }
            busquedaGeneral(jTxtMin.getText(), jTxtMax.getText(), jCheckHoy.isSelected());
        }
    }//GEN-LAST:event_jTxtBuscarActionPerformed

    private void jCmbModoHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jCmbModoHierarchyChanged


    }//GEN-LAST:event_jCmbModoHierarchyChanged

    private void jCmbModoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbModoActionPerformed
        if (jCmbModo.getSelectedItem().toString().equals("Fraud")) {
            jPanel3.setVisible(false);
            if (checks[0] != null) {
                for (int i = 0; i < 50; i++) {
                    checks[i].setSelected(true);
                }
            }
        } else if (jCmbModo.getSelectedItem().toString().equals("Moderation")) {
            jPanel3.setVisible(true);
            if (checks[0] != null) {
                for (int i = 0; i < 50; i++) {
                    checks[i].setSelected(false);
                }
            }
        }
    }//GEN-LAST:event_jCmbModoActionPerformed

    private void jBtnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAbrirActionPerformed
        if (checks[0] != null) {
            for (int i = 0; i < items; i++) {
                if (checks[i].isSelected()) {
                    String id = search.getItemList().get(i).getId();
                    enlace("https://moderations.adminml.com/revisions/item/search/item/" + id + "/");
                }
            }
        }
    }//GEN-LAST:event_jBtnAbrirActionPerformed

    private void qTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qTextActionPerformed

    private void qTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qTextFocusLost
        qText.setText(quitaEspacios(qText.getText()));

    }//GEN-LAST:event_qTextFocusLost

    private void jBtnResetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnResetearActionPerformed
        qText.setText("");
        jTxtPrecio.setText("");
        jRbNuevo.setSelected(true);
    }//GEN-LAST:event_jBtnResetearActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PriceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PromedioLabel;
    private javax.swing.JLabel PromedioUSDLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnAbrir;
    private javax.swing.JButton jBtnResetear;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jChbTodo;
    private javax.swing.JCheckBox jCheckHoy;
    private javax.swing.JComboBox<String> jCmbModo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblCategorias;
    private javax.swing.JLabel jLblMax;
    private javax.swing.JLabel jLblMed;
    private javax.swing.JLabel jLblMin;
    private javax.swing.JLabel jLblPrecio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JRadioButton jRbNuevo;
    private javax.swing.JRadioButton jRbUsado;
    private javax.swing.JScrollPane jSP;
    private javax.swing.JButton jTxtBuscar;
    private javax.swing.JTextField jTxtMax;
    private javax.swing.JTextField jTxtMin;
    private javax.swing.JTextField jTxtPrecio;
    private javax.swing.JTextField qText;
    private javax.swing.JComboBox<String> site_id;
    // End of variables declaration//GEN-END:variables

    public void inicializarChecks() {
        for (int i = 0; i < 50; i++) {
            checks[i] = new JCheckBox();
            checks[i].setSelected(true);
        }
    }

    public String quitaEspacios(String texto) {
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(texto);
        texto = "";
        while (tokens.hasMoreTokens()) {
            texto += " " + tokens.nextToken();
        }
        texto = texto.toString();
        texto = texto.trim();
        return texto;
    }

    public boolean[] calcularSeleccion(JCheckBox[] checks) {
        boolean[] aux = new boolean[50];
        for (int i = 0; i < 50; i++) {
            aux[i] = checks[i].isSelected();
        }
        return aux;
    }

    private void cargarDatos(Double promedioLocal, Double promedioUSD, Search search) {
        DecimalFormat format = new DecimalFormat("###########.##");
        if (promedioLocal >= 1000000) {
            PromedioLabel.setText(format.format(promedioLocal / 1000000) + " M " + CurrencyHandler.getInstance().getCurrencyID(site_id.getSelectedItem().toString()));
        } else {
            PromedioLabel.setText(format.format(promedioLocal) + " " + CurrencyHandler.getInstance().getCurrencyID(site_id.getSelectedItem().toString()));
        }

        PromedioUSDLabel.setText(promedioUSD + " USD");
        jLabel3.setText("# ITEMS: " + search.getTotalItems().toString());
        jLblMin.setText("MIN: " + search.getMinimo(site_id.getSelectedItem().toString(), checks));
        jLblMax.setText("MAX: " + search.getMaximo(site_id.getSelectedItem().toString(), checks));
        jLblMed.setText("MED: " + search.getMediana(site_id.getSelectedItem().toString(), checks));

        if (!jTxtPrecio.getText().equals("")) {
            verPrecio(Double.parseDouble(jTxtPrecio.getText()), promedioLocal);
        } else {
            jLblPrecio.setText("");
        }
    }

    private String verEstado(JRadioButton jRbNuevo) {
        if (jRbNuevo.isSelected()) {
            return "new";
        } else {
            return "used";
        }
    }

    private void verPrecio(Double precioIngresado, Double promedioLocal) {
        if (precioIngresado < (promedioLocal - promedioLocal * 0.3)) {
            jLblPrecio.setText("Muy bajo");
            jLblPrecio.setForeground(Color.RED);
        } else if (precioIngresado < (promedioLocal - promedioLocal * 0.1)) {
            jLblPrecio.setText("Bajo");
            jLblPrecio.setForeground(Color.ORANGE);
        } else {
            jLblPrecio.setText("Ok");
            jLblPrecio.setForeground(Color.BLUE);

        }
        jLblPrecio.setFont(new java.awt.Font("Arial", 1, 20));
    } 
    
    private JLabel verPrecio2(Double precioIngresado, Double promedioLocal) {
        JLabel aux = new JLabel();
        aux.setText(precioIngresado.toString());
        if (precioIngresado < (promedioLocal - promedioLocal * 0.3)) {
            aux.setForeground(Color.RED);
        } else if (precioIngresado < (promedioLocal - promedioLocal * 0.1)) {
            aux.setForeground(Color.ORANGE);
        } else {
            aux.setForeground(Color.BLUE);

        }
        aux.setFont(new java.awt.Font("Arial", 1, 20));
        return aux;
    } 

    public void cargarCategorias(Search search) {
        if (search.getFilters().get(0).getValues().get(0).getPath_from_root() != null) {
            int tamaño = search.getFilters().get(0).getValues().get(0).getPath_from_root().size();
            String categorias = "";
            for (int i = 0; i < tamaño; i++) {
                if (i < tamaño - 1) {
                    categorias = categorias + search.getFilters().get(0).getValues().get(0).getPath_from_root().get(i).getName() + " > ";
                } else {
                    categorias = categorias + search.getFilters().get(0).getValues().get(0).getPath_from_root().get(i).getName();
                }
            }
            jLblCategorias.setText(categorias);

        } else {
            jLblCategorias.setText("");
        }
    }

    public void cargarResultados() {
        items = 0;
        if (search.getItemList().size() < 50) {
            items = search.getItemList().size();
        } else {
            items = 50;
        }
        GridLayout gl = new GridLayout(items, 4);
        gl.setHgap(5);
        gl.setVgap(5);
        cp.setLayout(gl);
        cp.setSize(new Dimension(1000, 3500));
        for (int i = 0; i < items; i++) {
            try {
                url[i] = new URL(search.getItemList().get(i).getThumbnail());

            } catch (MalformedURLException ex) {
                Logger.getLogger(PriceFrame.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            try {
                imagen[i] = ImageIO.read(url[i]);

            } catch (IOException ex) {
                Logger.getLogger(PriceFrame.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            label[i] = new JLabel(new ImageIcon(imagen[i]));

            cp.add(label[i]);
            cp.add(new JLabel(search.getItemList().get(i).getTitle()));
            precio[i] = new JLabel();
            precio[i].setText(search.getItemList().get(i).getPrice().toString());
            
            Double elPrecio = Double.parseDouble(precio[i].getText());
            
            precio[i]=verPrecio2(elPrecio, promedioLocal);
            DecimalFormat format = new DecimalFormat("###########.##");
            format.format(elPrecio);
            if (elPrecio >= 1000000) {
                precio[i].setText(format.format(elPrecio / 1000000) + " M");
            }
            cp.add(precio[i]);
            checks[i] = new JCheckBox();
            checks[i].setSelected(true);

            cp.add(checks[i]);

        }
        jSP.setViewportView(cp);
        jSP.getViewport().setView(cp);
        cp.setVisible(true);
    }

    public void actionChecks() {
        if (!search.getItemList().isEmpty()) {
            Double promedioLocal = search.getPromedio(site_id.getSelectedItem().toString(), checks);
            Double promedioUSD = search.getPromedioenUSD(site_id.getSelectedItem().toString(), checks);
            cargarDatos(promedioLocal, promedioUSD, search);
        } else {
            JOptionPane.showMessageDialog(null, "Error de busqueda");
        }
    }

    public void enlace(String enlaceAAceder) {
        Desktop enlace = Desktop.getDesktop();
        try {
            enlace.browse(new URI(enlaceAAceder));
        } catch (IOException | URISyntaxException e) {
            e.getMessage();

        }
    }

    class NoHaceNada {

    }

    class hiloDatos extends NoHaceNada implements Runnable {

        @Override
        public void run() {
            cargarDatos(promedioLocal, promedioUSD, search);

        }
    }

    class hiloCategorias extends NoHaceNada implements Runnable {

        @Override
        public void run() {
            // Presenta en pantalla información sobre este hilo en particular
            cargarCategorias(search);
        }
    }

    class hiloResultados extends NoHaceNada implements Runnable {

        @Override
        public void run() {
            // Presenta en pantalla información sobre este hilo en particular
            cargarResultados();
        }
    }
}
