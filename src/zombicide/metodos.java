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

    /**
     * Método ataque de supervivientes a zombies
     *
     * @param planta
     */
    public static void ataqueaZombies(int planta) {
        crearPlanta(listaZombies, planta);
        System.out.println("Comienza el juego, hay: " + listaZombies.size() + " zombies.");
        for (int i = 0; i < listaSupervivientes.size(); i++) {
            for (int j = 0; j <= 2; j++) {
                if (!listaZombies.isEmpty()) {
                    System.out.println(listaSupervivientes.get(i).getNombre() + ", ¡es tu turno de atacar!");
                    int aleatorioAtaqueZ = (int) (Math.random() * listaZombies.size());
                    if (listaSupervivientes.get(i).getArma().getDano() >= listaZombies.get(aleatorioAtaqueZ).getMuere()) {
                        if (viveomuereZombie() == 1) {
                            System.out.println("Has matado al zombie numero: " + aleatorioAtaqueZ + " de " + listaZombies.size());
                            listaZombies.remove(aleatorioAtaqueZ);
                            System.out.println("Quedan: " + listaZombies.size() + " zombies vivos");
                            System.out.println("_________________________________");
                        } else {
                            System.out.println("No has matado a ningun zombie...");
                            System.out.println("Quedan: " + listaZombies.size() + " zombies vivos");
                            System.out.println("_________________________________");
                        }
                    }
                    planta++;
                } else {
                    System.out.println("Habeis acabado con todos los zombies, ¿Estais preparados para la siguiente planta?");
                    break;
                }
            }
        }
        System.out.println("Termina el juego, hay: " + listaZombies.size() + " zombies en la planta " + planta + ".");
        planta++;
    }
    
    /**
     * Método para el ataque de zombies a supervivientes
     * @param planta 
     */
    public static void ataqueaSupervivientes(int planta) {
        if (!listaZombies.isEmpty()) {
            System.out.println("\n Es hora de que ataquen los zombies...");
            System.out.println("____________________________");
            System.out.println("Comienza la matanza:");
            for (int i = 0; i < listaZombies.size(); i++) {
                int aleatorioAtaqueS = (int) (Math.random() * listaSupervivientes.size());
                if (listaZombies.get(i).getTipoZombie() == TipoZombie.CAMINANTE) {
                    if (listaSupervivientes.get(aleatorioAtaqueS).getVidas() > 0) {
                        int vidas = listaSupervivientes.get(aleatorioAtaqueS).getVidas();
                        listaSupervivientes.get(aleatorioAtaqueS).setVidas(vidas - 1);
                        System.out.println("El zombie "+i+ " le ha quitado una vida a: "+listaSupervivientes.get(aleatorioAtaqueS).getNombre());
                        if (listaSupervivientes.get(aleatorioAtaqueS).getVidas() > 1) {
                            System.out.println("Calma "+listaSupervivientes.get(aleatorioAtaqueS).getNombre()+", aun te quedan "+listaSupervivientes.get(aleatorioAtaqueS).getVidas()+" vidas");
                        } else if(listaSupervivientes.get(aleatorioAtaqueS).getVidas() == 1) {
                            System.out.println(listaSupervivientes.get(aleatorioAtaqueS).getNombre()+", solo te queda una vida.. ¡Aprovechala!");
                        } else if(listaSupervivientes.get(aleatorioAtaqueS).getVidas() == 0) {
                            System.out.println("Chicos... "+listaSupervivientes.get(aleatorioAtaqueS).getNombre()+" no ha sobrevivido a esta ronda.");
                        } else {
                            System.out.println("Problemas en ataqueaSupervivientes");
                        }
                    } else {
                        System.out.println(listaSupervivientes.get(aleatorioAtaqueS).getNombre()+" está muerto, no se le ha podido atacar");
                    }
                }
            }
        } else {
            planta++;
        }
    }
    
    /**
     * Método en el cual hacemos elegir a los jugadores sus skills y sus armas.
     *
     * @param listaSupervivientes
     * @param listaZombies
     */
    public static void elegirSupervivientes(ArrayList<Superviviente> listaSupervivientes, ArrayList<Zombie> listaZombies, Arma sarten, Arma pistola, Arma escopeta, Arma katana, Arma hacha) {
        System.out.println("Bienvenido a ZOMBICIDE");
        System.out.println("____________________________\n");
        System.out.println("Lo primero es lo primero.. ¡A elegir personajes!");

        for (int i = 0; i < listaSupervivientes.size(); i++) {
            System.out.println("Es el turno de JUGADOR" + (i + 1) + ":");

            System.out.println("Introduce tu nombre: ");
            String nombre = entrada.next();

            listaSupervivientes.get(i).setNombre(nombre);

            System.out.println("\t Elige un skill:");
            for (SkillsPersonaje skill : SkillsPersonaje.values()) {
                System.out.println("\t \t - " + skill);
            }
            int elegirskill = entrada.nextInt();
            switch (elegirskill) {
                case 1:
                    listaSupervivientes.get(i).setSkill(SkillsPersonaje.RAPIDO);
                    System.out.println("Perfecto, has elegido 'RAPIDO'");
                    break;
                case 2:
                    listaSupervivientes.get(i).setSkill(SkillsPersonaje.BUSCADOR);
                    System.out.println("Perfecto, has elegido 'BUSCADOR'");
                    break;
                case 3:
                    listaSupervivientes.get(i).setSkill(SkillsPersonaje.FORTACHON);
                    System.out.println("Perfecto, has elegido 'FORTACHON'");
                    break;
                case 4:
                    listaSupervivientes.get(i).setSkill(SkillsPersonaje.ESCURRIDIZO);
                    System.out.println("Perfecto, has elegido 'ESCURRIDIZO'");
                    break;
                case 5:
                    listaSupervivientes.get(i).setSkill(SkillsPersonaje.AMBIDIESTRO);
                    System.out.println("Perfecto, has elegido 'AMBIDIESTRO'");
                    break;
                default:
                    System.out.println("Algo está fallando al elegir las skills de los personajes.");
                    break;
            }

            System.out.println("\t Elige un arma:");
            for (TipoArma arma : TipoArma.values()) {
                System.out.println("\t \t - " + arma);
            }

            int elegirarma = entrada.nextInt();
            switch (elegirarma) {
                case 1:
                    listaSupervivientes.get(i).getArma().setTipoarma(TipoArma.SARTEN);
                    System.out.println("Venga valiente... ¡Buena suerte!");
                    break;
                case 2:
                    listaSupervivientes.get(i).getArma().setTipoarma(TipoArma.PISTOLA);
                    System.out.println("¡Si eres ambidiestro has acertado con tu elección!");
                    break;
                case 3:
                    listaSupervivientes.get(i).getArma().setTipoarma(TipoArma.ESCOPETA);
                    System.out.println("Exelente elección");
                    break;
                case 4:
                    listaSupervivientes.get(i).getArma().setTipoarma(TipoArma.KATANA);
                    System.out.println("Uuuh, una katana... ¿Seguro?");
                    break;
                case 5:
                    listaSupervivientes.get(i).getArma().setTipoarma(TipoArma.HACHA);
                    System.out.println("¡A repartir leña!");
                    break;
                default:
                    System.out.println("Opcion incorrecta...");
                    break;
            }
        }
        configArmasSkills(sarten, pistola, escopeta, katana, hacha);
    }

    /**
     * Método que comprueba todas las combinaciones posibles de skill con arma.
     *
     * @param sarten
     * @param pistola
     * @param escopeta
     * @param katana
     * @param hacha
     */
    public static void configArmasSkills(Arma sarten, Arma pistola, Arma escopeta, Arma katana, Arma hacha) {
        for (int i = 0; i < listaSupervivientes.size(); i++) {

            if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.RAPIDO) {
                //Habilidades de 'RAPIDO'
                if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.RAPIDO && listaSupervivientes.get(i).getArma().getTipoarma() == TipoArma.SARTEN) {
                    listaSupervivientes.get(i).getArma().setDano(2);
                    System.out.println("Sartén con daño mejorado para: " + listaSupervivientes.get(i).getNombre());
                } else if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.RAPIDO && listaSupervivientes.get(i).getArma().getTipoarma() == TipoArma.PISTOLA) {
                    listaSupervivientes.get(i).getArma().setDano(2);
                    System.out.println("Pistola con daño mejorado para: " + listaSupervivientes.get(i).getNombre());
                } else if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.RAPIDO && listaSupervivientes.get(i).getArma().getTipoarma() == TipoArma.ESCOPETA) {
                    listaSupervivientes.get(i).getArma().setDano(2);
                    System.out.println("Escopeta con daño mejorado para: " + listaSupervivientes.get(i).getNombre());
                } else {
                    System.out.println("Hacedlo como querais.. pero me da la sensación de que estais"
                            + "desperdiciando la habilidad del superviviente 'RAPIDO'.");
                }
            }

            //Habilidades de 'BUSCADOR'
            if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.BUSCADOR) {
                if (listaSupervivientes.get(i).getArma().getTipoarma() == TipoArma.KATANA) {
                    System.out.println("Perfecto " + listaSupervivientes.get(i).getNombre() + ", ya tienes la katana en tus manos.");
                } else {
                    listaSupervivientes.get(i).setArma(katana);
                    System.out.println("Se le asignará a :" + listaSupervivientes.get(i).getNombre() + " una katana"
                            + " por defecto ya que tiene la skill: 'BUSCADOR'.");
                }
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
        System.out.println("¿Estáis preparado?");
        System.out.println("Pulsa 1 si lo estáis.");
        System.out.println("Pulsa 2 si te haces popó.");
        int eleccion = entrada.nextInt();
        switch (eleccion) {
            case 1:
                System.out.println("Genial... ¡COMENZEMOS!\n");
                System.out.println("_________________________");
                System.out.println("Bienvenidos a la planta 1, aquí os encontrareis con 8 caminantes... "
                        + "Lo demás, es cosa vuestra.\n");
                crearPlanta(listaZombies, eleccion);
                System.out.println("Vamos a situar un poco al público con algo de información sobre vostros..¡Saludad!");
                //Mostramos a todos los supervivientes con todos sus datos
                mostrarSuperviviente(listaSupervivientes);
                System.out.println("\n Vale vale... Comenzemos.");
                System.out.println("__________________________");
                ataqueaZombies(planta);
                ataqueaSupervivientes(planta);

                break;
            case 2:
                System.out.println("¡Uy! ¿Alguien se ha echado para atrás? "
                        + "Esperamos verte pronto.");
                break;
            default:
                System.out.println("No has pulsado una opción correcta, entendemos "
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
        int viveomuere = (int) (Math.random() * 2);
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
    
    /**
     * Método que crea las plantas (planta se le pasa desde el main)
     * @param listaZombies
     * @param planta 
     */
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
                //datosZombies(listaZombies);
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
        Superviviente superviviente1 = new Superviviente("Rick", 3, 0, SkillsPersonaje.AMBIDIESTRO);
        //Fortachon dispone de una vida más al empezar el juego
        Superviviente superviviente2 = new Superviviente("Daryl", 3, 0, SkillsPersonaje.FORTACHON);
        //Escurridizo Si le van a morder, puede escaparse una única vez de la mordida (en cada planta)
        Superviviente superviviente3 = new Superviviente("Maggie", 3, 0, SkillsPersonaje.ESCURRIDIZO);
        //Rapido automaticamente tiene daño 2.
        Superviviente superviviente4 = new Superviviente("Glenn", 3, 0, SkillsPersonaje.RAPIDO);
        //Buscador empieza automaticamente con una katana.  
        Superviviente superviviente5 = new Superviviente("Michonne", 3, 0, SkillsPersonaje.BUSCADOR);

        // Creamos las 4 armas con sus valores iniciales.
        Arma sarten = new Arma(1, 1, TipoArma.SARTEN);
        Arma pistola = new Arma(1, 2, TipoArma.PISTOLA);
        Arma escopeta = new Arma(1, 2, TipoArma.ESCOPETA);
        Arma katana = new Arma(2, 1, TipoArma.KATANA);
        Arma hacha = new Arma(2, 1, TipoArma.HACHA);
        // Les damos las armas a nuestros supervivientes
        superviviente1.setArma(pistola);
        superviviente2.setArma(hacha);
        superviviente3.setArma(sarten);
        superviviente4.setArma(escopeta);
        superviviente5.setArma(katana);
        // Añadimos a los jugadores y a los zombies a sus arrays
        listaSupervivientes.add(superviviente1);
        listaSupervivientes.add(superviviente2);
        listaSupervivientes.add(superviviente3);
        listaSupervivientes.add(superviviente4);
        listaSupervivientes.add(superviviente5);
        /**
         * Un poquito en resumen: RICK --> AMBIDIESTRO --> PISTOLA DARYL -->
         * FORTACHÓN --> HACHA MAGGIE --> ESCURRIDIZO --> SARTÉN GLENN -->
         * RAPIDO --> ESCOPETA MICHONNE --> BUSCADOR --> KATANA
         */
    }

    public static void crearArmas() {
        Arma sarten = new Arma(1, 1, TipoArma.SARTEN);
        Arma pistola = new Arma(1, 2, TipoArma.PISTOLA);
        Arma escopeta = new Arma(1, 2, TipoArma.ESCOPETA);
        Arma katana = new Arma(2, 1, TipoArma.KATANA);
        Arma hacha = new Arma(2, 1, TipoArma.HACHA);
        //elegirSupervivientes(listaSupervivientes, listaZombies, sarten, pistola, escopeta, katana, hacha);
    }

    /**
     * Metodo donde creamos a todos los zombies de la planta 1
     *
     * @param listaZombies
     */
    public static void crearPlanta1(ArrayList<Zombie> listaZombies) {
        Caminante caminante1 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante2 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante3 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante4 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante5 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante6 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante7 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante8 = new Caminante(1, 1, TipoZombie.CAMINANTE);
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
