/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory.factory;

import color.*;
import shapes.Shape;

/**
 *
 * @author Anès
 */
public class ColorFactory extends AbstractFactory {

    @Override
    Color getColor(String color) {

        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();

        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        }

        return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }

}
