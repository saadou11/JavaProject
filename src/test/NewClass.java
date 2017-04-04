/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Admin
 */
class Ident
{  
private static int numCour=0 ; 
private int num ; 
    public Ident ()
        { numCour++ ;
          num = numCour ;
        }
    public int getIdent()
        { return num ;
        }
    public static int getIdentMax()
        { return numCour ;
        }
}
public class NewClass
{ public static void main (String args[])
{ Ident a = new Ident();
  Ident b = new Ident();
System.out.println ("numero de a : " + a.getIdent()) ;
System.out.println ("numero de b : " + b.getIdent()) ;
System.out.println ("dernier numero " + Ident.getIdentMax()) ;
Ident c = new Ident() ;
System.out.println ("dernier numero " + Ident.getIdentMax()) ;
}
}
