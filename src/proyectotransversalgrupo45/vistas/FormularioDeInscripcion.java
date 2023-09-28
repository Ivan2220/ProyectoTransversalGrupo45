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

public class FormularioDeInscripcion extends javax.swing.JInternalFrame {

    private List<Materia> listaM;
    private List<Alumno> listaA;

    private InscripcionData insData;
    private AlumnoData aData;
    private MateriaData mData;

    private DefaultTableModel modelo;

    public FormularioDeInscripcion() {
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
        jLabel3 = new javax.swing.JLabel();
        jrdMateriasInscriptas = new javax.swing.JRadioButton();
        jrdMateriasNoInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInscripcion = new javax.swing.JTable();
        jbtAnular = new javax.swing.JButton();
        jbtSalir = new javax.swing.JButton();
        jbtInscribir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Formulario Inscripcion");

        jLabel2.setText("Seleccione un alumno:");

        jLabel3.setText("Listado de Materias");

        jrdMateriasInscriptas.setText("Materias Inscriptas");
        jrdMateriasInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdMateriasInscriptasActionPerformed(evt);
            }
        });

        jrdMateriasNoInscriptas.setText("Materias no Inscriptas");
        jrdMateriasNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdMateriasNoInscriptasActionPerformed(evt);
            }
        });

        jtInscripcion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtInscripcion);

        jbtAnular.setText("Anular Inscripcion");
        jbtAnular.setEnabled(false);
        jbtAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAnularActionPerformed(evt);
            }
        });

        jbtSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectotransversalgrupo45/recursos/salir (1).png"))); // NOI18N
        jbtSalir.setText("Salir");
        jbtSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalirActionPerformed(evt);
            }
        });

        jbtInscribir.setText("Inscribir");
        jbtInscribir.setEnabled(false);
        jbtInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInscribirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jrdMateriasInscriptas))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrdMateriasNoInscriptas)
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jcboxListarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtInscribir)
                        .addGap(83, 83, 83)
                        .addComponent(jbtAnular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtSalir)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcboxListarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrdMateriasInscriptas)
                    .addComponent(jrdMateriasNoInscriptas))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtAnular)
                    .addComponent(jbtSalir)
                    .addComponent(jbtInscribir))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrdMateriasInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdMateriasInscriptasActionPerformed
        eliminarFilas();

        jrdMateriasInscriptas.setSelected(false);
        cargaDatosInscriptas();
        jbtInscribir.setEnabled(false);
        jbtAnular.setEnabled(true);
    }//GEN-LAST:event_jrdMateriasInscriptasActionPerformed

    private void jrdMateriasNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdMateriasNoInscriptasActionPerformed

        eliminarFilas();

        jrdMateriasNoInscriptas.setSelected(false);
        cargaDatosNoInscriptas();
        jbtInscribir.setEnabled(true);
        jbtAnular.setEnabled(false);
    }//GEN-LAST:event_jrdMateriasNoInscriptasActionPerformed

    private void jbtInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInscribirActionPerformed

        // Obtener la fila seleccionada en la JTable
        int filaSeleccionada = jtInscripcion.getSelectedRow();

        if (filaSeleccionada != -1) {

            Alumno a = (Alumno) jcboxListarAlumnos.getSelectedItem();

            // Obtener el ID de la materia seleccionada en la JTable
            int idMateria = (int) jtInscripcion.getValueAt(filaSeleccionada, 0);
            
            String nombreMateria = (String) modelo.getValueAt(filaSeleccionada, 1);
            int anio = (Integer) modelo.getValueAt(filaSeleccionada, 2);
            Materia m = new Materia(idMateria, nombreMateria, anio, true);

            Inscripcion i = new Inscripcion(a, m, 0);

            insData.guardarInscripcion(i);
            eliminarFilas();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una materia de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbtInscribirActionPerformed

    private void jbtAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAnularActionPerformed

        // Obtener la fila seleccionada en la JTable
        int filaSeleccionada = jtInscripcion.getSelectedRow();

        if (filaSeleccionada != -1) {

            Alumno a = (Alumno) jcboxListarAlumnos.getSelectedItem();

            // Obtener el ID de la materia seleccionada en la JTable
            int idMateria = (int) jtInscripcion.getValueAt(filaSeleccionada, 0);

            insData.borrarInscripcionMateriaAlumno(a.getIdAlumno(), idMateria);
            eliminarFilas();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una materia de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jbtAnularActionPerformed

    private void jbtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbtSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAnular;
    private javax.swing.JButton jbtInscribir;
    private javax.swing.JButton jbtSalir;
    private javax.swing.JComboBox<Alumno> jcboxListarAlumnos;
    private javax.swing.JRadioButton jrdMateriasInscriptas;
    private javax.swing.JRadioButton jrdMateriasNoInscriptas;
    private javax.swing.JTable jtInscripcion;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {

        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("ID");
        filaCabecera.add("Nombre");
        filaCabecera.add("Año");
        for (Object it : filaCabecera) {

            modelo.addColumn(it);

        }
        jtInscripcion.setModel(modelo);

    }

    private void comboListarAlumnos() {

        for (Alumno item : listaA) {

            jcboxListarAlumnos.addItem(item);

        }
    }

    private void eliminarFilas() {

        int f = jtInscripcion.getRowCount() - 1;
        for (; f >= 0; f--) {

            modelo.removeRow(f);
        }
    }

    private void cargaDatosNoInscriptas() {

        Alumno selec = (Alumno) jcboxListarAlumnos.getSelectedItem();
        listaM = insData.ObtenerNoMateriasCursadas(selec.getIdAlumno());
        for (Materia m : listaM) {

            modelo.addRow(new Object[]{
                m.getIdMateria(),
                m.getNombre(),
                m.getAnioMateria(),});

        }
    }

    private void cargaDatosInscriptas() {

        Alumno selec = (Alumno) jcboxListarAlumnos.getSelectedItem();
        List<Materia> lista = insData.ObtenerMateriasCursadas(selec.getIdAlumno());
        for (Materia m : lista) {

            modelo.addRow(new Object[]{
                m.getIdMateria(),
                m.getNombre(),
                m.getAnioMateria(),});

        }
    }
}
