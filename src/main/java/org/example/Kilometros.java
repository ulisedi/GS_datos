package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Kilometros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fichero = "kilometros.dat";
        try {
            //escribir en el archivo los datos que se quiera
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero));
            Double numKilometos =0.0;
            for (int i =0; i<5;i++){
                System.out.print("dime que kilometros has corrido el dia "+ (i+1)+" : ");
                try {
                    numKilometos = sc.nextDouble();
                } catch (Exception e) {
                    System.out.println("El valor tiene que ser un Double. Formato:    X,X");
                    i--;
                    sc.nextLine();
                }
                dos.writeDouble(numKilometos);
            }
            //

            // leer los datos y manipularlos
            DataInputStream dis = new DataInputStream(new FileInputStream(fichero));
            ArrayList<Double> kilometros = new ArrayList<>();
            dis = new DataInputStream(new FileInputStream(fichero));
            while (dis.available() > 0) {
                kilometros.add(dis.readDouble());
            }
            dis.close();

            System.out.println("kilometros de los 5 Dias");

            dis = new DataInputStream(new FileInputStream(fichero));
            double media =0;
            double total =0;
            double diaMax=0;
            while (dis.available() > 0) {
                double km = dis.readDouble();
                System.out.println(" Kilometros del dia "+ (kilometros.indexOf(km)+1) +": "+ km+" km");
                total += km;
                if(km > diaMax){
                    diaMax=km;
                }

            }
            media = total / kilometros.size();
            dis.close();
            System.out.println(" el total recorido es de: "+ total);
            System.out.println(" la media es de: "+ media);
            System.out.println(" El día con mayor número de kilómetroses el: "+ (kilometros.indexOf(diaMax)+1)+" con "+ diaMax+" km");


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}