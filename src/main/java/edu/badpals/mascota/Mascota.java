package edu.badpals.mascota;

import java.io.Serializable;

public class Mascota implements Serializable {
  private static final long serialVersionUID = 1L;

  private final String nombre;
  private final int numPatas;
  private boolean pelo;

  public Mascota(String nombre, int numPatas) {
    this.nombre = nombre;
    this.numPatas = numPatas;
    this.pelo = true;
  }

  public Mascota(String nombre, int numPatas, boolean pelo) {
    this(nombre, numPatas);
    this.pelo = pelo;
  }

  public String getNombre() {
    return nombre;
  }

  public int getNumPatas() {
    return numPatas;
  }

  public boolean hasPelo() {
    return pelo;
  }

  @Override
  public String toString() {
    return "Mascota nombre=" + nombre + " numPatas=" + numPatas + " pelo=" + pelo;
  }
}
