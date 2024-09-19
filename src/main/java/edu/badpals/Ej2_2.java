package edu.badpals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ej2_2 {
    public static void main(String[] args) {
        //System.out.println("Escribe el path");
        //String path = new Scanner(System.in).nextLine();

        String path = ".\\ejemplo.txt";
        System.out.println(Ej2_2.charCounter(path));
    }

    private static String charCounter(String path) {
        try {
            Map<String, Integer> dicc = contadorCaracteres(path);
            Integer max = 0;
            StringBuilder out = new StringBuilder();
            for (Map.Entry<String, Integer> entry : dicc.entrySet()) {
                if (entry.getValue() > max) {
                    out = new StringBuilder(entry.getKey());
                    max = entry.getValue();
                } else if (entry
                        .getValue()
                        .equals(max)) {
                    out.append(entry.getKey());
                }
            }
            return out.append(" aparecen este numero de veces: ")
                    .append(max)
                    .toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    private static Map<String, Integer> contadorCaracteres(String path) throws IOException {
        Map<String, Integer> dicc = new HashMap<>();
        BufferedReader lector = new BufferedReader(new FileReader(path));
        String linea;
        while ((linea = lector.readLine()) != null) {
            for (char caracter : linea.toCharArray()) {
                String caracterString = String.valueOf(caracter);
                dicc.putIfAbsent(caracterString, 0);
                dicc.replace(caracterString, dicc.get(caracterString) + 1);
            }
        }
        return dicc;
    }
}
