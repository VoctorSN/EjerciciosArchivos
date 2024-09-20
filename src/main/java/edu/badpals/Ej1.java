package edu.badpals;

import java.nio.file.Files;
import java.nio.file.Path;

public class Ej1 {

  public static void main(String[] args) {
    // Scanner nombre_dir = new Scanner(System.in);
    // Path path = Path.of(nombre_dir.nextLine());

    Path path = Path.of(".\\");
    System.out.println(Ej1.ls(path));
  }

  public static String ls(Path path) {
    if (!Files.isDirectory(path)) System.out.println("No es un directorio");
    try {
      StringBuilder lineas = new StringBuilder();
      for (Path archivo : Files.newDirectoryStream(path)) {
        lineas.append(lectorPropiedades(archivo));
      }
      return lineas.toString();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return "";
  }

  public static String lectorPropiedades(Path archivo) {
    boolean isDir = Files.isDirectory(archivo);
    return (isDir ? "d" : "-")
        + (Files.isReadable(archivo) ? "r" : "-")
        + (Files.isWritable(archivo) ? "w" : "-")
        + (Files.isExecutable(archivo) ? "x " : "- ")
        + archivo
        + (isDir ? "/\n" : "\n");
  }
}
