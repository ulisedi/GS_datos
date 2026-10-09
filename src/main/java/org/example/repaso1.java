package org.example;

import java.io.*;

public class repaso1 {
    public static void main(String[] args) {
        File fichero = new File("hola.txt");


        try {
            //lectura
                FileReader reader = new FileReader(fichero);
                BufferedReader bufferR = new BufferedReader(reader);
                // genera una variable para ir representando "linea" palabra por palabra
                String linea;
                while((linea=bufferR.readLine()) != null) {
                    System.out.println(linea);
                }
            //escritura true es para que no se reescriban los datos al añadir mas
                FileWriter writer = new FileWriter(fichero,true);
                writer.write("holahola");
                writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lecturaFchero(fichero);
    }
    public static void lecturaFchero(File archivo){
        try {
            FileReader reader = new FileReader(archivo);
            BufferedReader bufferR = new BufferedReader(reader);
            String linea;
            while((linea=bufferR.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
