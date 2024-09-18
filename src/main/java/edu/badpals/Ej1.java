package edu.badpals;

import java.nio.file.Files;
import java.nio.file.Path;

public class Ej1 {

    public static void main(String[] args) {
        //Scanner nombre_dir = new Scanner(System.in);
        //Path path = Path.of(nombre_dir.nextLine());

        Path path = Path.of(".\\");
        System.out.println(Ej1.ls(path));
    }

    public static String ls(Path path){
        if (!Files.isDirectory(path))
            System.out.println("No es un directorio");
        try{
            StringBuilder lineas = new StringBuilder();
            for (Path archivo: Files.newDirectoryStream(path)){
                lineas.append(Files.isDirectory(archivo) ? "d" : "-");
                lineas.append(Files.isReadable(archivo) ? "r" : "-");
                lineas.append(Files.isWritable(archivo) ? "w" : "-");
                lineas.append(Files.isExecutable(archivo) ? "x " : "- ");
                lineas.append(archivo);
                lineas.append("\n");
            }
            return lineas.toString();
        } catch (Exception e){
                System.out.println(e.getMessage());
        }
        return "";
    }
}
