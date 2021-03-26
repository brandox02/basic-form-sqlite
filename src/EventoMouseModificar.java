// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.sql.SQLException;
import java.io.IOException;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EventoMouseModificar implements ActionListener
{
    static boolean verificador;
    static int idRegistro;
    static String[] resultado;
    
    static {
        EventoMouseModificar.verificador = false;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        System.out.println("Se le a dau a modifical");
        final int indexSelected = Panel3.tabla.getSelectedRow();
        try {
            final Conectora con = new Conectora();
            EventoMouseModificar.idRegistro = Integer.valueOf((String)Panel3.modelo.getValueAt(indexSelected, 0));
            MarcoTarea.panel.nombre.requestFocus();
            EventoMouseModificar.resultado = con.mostrarRegistro(EventoMouseModificar.idRegistro);
            EventoMouseModificar.verificador = true;
            final String texto = "Vas a actualizar el registro con el id " + EventoMouseModificar.idRegistro + "\n si dejas un campo vacio conservara el valor original\nPresiona Actualizar para guardar los cambios ";
            JOptionPane.showMessageDialog(null, texto);
            Panel.clearTextField();
            Panel2.boton1.setText("Actualizar");
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "No has seleccionado ningun registro para modificarlo");
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
        catch (SQLException e3) {
            e3.printStackTrace();
        }
    }
}
