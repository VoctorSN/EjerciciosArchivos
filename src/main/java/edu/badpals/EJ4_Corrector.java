package edu.badpals;

import java.lang.module.FindException;

public class EJ4_Corrector {
    public EJ4_Corrector() {
    }

    public static double corregirTest(String testCorregido, String testACorregir) {
        double puntuacion = 0;
        int index = 0;
        while (index < 20){
            char respuesta = testACorregir.charAt(index);
            if (respuesta == testCorregido.charAt(index)){
                puntuacion += 0.5;
            } else if (respuesta != ' ') {
                puntuacion -= 0.15;
            }
            index++;
        }
        return puntuacion;
    }

    public static String calificar(double nota) {
        if (nota >= 8.5){
            return "excelente";
        } else if (nota >= 7) {
            return "notable";
        } else if (nota >= 6) {
            return "bien";
        } else if (nota >= 5) {
            return "aprobado";
        }
        return "suspenso";
    }
}


