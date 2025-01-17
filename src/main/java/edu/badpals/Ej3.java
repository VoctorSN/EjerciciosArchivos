package edu.badpals;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ej3 {

  public static void main(String[] args) {
    String path = ".\\ejemplo.txt";
    String ordenacion = "desc";
    String typeCase = "sensitive";
    List<String> texto = Ej3.ordenaciones(path, ordenacion, typeCase);
    Ej3.configuradorDeNombre(path, ordenacion, typeCase, texto);

    // Ej3.ordenaciones("C:\\Users\\victo\\Downloads\\EjerciciosProfeZZZ-20240916T174606Z-001\\EjerciciosProfeZZZ\\ejemplo.txt","asc","insensitive");
  }

  public static List<String> ordenaciones(String path, String ordenacion, String typeCase) {
    List<String> lista = Ej3.lectorDeFichero(path);
    if (typeCase.equals("insensitive")) {
      lista.sort(String.CASE_INSENSITIVE_ORDER);
    } else {
      Collections.sort(lista);
    }
    if (ordenacion.equals("desc")) {
      Collections.reverse(lista);
    }
    return lista;
  }

  public static List<String> lectorDeFichero(String path) {
    try{
    return Files.readAllLines(Path.of(path));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return new ArrayList<>();
  }

  private static void configuradorDeNombre(
      String path, String ordenacion, String typeCase, List<String> lista) {
    int lastDotIndex = path.lastIndexOf('.');
    if (lastDotIndex == -1) {
      throw new IllegalArgumentException("El archivo no tiene una extensión válida.");
    }
    String baseName = path.substring(0, lastDotIndex);
    String extension = path.substring(lastDotIndex);
    String nuevoPathString = baseName + "_" + ordenacion + "_" + typeCase + extension;
    Ej3.creadorArchivo(nuevoPathString, lista);
  }

  public static void creadorArchivo(String path, List<String> lineas) {
    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(path, false))) {
      for (String linea : lineas) {
        escritor.write(linea);
        escritor.newLine();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
