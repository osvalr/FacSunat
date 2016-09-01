
package Utilidad;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFielCharLimit extends PlainDocument{
    private final int limite;
    public JTextFielCharLimit(int x_limite)
    {
        this.limite=x_limite;
    }
    @Override
    public void insertString(int offset,String str,AttributeSet set)throws  BadLocationException
    {
        if(str==null)
            return;
        else if(getLength()+ str.length()<=limite)
        {
            str=str.toUpperCase();
            super.insertString(offset, str, set);
        }
    }
}
