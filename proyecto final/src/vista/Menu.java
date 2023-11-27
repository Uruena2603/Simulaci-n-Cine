package vista;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import controlador.ControladorImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Reservas;
import modelo.Sillas;
import modelo.Tarjeta;

public final class Menu extends javax.swing.JFrame {

    Tarjeta tar = new Tarjeta();
    JToggleButton[][] sillas = new JToggleButton[14][20];
    static ArrayList<Sillas> btn = new ArrayList<Sillas>();
    ControladorImpl contr = new ControladorImpl();

    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ejecutar();
    }

    public JToggleButton ejecutar() {

        int d, v = 0;

        sillasD.setText("280");
        d = Integer.parseInt(sillasD.getText());

        jPanel2.setLayout(new GridLayout(14, 20));

        for (int i = 0; i < 14; i++) {

            char letra = (char) (65 + i);

            for (int j = 0; j < 20; j++) {
                final int fila = i;
                final int columna = j;

                sillas[i][j] = new JToggleButton();
                sillas[i][j].setBackground(new Color(255, 255, 255));
                sillas[i][j].setName(letra + "" + j);
                sillas[i][j].setText(letra + "" + j);
                if (i > 10) {

                    sillas[i][j].setBackground(new Color(51, 204, 0));
                }//IF 2 

                jPanel2.add(sillas[i][j]);

                sillas[i][j].addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent arg0) {
                        Sillas x = new Sillas();
                        x.setFila(fila);
                        x.setColumna(columna);
                        btn.add(x);
                    }//actionPerformed
                });

                d = d - v;
                sillasD.setText(d + "");
                sillasV.setText(v + "");
            }//FOR J FILAS
        }//FOR I COLUMNAS

        ArrayList<Reservas> reservasCreadas = contr.infoReseva();
        if (reservasCreadas != null) {
            for (Reservas reserva : reservasCreadas) {
                ArrayList<Sillas> sillasTmp = reserva.getSilla();
                for (Sillas silla : sillasTmp) {
                    sillas[silla.getFila()][silla.getColumna()].setSelected(true);
                    d = Integer.parseInt(sillasD.getText());
                    v = Integer.parseInt(sillasV.getText());
                    sillasD.setText(d - 1 + "");
                    sillasV.setText(v + 1 + "");
                }// FOR SILLA
            }//FOR RESERVA
        }//IF
        return null;
    }//EJECUTAR                         

    public static boolean validarN(String cedula) {
        return cedula.matches("[0-9]*");
        //VALIDAR SOLO NUMEROS EN LA CEDULA
    }//VALIDARN

    public boolean validaciones() {

        if (!validarN(cedula.getText()) || cedula.getText().equals("") || nombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "DATOS INVALIDOS",
                    "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
            return false;
        }//IF       
        return true;
    }//VALIDACIONES

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tarjeta = new javax.swing.JButton();
        crearR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        caja = new javax.swing.JTextField();
        sillasV = new javax.swing.JTextField();
        sillasD = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        eliminarR = new javax.swing.JButton();
        pagoE = new javax.swing.JButton();
        pagoT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        nombre = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        dineroE = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CINE ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1221, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1067, Short.MAX_VALUE)
        );

        tarjeta.setBackground(new java.awt.Color(255, 255, 255));
        tarjeta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tarjeta.setForeground(new java.awt.Color(0, 0, 0));

        tarjeta.setText("TARJETAS");
        tarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tarjetaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tarjetaMouseExited(evt);
            }
        });
        tarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaActionPerformed(evt);
            }
        });

        crearR.setBackground(new java.awt.Color(255, 255, 255));
        crearR.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        crearR.setForeground(new java.awt.Color(0, 0, 0));
        crearR.setText("AGRERGAR RESERVA");
        crearR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearRMouseExited(evt);
            }
        });
        crearR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearRActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INFORMACIÓN GENERAL");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DINERO EN CAJA: ");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SILLAS DISPONIBLES: ");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SILLAS OCUPADAS:");

        caja.setBackground(new java.awt.Color(255, 255, 255));
        caja.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        caja.setForeground(new java.awt.Color(0, 0, 0));
        caja.setBorder(null);
        caja.setEnabled(false);

        sillasV.setBackground(new java.awt.Color(255, 255, 255));
        sillasV.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        sillasV.setForeground(new java.awt.Color(0, 0, 0));
        sillasV.setBorder(null);
        sillasV.setEnabled(false);

        sillasD.setBackground(new java.awt.Color(255, 255, 255));
        sillasD.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        sillasD.setForeground(new java.awt.Color(0, 0, 0));
        sillasD.setBorder(null);
        sillasD.setEnabled(false);

        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("NOMBRE:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CEDULA:");

        cedula.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        cedula.setBorder(null);

        eliminarR.setBackground(new java.awt.Color(255, 255, 255));
        eliminarR.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        eliminarR.setForeground(new java.awt.Color(0, 0, 0));
        eliminarR.setText("ELIMINAR RESERVA");
        eliminarR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eliminarRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarRMouseExited(evt);
            }
        });
        eliminarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarRActionPerformed(evt);
            }
        });

        pagoE.setBackground(new java.awt.Color(255, 255, 255));
        pagoE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pagoE.setText("PAGO EN EFECTIVO");
        pagoE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pagoEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pagoEMouseExited(evt);
            }
        });
        pagoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagoEActionPerformed(evt);
            }
        });

        pagoT.setBackground(new java.awt.Color(255, 255, 255));
        pagoT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pagoT.setText("PAGO CON TARJETA");
        pagoT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pagoTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pagoTMouseExited(evt);
            }
        });
        pagoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagoTActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        nombre.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        nombre.setBorder(null);

        jPanel3.setBackground(new java.awt.Color(51, 204, 0));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PANTALLA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(509, 509, 509))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dineroE.setBackground(new java.awt.Color(255, 255, 255));
        dineroE.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        dineroE.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(crearR)
                                .addGap(16, 16, 16)
                                .addComponent(eliminarR, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tarjeta))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(label)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(103, 103, 103))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(caja, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sillasD, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(sillasV, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pagoT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pagoE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dineroE, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caja, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(sillasD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(sillasV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crearR)
                            .addComponent(eliminarR)
                            .addComponent(tarjeta))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pagoT)
                                .addComponent(pagoE))
                            .addComponent(dineroE, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaActionPerformed

        new V_Tarjeta().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tarjetaActionPerformed

    private void tarjetaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tarjetaMouseEntered
        tarjeta.setBackground(new Color(51, 204, 0));
        tarjeta.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_tarjetaMouseEntered

    private void tarjetaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tarjetaMouseExited
        tarjeta.setBackground(new Color(255, 255, 255));
        tarjeta.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_tarjetaMouseExited

    private void eliminarRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarRMouseEntered
        eliminarR.setBackground(new Color(51, 204, 0));
        eliminarR.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_eliminarRMouseEntered

    private void eliminarRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarRMouseExited
        eliminarR.setBackground(new Color(255, 255, 255));
        eliminarR.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_eliminarRMouseExited

    private void crearRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearRMouseEntered
        crearR.setBackground(new Color(51, 204, 0));
        crearR.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_crearRMouseEntered

    private void crearRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearRMouseExited
        crearR.setBackground(new Color(255, 255, 255));
        crearR.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_crearRMouseExited

    private void pagoEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagoEMouseExited
        pagoE.setBackground(new Color(255, 255, 255));
        pagoE.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_pagoEMouseExited

    private void pagoTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagoTMouseExited
        pagoT.setBackground(new Color(255, 255, 255));
        pagoT.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_pagoTMouseExited

    private void pagoEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagoEMouseEntered
        pagoE.setBackground(new Color(51, 204, 0));
        pagoE.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_pagoEMouseEntered

    private void pagoTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagoTMouseEntered
        pagoT.setBackground(new Color(51, 204, 0));
        pagoT.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_pagoTMouseEntered

    private void crearRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearRActionPerformed

        if (validaciones() == true) {
            contr.crearReserva(cedula.getText(), nombre.getText(), btn);
            cedula.setText("");
            nombre.setText("");
            for (Sillas i : btn) {
                int d = Integer.parseInt(sillasD.getText());
                int v = Integer.parseInt(sillasV.getText());
                sillasD.setText(d - 1 + "");
                sillasV.setText(v + 1 + "");
            }//FOR
            btn = new ArrayList<Sillas>();
        }
        cedula.setText("");
        nombre.setText("");

    }//GEN-LAST:event_crearRActionPerformed

    private void eliminarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarRActionPerformed

        if (validaciones() == true) {
            ArrayList<Sillas> x = contr.eliminarReserva(cedula.getText());
            if (x != null) {
                for (Sillas i : x) {
                    sillas[i.getFila()][i.getColumna()].setSelected(false);
                    int d = Integer.parseInt(sillasD.getText());
                    int v = Integer.parseInt(sillasV.getText());
                    sillasD.setText(d + 1 + "");
                    sillasV.setText(v - 1 + "");
                }//FOR
            }//IF
            cedula.setText("");
            nombre.setText("");
        }
        cedula.setText("");
        nombre.setText("");
    }//GEN-LAST:event_eliminarRActionPerformed

    private void pagoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagoEActionPerformed

        if (validaciones() == true) {
            contr.pagoE(Integer.parseInt(dineroE.getText()), cedula.getText(), nombre.getText());
        }//IF
        cedula.setText("");
        nombre.setText("");
        dineroE.setText("");
    }//GEN-LAST:event_pagoEActionPerformed

    private void pagoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagoTActionPerformed

        if (validaciones() == true) {
            contr.pagoF(tar.getSaldo(), cedula.getText(), nombre.getText());
        }//IF
        cedula.setText("");
        nombre.setText("");
    }//GEN-LAST:event_pagoTActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField caja;
    private javax.swing.JTextField cedula;
    private javax.swing.JButton crearR;
    private javax.swing.JTextField dineroE;
    private javax.swing.JButton eliminarR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton pagoE;
    private javax.swing.JButton pagoT;
    private javax.swing.JTextField sillasD;
    private javax.swing.JTextField sillasV;
    private javax.swing.JButton tarjeta;
    // End of variables declaration//GEN-END:variables
}
