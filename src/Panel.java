// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

class Panel extends JPanel
{
    public JTextField nombre;
    JTextField apellidos;
    JTextField email;
    JTextField numero;
    JTextField direccion;
    
    public Panel() {
        this.setBounds(10, 10, 10, 10);
        this.setBounds(35, 8, 265, 260);
        final JLabel a = new JLabel("  Datos Personales: ");
        this.add(a);
        final JLabel b = new JLabel("  Nombre Del Contacto:");
        this.add(b);
        this.add(this.nombre = new JTextField());
        this.add(new JLabel("  Apellidos Del Contacto:"));
        this.add(this.apellidos = new JTextField());
        this.add(new JLabel("  Email Del Contacto:"));
        this.add(this.email = new JTextField());
        this.add(new JLabel("  Celular Del Contacto:"));
        this.add(this.numero = new JTextField());
        this.add(new JLabel("  Direccion Del Contacto:"));
        this.add(this.direccion = new JTextField());
        this.setLayout(new GridLayout(11, 1, 9, 9));
    }
    
    public static String[] getInfo() {
        final String[] array = { MarcoTarea.panel.nombre.getText(), MarcoTarea.panel.apellidos.getText(), MarcoTarea.panel.email.getText(), MarcoTarea.panel.numero.getText(), MarcoTarea.panel.direccion.getText(), null };
        if (MarcoTarea.realpanel.combobox.getSelectedItem() == "Seleccionar") {
            array[5] = "Indefinido";
        }
        else {
            array[5] = (String)MarcoTarea.realpanel.combobox.getSelectedItem();
        }
        return array;
    }
    
    public static void clearTextField() {
        MarcoTarea.panel.nombre.setText(null);
        MarcoTarea.panel.apellidos.setText(null);
        MarcoTarea.panel.email.setText(null);
        MarcoTarea.panel.numero.setText(null);
        MarcoTarea.panel.direccion.setText(null);
    }
    
    public static void mostrarTablas() throws IOException {
        final Conectora con = new Conectora();
        final ArrayList<String[]> f = con.mostrarRegistros();
        for (final String[] ee : f) {
            Panel3.modelo.addRow(ee);
        }
    }
    
    public static void limpiarTabla() {
        try {
            for (int filas = Panel3.tabla.getRowCount(), i = 0; filas > i; ++i) {
                Panel3.modelo.removeRow(0);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
}
