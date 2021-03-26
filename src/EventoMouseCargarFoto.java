// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.io.File;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.awt.Component;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EventoMouseCargarFoto implements ActionListener
{
    static String pathFoto;
    static String nombreFoto;
    
    static {
        EventoMouseCargarFoto.pathFoto = null;
        EventoMouseCargarFoto.nombreFoto = null;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final JFileChooser fileChooser = new JFileChooser();
        try {
            fileChooser.setDialogTitle("Selecciona la imagen");
            fileChooser.showOpenDialog(fileChooser);
            final File h = fileChooser.getSelectedFile();
            EventoMouseCargarFoto.pathFoto = h.getAbsolutePath();
            EventoMouseCargarFoto.nombreFoto = h.getName();
            try {
                MarcoTarea.panel_1_1.mostrarImagen();
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No seleccionaste ninguna foto");
        }
    }
}
