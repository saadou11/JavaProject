package main;

import java.util.ArrayList;
import java.lang.Integer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class DealingWithFunctions {

    /**
     * *
     * THIS IS USED TO GENERATE A DOCUMENTATION. WE WILL SEE THIS LATER !
     *
     * @param s : The string to be updated
     * @return string
     */
    public String getUpdatedString(String s) {

        int len = s.length();

        String example = "           OK      ";
        System.out.println(example.trim());

        String customString = "pre_".concat(s).concat("_suf");

        System.out.println(s);
        System.out.println("site of the string :" + len + "\n");
        System.out.println(customString + "\n");
        System.out.println(s.toUpperCase() + "\n");
        /*       
         2 : print it
         3 : print its size
         4 : add a prefix "pre_" and a suffix "_suf" so that if string is hello , you should print pre_hello_suff
         PLEASE NOTE THAT : I don't want something like systeme.out.printlen("pre_"+variable+"_suf" !! 
         I want you to create another string called customString and call the methode that appends a string to another !  GOOGLE IS YOUR FRIEND !
        
         5: print the first string in UPPER case
         6 : finally : return the variable created first !
         */

        // IMPORTANT : we must have an instruction like " return ..." because this function return a string by definition ! 
        return customString;
    }

	/*Modification made by Anes from FORK*/
    public ArrayList<Object> getArrayListOfInteger(int size) {

        ArrayList<Object> myList = new ArrayList<>(size);
        
        for (int i = 0; i < size; i++) {
            myList.add(i);
        }
        return myList; 

    }
    
    public ArrayList<Object> getArrayListOfStrings(int size, String s) {

        ArrayList<Object> myList = new ArrayList<>(size);
        
        for (int i = 0; i < size; i++) {
            myList.add(s);
        }
        return myList; 

    }
    
    public void printArrayList(ArrayList<Object> list){
        
        for(Object obj : list)
            System.out.println(obj.toString());
    
    }

    /* Static methods can be called directly from the class name. 
     There is no need to instantite the class to acces this type of methods
     */
    public static int MyStaticMethod() {
        return 100;
    }

    public static void main(String[] args) {

        System.out.println(args);

        DealingWithFunctions myClass = new DealingWithFunctions();
        System.out.println("LET'S CALL THE FIRST METHOD");
        myClass.getUpdatedString(args[0]); // your function will update the string hello !
        System.out.println("LET'S CALL THE SECOND METHOD");
        
        /* CAST A VARIABLE MEANS THAT WE GET ITS VALUE FOR A DIFFERENT TYPE */
        ArrayList listOfInt = myClass.getArrayListOfInteger(Integer.valueOf(args[1])); // your method should create an arrayList containing 10 integers ( from 0 to 9)
        ArrayList listOfString = myClass.getArrayListOfStrings(Integer.valueOf(args[1]), args[0]); // your method should create an arrayList containing 10 integers ( from 0 to 9)
        
        System.out.println("MY LIST OF INTEGER VALUES :");
        myClass.printArrayList(listOfInt);
        System.out.println("MY LIST OF STRING VALUES :");
        myClass.printArrayList(listOfString);
        
        
        System.out.println("OUT OF PRINT FUNCTION");
        String s1 = myClass.getUpdatedString("hello");
        System.out.println(s1);

        System.out.println(DealingWithFunctions.MyStaticMethod());

    }
}
