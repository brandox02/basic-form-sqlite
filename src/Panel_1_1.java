// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Panel_1_1 extends JPanel
{
    JLabel h;
    String destino;
    
    public Panel_1_1() {
        this.h = new JLabel();
        this.setBounds(310, 16, 240, 180);
        this.add(this.h);
    }
    
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2D = (Graphics2D)g;
        g2D.setPaint(Color.GRAY);
        final Font mifuente = new Font("Segoe UI", 1, 16);
        g2D.setFont(mifuente);
        g2D.draw3DRect(10, 10, 215, 180, false);
        g2D.drawString("FOTO", 100, 110);
    }
    
    public void mostrarImagen() throws IOException {
        final String ruta = EventoMouseCargarFoto.pathFoto.replace("\\", "\\\\");
        final String nombre = EventoMouseCargarFoto.nombreFoto;
        System.out.println("La ruta es: " + ruta);
        System.out.println("El nombre del archivo es: " + nombre);
        ImageResizer.copyImage(ruta, this.destino = "fotos\\" + nombre);
        final ImageIcon image = new ImageIcon(this.destino);
        this.h.setIcon(image);
    }
}
