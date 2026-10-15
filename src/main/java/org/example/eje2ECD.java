//Eduard-Constantin Davidov
package org.example;

import java.io.*;

public class eje2ECD {

    public static void main(String[] args) throws IOException {
        File fichero = new File("datos.txt");
        int suma = 0;
        try (BufferedReader bufferR = new BufferedReader(new FileReader(fichero))){
            //leer el archivo
            String linea;
            // se introduce en la variable linea por cada iteracion hasta que no de null
            // para pasarlo por pantalla
            while ((linea = bufferR.readLine()) != null) {
                System.out.println(linea);
                // no me acuerdo como se parsea
                try {
                    suma += Integer.parseInt(linea.trim());
                } catch (NumberFormatException e) {

                }
            }
            // se escribe en el final del archivo el resultado guardado en "suma"
        } catch (NumberFormatException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter writer = new FileWriter(fichero, true);){
            writer.write(" \n Suma total = " + suma);
        }

        /// al poner el coso entre los parentesis no hace falta hacer el close louego
        ///  que los hace solo


    }


}
