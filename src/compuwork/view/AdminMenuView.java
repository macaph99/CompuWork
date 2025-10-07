/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package compuwork.view;

import compuwork.controller.DepartamentoController;
import compuwork.controller.EmpleadoController;
import javax.swing.JPanel;
import compuwork.view.DepartamentoListView;
import compuwork.view.EmpleadoListView;
import compuwork.view.DepartamentoView;
import compuwork.view.EmpleadoView;


/**
 *
 * @author user
 */
public class AdminMenuView extends javax.swing.JPanel {
    private final SeleccionDeRol mainFrame;
    private final DepartamentoController depCtrl;
    private final EmpleadoController empCtrl;

    public AdminMenuView(SeleccionDeRol mainFrame, DepartamentoController depCtrl, EmpleadoController empCtrl) {
        initComponents();
        this.mainFrame = mainFrame;
        this.depCtrl = depCtrl;
        this.empCtrl = empCtrl;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        panelAdministrador = new javax.swing.JPanel();
        administradorLabel = new javax.swing.JLabel();
        botonSelectAdm = new javax.swing.JButton();
        panelEmpleado = new javax.swing.JPanel();
        empleadoLabel = new javax.swing.JLabel();
        botonSelectEmp = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnRegDepto = new javax.swing.JButton();
        btnRegEmpleado = new javax.swing.JButton();
        btnListarDeptos = new javax.swing.JButton();
        btnListarEmpleados = new javax.swing.JButton();
        btnRepInd = new javax.swing.JButton();
        btnRepDep = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        panelAdministrador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        administradorLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        administradorLabel.setText("Administrador");

        botonSelectAdm.setText("Seleccionar");
        botonSelectAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSelectAdmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdministradorLayout = new javax.swing.GroupLayout(panelAdministrador);
        panelAdministrador.setLayout(panelAdministradorLayout);
        panelAdministradorLayout.setHorizontalGroup(
            panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdministradorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(botonSelectAdm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(administradorLabel)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        panelAdministradorLayout.setVerticalGroup(
            panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdministradorLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(administradorLabel)
                    .addComponent(botonSelectAdm))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        panelEmpleado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        empleadoLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        empleadoLabel.setText("Empleado");

        botonSelectEmp.setText("Seleccionar");
        botonSelectEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSelectEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEmpleadoLayout = new javax.swing.GroupLayout(panelEmpleado);
        panelEmpleado.setLayout(panelEmpleadoLayout);
        panelEmpleadoLayout.setHorizontalGroup(
            panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmpleadoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(botonSelectEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(empleadoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEmpleadoLayout.setVerticalGroup(
            panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empleadoLabel)
                    .addComponent(botonSelectEmp))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(139, 139, 139))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(panelAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(255, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("COMPUWORK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Listar:");

        btnExit.setBackground(new java.awt.Color(255, 51, 51));
        btnExit.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("EXIT");
        btnExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnRegDepto.setText("REG. DEPARTAMENTO");
        btnRegDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegDeptoActionPerformed(evt);
            }
        });

        btnRegEmpleado.setText("REG. EMPLEADO");
        btnRegEmpleado.setPreferredSize(new java.awt.Dimension(149, 23));
        btnRegEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegEmpleadoActionPerformed(evt);
            }
        });

