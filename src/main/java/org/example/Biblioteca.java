package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    static final String FICHERO = "biblioteca.dat";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- BIBLIOTECA ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Mostrar catálogo");
            System.out.println("3. Buscar libro");
            System.out.println("4. Prestar libro");
            System.out.println("5. Listar prestados");
            System.out.println("6. Estadísticas");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarLibro(sc);
                    break;

                case 2:
                    mostrarCatalogo();
                    break;

                case 3:
                    buscarLibro(sc);
                    break;

                case 4:
                    prestarLibro(sc);
                    break;

                case 5:
                    listarPrestados();
                    break;

                case 6:
                    estadisticas();
                    break;

                case 7:
                    System.out.println("Fin del programa.");
                    break;
            }

        } while (opcion != 7);

        sc.close();
    }

    // Cargar libros del fichero
    static ArrayList<Libro> cargarLibros() {

        File fichero = new File(FICHERO);

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FICHERO))) {

            return (ArrayList<Libro>) ois.readObject();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Guardar libros
    private static void guardarLibros(ArrayList<Libro> libros) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

            oos.writeObject(libros);

        } catch (IOException e) {
            System.out.println("Error al guardar.");
        }
    }

    // Registrar libro
    static void registrarLibro(Scanner sc) {

        ArrayList<Libro> libros = cargarLibros();

        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        libros.add(new Libro(codigo, titulo, autor, false));

        guardarLibros(libros);

    }

    // Mostrar catálogo
    static void mostrarCatalogo() {

        ArrayList<Libro> libros = cargarLibros();


        for (Libro l : libros) {
            System.out.println("\n" + l.toString());
        }
    }

    // Buscar libro
    static void buscarLibro(Scanner sc) {

        ArrayList<Libro> libros = cargarLibros();

        System.out.print("Código a buscar: ");
        int codigo = sc.nextInt();

        for (Libro l : libros) {

            if (l.getCodigo() == codigo) {
                System.out.println("\nLibro encontrado:");
                System.out.println(l);
                return;
            }
        }

    }

    // Prestar libro
    static void prestarLibro(Scanner sc) {

        ArrayList<Libro> libros = cargarLibros();

        System.out.print("Código del libro: ");
        int codigo = sc.nextInt();

        for (Libro l : libros) {

            if (l.getCodigo() == codigo) {

                if (!l.isPrestado()) {

                    l.setPrestado(true);
                    guardarLibros(libros);

                    System.out.println("Préstamo realizado.");

                } else {
                    System.out.println("El libro ya está prestado.");
                }

                return;
            }
        }

    }

    // Mostrar prestados
    static void listarPrestados() {

        ArrayList<Libro> libros = cargarLibros();



        for (Libro l : libros) {

            if (l.isPrestado()) {

                System.out.println("\n" + l.toString());

            }
        }


    }

    // Estadísticas
    static void estadisticas() {

        ArrayList<Libro> libros = cargarLibros();

        int total = libros.size();
        int prestados = 0;

        for (Libro l : libros) {

            if (l.isPrestado()) {
                prestados++;
            }
        }

        int disponibles = total - prestados;

        System.out.println("Total libros: " + total);
        System.out.println("Prestados: " + prestados);
        System.out.println("Disponibles: " + disponibles);

    }
}