/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombicide;

import java.util.ArrayList;
import static zombicide.TestZombicide.listaSupervivientes;
import static zombicide.TestZombicide.listaZombies;

/**
 *
 * @author alu520994162
 */
public class metodos {

    /**
     * Método que genera un aleatorio de 0 o 1 para determinar el exito
     * de un superviviente al realizar su ataque.
     * @param viveomuere 
     */
    public static void viveomuereZombie(int viveomuere) {
        if (viveomuere == 0) {
            System.out.println(viveomuere+ " vive");
        } else if (viveomuere == 1) {
            System.out.println(viveomuere+ " muerto");
        } else {
            System.out.println("Problemas en viveomuereZombie");
        }
    }
    /**
     * Método que muestra los datos de los supervivientes
     * @param listaSuperviviente 
     */
    public static void mostrarSuperviviente(ArrayList<Superviviente> listaSuperviviente) {
        //Mostramos todos los datos de los supervivientes
        System.out.println("Datos de los supervivientes:");
        System.out.println("_______________________________");
        for (int i = 0; i < listaSupervivientes.size(); i++) {
            System.out.println("Superviviente: " + (i + 1) + "\t");
            System.out.println("\t Nombre: " + listaSupervivientes.get(i).getNombre());
            System.out.println("\t Vidas: " + listaSupervivientes.get(i).getVidas());
            System.out.println("\t Nivel: " + listaSupervivientes.get(i).getNivel());
            System.out.println("\t Skills: " + listaSupervivientes.get(i).getSkill());
            if (listaSupervivientes.get(i).tieneArma()) {
                System.out.println("\t Arma: " + listaSupervivientes.get(i).getArma().getTipoarma());
                System.out.println("\t \t Daño: " + listaSupervivientes.get(i).getArma().getDano());
                System.out.println("\t \t Distancia: " + listaSupervivientes.get(i).getArma().getDistancia()+ "\n");
            } else {
                System.out.println("\t \t Este jugador no tiene arma \n");
            }
            System.out.println("_______________________________");
        }
    }
    
    /**
     * Método para asignar los zombies a la planta1
     *
     * @param listaZombies
     * @param planta
     */
    public static void planta1(ArrayList<Zombie> listaZombies, int planta) {
        System.out.println("Planta 1");
        System.out.println("_______________________________");
        //Limpiamos el array para cada planta
        listaZombies.removeAll(listaZombies);
        //Para la planta 1 vamos a crear:
        //8 caminantes
        Caminante caminante1 = new Caminante(2, 1, TipoZombie.CAMINANTE);
        Caminante caminante2 = new Caminante(3, 2, TipoZombie.CAMINANTE);
        Caminante caminante3 = new Caminante(3, 1, TipoZombie.CAMINANTE);
        Caminante caminante4 = new Caminante(2, 3, TipoZombie.CAMINANTE);
        Caminante caminante5 = new Caminante(5, 1, TipoZombie.CAMINANTE);
        Caminante caminante6 = new Caminante(3, 2, TipoZombie.CAMINANTE);
        Caminante caminante7 = new Caminante(1, 3, TipoZombie.CAMINANTE);
        Caminante caminante8 = new Caminante(2, 3, TipoZombie.CAMINANTE);
        listaZombies.add(caminante1);
        listaZombies.add(caminante2);
        listaZombies.add(caminante3);
        listaZombies.add(caminante4);
        listaZombies.add(caminante5);
        listaZombies.add(caminante6);
        listaZombies.add(caminante7);
        listaZombies.add(caminante8);

        //Mostramos todos los datos de los zombies
        datosZombies(listaZombies);
    }

    /**
     * Método para asignar los zombies a la planta2
     *
     * @param listaZombies
     * @param planta
     */
    public static void planta2(ArrayList<Zombie> listaZombies, int planta) {
        System.out.println("Planta 2");
        System.out.println("_______________________________");
        //Limpiamos el array para cada planta
        listaZombies.removeAll(listaZombies);
        //Para la planta 2 vamos a crear:
        //6 caminantes
        //2 gordos
        Caminante caminante1 = new Caminante(2, 1, TipoZombie.CAMINANTE);
        Caminante caminante2 = new Caminante(3, 2, TipoZombie.CAMINANTE);
        Caminante caminante3 = new Caminante(2, 1, TipoZombie.CAMINANTE);
        Caminante caminante4 = new Caminante(3, 1, TipoZombie.CAMINANTE);
        Caminante caminante5 = new Caminante(2, 3, TipoZombie.CAMINANTE);
        Caminante caminante6 = new Caminante(3, 3, TipoZombie.CAMINANTE);
        Gordo gordo1 = new Gordo(1, 1, TipoZombie.GORDO);
        Gordo gordo2 = new Gordo(1, 2, TipoZombie.GORDO);

        listaZombies.add(caminante1);
        listaZombies.add(caminante2);
        listaZombies.add(gordo1);
        listaZombies.add(caminante3);
        listaZombies.add(caminante4);
        listaZombies.add(gordo2);
        listaZombies.add(caminante5);
        listaZombies.add(caminante6);

        //Mostramos todos los datos de los zombies
        datosZombies(listaZombies);
    }

