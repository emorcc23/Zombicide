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
        //metodos.mostrarSuperviviente(listaSupervivientes);

        int planta = 0;
        

        planta = 1;
//        metodos.crearPlanta(listaZombies, planta);
        
        
        metodos.ataqueaZombies(1);
//        int aleatorioAtaqueZ = (int) (Math.random()* listaZombies.size());
//        //Segunda comprobación
//        for (int i = 0; i < listaZombies.size(); i++) {
//            System.out.println(listaZombies.get(i).getTipoZombie());
//        }
//        
//        listaZombies.remove(aleatorioAtaqueZ);
//        System.out.println(aleatorioAtaqueZ);
//        listaZombies.remove(aleatorioAtaqueZ);
//        System.out.println(aleatorioAtaqueZ);
//        listaZombies.remove(aleatorioAtaqueZ);
//        System.out.println(aleatorioAtaqueZ);
//        System.out.println("-----------------------------");
        
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
