package org.example;

import java.io.*;

public class unteje1 {
    public int nDep;
    public String nombre;
    public String localidad;

    public  unteje1(int nDep,String nombre,String localidad){
        this.nDep=nDep;
        this.nombre=nombre;
        this.localidad=localidad;
    }

    public String lecturaA(File archivo){
        String linea;
        try {
            FileReader reader = new FileReader(archivo);
            BufferedReader br = new BufferedReader(reader);
            while((linea=br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return linea;
    }




    public static void main(String[] args) {
        File fichero = new File("departamento.dat");
        try {
            //lectura
                FileReader reader = new FileReader(fichero);
                BufferedReader bufferR = new BufferedReader(reader);
                // genera una variable para ir representando "linea" palabra por palabra
                String linea;
                while((linea=bufferR.readLine()) != null) {
                    System.out.println(linea);
                }
            //escritura
                FileWriter writer = new FileWriter(fichero);
                PrintWriter pw = new PrintWriter(writer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
