// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.io.IOException;
import java.io.File;
import java.sql.Connection;

class Conectora
{
    String url;
    Connection connect;
    boolean verificador;
    
    public Conectora() throws IOException {
        this.url = "base.db";
        this.verificador = false;
        final String ruta = "base.db";
        final File fichero = new File(ruta);
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
    }
    
    public void connect() throws IOException {
        try {
            this.connect = DriverManager.getConnection("jdbc:sqlite:" + this.url);
            if (this.connect != null) {
                System.out.println("Conectado");
                this.verificador = true;
            }
        }
        catch (SQLException ex) {
            this.verificador = false;
            JOptionPane.showMessageDialog(null, "No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }
    
    public void close() {
        try {
            this.connect.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(Conectora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createTable(final DatosFormulario registro) throws IOException {
        try {
            this.connect();
            final Statement sentencia = this.connect.createStatement();
            final String sql = "CREATE TABLE registro(ID INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT NOT NULL, Apellidos TEXT NOT NULL, Email TEXT NOT NULL, Celular TEXT NOT NULL, Direccion TEXT NOT NULL, Sexo TEXT , Imagen TEXT )";
            System.out.println(sql);
            sentencia.execute(sql);
            sentencia.close();
            this.close();
            System.out.println("Exito al crear la tabla");
            this.saveRegistros(registro);
        }
        catch (SQLException e) {
            System.err.println("Error de save personas en ca" + e.getMessage());
        }
    }
    
    public void saveRegistros(final DatosFormulario registro) throws IOException {
        try {
            this.connect();
            System.out.println("Por lo meno entro en save registro");
            final String instrucion = "insert into registro(Nombre,Apellidos,Email,Celular,Direccion,Sexo,Imagen) values (?,?,?,?,?,?,?)";
            final PreparedStatement st = this.connect.prepareStatement(instrucion);
            st.setString(1, registro.getNombre());
            st.setString(2, registro.getApellidos());
            st.setString(3, registro.getEmail());
            st.setString(4, registro.getCelular());
            st.setString(5, registro.getDireccion());
            st.setString(6, registro.getsexo());
            st.setString(7, registro.getImagen());
            st.execute();
            st.close();
            this.close();
            System.out.println("insercion exitosa");
        }
        catch (SQLException ex) {
            System.err.println("Error de save personas en ca" + ex.getMessage());
            this.createTable(registro);
        }
    }
    
    public void BorrarRegistro(final int id) throws IOException {
        this.connect();
        final String instruccion = "DELETE FROM registro WHERE ID = ?";
        try {
            final PreparedStatement st = this.connect.prepareStatement(instruccion);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
            this.close();
            JOptionPane.showMessageDialog(null, "Se ha borrado el registro correctamente");
            Panel.limpiarTabla();
            Panel.mostrarTablas();
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de borrar el registro: \n" + e.getErrorCode());
        }
    }
    
    public ArrayList<String[]> mostrarRegistros() throws IOException {
        ResultSet result = null;
        final ArrayList<String[]> lista = new ArrayList<String[]>();
        try {
            this.connect();
            final PreparedStatement st = this.connect.prepareStatement("select * from registro");
            result = st.executeQuery();
            while (result.next()) {
                final String[] array = { String.valueOf(result.getInt("ID")), result.getString("Nombre"), result.getString("Apellidos"), result.getString("Email"), result.getString("Celular"), result.getString("Direccion"), result.getString("Sexo"), result.getString("Imagen") };
                lista.add(array);
            }
            st.close();
            this.close();
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return lista;
    }
    
    public String[] mostrarRegistro(final int id) throws IOException, SQLException {
        ResultSet result = null;
        final String[] array = new String[8];
        this.connect();
        final PreparedStatement st = this.connect.prepareStatement("select * from registro where ID = ?");
        st.setInt(1, id);
        result = st.executeQuery();
        while (result.next()) {
            array[0] = String.valueOf(result.getInt("ID"));
            array[1] = result.getString("Nombre");
            array[2] = result.getString("Apellidos");
            array[3] = result.getString("Email");
            array[4] = result.getString("Celular");
            array[5] = result.getString("Direccion");
            array[6] = result.getString("Sexo");
            array[7] = result.getString("Imagen");
        }
        st.close();
        this.close();
        return array;
    }
    
    public void BorrarTodo() throws IOException {
        this.connect();
        final String instruccion = "DELETE FROM sqlite_sequence WHERE name = 'registro'";
        final String instruccion2 = "DELETE FROM registro";
        try {
            final PreparedStatement st = this.connect.prepareStatement(instruccion);
            final PreparedStatement st2 = this.connect.prepareStatement(instruccion2);
            st2.executeUpdate();
            st.executeUpdate();
            st2.close();
            st.close();
            this.close();
            JOptionPane.showMessageDialog(null, "Se han borrado todos los registros correctamente");
            Panel.limpiarTabla();
            Panel.mostrarTablas();
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de borrar el registro: \n" + e.getErrorCode());
        }
    }
    
    public void update(final int id, final String nombre, final String apellidos, final String email, final String celular, final String direccion, final String sexo, final String imagen) throws IOException, SQLException {
        String Nombre = null;
        String Apellidos = null;
        String Email = null;
        String Celular = null;
        String Direccion = null;
        String Sexo = null;
        String Imagen = null;
        System.out.println("El nombre es:" + nombre + "comienza");
        if (nombre.equals("")) {
            System.out.println("Entro al nombre");
            Nombre = EventoMouseModificar.resultado[1];
        }
        else {
            Nombre = nombre;
        }
        if (apellidos.equals("")) {
            Apellidos = EventoMouseModificar.resultado[2];
        }
        else {
            Apellidos = apellidos;
        }
        if (email.equals("")) {
            Email = EventoMouseModificar.resultado[3];
        }
        else {
            Email = email;
        }
        if (celular.equals("")) {
            Celular = EventoMouseModificar.resultado[4];
        }
        else {
            Celular = celular;
        }
        if (direccion.equals("")) {
            Direccion = EventoMouseModificar.resultado[5];
        }
        else {
            Direccion = direccion;
        }
        if (sexo.equals("")) {
            Sexo = EventoMouseModificar.resultado[6];
        }
        else {
            Sexo = sexo;
        }
        System.out.println("valor de imagen es:" + imagen);
        if (imagen == null) {
            Imagen = EventoMouseModificar.resultado[7];
        }
        else {
            Imagen = imagen;
        }
        this.connect();
        final String instruccion = "UPDATE registro SET Nombre = ?,Apellidos = ?,Email = ?,Celular = ?,Direccion = ?,Sexo = ?,Imagen = ?  where ID = ?";
        try {
            final PreparedStatement st = this.connect.prepareStatement(instruccion);
            st.setString(1, Nombre);
            st.setString(2, Apellidos);
            st.setString(3, Email);
            st.setString(4, Celular);
            st.setString(5, Direccion);
            st.setString(6, Sexo);
            st.setString(7, Imagen);
            st.setInt(8, id);
            st.executeUpdate();
            st.close();
            this.close();
            JOptionPane.showMessageDialog(null, "Se ha actualizau el registro correctamente");
            Panel.limpiarTabla();
            Panel.mostrarTablas();
        }
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de borrar el registro: \n" + e.getErrorCode());
        }
    }
}
