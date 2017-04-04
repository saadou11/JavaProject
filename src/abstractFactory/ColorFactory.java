/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory;

import abstractFactory.color.Colors;
import abstractFactory.color.Blue;
import abstractFactory.color.Green;
import abstractFactory.color.Red;
import abstractFactory.countries.Country;
import abstractFactory.shapes.Shape;

/**
 *
 * @author Admin
 */
public class ColorFactory extends AbstractFactory {

    @Override
   public Shape getShape(String shapeType){
      return null;
   }
   
   @Override
   public Colors getColor(String color) {
   
      if(color == null){
         return null;
      }		
      
      if(color.equalsIgnoreCase("RED")){
         return new Red();
         
      }else if(color.equalsIgnoreCase("GREEN")){
         return new Green();
         
      }else if(color.equalsIgnoreCase("BLUE")){
         return new Blue();
      }
      
      return null;
   }

    @Override
    public Country getCountry(String countryName) {
        return null;
    }
}
