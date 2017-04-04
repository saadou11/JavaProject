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
public class SingletonPatternDemo {
    
    public static void main(String[] args) {
        
      //illegal construct
        //Compile Time Error: The constructor SingleObject() is not visible
        //SingleObject object = new SingleObject();
        //Get the only object available
        SingleObject object = SingleObject.getInstance();

        SingleObject object2 = SingleObject.getInstance();

        //show the message
        object.showMessage(object);
        object2.showMessage(object2);
        
        SingletonPatternDemo s1 = new SingletonPatternDemo();
        SingletonPatternDemo s2 = new SingletonPatternDemo();
        
        
        System.out.println("SINGLETON DEMO");
        System.out.println("s1 => string value of the object : "+s1.toString()+" ; hashcode : "+s1.hashCode());
        System.out.println("s2 => string value of the object : "+s2.toString()+" ; hashcode : "+s2.hashCode());
        
        
       
    }
    
}
