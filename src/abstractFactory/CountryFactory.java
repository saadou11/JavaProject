/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory;

import abstractFactory.color.Colors;
import abstractFactory.countries.Algeria;
import abstractFactory.countries.Country;
import abstractFactory.countries.Iceland;
import abstractFactory.shapes.Shape;

/**
 *
 * @author Admin
 */
public class CountryFactory extends AbstractFactory {

    @Override
    public Colors getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Country getCountry(String countryName) {
        if (countryName == null || countryName.equals("")) {
            return null;
        } else if (countryName.equalsIgnoreCase("ALGERIA")) {
            return new Algeria();
        } else if (countryName.equalsIgnoreCase("ICELAND")) {
            return new Iceland();
        }

        return null;
    }

}
