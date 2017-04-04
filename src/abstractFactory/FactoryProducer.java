/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory;

/**
 *
 * @author Admin
 */
public class FactoryProducer {

    private static ShapeFactory shapeFactoryInstance;
    private static ColorFactory colorFactoryInstance;
    private static CountryFactory countryFactoryInstance;

    
    private FactoryProducer(){}
    
    public static AbstractFactory getFactory(String choice) {

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
        } else if (choice.equalsIgnoreCase("COUNTRY")) {
            if (countryFactoryInstance == null) {
                countryFactoryInstance = new CountryFactory();
            }
            return countryFactoryInstance;
        }

        return null;
    }
}
