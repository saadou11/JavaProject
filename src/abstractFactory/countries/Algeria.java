/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory.countries;

import abstractFactory.utils.Constants;

/**
 *
 * @author Admin
 */
public class Algeria implements Country{

    @Override
    public int getPopulation() {
        return Constants.ALGERIA_POPULATION;
    }

    @Override
    public Integer getArea() {
        return Constants.ALGERIA_AREA;
    }

    @Override
    public String getLanguage() {
        return Constants.ALGERIA_LANGUAGE;
    }
    
}
