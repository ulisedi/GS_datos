//Eduard-Constantin Davidov
package org.example;

import java.io.*;

public class eje2ECDrevidado {

    public static void main(String[] args) {
        File fichero = new File("datos.txt");
        int suma = 0;

        // try-with-resources: el lector se cierra solo al terminar
        try (BufferedReader bufferR = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = bufferR.readLine()) != null) {
                System.out.println(linea);
                try {
                    suma += Integer.parseInt(linea.trim());
                } catch (NumberFormatException e) {
                    // línea vacía o que no es un número: se ignora
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
            return;
        }

        // true = modo "append": escribe al final sin borrar lo anterior
        try (FileWriter writer = new FileWriter(fichero, true)) {
            writer.write("\nSuma total = " + suma);
        } catch (IOException e) {
            System.out.println("Error escribiendo el archivo: " + e.getMessage());
        }
    }
}