/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import abstractFactory.factory.*;
import abstractFactory.color.Color;
import abstractFactory.shapes.Shape;

/**
 *
 * @author Anès
 */
public class RunFactory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AbstractFactory shapeFactory = FactoryProducer.getFactoryProducerInstance("SHAPE");

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();


        AbstractFactory colorFactory = FactoryProducer.getFactoryProducerInstance("COLOR");

        Color color1 = colorFactory.getColor("RED");
        color1.fill();

        Color color2 = colorFactory.getColor("Green");
        color2.fill();

        Color color3 = colorFactory.getColor("BLUE");
        color3.fill();
    }

}
