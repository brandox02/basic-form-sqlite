// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class VentanaFormulario
{
    private JFrame frame;
    public static MarcoTarea mimarco;
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final MarcoTarea mimarco = new MarcoTarea();
                    mimarco.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
