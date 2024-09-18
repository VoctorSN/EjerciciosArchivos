package edu.badpals;


public class Ej4_Corrector {
    public static final String EXCELENTE = "excelente";
    public static final String NOTABLE = "notable";
    public static final String BIEN = "bien";
    public static final String APROBADO = "aprobado";
    public static final String SUSPENSO = "suspenso";
    public Ej4_Corrector() {
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
            return Ej4_Corrector.EXCELENTE;
        } else if (nota >= 7) {
            return Ej4_Corrector.NOTABLE;
        } else if (nota >= 6) {
            return Ej4_Corrector.BIEN;
        } else if (nota >= 5) {
            return Ej4_Corrector.APROBADO;
        }
        return Ej4_Corrector.SUSPENSO;
    }
}


