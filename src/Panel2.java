// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

class Panel2 extends JPanel
{
    static JButton boton1;
    
    public Panel2() {
        this.setBounds(35, 270, 510, 25);
        this.setLayout(new GridLayout(1, 2, 30, 0));
        Panel2.boton1 = new JButton("Guardar Informacion");
        final JButton boton2 = new JButton("Probar Conexion");
        boton2.addActionListener(new EventoProbarConexion());
        Panel2.boton1.addActionListener(new EventoMouseGuardarInfo());
        this.add(Panel2.boton1);
        this.add(boton2);
    }
}
