package edu.badpals;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ej2 {
    public static void main(String[] args){
        //Scanner sc = new Scanner(System.in);

        //System.out.println("Escribe el path");
        //String path = sc.nextLine();
        //System.out.println("Escribe la letra");
        //char letraABuscar = sc.nextLine().charAt(0);

        String path = ".\\ejemplo.txt";
        char letra = 'a';
        System.out.println(Ej2.charCounter(path,letra));
    }

    private static int charCounter(String path, char letra) {
        try {
            int vecesAparecida = 0;
            BufferedReader lector = new BufferedReader(new FileReader(path));
            String linea;
            while((linea = lector.readLine()) != null){
                for (char caracter : linea.toCharArray()){
                    if (caracter == letra){
                        vecesAparecida ++;
                    }
                }
            }

            return vecesAparecida;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
