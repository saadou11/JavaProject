/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class NewClass1 {

    public static void main(String[] args) {

        NewClass1 instance = new NewClass1();
        instance.readFile("Test.txt");
        instance.writeFile("Test.txt");
        

        int num[] = {1, 2, 3};
        try {

            for (int i = 0; i <= 5; i++) {
                System.out.println("ITERATION " + i + " : " + num[i]);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("CATCHING THE ARRAYOUTOFBOUNDSEXCEPTION");
        } catch (ArithmeticException ae) {
            System.out.println("AFFICHAGE DE LA PILE D'EXCEPTION");
            System.out.println(ae.getMessage());
        } finally {
            System.out.println("ICI JE PEUX FAIRE CE QUE JE VEUX !");
            System.out.println(" UNE SORTE DE N ième partie du programme qui est censé se déroulé si le programme n'a pas quitté !");
        }

        try {
            System.out.println(5 / 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        // CONCLUSION : étant donné un bloc try suivi de plusieurs bloc catch,
        // Le programme rentre dans le bloc catch de la première exception qu'il rencontre.
        // Ensuite, s'il y  a un affiche de la pile des message, alors celle là sera affichée et le programme s'arrête.
        // Sinon, le message personnalisé sera affiché et ensuite le programme cherche s'il y a un bloc finally pour l'exécuter
        // Sinon il continue l'exécution de ce qui vient après.
        // LE PLUS IMPORTANT:  sur un ensemble de bloc catch, celui de la première exception rencontrée sera exécuté, peu importe l'ordre des blocs
        // le programme va parcourir tout les bloc pour voir celui qui correspond à l'exception rencontrée.
    }

    public void readFileCharByChar(String fileName) {

        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            int lineData;
            while ((lineData = fis.read()) != -1) {
                System.out.println(String.valueOf(lineData));
                System.out.println((char) lineData);
            }
            // L'ordre : commencer par la sous-class !!
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(NewClass1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readFile(String fileName) {

        try {
            /*Creation de l'objet FIle, pour considérer le fichier à lire comme un objet manipulable par le programme*/
            File file = new File(fileName);
            /* J'envoie l'objet file à une source de lecture, plus précisement une source de lecture de fichier : FileInputStream*/
            FileInputStream fis = new FileInputStream(file);
            /* Je créé l'objet lecteur !! qui lis de la mémoire.
             La mémoire contient un buffer, on aurait pu attribué au buffer une taille pour dire lis moi bloc par bloc de n charactères par exemple.
            
             L'objet BufferReader a besoin d'une entrée. l'entrée est appelé le InputStreamReader.
             Finalement l'InputStreamReader prend en paramètre un type précis de streamReader : en l'occruence le FileInputStream
             */

            BufferedReader buffer = new BufferedReader(new InputStreamReader(fis));
            /* On définit une variable de type chaine de caractères correspondant à la ligne qui va être lue*/
            String aLine;
  
            /*On boucle sur toute les ligne obtenue par la méthode readLine*/

            while ((aLine = buffer.readLine()) != null) {
               
                System.out.println(aLine);
                
            }
            // L'ordre : commencer par la sous-class !!
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(NewClass1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void writeFile(String FileName){
    try {
         File file = new File(FileName);
         FileWriter fileWritter = new FileWriter(file,true);
         String line = "hello my name is trevor !";
         BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
         
         bufferWritter.write(line);
    	 bufferWritter.close();
      
        }catch(FileNotFoundException e){
        e.printStackTrace();
        }catch(IOException e){
        e.printStackTrace();
        }
    
    
    }
}
    