    /**
     * Método para asignar los zombies a la planta3
     *
     * @param listaZombies
     * @param planta
     */
    public static void planta3(ArrayList<Zombie> listaZombies, int planta) {
        System.out.println("Planta 3");
        System.out.println("_______________________________");
        //Limpiamos el array para cada planta
        listaZombies.removeAll(listaZombies);
        //Para la planta 3 vamos a crear:
        //5 caminantes
        //2 gordo
        //1 unkonwn
        Caminante caminante1 = new Caminante(2, 1, TipoZombie.CAMINANTE);
        Caminante caminante2 = new Caminante(3, 2, TipoZombie.CAMINANTE);
        Caminante caminante3 = new Caminante(2, 1, TipoZombie.CAMINANTE);
        Caminante caminante4 = new Caminante(3, 1, TipoZombie.CAMINANTE);
        Caminante caminante5 = new Caminante(2, 3, TipoZombie.CAMINANTE);
        Gordo gordo1 = new Gordo(1, 1, TipoZombie.GORDO);
        Gordo gordo2 = new Gordo(1, 2, TipoZombie.GORDO);
        Unknown unknown1 = new Unknown(3, 4, TipoZombie.UNKNOW);
        listaZombies.add(caminante1);
        listaZombies.add(caminante2);
        listaZombies.add(gordo1);
        listaZombies.add(caminante3);
        listaZombies.add(caminante4);
        listaZombies.add(gordo2);
        listaZombies.add(caminante5);
        listaZombies.add(unknown1);

        //Mostramos todos los datos de los zombies
        datosZombies(listaZombies);
    }

    /**
     * Método que muestra todos los datos de los Zombies.
     *
     * @param listaZombies
     */
    public static void datosZombies(ArrayList<Zombie> listaZombies) {
        for (int i = 0; i < listaZombies.size(); i++) {
            System.out.println("Zombie: " + (i + 1) + "\t");
            System.out.println("\t Daño: " + listaZombies.get(i).getDano());
            System.out.println("\t TipoZombie: " + listaZombies.get(i).getTipoZombie());
            System.out.println("\t Movimiento: " + listaZombies.get(i).getMovimiento());
            System.out.println("\t Horda:");
            System.out.println("\t \t Respawn: " + listaZombies.get(i).getHorda().getRespawn() + "\n");
            System.out.println("_______________________________");        
        }
    }
    
    public static void SupervivientesDefault() {
                /**
         * Creamos 5 jugadores y 5 zombies
         */
        Superviviente Rick = new Superviviente("Rick", 3, 0, SkillsPersonaje.RAPIDO);
        Superviviente Daryl = new Superviviente("Daryl", 3, 0, SkillsPersonaje.FORTACHON);
        Superviviente Maggie = new Superviviente("Maggie", 3, 0, SkillsPersonaje.BUSCADOR);
        Superviviente Glenn = new Superviviente("Glenn", 3, 0, SkillsPersonaje.ESCURRIDIZO);
        Superviviente Michonne = new Superviviente("Michonne", 3, 0, SkillsPersonaje.AMBIDIESTRO);
        // Creamos las 4 armas con sus valores iniciales.
        Arma sarten = new Arma(1, 0, TipoArma.SARTEN);
        Arma pistola = new Arma(3, 1, TipoArma.PISTOLA);
        Arma escopeta = new Arma(7, 2, TipoArma.ESCOPETA);
        Arma katana = new Arma(4, 0, TipoArma.KATANA);
        // Les damos las armas a nuestros supervivientes
        Rick.setArma(pistola);
        Daryl.setArma(escopeta);
        Maggie.setArma(sarten);
        Glenn.setArma(sarten);
        Michonne.setArma(katana);
        // Añadimos a los jugadores y a los zombies a sus arrays
        listaSupervivientes.add(Rick);
        listaSupervivientes.add(Daryl);
        listaSupervivientes.add(Maggie);
        listaSupervivientes.add(Glenn);
        listaSupervivientes.add(Michonne);
    }
}
