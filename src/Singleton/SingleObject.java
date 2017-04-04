/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

/**
 *
 * @author Admin
 */
public class SingleObject {
   
    //create an object of SingleObject
    private static SingleObject instance;

    //make the constructor private so that this class cannot be
    //instantiated
    private SingleObject() {}

    //Get the only object available
    public static SingleObject getInstance() {

        if (instance == null) {
            instance = new SingleObject();
        }
        return instance;
    }

    public void showMessage(SingleObject obj) {
        System.out.println("Hello World!");
        System.out.println("OBJ: "+obj.hashCode());
        System.out.println("OBJ:"+obj.toString());
        System.out.println("--------------------------------------");
    }
    
    
}
