package edu.badpals.mascota;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Personas {

  public static void main(String[] args) {
    List<Persona> personas = new ArrayList<Persona>();
    personas.add(new Persona("Joel"));
    personas.add(new Persona("Aman"));
    personas.add(new Persona("Victor"));
    personas.add(new Persona("Manuel"));

    try (ObjectOutputStream escritor =
        new ObjectOutputStream(new FileOutputStream("personas.bin"))) {
      for (Persona persona : personas) {
        escritor.writeObject(persona);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
