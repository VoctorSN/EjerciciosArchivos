package edu.badpals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ej3 {

    public static void main(String[] args){
        Ej3.ordenaciones("C:\\Users\\victo\\Downloads\\EjerciciosProfeZZZ-20240916T174606Z-001\\EjerciciosProfeZZZ\\ejemplo.txt","asc","sensitive");
        //Ej3.ordenaciones("C:\\Users\\victo\\Downloads\\EjerciciosProfeZZZ-20240916T174606Z-001\\EjerciciosProfeZZZ\\ejemplo.txt","asc","insensitive");
    }

    private static void ordenaciones(String path,String ordenacion,String typeCase) {
        try (BufferedReader lector = new BufferedReader(new FileReader(path))){
            List<String> lista = new ArrayList<>();
            String linea;
            while ((linea = lector.readLine()) != null){
                lista.add(linea);
            }
            if (typeCase.equals("insensitive")){
                lista.sort(String.CASE_INSENSITIVE_ORDER);
            } else {
                Collections.sort(lista);
            }
            if (ordenacion.equals("desc")){
                Collections.reverse(lista);
            }
            System.out.println(lista);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            Path oldPath = Paths.get(path);
            String[] nuevoPathArray = path.split("\\.");
            String nuevoPathString = nuevoPathArray[0] + "_" + ordenacion + "_" + typeCase + "." + nuevoPathArray[1];
            Path newPath = Paths.get(nuevoPathString);
            Files.move(oldPath,newPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
