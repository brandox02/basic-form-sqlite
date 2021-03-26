// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.io.IOException;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JFrame;

class MarcoTarea extends JFrame
{
    static Panel panel;
    static real_panel realpanel;
    static Panel_1_1 panel_1_1;
    static JPanel panel3;
    public static JPanel panel4;
    
    public MarcoTarea() throws IOException {
        this.add(MarcoTarea.realpanel = new real_panel());
        this.add(MarcoTarea.panel = new Panel());
        this.add(MarcoTarea.panel_1_1 = new Panel_1_1());
        this.add(new Panel2());
        this.add(MarcoTarea.panel3 = new Panel3());
        this.add(MarcoTarea.panel4 = new Panel4());
        this.add(new Panel5());
        this.setTitle("Real Formulario");
        this.setSize(575, 535);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
