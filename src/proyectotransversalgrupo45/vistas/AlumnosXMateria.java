package proyectotransversalgrupo45.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import proyectotransversalgrupo45.accesoADatos.AlumnoData;
import proyectotransversalgrupo45.accesoADatos.InscripcionData;
import proyectotransversalgrupo45.accesoADatos.MateriaData;
import proyectotransversalgrupo45.entidades.Alumno;
import proyectotransversalgrupo45.entidades.Inscripcion;
import proyectotransversalgrupo45.entidades.Materia;

public class AlumnosXMateria extends javax.swing.JInternalFrame {

    private List<Alumno> listaA;
    private List<Materia> listaM;
    private InscripcionData insData;
    private AlumnoData aData;
    private MateriaData mData;

    private DefaultTableModel modelo;

    public AlumnosXMateria() {
        initComponents();
        aData = new AlumnoData();
        mData = new MateriaData();  
        listaA = aData.listarAlumnos();
        listaM = mData.listarMaterias();
        modelo = new DefaultTableModel();
        insData = new InscripcionData();
        armarCabecera();
        comboListarAlumnos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbxListarMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jbtSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Listado de Alumnos por Materia");

        jLabel2.setText("Seleccione una Materia:");

        jcbxListarMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxListarMateriasActionPerformed(evt);
            }
        });

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtAlumnos);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jcbxListarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtSalir)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbxListarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jbtSalir)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbtSalirActionPerformed

    private void jcbxListarMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxListarMateriasActionPerformed
        eliminarFilas();
        cargaDeAlumnos();
    }//GEN-LAST:event_jcbxListarMateriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtSalir;
    private javax.swing.JComboBox<Materia> jcbxListarMaterias;
    private javax.swing.JTable jtAlumnos;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {

        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("ID");
        filaCabecera.add("DNI");
        filaCabecera.add("Apellido");
        filaCabecera.add("Nombre");
        for (Object it : filaCabecera) {

            modelo.addColumn(it);

        }
        jtAlumnos.setModel(modelo);

    }

    private void comboListarAlumnos() {

        for (Materia item : listaM) {

            jcbxListarMaterias.addItem(item);

        }
    }

    private void eliminarFilas() {

        int f = jtAlumnos.getRowCount() - 1;
        for (; f >= 0; f--) {

            modelo.removeRow(f);
        }
    }

    private void cargaDeAlumnos() {

        Materia selec = (Materia) jcbxListarMaterias.getSelectedItem();
        List<Alumno> insc = insData.obtenerAlumnosXMateria(selec.getIdMateria());

        for (Alumno alumno : insc) {

            modelo.addRow(new Object[]{
                alumno.getIdAlumno(),
                alumno.getDni(),
                alumno.getApellido(),
                alumno.getNombre()

            });
        }
    }
}
