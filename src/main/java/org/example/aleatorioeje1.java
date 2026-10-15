package org.example;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.RandomAccess;

public class aleatorioeje1 {
    public static class curso{
        int numCurso;
        String nomCurso;
        Double coste;
        public  curso(int numCurso,String nomCurso, Double coste){
            this.numCurso=numCurso;
            this.nomCurso=nomCurso;
            this.coste=coste;
        }

    }
    static void main(String[] args) {
        ArrayList <curso> cursos;
        try {
            RandomAccessFile raf =new RandomAccessFile("CursosAleatorio.dat","rw");
            for(int i =0;i <= 15;i++){
                    raf.setLength(i);
            }



        } catch (IOException e){

        }


    }
}
