// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.io.IOException;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EventoProbarConexion implements ActionListener
{
    @Override
    public void actionPerformed(final ActionEvent e) {
        try {
            final Conectora con = new Conectora();
            con.connect();
            con.close();
            if (con.verificador) {
                con.verificador = false;
                JOptionPane.showMessageDialog(null, "Se ha podido establecer conexion\nLa conexion es estable");
            }
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
