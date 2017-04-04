/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory;

import abstractFactory.color.Colors;
import abstractFactory.countries.Country;
import abstractFactory.shapes.Rectangle;
import abstractFactory.shapes.Circle;
import abstractFactory.shapes.Square;
import abstractFactory.shapes.Shape;

/**
 *
 * @author Admin
 */
public class ShapeFactory extends AbstractFactory  {

    @Override
   public Shape getShape(String shapeType){
   
      if(shapeType == null){
         return null;
      }		
      
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();
         
      }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
         
      }else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      
      return null;
   }
   
   @Override
   public Colors getColor(String color) {
      return null;
   }
   
   @Override
   public Country getCountry(String countryName) {
      return null;
   }
}
