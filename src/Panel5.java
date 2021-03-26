// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import javax.swing.JPanel;

class Panel5 extends JPanel
{
    public Panel5() {
        this.setBounds(600, 50, 200, 20);
        this.setLayout(new FlowLayout());
    }
    
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2D = (Graphics2D)g;
        final Font mifuente = new Font("Segoe UI", 1, 16);
        g2D.draw3DRect(5, 5, 550, 298, false);
        g2D.setFont(mifuente);
        g2D.drawString("Program Made With \u2665 By Brandon F. Mejia ", 120, 485);
    }
}
