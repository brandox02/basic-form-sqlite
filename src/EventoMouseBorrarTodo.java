// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EventoMouseBorrarTodo implements ActionListener
{
    @Override
    public void actionPerformed(final ActionEvent e) {
        try {
            final Conectora con = new Conectora();
            con.BorrarTodo();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
