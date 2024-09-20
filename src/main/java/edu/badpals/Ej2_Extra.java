package edu.badpals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ej2_Extra {

  private final Scanner sc = new Scanner(System.in);
  private final StringBuilder INTERFAZ_MENU =
      new StringBuilder(
          "Que quieres hacer:\n-cd cambiar de directorio\n-ls mostrar el contenido del directorio actual\n-cat mostrar el contenido de un archivo\n-exit salir del menu\n");
  private String respuesta = "";
  private String path = System.getProperty("user.dir");

  public static void main(String[] args) {
    Ej2_Extra app = new Ej2_Extra();
    app.openMenu();
  }

  private void openMenu() {
    while (!respuesta.equals("exit")) {
      System.out.println(INTERFAZ_MENU);
      System.out.println(">" + this.path);
      respuesta = sc.nextLine();
      switch (respuesta) {
        case "ls" -> ls(this.path);
        case "cat" -> cat(this.path);
        case "cd" -> cd(this.path);
        default -> {
          if (respuesta.equals("exit")) {
            System.out.println("Saliendo de la terminal");
          } else {
            System.out.println("Esa no es una respuesta valida");
          }
        }
      }
    }
  }

  private void ls(String path) {
    System.out.println(Ej1_Extra.arbolDirectorios(path));
  }

  private void cd(String dondeEstamos) {
    System.out.println("A que direccion quieres ir");
    String dondeVamos = sc.nextLine();
    String stringResultante;
    if (Path.of(dondeVamos).isAbsolute()) {
      stringResultante = dondeVamos;
    } else {
      while (dondeVamos.startsWith("..\\") || dondeVamos.startsWith("../")) {
        dondeEstamos = Path.of(dondeEstamos).getParent().toString();
        dondeVamos = dondeVamos.substring(3);
      }
      stringResultante = Paths.get(dondeEstamos, dondeVamos).normalize().toString();
    }
    Path pathResultante = Path.of(stringResultante);
    if (Files.isDirectory(pathResultante)) {
      this.path = stringResultante;
    } else {
      if (Files.exists(pathResultante)) {
        System.out.println("no puedes ir a un archivo");
      } else {
        System.out.println(pathResultante);
        System.out.println("Esta ruta no existe");
      }
    }
  }

  private void cat(String path) {
    System.out.println("Que archivo quieres leer");
    String pathArchivo = Paths.get(path, sc.nextLine()).normalize().toString();
    if (Files.exists(Path.of(pathArchivo))) {
      for (String linea : Ej3.lectorDeFichero(pathArchivo)) {
        System.out.println(linea);
      }
    } else {
      System.out.println("No existe el archivo");
    }
  }
}
