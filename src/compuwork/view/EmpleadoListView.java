/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package compuwork.view;

import compuwork.controller.EmpleadoController;
import compuwork.controller.DepartamentoController;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 *
 * @author Jorge
 */

public class EmpleadoListView extends javax.swing.JPanel {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DepartamentoView.class.getName());

    private SeleccionDeRol mainFrame;
    private DepartamentoController depCtrl;
    private EmpleadoController empCtrl;

    //maca dice: aca se debe crear el constructor para poder onectar el listado a la tabla, pero aún no sabemos como
    public EmpleadoListView() {
        initComponents();
    }

    /**
     * Creates new form EmpleadoListView
     */
    public EmpleadoListView(SeleccionDeRol mainFrame, DepartamentoController depCtrl, EmpleadoController empCtrl) {
        initComponents();
        this.mainFrame = mainFrame;
        this.depCtrl = depCtrl;
        this.empCtrl = empCtrl;
        configurarColumnaEliminarComoBoton();
        cargarDatos();
    }
    
      private void cargarDatos() {
        DefaultTableModel model = (DefaultTableModel) tblEmpleados.getModel();
        model.setRowCount(0);

        var lista = empCtrl.getEmpleados();
        DateTimeFormatter F = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (var empleado : lista) {
            String fechaVinc = (empleado.getFechaVinculacion() == null) ? "" : empleado.getFechaVinculacion().format(F);
            String fechaIngr = (empleado.getFechaIngreso() == null) ? "" : empleado.getFechaIngreso().format(F);

            model.addRow(new Object[]{
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getDocumento(),
                fechaVinc,
                fechaIngr,
                empleado.getTipo_empleado(),
                empleado.getSalario(),
                "Eliminar"
            });
        }
    }

    private static class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
        ButtonRenderer() {
            setOpaque(true);
            setFocusPainted(false);
            setForeground(Color.WHITE);
            setBackground(new Color(220, 53, 69));
            setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value == null ? "Eliminar" : value.toString());
            return this;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {
        private final JButton button = new JButton();
        private String currentText;
        private int currentRow = -1;
        private boolean clicked;

        public ButtonEditor() {
            super(new JTextField());
            setClickCountToStart(1);
            button.setOpaque(true);
            button.setFocusPainted(false);
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(220, 53, 69));
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            currentText = (value == null) ? "Eliminar" : value.toString();
            currentRow = row;
            button.setText(currentText);
            clicked = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (clicked) {
                int resp = JOptionPane.showConfirmDialog(
                        EmpleadoListView.this,
                        "¿Estás seguro de eliminar este empleado?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (resp == JOptionPane.YES_OPTION) {
                    int colDoc = tblEmpleados.getColumnModel().getColumnIndex("Documento");
                    Object cell = tblEmpleados.getValueAt(currentRow, colDoc);

                    long docId = (cell instanceof Number)
                            ? ((Number) cell).longValue()
                            : Long.parseLong(cell.toString());

                    boolean ok = empCtrl.eliminarPorDocumento(docId);
                    if (!ok) {
                        JOptionPane.showMessageDialog(EmpleadoListView.this, "No se pudo eliminar (no encontrado).");
                    } else {
                        cargarDatos();
                    }
                }
            }
            clicked = false;
            return currentText;
        }

        @Override
        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }
    }

    private void configurarColumnaEliminarComoBoton() {
        tblEmpleados.getTableHeader().setReorderingAllowed(false);
        TableColumn colEliminar = tblEmpleados.getColumn("ELIMINAR");
        colEliminar.setCellRenderer(new ButtonRenderer());
        colEliminar.setCellEditor(new ButtonEditor());
        colEliminar.setPreferredWidth(100);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Nombre = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        botonEditar = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));

        Nombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Nombre.setText("Lista de empleados:");

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setBackground(new java.awt.Color(255, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("COMPUWORK");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        botonRegresar.setBackground(new java.awt.Color(255, 153, 0));
        botonRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonRegresar.setForeground(new java.awt.Color(255, 255, 255));
        botonRegresar.setText("< Regresar");
        botonRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(102, 102, 102)));
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Documento", "Fecha vinculacion", "Fecha ingreso", "Tipo empleado", "Salario", "ELIMINAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblEmpleados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEmpleados);

        botonEditar.setBackground(new java.awt.Color(0, 153, 0));
        botonEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonEditar.setForeground(new java.awt.Color(255, 255, 255));
        botonEditar.setText("Editar");
        botonEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(102, 102, 102)));
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addComponent(Nombre)
                .addGap(197, 197, 197))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        AdminMenuView adminView = new AdminMenuView(mainFrame, depCtrl, empCtrl);

        mainFrame.cambiarVista(adminView);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEditarActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    // End of variables declaration//GEN-END:variables
}
