package edu.badpals.mascota;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Mascotas {

  public static void main(String[] args) {
    Mascota[] mascotas = new Mascota[4];
    mascotas[0] = new Mascota("Rudy", 4);
    mascotas[1] = new Mascota("Piolin", 2, false);
    mascotas[2] = new Mascota("Nemo", 0, false);
    mascotas[3] = new Mascota("Tara", 8);

    try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("prueba.bin"))) {
      for (Mascota m : mascotas) {
        escritor.writeObject(m);
      }
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }
}
