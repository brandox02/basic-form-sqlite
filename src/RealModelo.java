// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import javax.swing.table.DefaultTableModel;

class RealModelo extends DefaultTableModel
{
    public RealModelo(final String[][] datosFilas, final String[] columnas) {
        super(datosFilas, columnas);
    }
    
    @Override
    public boolean isCellEditable(final int row, final int column) {
        return false;
    }
}
