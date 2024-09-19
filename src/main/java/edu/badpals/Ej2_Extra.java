package edu.badpals;

import java.util.*;

public class Ej2_Extra {

    private Scanner sc = new Scanner(System.in);
    private String respuesta = "";
    private final Set<String> RESPUESTAS = new HashSet<>(Arrays.asList("cat","cd","ls"));
    private String path = System.getProperty("user.dir");
    private final StringBuilder INTERFAZ_MENU = new StringBuilder("Que quieres hacer:\n-cd cambiar de directorio\n-ls mostrar el contenido del directorio actual\n-cat mostrar el contenido de un archivo\n-exit salir del menu\n").append("\n>").append(path).append(" ");

    public static void main(String[] args){
        Ej2_Extra app = new Ej2_Extra();
        app.openMenu();
    }

    private void openMenu() {
        while (!respuesta.equals("exit")){
            System.out.println(INTERFAZ_MENU);
            respuesta = sc.nextLine();
            if (!RESPUESTAS.contains(respuesta)){
                System.out.println("Esa no es una respuesta valida");
                this.openMenu();
            }
            if (respuesta.equals("ls")){
                ls(path);
            } else if (respuesta.equals("cat")) {
                cat(path);
            }
        }
    }

    private static void ls(String path) {
        System.out.println(Ej1_Extra.arbolDirectorios(path));
    }

    private void cat(String path){
        System.out.println("Que archivo quieres leer");
        String archivo = sc.nextLine();
        System.out.println(Ej3.lectorDeFichero(archivo));
    }


}
