/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory.factory;

/**
 *
 * @author Anès
 */
public class FactoryProducer {

    private static AbstractFactory shapeFactoryInstance = null;
    private static AbstractFactory colorFactoryInstance = null;

    public static AbstractFactory getFactoryProducerInstance(String choice) {

        if (choice.equalsIgnoreCase("SHAPE")) {
            if (shapeFactoryInstance == null) {
                shapeFactoryInstance = new ShapeFactory();
            }
            return shapeFactoryInstance;

        } else if (choice.equalsIgnoreCase("COLOR")) {
            if (colorFactoryInstance == null) {
                colorFactoryInstance = new ColorFactory();
            }
            return colorFactoryInstance;
        }

        return null;
    }
}
