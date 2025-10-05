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

        for (var e : lista) {
            String fechaVinc = (e.getFechaVinculacion() == null) ? "" : e.getFechaVinculacion().format(F);
            String fechaIngr = (e.getFechaIngreso() == null) ? "" : e.getFechaIngreso().format(F);

            model.addRow(new Object[]{
                e.getNombre(),
                e.getApellido(),
                e.getDocumento(),
                fechaVinc,
                fechaIngr,
                e.getTipo_empleado(),
                e.getSalario(),
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
        botonRegistrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Nombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Nombre.setText("Lista de empleados:");

        botonRegistrar.setBackground(new java.awt.Color(0, 255, 0));
        botonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrar.setText("Guardar");
        botonRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(102, 102, 102)));
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

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
                .addGap(125, 125, 125)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(Nombre))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        AdminMenuView adminView = new AdminMenuView(mainFrame, depCtrl, empCtrl);

        mainFrame.cambiarVista(adminView);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
       
        /*try{
            String nombreDepartamento = textNombre.getText();
            String descripcionDepartamento = textDescripcion.getText();
            Departamento departamento = new Departamento(nombreDepartamento, descripcionDepartamento);

            if(nombreDepartamento.equals("") && descripcionDepartamento.equals("")){
                JOptionPane.showMessageDialog(this, "Campos nombre y descripción vacios.");
            } else if(nombreDepartamento.equals("") && !descripcionDepartamento.equals("")){
                JOptionPane.showMessageDialog(this, "Campo nombre vacio.");
            } else if(!nombreDepartamento.equals("") && descripcionDepartamento.equals("")){
                JOptionPane.showMessageDialog(this, "Campo descripcion vacio.");
            } else{
                depCtrl.registrar(departamento);

                JOptionPane.showMessageDialog(this, "Departamento registrado con éxito");

                textNombre.setText("");
                textDescripcion.setText("");
            }

        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }*/
    }//GEN-LAST:event_botonRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    // End of variables declaration//GEN-END:variables
}
