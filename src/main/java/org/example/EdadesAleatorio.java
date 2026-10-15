/*
 * EJERCICIO: Acceso aleatorio a un fichero
 *
 * Crea un programa que trabaje con un fichero llamado edades.dat.
 *
 * El programa deberá:
 *
 * 1. Guardar las edades de 5 personas en un fichero binario.
 *
 * 2. Mostrar todas las edades almacenadas.
 *
 * 3. Solicitar al usuario la posición de una persona
 *    (0, 1, 2, 3 o 4).
 *
 * 4. Utilizar el método seek() para acceder directamente
 *    a la edad de esa persona.
 *
 * 5. Solicitar una nueva edad y modificar el valor
 *    almacenado en el fichero.
 *
 * 6. Volver a mostrar todas las edades para comprobar
 *    que la modificación se ha realizado correctamente.
 *
 * Pista:
 * Un int ocupa 4 bytes.
 *
 * Para acceder a una posición concreta:
 *
 * posición * 4
 */

import java.io.RandomAccessFile;
import java.util.Scanner;

public class EdadesAleatorio {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            RandomAccessFile raf =
                    new RandomAccessFile("edades.dat", "rw");

            // Crear fichero
            raf.setLength(0);

            raf.writeInt(20);
            raf.writeInt(25);
            raf.writeInt(30);
            raf.writeInt(35);
            raf.writeInt(40);

            // Mostrar contenido inicial
            System.out.println("EDADES INICIALES:");

            raf.seek(0);

            for (int i = 0; i < 5; i++) {

                System.out.println(raf.readInt());
            }

            // Modificar una posición
            System.out.print("Posición a modificar (0-4): ");
            int posicion = sc.nextInt();

            System.out.print("Nueva edad: ");
            int nuevaEdad = sc.nextInt();

            raf.seek(posicion * 4);//multiplico por 4 porque cada int ocupa 4 bytes

            raf.writeInt(nuevaEdad);

            // Mostrar contenido actualizado
            System.out.println("EDADES ACTUALIZADAS:");

            raf.seek(0);

            for (int i = 0; i < 5; i++) {

                System.out.println(raf.readInt());
            }

            raf.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}