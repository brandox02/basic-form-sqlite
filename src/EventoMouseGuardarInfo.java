// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.awt.Component;
import javax.swing.Icon;
import java.sql.SQLException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class EventoMouseGuardarInfo extends JOptionPane implements ActionListener
{
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (EventoMouseModificar.verificador) {
            try {
                final Conectora con = new Conectora();
                final String[] g = Panel.getInfo();
                System.out.println("Ahora va a hacer la actualizacion");
                con.update(EventoMouseModificar.idRegistro, g[0], g[1], g[2], g[3], g[4], g[5], MarcoTarea.panel_1_1.destino);
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
            catch (SQLException e3) {
                e3.printStackTrace();
            }
            EventoMouseModificar.verificador = false;
            Panel2.boton1.setText("Guardar Informacion");
            Panel.clearTextField();
            MarcoTarea.panel_1_1.h.setIcon(null);
            MarcoTarea.panel_1_1.destino = "";
        }
        else {
            final String[] g2 = Panel.getInfo();
            final DatosFormulario registro = new DatosFormulario(null, g2[0], g2[1], g2[2], g2[3], g2[4], g2[5], MarcoTarea.panel_1_1.destino);
            try {
                final Conectora con2 = new Conectora();
                con2.saveRegistros(registro);
                Panel.limpiarTabla();
                Panel.mostrarTablas();
                Panel.clearTextField();
                MarcoTarea.panel_1_1.h.setIcon(null);
                MarcoTarea.panel_1_1.destino = "";
                JOptionPane.showMessageDialog(null, "Se ha ingresado el registro correctamente");
            }
            catch (IOException e4) {
                e4.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se ha ingresado el registro correctamente. Error:\n" + e4.getMessage());
            }
        }
    }
}
