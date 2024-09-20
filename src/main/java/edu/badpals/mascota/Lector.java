package edu.badpals.mascota;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Lector {
  public static void main(String[] args) {
    List<Mascota> mascotas = new ArrayList<Mascota>();

    try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream("prueba.bin"))) {
      while (true) {
        Object o = lector.readObject();
        if (o instanceof Mascota) {
          mascotas.add((Mascota) o);
        }
      }

    } catch (EOFException ex) {
      System.out.println("Hemos llegado al final del archivo.");
      for (Mascota m : mascotas) {
        System.out.println(m);
      }
    } catch (IOException ex) {
      System.err.println(ex);
    } catch (ClassNotFoundException ex) {
      System.err.println(ex);
    }
  }
}
