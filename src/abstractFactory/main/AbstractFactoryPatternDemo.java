/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory.main;

import abstractFactory.AbstractFactory;
import abstractFactory.FactoryProducer;
import abstractFactory.color.Colors;
import abstractFactory.countries.Country;
import abstractFactory.shapes.Shape;

/**
 *
 * @author Admin
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {

        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //get an object of Shape Circle
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Shape Circle
        shape1.draw();

        //get an object of Shape Rectangle
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Shape Rectangle
        shape2.draw();

        //get an object of Shape Square 
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of Shape Square
        shape3.draw();

        //get color factory
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        //get an object of Color Red
        Colors color1 = colorFactory.getColor("RED");

        //call fill method of Red
        color1.fill();

        //get an object of Color Green
        Colors color2 = colorFactory.getColor("Green");

        //call fill method of Green
        color2.fill();

        //get an object of Color Blue
        Colors color3 = colorFactory.getColor("BLUE");

        //call fill method of Color Blue
        color3.fill();

        AbstractFactory countryFactory = FactoryProducer.getFactory("COUNTRY");
        AbstractFactory countryFactory1 = FactoryProducer.getFactory("COUNTRY");
        System.out.println("hashcode countryFactory :" + countryFactory.hashCode());
        System.out.println("hashcode countryFactory1 :" + countryFactory1.hashCode());
        
        Country country1 = countryFactory.getCountry("Algeria");
        

        System.out.println("Algeria populations :" + country1.getPopulation());
        System.out.println("Algeria area :" + country1.getArea());
        System.out.println("Algeria language :" + country1.getLanguage());
        

        Country country2 = countryFactory.getCountry("iceland");

        System.out.println("iceland populations :" + country2.getPopulation());
        System.out.println("iceland area :" + country2.getArea());
        System.out.println("iceland language :" + country2.getLanguage());

    }
}
