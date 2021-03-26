// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

class real_panel extends JPanel
{
    public JComboBox combobox;
    
    public real_panel() {
        this.setBounds(320, 200, 217, 58);
        final JButton boton = new JButton("Cargar Foto");
        boton.addActionListener(new EventoMouseCargarFoto());
        (this.combobox = new JComboBox()).addItem("Seleccionar");
        this.combobox.addItem("Masculino");
        this.combobox.addItem("Femenino");
        this.setLayout(new GridLayout(2, 1, 3, 3));
        this.add(boton);
        this.add(this.combobox);
    }
}
