package org.example;/*
 * EJERCICIO: Gestión de productos en fichero binario
 *
 * Crea un programa que trabaje con un fichero binario llamado productos.dat.
 *
 * Cada producto estará formado por:
 *      - Código (int)
 *      - Precio (double)
 *
 * El programa deberá:
 *
 * 1. Crear el fichero y almacenar 3 productos.
 *
 * 2. Leer el fichero y mostrar todos los productos.
 *
 * 3. Solicitar un código de producto y un nuevo precio.
 *
 * 4. Modificar el precio del producto indicado.
 *
 * 5. Guardar de nuevo los datos en el fichero.
 *
 * 6. Mostrar el contenido actualizado.
 *
 * Ejemplo:
 *
 * Antes:
 *
 * Código: 1  Precio: 10.5
 * Código: 2  Precio: 20.0
 * Código: 3  Precio: 30.0
 *
 * Modificación:
 *
 * Código a modificar: 2
 * Nuevo precio: 25.5
 *
 * Después:
 *
 * Código: 1  Precio: 10.5
 * Código: 2  Precio: 25.5
 * Código: 3  Precio: 30.0
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductosBinarios {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String fichero = "productos.dat";

        try {

            // CREAR FICHERO CON 3 PRODUCTOS
            DataOutputStream dos =
                    new DataOutputStream(
                            new FileOutputStream(fichero));

            dos.writeInt(1);
            dos.writeDouble(10.5);

            dos.writeInt(2);
            dos.writeDouble(20.0);

            dos.writeInt(3);
            dos.writeDouble(30.0);

            dos.close();

            // MOSTRAR CONTENIDO ORIGINAL
            System.out.println("CONTENIDO ORIGINAL:");

            DataInputStream dis =
                    new DataInputStream(
                            new FileInputStream(fichero));

            while (dis.available() > 0) {

                int codigo = dis.readInt();
                double precio = dis.readDouble();

                System.out.println(
                        "Código: " + codigo +
                        " Precio: " + precio);
            }

            dis.close();

            // PEDIR MODIFICACIÓN
            System.out.print("Código a modificar: ");
            int codigoBuscar = sc.nextInt();

            System.out.print("Nuevo precio: ");
            double nuevoPrecio = sc.nextDouble();

            // LEER TODO EL FICHERO
            ArrayList<Integer> codigos = new ArrayList<>();
            ArrayList<Double> precios = new ArrayList<>();

            dis = new DataInputStream(
                    new FileInputStream(fichero));

            while (dis.available() > 0) {

                codigos.add(dis.readInt());
                precios.add(dis.readDouble());
            }

            dis.close();

            // MODIFICAR
            boolean encontrado = false;

            for (int i = 0; i < codigos.size(); i++) {

                if (codigos.get(i) == codigoBuscar) {

                    precios.set(i, nuevoPrecio);
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {

                // REESCRIBIR FICHERO
                dos = new DataOutputStream(
                        new FileOutputStream(fichero));

                for (int i = 0; i < codigos.size(); i++) {

                    dos.writeInt(codigos.get(i));
                    dos.writeDouble(precios.get(i));
                }

                dos.close();

                System.out.println("Producto modificado.");
            } else {

                System.out.println("Código no encontrado.");
            }

            // MOSTRAR CONTENIDO ACTUALIZADO
            System.out.println("CONTENIDO ACTUALIZADO:");

            dis = new DataInputStream(
                    new FileInputStream(fichero));

            while (dis.available() > 0) {

                int codigo = dis.readInt();
                double precio = dis.readDouble();

                System.out.println(
                        "Código: " + codigo +
                        " Precio: " + precio);
            }

            dis.close();

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}