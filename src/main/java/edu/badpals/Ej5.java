package edu.badpals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        String path = "./coches.txt";
        Map<String, String> dicc = Ej5.leectorCoches(path);
        System.out.println(Ej5.leectorCoches(path));
        escitorCoches(dicc, "./marcas.txt");
    }

    private static Map<String, String> leectorCoches(String p) {
        Path path = Path.of(p);
        Map<String, String> dicc = new HashMap<>();
        try (var lector = new Scanner(path)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                if (linea.isBlank()) {
                    continue;
                }
                int index = linea.indexOf(" ");
                String marca = linea.substring(0, index);
                String modelo = linea.substring(index + 1);
                dicc.computeIfPresent(marca, (k, v) -> v + ", " + modelo);
                dicc.putIfAbsent(marca, modelo);
            }
            return dicc;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dicc;
    }

    private static void escitorCoches(Map<String, String> dicc, String path) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(path, false))) {
            for (Map.Entry<String, String> entry : dicc.entrySet()) {
                escritor.write(entry.toString().replace("=", ": "));
                escritor.newLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Ej3.creadorArchivo(path, Ej3.ordenaciones(path, "asc", "sensitive"));
    }
}
