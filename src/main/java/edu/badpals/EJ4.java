package edu.badpals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;

public class EJ4 {

    public static void main(String[] args){
        System.out.println(EJ4.corregirTests(".\\testCorregidos.txt"));
    }

    public static String corregirTests(String path){
        StringBuilder out = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");

        try (BufferedReader lector = new BufferedReader(new FileReader(path))){
            String linea;
            int i = 1;
            String testCorregido = "";
            while ((linea = lector.readLine()) != null){
                if (i == 1){
                    i = 0;
                    testCorregido = linea;
                    continue;
                } else if (linea.isEmpty()) {
                    continue;
                }
                int indexEspacio = linea.indexOf(" ");
                String codigoAlumno = linea.substring(0,indexEspacio);
                String respuestas = linea.substring(indexEspacio+1);
                double nota = EJ4_Corrector.corregirTest(testCorregido,respuestas);
                out.append(codigoAlumno);
                out.append(' ');
                out.append(df.format(nota));
                out.append(' ');
                out.append(EJ4_Corrector.calificar(nota));
                out.append("\n");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return out.toString();
    }

}
