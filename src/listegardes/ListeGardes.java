/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listegardes;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class ListeGardes {

    final ArrayList<String> type_gardes = new ArrayList<String>() {
        {
            add("SERVICE");
            add("CONSULTATION");
            add("OBSERVATION");
        }
    };

    public ArrayList generateDoctor() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            list.add(i);
        }

        return list;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListeGardes l = new ListeGardes();
        System.out.println(l.generateDoctor());
        System.out.println(l.type_gardes.get(new Random().nextInt(3)));
    }

}
