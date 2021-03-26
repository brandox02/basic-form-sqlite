// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EventoMouseBotonSalir implements ActionListener
{
    @Override
    public void actionPerformed(final ActionEvent e) {
        System.out.println("Entro en el evento mouse boton salir");
        System.exit(0);
    }
}
