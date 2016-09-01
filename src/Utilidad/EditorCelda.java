
package Utilidad;

import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class EditorCelda extends AbstractCellEditor implements TableCellEditor{

    JComponent _componente = new JTextField();
    JTable _jtable;
    int _row;
    int _column;
    Object _vInicial;
    Formato _fmd=new Formato();
    boolean _estado=false;
    public EditorCelda(boolean  x_estado)
    {
        this._estado=x_estado;
    }
    public EditorCelda()
    {
    //    this._estado=x_estado;
    }
    @Override
    public Object getCellEditorValue() {
        //JOptionPane.showMessageDialog(null, "valor :"+((JTextField) _componente).getText() , "Mensaje",JOptionPane.WARNING_MESSAGE);
        
        if(_estado)
        {
            ModificacionDireccion(String.valueOf(((JTextField) _componente).getText()));
        }
        else
        {
            CalcularIGV(Double.parseDouble(((JTextField) _componente).getText()));        
            Modificacion(String.valueOf(((JTextField) _componente).getText()));
        }
        return ((JTextField) _componente).getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

           _jtable=table;
           _row=row;
           _column=column;
           _vInicial=value.toString();
           ((JTextField) _componente).setText((String)value);
           return _componente;

    }
    
    private void CalcularIGV(Double x_valor)
    {
        double _igv=Double.valueOf(_jtable.getValueAt(_row, 5).toString());
        _igv=_igv*x_valor/100;
        double _total=x_valor+_igv;
        _jtable.setValueAt(String.valueOf(_fmd.Farmat2DosDecimales(_total)), _row, 6);
        
    }
    private void Modificacion(String _valor)
    {
        if(!_vInicial.equals(_valor))
        {
            if(_jtable.getValueAt(_row, 12).toString().equals("UNCHANGUE"))
                _jtable.setValueAt(String.valueOf("MODIFY"), _row, 12);
        }
    }
    
    private void ModificacionDireccion(String _valor)
    {
        if(!_vInicial.equals(_valor))
        {
            if(_jtable.getValueAt(_row, 2).toString().equals("UNCHANGUE"))
                _jtable.setValueAt(String.valueOf("MODIFY"), _row, 2);
        }
    }
    
}
