/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory.shapes;

/**
 *
 * @author Anès
 */
public interface Shape {

    /* When you say that a class implements this Shape interface, the interpreter will ask you to
     either implement the methods in the interface or (if you don't want to) to make this class abstract
     so that subclass of this class will implement these functions
     */
    void draw();

}
