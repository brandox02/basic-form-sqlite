// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

class Panel4 extends JPanel
{
    public static JButton boton4;
    
    public Panel4() {
        this.setBounds(0, 432, 560, 40);
        this.setLayout(new FlowLayout());
        final JButton boton2 = new JButton("Expandir");
        boton2.addActionListener(new EventoMouseExpandir());
        final JButton boton3 = new JButton("Eliminar");
        boton3.addActionListener(new EventoMouseBorrarRegistro());
        (Panel4.boton4 = new JButton("Modificar")).addActionListener(new EventoMouseModificar());
        final JButton boton4 = new JButton("Limpiar");
        boton4.addActionListener(new EventoMouseBorrarTodo());
        final JButton boton5 = new JButton("Salir");
        boton5.addActionListener(new EventoMouseBotonSalir());
        this.add(boton2);
        this.add(boton3);
        this.add(Panel4.boton4);
        this.add(boton4);
        this.add(boton5);
    }
}
