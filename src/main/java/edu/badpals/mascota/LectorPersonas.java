package edu.badpals.mascota;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LectorPersonas {
  public static void main(String[] args) {
    try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream("personas.bin"))) {
      while (lector.available() > 0) {
        Object persona = lector.readObject();
        if (persona instanceof Persona) {
          System.out.println(persona);
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
