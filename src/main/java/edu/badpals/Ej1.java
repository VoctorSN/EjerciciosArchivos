package edu.badpals;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Ej1 {

    public static void main(String[] args) {
        Ej1.ls();
    }

    public static void ls(){
        Scanner nombre_dir = new Scanner(System.in);
        Path path = Path.of(nombre_dir.nextLine());
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
            System.out.println(lineas);
        } catch (Exception e){
                System.out.println(e.getMessage());
        }
    }
}
