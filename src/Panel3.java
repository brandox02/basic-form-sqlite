// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.io.IOException;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JPanel;

class Panel3 extends JPanel
{
    public static RealModelo modelo;
    String[] columnas;
    String[][] datosFilas;
    static JTable tabla;
    
    public Panel3() throws IOException {
        this.columnas = new String[] { "ID", "Nombre", "Apellidos", "Email", "Celular", "Direccion", "Sexo", "Imagen" };
        this.datosFilas = new String[0][];
        this.setBounds(30, 305, 515, 125);
        this.setLayout(new BorderLayout());
        Panel3.modelo = new RealModelo(this.datosFilas, this.columnas);
        Panel3.tabla = new JTable(Panel3.modelo);
        this.add(new JScrollPane(Panel3.tabla));
        Panel.mostrarTablas();
    }
}
