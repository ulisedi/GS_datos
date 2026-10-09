package org.example;

import java.io.*;
public class sdfd
{
    public static void main(String[] args)
    {
        File fichero = null;
        FileWriter writer = null;
        PrintWriter pw = null;
        try
        {
            fichero = new File("hola.txt");
            writer = new FileWriter(fichero);
            pw = new PrintWriter(writer);
            for (int i = 0; i < 10; i++) {
                pw.println("Linea " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}