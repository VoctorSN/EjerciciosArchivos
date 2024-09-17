package edu.badpals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args){
        Ej2.charCounter();
    }

    private static void charCounter() {
        try {
            int vecesAparecida = 0;
            System.out.println("Escribe el path");
            String path = new Scanner(System.in).nextLine();
            BufferedReader lector = new BufferedReader(new FileReader(path));
            System.out.println("Escribe la letra");
            char letraABuscar = new Scanner(System.in).nextLine().charAt(0);
            for (char caracter : lector.readLine().toCharArray()){
                if (caracter == letraABuscar){
                    vecesAparecida += 1;
                }
            }
            System.out.println(vecesAparecida);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
