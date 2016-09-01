
package Utilidad;

import java.awt.Dimension;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class ComboPersonalizado extends JComboBox {
    public ComboPersonalizado() { 
    } 
 
    public ComboPersonalizado(final Object items[]){ 
        super(items); 
    } 
 
    public ComboPersonalizado(Vector items) { 
        super(items); 
    } 
 
    public ComboPersonalizado(ComboBoxModel aModel) { 
        super(aModel); 
    } 
 
    private boolean layingOut = false; 
 
    public void doLayout(){ 
        try{ 
            layingOut = true; 
            super.doLayout(); 
        }finally{ 
            layingOut = false; 
        } 
    } 
 
    @Override
    public Dimension getSize(){ 
        Dimension dim = super.getSize(); 
        if(!layingOut) 
            dim.width = Math.max(dim.width, getPreferredSize().width); 
        return dim; 
    } 
}

