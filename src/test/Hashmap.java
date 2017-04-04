/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.*;
/**
 *
 * @author Admin
 */

public class Hashmap {
public static void main(String[] args){
        
        Map james = new HashMap();  
        james.put("dunk", "20");
        james.put("speed", "20");
        james.put("shoot", "20");
        
        Map paul = new HashMap();
        paul.put("dunk", "17");
        paul.put("speed", "19");
        paul.put("shoot", "19");
           
        Map harden = new HashMap();
        harden.put("dunk", "18");
        harden.put("speed", "17");
        harden.put("shoot", "20");
        
    System.out.println("James Attribute : ");
    System.out.println("\t" + james);
    
    System.out.println("Paul Attribute : ");
    System.out.println("\t" + paul);
    
    System.out.println("Harden Attribute : ");
    System.out.println("\t" + harden);
    
    }
}
