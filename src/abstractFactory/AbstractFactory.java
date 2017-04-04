/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory;

import abstractFactory.color.Colors;
import abstractFactory.countries.Country;
import abstractFactory.shapes.Shape;

/**
 *
 * @author Admin
 */
public abstract class AbstractFactory {
   public abstract Colors getColor(String color);
   public abstract Shape getShape(String shape) ;
   public abstract Country getCountry(String countryName);
}
