/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidad;

/**
 *
 * @author USUARIO
 */
public class DisplayValue {
    
public Object displayMeneber;
public Object valueMenber;

public DisplayValue(Object display,Object value)
{
    this.displayMeneber=display;
    this.valueMenber=value;
    
}

public String getValueMenber()
{
    return valueMenber.toString();
}

public String toString()
{
 return displayMeneber.toString();
    
}
}