        btnListarDeptos.setText("DEPARTAMENTOS");
        btnListarDeptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarDeptosActionPerformed(evt);
            }
        });

        btnListarEmpleados.setText("EMPLEADOS");
        btnListarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarEmpleadosActionPerformed(evt);
            }
        });

        btnRepInd.setText("INDIVIDUAL");
        btnRepInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepIndActionPerformed(evt);
            }
        });

        btnRepDep.setText("POR DEPARTAMENTO");
        btnRepDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepDepActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Reporte:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnListarDeptos, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnListarEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnRegDepto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel6)))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRepInd, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRepDep, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel7))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRepInd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRepDep, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarDeptos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonSelectAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSelectAdmActionPerformed
        
    }//GEN-LAST:event_botonSelectAdmActionPerformed

    private void botonSelectEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSelectEmpActionPerformed
        
    }//GEN-LAST:event_botonSelectEmpActionPerformed

    private void btnListarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarEmpleadosActionPerformed
        EmpleadoListView listView = new EmpleadoListView(mainFrame,depCtrl, empCtrl);
        mainFrame.cambiarVista(listView);
    }//GEN-LAST:event_btnListarEmpleadosActionPerformed

    private void btnListarDeptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarDeptosActionPerformed
        DepartamentoListView listview = new DepartamentoListView(mainFrame, depCtrl, empCtrl);
        mainFrame.cambiarVista(listview);
    }//GEN-LAST:event_btnListarDeptosActionPerformed

    private void btnRegEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegEmpleadoActionPerformed
        EmpleadoView empView = new EmpleadoView(mainFrame, depCtrl, empCtrl);
        mainFrame.cambiarVista(empView);
    }//GEN-LAST:event_btnRegEmpleadoActionPerformed

    private void btnRegDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegDeptoActionPerformed
        DepartamentoView dptoView = new DepartamentoView(mainFrame, depCtrl, empCtrl);
        mainFrame.cambiarVista(dptoView);
    }//GEN-LAST:event_btnRegDeptoActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        mainFrame.volverAInicio();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnRepIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepIndActionPerformed
        try {
            var empleados = empCtrl.getEmpleados();
            if (empleados.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "No hay empleados registrados.",
                    "Atención",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            String[] opciones = empleados.stream()
                .map(empleado -> empleado.getIdEmpleado() + " - " + empleado.getNombre() + " " + empleado.getApellido())
                .toArray(String[]::new);

            String seleccion = (String) javax.swing.JOptionPane.showInputDialog(
                this,
                "Selecciona un empleado:",
                "Reporte Individual",
                javax.swing.JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (seleccion != null) {
                int idEmpleado = Integer.parseInt(seleccion.split(" - ")[0]);
                var elegido = empleados.stream()
                    .filter(empleado -> empleado.getIdEmpleado() == idEmpleado)
                    .findFirst().orElse(null);
                if (elegido == null) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
                    return;
                }
                String reporte = compuwork.models.ReporteDesempeno.generarReporteEmpleado(elegido);
                javax.swing.JOptionPane.showMessageDialog(this,
                    reporte,
                    "Reporte Individual",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error generando reporte: " + e.getMessage(),
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRepIndActionPerformed

    private void btnRepDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepDepActionPerformed
        try {
            var departamentos = depCtrl.getDepartamentos();
            if (departamentos.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "No hay departamentos registrados.",
                    "Atención",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            String[] opciones = departamentos.stream()
                .map(departamento -> departamento.getIdDepartamento() + " - " + departamento.getNombre())
                .toArray(String[]::new);

            String seleccion = (String) javax.swing.JOptionPane.showInputDialog(
                this,
                "Selecciona un departamento:",
                "Reporte por Departamento",
                javax.swing.JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (seleccion != null) {
                int idDepto = Integer.parseInt(seleccion.split(" - ")[0]);
                var depto = departamentos.stream()
                    .filter(departamento -> departamento.getIdDepartamento() == idDepto)
                    .findFirst().orElse(null);
                if (depto == null) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Departamento no encontrado.");
                    return;
                }
                String reporte = compuwork.models.ReporteDesempeno.generarReporteDepartamento(depto);
                javax.swing.JOptionPane.showMessageDialog(this,
                    reporte,
                    "Reporte por Departamento",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error generando reporte: " + e.getMessage(),
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRepDepActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel administradorLabel;
    private javax.swing.JButton botonSelectAdm;
    private javax.swing.JButton botonSelectEmp;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnListarDeptos;
    private javax.swing.JButton btnListarEmpleados;
    private javax.swing.JButton btnRegDepto;
    private javax.swing.JButton btnRegEmpleado;
    private javax.swing.JButton btnRepDep;
    private javax.swing.JButton btnRepInd;
    private javax.swing.JLabel empleadoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel panelAdministrador;
    private javax.swing.JPanel panelEmpleado;
    // End of variables declaration//GEN-END:variables
}
