package zombicide;

import java.util.*;
import zombicide.metodos;

/**
 *
 * @author alu520994162
 */
public class TestZombicide {

    static ArrayList<Superviviente> listaSupervivientes = new ArrayList<>();
    static ArrayList<Zombie> listaZombies = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean salir = false;
        int opcion;

        Scanner entrada = new Scanner(System.in);

        while (!salir) {

            System.out.println("\t ¡Bienvenido a Zombicide!\n");
            System.out.println("1. Partida rápida");
            System.out.println("2. Partida con amigos");
            System.out.println("3. Conocer a los supervivientes");
            System.out.println("4. Conocer a que nos vamos a enfrentar");
            System.out.println("5. Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:
                    metodos.mostrarSuperviviente(listaSupervivientes);
                    break;
                case 4:
                    
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("No has pulsado una opción correcta.");

            }
        }

//        metodos.SupervivientesDefault();
        int planta;

        planta = 1;
        metodos.crearPlanta(listaZombies, planta);
        metodos.SupervivientesDefault();
        metodos.crearArmas();
        metodos.mostrarSuperviviente(listaSupervivientes);

        /**
         * Esto devuelve si esta vivo o muerto al dar un impacto (Acordarse de
         * quitar el comentario) metodos.viveomuereZombie(viveomuere);
         */
        /**
         * Para empezar el juego... -El edificio tiene 3 plantas- -En cada
         * planta hay una horda con 8 zombis..............
         */
        metodos.batalla(listaZombies, listaSupervivientes, planta);
        planta++;
        metodos.batalla(listaZombies, listaSupervivientes, planta);
        planta++;
        metodos.batalla(listaZombies, listaSupervivientes, planta);
    }
}
