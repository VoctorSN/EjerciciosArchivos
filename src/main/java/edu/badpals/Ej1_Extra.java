package edu.badpals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ej1_Extra {

    public static void main(String[] args){
        System.out.println(Ej1_Extra.arbolDirectorios("."));
    }

    public static String arbolDirectorios(String path) {
        return Ej1_Extra.arbolDirectorios(Path.of(path));
    }

    public static String arbolDirectorios(Path path) {
        if (!Files.isDirectory(path))
            System.out.println("No es un directorio");
        try {
            StringBuilder lineas = new StringBuilder();
            lineas.append(lectorFichero(path,0));
            return lineas.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";

    }

    private static String  lectorFichero(Path path,int tabs) throws IOException {
        StringBuilder lineas = new StringBuilder();
        for (Path archivo : Files.newDirectoryStream(path)) {
            lineas.append("\t".repeat(Math.max(0, tabs)));
            lineas.append(tabs==0 ? Ej1.lectorPropiedades(archivo) : ">" + Ej1.lectorPropiedades(archivo));
            if (Files.isDirectory(archivo)){
                lineas.append(lectorFichero(archivo,tabs+1));
            }
        }
        return lineas.toString();
    }
}