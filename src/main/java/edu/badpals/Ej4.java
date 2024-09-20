package edu.badpals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ej4 {

  public static void main(String[] args) {
    System.out.println(Ej4.corregirTests(".\\testCorregidos.txt"));
  }

  public static String corregirTests(String path) {
    StringBuilder out = new StringBuilder();
    DecimalFormat df = new DecimalFormat("#.##");

    try (BufferedReader lector = new BufferedReader(new FileReader(path))) {
      String linea;
      int i = 1;
      String testCorregido = "";
      List<String> listaNotas = new ArrayList<>();
      while ((linea = lector.readLine()) != null) {
        if (i == 1) {
          i = 0;
          testCorregido = linea;
        } else if (!linea.isEmpty()) {
          int indexEspacio = linea.indexOf(" ");
          String codigoAlumno = linea.substring(0, indexEspacio);
          String respuestas = linea.substring(indexEspacio + 1);
          double nota = Ej4_Corrector.corregirTest(testCorregido, respuestas);
          String notaCalificada = Ej4_Corrector.calificar(nota);
          out.append(codigoAlumno);
          out.append(' ');
          out.append(df.format(nota));
          out.append(' ');
          out.append(notaCalificada);
          out.append("\n");
          listaNotas.add(notaCalificada);
        }
      }
      String tabla = Ej4.contarNotas(listaNotas);
      out.append(tabla);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return out.toString();
  }

  private static String contarNotas(List<String> notas) {

    return "Hay " +
            Collections.frequency(notas, Ej4_Corrector.EXCELENTE) +
            " excelentes\n" +
            "Hay " +
            Collections.frequency(notas, Ej4_Corrector.NOTABLE) +
            " notables\n" +
            "Hay " +
            Collections.frequency(notas, Ej4_Corrector.BIEN) +
            " bienes\n" +
            "Hay " +
            Collections.frequency(notas, Ej4_Corrector.APROBADO) +
            " aprobados\n" +
            "Hay " +
            Collections.frequency(notas, Ej4_Corrector.SUSPENSO) +
            " suspensos\n";
  }
}
