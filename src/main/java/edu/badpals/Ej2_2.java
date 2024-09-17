package edu.badpals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Ej2_2 {
    public static void main(String[] args){
        //System.out.println("Escribe el path");
        //String path = new Scanner(System.in).nextLine();

        String path = "C:\\Users\\a23victorsn\\IdeaProjects\\EjerciciosProfeZZZ\\ejemplo.txt";
        Ej2_2.charCounter(path);
    }

    private static void charCounter(String path) {
        try {
            Map<String, Integer> dicc = new HashMap<>();
            BufferedReader lector = new BufferedReader(new FileReader(path));
            for (char caracter : lector.readLine().toCharArray()){
                String caracterString = String.valueOf(caracter);
                dicc.putIfAbsent(caracterString,0);
                dicc.replace(caracterString,dicc.get(caracterString) + 1);
            }
            Integer max = Collections.max(dicc.values());
            StringBuilder out = new StringBuilder();
            for (Map.Entry<String,Integer> entry : dicc.entrySet()){
                if (Objects.equals(entry.getValue(), max)){
                    out.append(entry.getKey());
                }
            }
            System.out.println(out);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
