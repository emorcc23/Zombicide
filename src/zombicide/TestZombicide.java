package zombicide;

import java.util.*;

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

        /**
         * Creamos 5 jugadores y 5 zombies
         */
        Superviviente Rick = new Superviviente("Rick", 3, 0, SkillsPersonaje.RAPIDO);
        Superviviente Daryl = new Superviviente("Daryl", 3, 0, SkillsPersonaje.FORTACHON);
        Superviviente Maggie = new Superviviente("Maggie", 3, 0, SkillsPersonaje.BUSCADOR);
        Superviviente Glenn = new Superviviente("Glenn", 3, 0, SkillsPersonaje.ESCURRIDIZO);
        Superviviente Michonne = new Superviviente("Michonne", 3, 0, SkillsPersonaje.AMBIDIESTRO);
        Zombie zombie1 = new Zombie(2, 1, TipoZombie.CAMINANTE);
        Zombie zombie2 = new Zombie(3, 2, TipoZombie.CAMINANTE);
        Zombie zombie3 = new Zombie(3, 1, TipoZombie.CAMINANTE);
        Zombie zombie4 = new Zombie(2, 3, TipoZombie.CAMINANTE);
        Zombie zombie5 = new Zombie(5, 1, TipoZombie.CAMINANTE);
        
        /**
         * Creamos las 4 armas con sus valores iniciales.
         */
        Arma sarten = new Arma(1, 0, TipoArma.SARTEN);
        Arma pistola = new Arma(3, 1, TipoArma.PISTOLA);
        Arma escopeta = new Arma(7, 2, TipoArma.ESCOPETA);
        Arma katana = new Arma(4, 0, TipoArma.KATANA);
        
        /**
         * Les damos las armas a nuestros supervivientes
         */
        Rick.setArma(pistola);
        Daryl.setArma(escopeta);
        Maggie.setArma(sarten);
        Glenn.setArma(sarten);
        Michonne.setArma(katana);

        Caminante c = new Caminante();
        
        /**
         * Añadimos a los jugadores y a los zombies a sus arrays
         */
        listaSupervivientes.add(Rick);
        listaSupervivientes.add(Daryl);
        listaSupervivientes.add(Maggie);
        listaSupervivientes.add(Glenn);
        listaSupervivientes.add(Michonne);
        listaZombies.add(zombie1);
        listaZombies.add(zombie2);
        listaZombies.add(zombie3);
        listaZombies.add(zombie4);
        listaZombies.add(zombie5);
/*
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
        }
        
        for (int i = 0; i < listaZombies.size(); i++) {
            System.out.println("Zombie: "+ (i + 1) + "\t");
            System.out.println("\t Daño: "+listaZombies.get(i).getDano());
            System.out.println("\t TipoZombie: "+listaZombies.get(i).getTipoZombie());
            System.out.println("\t Movimiento: "+listaZombies.get(i).getMovimiento());
            System.out.println("\t Horda:");
            System.out.println("\t \t Respawn: "+listaZombies.get(i).getHorda().getRespawn()+"\n");
        }*/

        
        
    }
}
