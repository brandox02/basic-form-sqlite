// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EventoMouseExpandir implements ActionListener
{
    @Override
    public void actionPerformed(final ActionEvent e) {
        final JFrame miframe = new JFrame();
        miframe.setSize(600, 320);
        miframe.setLocationRelativeTo(null);
        miframe.setTitle("Tabla Expandida");
        final JPanel panel = new JPanel();
        panel.setLayout(null);
        miframe.add(new JScrollPane(new JTable(Panel3.modelo)));
        miframe.setVisible(true);
    }
}
