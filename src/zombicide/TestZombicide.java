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
        

        metodos.SupervivientesDefault();
        metodos.mostrarSuperviviente(listaSupervivientes);

        int planta = 0;
        int viveomuere = (int) (Math.random()* 2);

        planta = 1;
        switch (planta) {
            case 1:
                metodos.planta1(listaZombies, planta);
                planta++;
                break;
            case 2:
                metodos.planta2(listaZombies, planta);
                planta++;
                break;
            case 3:
                metodos.planta3(listaZombies, planta);
                planta = 0;
                break;
            case 0:
                System.out.println("No tienes asignada ninguna planta, ojito!");
                break;
            default:
                System.out.println("Algo va mal con las plantas.. revisalo!");
                break;
        }
        
        /**
         * Esto devuelve si esta vivo o muerto al dar un impacto
         * (Acordarse de quitar el comentario)
         * metodos.viveomuereZombie(viveomuere);
         */
        
        /**
         * Para empezar el juego...
         * -El edificio tiene 3 plantas-
         * -En cada planta hay una horda con 8 zombis..............
         */
    }
}
