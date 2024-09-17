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
        System.out.println(Ej3.ordenaciones(".\\ejemplo.txt","asc","sensitive"));
        //Ej3.ordenaciones("C:\\Users\\victo\\Downloads\\EjerciciosProfeZZZ-20240916T174606Z-001\\EjerciciosProfeZZZ\\ejemplo.txt","asc","insensitive");
    }

    private static List<String> ordenaciones(String path,String ordenacion,String typeCase) {

        List<String> lista = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(path))){
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
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            Path oldPath = Paths.get(path);
            int lastDotIndex = path.lastIndexOf('.');
            if (lastDotIndex == -1) {
                throw new IllegalArgumentException("El archivo no tiene una extensión válida.");
            }
            String baseName = path.substring(0, lastDotIndex);
            String extension = path.substring(lastDotIndex);
            String nuevoPathString = baseName + "_" + ordenacion + "_" + typeCase + extension;
            Path newPath = Paths.get(nuevoPathString);
            Files.move(oldPath,newPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
