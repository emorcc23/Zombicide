package zombicide;

import java.util.*;

/**
 *
 * @author alu520994162
 */
public class TestZombicide {
    
    //Contiene supervivientes
    static ArrayList<Superviviente> listaSupervivientes = new ArrayList<>();
    //Contiene Zombies
    static ArrayList<Zombie> listaZombies = new ArrayList<>();

    //Arrays adicionales que uso en crearArmasYelegirSupervivientes()
    //para que los jugadores puedan escoger skill y arma.
    static ArrayList<String> listaArmas = new ArrayList<>();
    static ArrayList<String> listaSkills = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean salir = false;
        int opcion;
        int contador = 0;

        Scanner entrada = new Scanner(System.in);

//
//        metodos.crearArraysAdicionales();
//        metodos.SupervivientesDefault();
//        metodos.crearArmasYelegirSupervivientes(listaArmas, listaSkills);
        

        System.out.println("Empieza");
        int planta = 0;

//        metodos.SupervivientesDefault();
//        do {
//            planta++;
//            metodos.crearPlanta(listaZombies, planta);
//            metodos.batalla(listaZombies, listaSupervivientes, planta, contador);
//        } while (planta < 3);

        while (!salir) {

            System.out.println("\t ¡Bienvenido a Zombicide!\n");
            System.out.println("1. Partida rápida");
            System.out.println("2. Partida con amigos");
            System.out.println("3. Conocer a los supervivientes por defecto");
            System.out.println("4. Conocer a que nos vamos a enfrentar");
            System.out.println("5. Salir");
            opcion = entrada.nextInt();
            
            metodos.SupervivientesDefault();
            
            switch (opcion) {
                case 1:
                    //Partida rápida
                    do {
                        planta++;
                        metodos.crearPlanta(listaZombies, planta);
                        metodos.batalla(listaZombies, listaSupervivientes, planta, contador);
                    } while (planta < 3);
                    break;
                case 2:
                    //Partida con amigos
                    do {
                        planta++;
                        metodos.crearArraysAdicionales();
                        metodos.crearArmasYelegirSupervivientes(listaArmas, listaSkills);
                        metodos.batalla(listaZombies, listaSupervivientes, planta, contador);
                    } while (planta < 3);
                    break;
                case 3:
                    metodos.mostrarSuperviviente(listaSupervivientes);
                    break;
                case 4:
                    metodos.infoZombies();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("No has pulsado una opción correcta.");

            }
        }
    }

}
