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
class PointAllie {
    private final char nom;
    private double abs;
    private double ord;
    public PointAllie(char nom , double abs, double ord){       //constructeur
        this.nom = nom;
        this.abs = abs; 
        this.ord = ord;
    }
    public void affiche(){
        System.out.println("point avec nom : " + nom + " d'abscisse " + abs + " et d'ordre : " + ord);
    }
    public void translate(double dx, double dy){
    abs += dx;
    ord += dy;
    }
    public void PlusOne(){
    abs += 1;
    ord += 1;
    }
    
    public static PointAllie MaxNorme (PointAllie a, PointAllie b)
    {
    double na = a.abs*a.abs + a.ord*a.ord;
    double nb = b.abs*b.abs + b.ord*b.ord;
    if(na<nb)
        return b;
    else 
        return a;
    } 
}


public class TestDePoint{
public static void main (String args[]){
    PointAllie A = new PointAllie('a',3.7,5.9);
    PointAllie B = new PointAllie('b',1.2,2.2);
    System.out.println("AVANT MOUV Point A :");
    A.affiche();
    System.out.println("APRES MOUV Point A :");
    A.translate(5,3);
    A.affiche();
    System.out.println("plus one (point a) !");
    A.PlusOne();
    A.affiche();
    System.out.println("---------------------------");
    System.out.println("AVANT MOUV Point B :");
    B.affiche();
    System.out.println("APRES MOUV Point B :");
    B.translate(2,1);
    B.affiche();
    System.out.println("plus one (point b) !");
    B.PlusOne();
    B.affiche();
    System.out.println("---------------------------");
    PointAllie p = PointAllie.MaxNorme(A, B);
    System.out.println("Le point le plus eloigne est : " );
    p.affiche();
} 
}
