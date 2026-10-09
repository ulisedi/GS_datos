package org.example;

import java.io.*;
import java.util.Scanner;

public class eje1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[] preguntas = new float[10];
        float suma = 0;
        float mayor = 0;
        float menor = 10;

        for (int i = 0; i < preguntas.length; i++) {
            System.out.println("Dime la nota numero: " + (i + 1));
            try {
                preguntas[i] = sc.nextFloat();
            } catch (Exception e) {
                System.out.println("Error con el valor introducido");
                i--;
                continue;
            }
            if (menor > preguntas[i]) {
                menor = preguntas[i];
            }
            if (preguntas[i] > mayor) {
                mayor = preguntas[i];
            }
            suma += preguntas[i];
        }

        try (FileWriter escritor = new FileWriter("eje1.txt")) {
            escritor.write("El promedio de notas es: " + suma / preguntas.length + "\n");
            escritor.write("El mayor es: " + mayor + "\n");
            escritor.write("El menor es: " + menor + "\n");
            System.out.println("¡Escrito correctamente!");
            FileReader reader = new FileReader("eje1.txt");
            BufferedReader bReader = new BufferedReader(reader);
            String linea ;
            while ((linea=bReader.readLine()) != null){
              System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo.");
        }



    }


}
