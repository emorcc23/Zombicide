/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombicide;

import java.util.*;
import static zombicide.TestZombicide.listaSupervivientes;
import static zombicide.TestZombicide.listaZombies;

/**
 *
 * @author alu520994162
 */
public class metodos {

    static Scanner entrada = new Scanner(System.in);
    
    public static void ataqueaZombies(int planta) {
        crearPlanta(listaZombies, planta);
        System.out.println("Comienza el juego, hay: "+listaZombies.size()+" zombies.");
        for (int i = 0; i < listaSupervivientes.size(); i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.println(listaSupervivientes.get(i).getNombre() + ", ¡es tu turno de atacar!");
                int aleatorioAtaqueZ = (int) (Math.random()* listaZombies.size());
                if (listaSupervivientes.get(i).getArma().getDano() >= listaZombies.get(aleatorioAtaqueZ).getMuere()) {
                    if (viveomuereZombie() == 1) {
                        System.out.println("Has matado al zombie numero: "+aleatorioAtaqueZ+" de "+listaZombies.size());
                        listaZombies.remove(aleatorioAtaqueZ);
                        System.out.println("Quedan: "+listaZombies.size()+" zombies vivos");
                        System.out.println("_________________________________");
                    } else {
                        System.out.println("No has matado a ningun zombie...");
                        System.out.println("Quedan: "+listaZombies.size()+" zombies vivos");
                        System.out.println("_________________________________");
                    }
                } else {
                    System.out.println("Tu equipo se ha cargado a todos los zombies...");
                    break;
                }
            }
        }
        System.out.println("Termina el juego, hay: "+listaZombies.size()+" zombies.");
    }

    public static void configArmasSkills() {
        for (int i = 0; i < listaSupervivientes.size(); i++) {

            //Habilidades de 'RAPIDO'
            if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.RAPIDO && listaSupervivientes.get(i).getArma().getTipoarma() == TipoArma.SARTEN) {
                Arma sarten = new Arma(2, 1, TipoArma.SARTEN);
                listaSupervivientes.get(i).setArma(sarten);
                System.out.println("Sartén con daño mejorado para: " + listaSupervivientes.get(i).getNombre());
            } else if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.RAPIDO && listaSupervivientes.get(i).getArma().getTipoarma() == TipoArma.PISTOLA) {
                Arma pistola = new Arma(2, 2, TipoArma.PISTOLA);
                listaSupervivientes.get(i).setArma(pistola);
                System.out.println("Pistola con daño mejorado para: " + listaSupervivientes.get(i).getNombre());
            } else if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.RAPIDO && listaSupervivientes.get(i).getArma().getTipoarma() == TipoArma.ESCOPETA) {
                Arma escopeta = new Arma(2, 2, TipoArma.ESCOPETA);
                listaSupervivientes.get(i).setArma(escopeta);
                System.out.println("Escopeta con daño mejorado para: " + listaSupervivientes.get(i).getNombre());
            } else {
                System.out.println("Hacedlo como querais.. pero me da la sensación de que estais"
                        + "desperdiciando la habilidad del superviviente 'RAPIDO'.");
            }

            //Habilidades de 'BUSCADOR'
            if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.BUSCADOR) {
                Arma katana = new Arma(2, 1, TipoArma.KATANA);
                listaSupervivientes.get(i).setArma(katana);
                System.out.println("Se le asignará a :" + listaSupervivientes.get(i).getNombre() + " una katana"
                        + "por defecto ya que tiene la skill: 'BUSCADOR'.");
            }

            //Habilidades de 'FORTACHON'
            if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.FORTACHON) {
                listaSupervivientes.get(i).setVidas(4);
                System.out.println("Enhorabuena " + listaSupervivientes.get(i).getNombre() + ", gracias a tu "
                        + "habilidad de 'FORTACHON' cuentas con una vida extra.");
            }

            //Habilidades de 'ESCURRIDIZO'
            if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.ESCURRIDIZO) {
                //En cada planta se puede salvar de un ataque de zombie
            }

            //Habilidades de 'AMBIDIESTRO'
            if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.AMBIDIESTRO) {
                //Si lleva pistola, tendrá 6 ocasiones para atacar.
            }
        }
    }

    //A medias (hay que terminar primero la configuración de armas y skills)
    public static void batalla(ArrayList<Zombie> listaZombies, ArrayList<Superviviente> listaSupervivientes, int planta) {
        System.out.println("¿Estás preparado?");
        System.out.println("Pulsa 1 si lo estás.");
        System.out.println("Mejor en otro momento, me hago popó.");
        int eleccion = entrada.nextInt();
        switch (eleccion) {
            case 1:
                System.out.println("Genial... ¡COMENZEMOS!\n");
                System.out.println("_________________________");
                System.out.println("Bienvenidos a la planta 1, aquí os encontrareis con 8 caminantes... "
                        + "Lo demás... es cosa vuestra.\n");
                crearPlanta(listaZombies, eleccion);
                System.out.println("Vamos a situar un poco al público con algo de información sobre vostros..¡Saludad!");
                for (int i = 0; i < listaSupervivientes.size(); i++) {
                    mostrarSuperviviente(listaSupervivientes);
                }
                System.out.println("\n Vale vale... Comenzemos.");

                for (int i = 0; i < listaSupervivientes.size(); i++) {

                }

                break;
            case 2:
                System.out.println("¡Uy! ¿Alguien se ha echado para atrás? "
                        + "Esperamos verte pronto.");
                break;
            default:
                System.out.println("No has pulsado una opción correcta, entiendemos "
                        + "que no estás preparado...");
        }
    }

    /**
     * Método que genera un aleatorio de 0 o 1 para determinar el exito de un
     * superviviente al realizar su ataque.
     *
     * @return 
     */
    public static int viveomuereZombie() {
        int viveomuere = (int) (Math.random()* 2);
        switch (viveomuere) {
            case 0:
                System.out.println(viveomuere + " vive");
                break;
            case 1:
                System.out.println(viveomuere + " muerto");
                break;
            default:
                System.out.println("Problemas en viveomuereZombie");
                break;
        }
        return viveomuere;
    }

    /**
     * Método que muestra los datos de los supervivientes
     *
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
                System.out.println("\t \t Distancia: " + listaSupervivientes.get(i).getArma().getDistancia() + "\n");
            } else {
                System.out.println("\t \t Este jugador no tiene arma \n");
            }
            System.out.println("_______________________________");
        }
    }

    public static void crearPlanta(ArrayList<Zombie> listaZombies, int planta) {
        switch (planta) {
            case 1:
                System.out.println("Planta 1");
                System.out.println("_______________________________");
                //Limpiamos el array para cada planta
                listaZombies.removeAll(listaZombies);
                //Para la planta 1 vamos a crear:
                //8 caminantes
                crearPlanta1(listaZombies);
                //Mostramos todos los datos de los zombies
//                datosZombies(listaZombies);
                break;
            case 2:
                System.out.println("Planta 2");
                System.out.println("_______________________________");
                //Limpiamos el array para cada planta
                listaZombies.removeAll(listaZombies);
                //Para la planta 2 vamos a crear:
                //6 caminantes
                //2 gordos
                crearPlanta2(listaZombies);
                //Mostramos todos los datos de los zombies
//                datosZombies(listaZombies);
                break;
            case 3:
                System.out.println("Planta 3");
                System.out.println("_______________________________");
                //Limpiamos el array para cada planta
                listaZombies.removeAll(listaZombies);
                //Para la planta 3 vamos a crear:
                //5 caminantes
                //2 gordo
                //1 unkonwn
                crearPlanta3(listaZombies);
                //Mostramos todos los datos de los zombies
//                datosZombies(listaZombies);
                int num1 = 1;
                if (num1 == 1) {
                    Unknown.zarpazo();
                }
                break;
            case 0:
                System.out.println("No tienes asignada ninguna planta, ojito!");
                break;
            default:
                System.out.println("Algo va mal con las plantas.. revisalo!");
                break;
        }
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

    /**
     * Metodo que crea a los 5 supervivientes con sus skills y sus armas por
     * defecto.
     */
    public static void SupervivientesDefault() {

        //Ambidiestro Si el arma que lleva el superviviente epistola, automaticamente lleva dos (dispara dos veces)
        Superviviente Rick = new Superviviente("Rick", 3, 0, SkillsPersonaje.AMBIDIESTRO);
        //Fortachon dispone de una vida más al empezar el juego
        Superviviente Daryl = new Superviviente("Daryl", 3, 0, SkillsPersonaje.FORTACHON);
        //Escurridizo Si le van a morder, puede escaparse una única vez de la mordida (en cada planta)
        Superviviente Maggie = new Superviviente("Maggie", 3, 0, SkillsPersonaje.ESCURRIDIZO);
        //Rapido automaticamente tiene daño 2.
        Superviviente Glenn = new Superviviente("Glenn", 3, 0, SkillsPersonaje.RAPIDO);
        //Buscador empieza automaticamente con una katana.  
        Superviviente Michonne = new Superviviente("Michonne", 3, 0, SkillsPersonaje.BUSCADOR);

        // Creamos las 4 armas con sus valores iniciales.
        Arma sarten = new Arma(1, 1, TipoArma.SARTEN);
        Arma pistola = new Arma(1, 2, TipoArma.PISTOLA);
        Arma escopeta = new Arma(1, 2, TipoArma.ESCOPETA);
        Arma katana = new Arma(2, 1, TipoArma.KATANA);
        Arma hacha = new Arma(2, 1, TipoArma.HACHA);
        // Les damos las armas a nuestros supervivientes
        Rick.setArma(pistola);
        Daryl.setArma(hacha);
        Maggie.setArma(sarten);
        Glenn.setArma(escopeta);
        Michonne.setArma(katana);
        // Añadimos a los jugadores y a los zombies a sus arrays
        listaSupervivientes.add(Rick);
        listaSupervivientes.add(Daryl);
        listaSupervivientes.add(Maggie);
        listaSupervivientes.add(Glenn);
        listaSupervivientes.add(Michonne);
        /**
         * Un poquito en resumen: RICK --> AMBIDIESTRO --> PISTOLA DARYL -->
         * FORTACHÓN --> HACHA MAGGIE --> ESCURRIDIZO --> SARTÉN GLENN -->
         * RAPIDO --> ESCOPETA MICHONNE --> BUSCADOR --> KATANA
         */
    }

    /**
     * Metodo donde creamos a todos los zombies de la planta 1
     *
     * @param listaZombies
     */
    public static void crearPlanta1(ArrayList<Zombie> listaZombies) {
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
    }

    /**
     * Metodo donde creamos a todos los zombies de la planta 2
     *
     * @param listaZombies
     */
    public static void crearPlanta2(ArrayList<Zombie> listaZombies) {
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
    }

    /**
     * Metodo donde creamos a todos los zombies de la planta 3
     *
     * @param listaZombies
     */
    public static void crearPlanta3(ArrayList<Zombie> listaZombies) {
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
    }
}
