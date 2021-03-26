// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.io.IOException;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EventoMouseBorrarRegistro implements ActionListener
{
    @Override
    public void actionPerformed(final ActionEvent e) {
        Conectora con = null;
        final int indexSelected = Panel3.tabla.getSelectedRow();
        try {
            final int idIndexSelected = Integer.valueOf((String)Panel3.modelo.getValueAt(indexSelected, 0));
            con = new Conectora();
            con.BorrarRegistro(idIndexSelected);
        }
        catch (ArrayIndexOutOfBoundsException | IOException ex3) {
            final Exception ex2;
            final Exception ex = ex2;
            JOptionPane.showMessageDialog(null, "No tiene seleccionado ningun registro!");
        }
    }
}
