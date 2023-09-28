package proyectotransversalgrupo45.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectotransversalgrupo45.accesoADatos.AlumnoData;
import proyectotransversalgrupo45.accesoADatos.InscripcionData;
import proyectotransversalgrupo45.accesoADatos.MateriaData;
import proyectotransversalgrupo45.entidades.Alumno;
import proyectotransversalgrupo45.entidades.Inscripcion;
import proyectotransversalgrupo45.entidades.Materia;

public class ActualizarNota extends javax.swing.JInternalFrame {

    private List<Alumno> listaA;

    private InscripcionData insData;
    private AlumnoData aData;
    private MateriaData mData;

    private DefaultTableModel modelo;

    public ActualizarNota() {
        initComponents();
        aData = new AlumnoData();
        listaA = aData.listarAlumnos();
        modelo = new DefaultTableModel();
        insData = new InscripcionData();
        mData = new MateriaData();
        armarCabecera();
        comboListarAlumnos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcboxListarAlumnos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtNota = new javax.swing.JTable();
        jbtGuardar = new javax.swing.JButton();
        jbtSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Carga de Nota");

        jLabel2.setText("Seleccione un Alumno:");

        jcboxListarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboxListarAlumnosActionPerformed(evt);
            }
        });

        jtNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtNota);

        jbtGuardar.setText("Guardar");
        jbtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGuardarActionPerformed(evt);
            }
        });

        jbtSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectotransversalgrupo45/recursos/salir (1).png"))); // NOI18N
        jbtSalir.setText("Salir");
        jbtSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcboxListarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtSalir)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcboxListarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtGuardar)
                    .addComponent(jbtSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcboxListarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboxListarAlumnosActionPerformed
        eliminarFilas();
        cargaDeMaterias();
    }//GEN-LAST:event_jcboxListarAlumnosActionPerformed

    private void jbtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGuardarActionPerformed

        int filaSeleccionada = jtNota.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una materia "
                    + "de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Alumno alumno = (Alumno) jcboxListarAlumnos.getSelectedItem();
        int idAlumno = alumno.getIdAlumno();

        int idMateria = (int) jtNota.getValueAt(filaSeleccionada, 0);
        Materia m = mData.buscarMateria(idMateria);

        try {

            String nuevaNotaStr = JOptionPane.showInputDialog(this, "Ingrese la nueva nota:",
                    "Actualizar Nota", JOptionPane.PLAIN_MESSAGE);

            if (nuevaNotaStr != null) {
                double nuevaNota = Double.parseDouble(nuevaNotaStr);

                insData.actualizarNota(idAlumno, idMateria, nuevaNota);

                JOptionPane.showMessageDialog(this, "La nota ha sido actualizada correctamente.",
                        "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una nota válida.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la nota.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtGuardarActionPerformed

    private void jbtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbtSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtGuardar;
    private javax.swing.JButton jbtSalir;
    private javax.swing.JComboBox<Alumno> jcboxListarAlumnos;
    private javax.swing.JTable jtNota;
    // End of variables declaration//GEN-END:variables
private void armarCabecera() {

        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Codigo");
        filaCabecera.add("Nombre");
        filaCabecera.add("Nota");
        for (Object it : filaCabecera) {

            modelo.addColumn(it);

        }
        jtNota.setModel(modelo);

    }

    private void comboListarAlumnos() {

        for (Alumno item : listaA) {

            jcboxListarAlumnos.addItem(item);

        }
    }

    private void eliminarFilas() {

        int f = jtNota.getRowCount() - 1;
        for (; f >= 0; f--) {

            modelo.removeRow(f);
        }
    }

    private void cargaDeMaterias() {

        Alumno selec = (Alumno) jcboxListarAlumnos.getSelectedItem();
        List<Inscripcion> insc = insData.ObtenerInscripcionesPorAlumno(selec.getIdAlumno());

        for (Inscripcion ins : insc) {

            Materia materia = ins.getMateria();
            double nota = ins.getNota();

            if (materia.isActivo()) {

                modelo.addRow(new Object[]{
                    materia.getIdMateria(),
                    materia.getNombre(),
                    nota
                });
            }
        }
    }

}
