package proyectotransversalgrupo45.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectotransversalgrupo45.entidades.Alumno;
import proyectotransversalgrupo45.entidades.Inscripcion;
import proyectotransversalgrupo45.entidades.Materia;

public class InscripcionData {

    private Connection con = null;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {

        con = Conexion.getConexion();
        matData = new MateriaData();
        aluData = new AlumnoData();
    }

    public void guardarInscripcion(Inscripcion insc) {

        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción Guardada: " + insc.toString());

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la inscripción");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripción: " + ex.getMessage());
        }
    }

    public List<Inscripcion> listarInscripciones() {

        String sql = "SELECT * FROM `inscripcion`";

        ArrayList<Inscripcion> ins = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Inscripcion inscripcion = new Inscripcion();

                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                inscripcion.setNota(rs.getDouble("nota"));

                // Obtener el ID del alumno y la materia
                int idAlumno = rs.getInt("idAlumno");
                int idMateria = rs.getInt("idMateria");

                // Obtener los objetos Alumno y Materia correspondientes a los IDs
                Alumno alumno = aluData.buscarAlumno(idAlumno);
                Materia materia = matData.buscarMateria(idMateria);

                // Configurar el alumno y la materia en la inscripción
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);

                ins.add(inscripcion);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

        return ins;
    }

    public List<Inscripcion> ObtenerInscripcionesPorAlumno(int id) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Inscripcion inscripcion = new Inscripcion();

                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));

                inscripcion.setNota(rs.getDouble("nota"));

                Alumno alumno = aluData.buscarAlumno(rs.getInt("idAlumno"));

                Materia materia = matData.buscarMateria(rs.getInt("idMateria"));

                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);

                inscripciones.add(inscripcion);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + ex.getMessage());
        }

        return inscripciones;
    }

    public List<Materia> ObtenerMateriasCursadas(int id) {

        ArrayList<Materia> materias = new ArrayList<>();

        String sql = "SELECT i.idMateria, m.nombre, m.año "
                + "FROM inscripcion i "
                + "JOIN materia m ON i.idMateria = m.idMateria "
                + "WHERE i.idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();

                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + ex.getMessage());
        }

        return materias;
    }

    public List<Materia> ObtenerNoMateriasCursadas(int id) {
        ArrayList<Materia> materiasNoCursadas = new ArrayList<>();

        String sql = "SELECT * FROM materia "
                + "WHERE estado = 1 AND idMateria NOT IN ( "
                + "    SELECT idMateria FROM inscripcion WHERE idAlumno = ? "
                + ")";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();

                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materiasNoCursadas.add(materia);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener materias no cursadas: " + ex.getMessage());
        }

        return materiasNoCursadas;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {

        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas == 1) {
                JOptionPane.showMessageDialog(null, "Inscripción eliminada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró una inscripción para eliminar");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nuevaNota) {
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nuevaNota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            int filasAfectadas = ps.executeUpdate();


            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la nota: " + ex.getMessage());
        }
    }

    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT a.idAlumno, dni, apellido, nombre,fechaNacimiento, estado "
                + "FROM inscripcion i "
                + "JOIN alumno a ON i.idAlumno = a.idAlumno "
                + "WHERE i.idMateria = ? AND a.estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();

                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));

                alumnos.add(alumno);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + ex.getMessage());
        }

        return alumnos;
    }

}
