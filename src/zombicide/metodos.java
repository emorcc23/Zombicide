/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombicide;

import java.util.*;
import static zombicide.TestZombicide.listaArmas;
import static zombicide.TestZombicide.listaSkills;
import static zombicide.TestZombicide.listaSupervivientes;
import static zombicide.TestZombicide.listaZombies;

/**
 *
 * @author alvaro
 */
public class metodos {

    static Scanner entrada = new Scanner(System.in);

    /**
     * Método ataque de supervivientes a zombies
     *
     * @param planta
     */
    public static void ataqueaZombies(int planta) {
        //Mostramos cuantos supervivientes hay
        System.out.println("Turno de supervivientes, hay: " + listaZombies.size() + " zombies.");
        //Recorremos el array de Supervivientes para que todos los que sigan vivos puedan atacar
        for (int i = 0; i < listaSupervivientes.size(); i++) {
            //Creamos un bucle de 3 giros ya cada superviviente debe atacar tres veces.
            for (int j = 0; j <= 2; j++) {
                //Si listaZombies no está vacio, entonces...
                if (!listaZombies.isEmpty()) {
                    System.out.println(listaSupervivientes.get(i).getNombre() + ", ¡es tu ataque numero: " + (j + 1) + "!");
                    //Creamos un aleatorio del tamaño de listaZombies para que los supervivientes ataquen directamente
                    int aleatorioAtaqueZ = (int) (Math.random() * listaZombies.size());
                    //Si el daño de un arma es mayor que la vida del zombie en concreto entonces...
                    if (listaSupervivientes.get(i).getArma().getDano() >= listaZombies.get(aleatorioAtaqueZ).getMuere()) {
                        //viveomuereZombie consta de un aleatorio que determina una vez comprobado que el arma del superviviente
                        //puede matar a un zombie, este aleatorio cuenta con solo 0 o 1 para determinar si el ataque mata al zombie
                        // o no. Vive = 1, muere = 0.
                        if (viveomuereZombie() == 1) {
                            System.out.println("Has matado al zombie numero: " + aleatorioAtaqueZ + " de " + listaZombies.size());
                            System.out.println("Zombie del tipo: " + listaZombies.get(aleatorioAtaqueZ).getTipoZombie());
                            //Eliminamos al zombie el cual ha matado el superviviente.
                            listaZombies.remove(aleatorioAtaqueZ);
                            System.out.println("Quedan: " + listaZombies.size() + " zombies vivos");
                            System.out.println("_________________________________");
                        } else {
                            //No se ha matado a nadie y por tanto mostramos tan solo un mensaje
                            //de información.
                            System.out.println("No has matado a ningun zombie...");
                            System.out.println("Quedan: " + listaZombies.size() + " zombies vivos");
                            System.out.println("_________________________________");
                        }
                        //En este else solo entrará si el daño del arma no iguala o supera la vida del zombie
                    } else {
                        System.out.println("No has matado a ningun zombie ya que tu arma no tiene suficiente daño");
                        System.out.println("Quedan: " + listaZombies.size() + " zombies vivos");
                        System.out.println("_______________________________");
                    }
                }
                
            }
            System.out.println("\n \n");
        }
        //Si listaZombies está vacio entonces...
        if (listaZombies.isEmpty()) {
            System.out.println("Habeis acabado con todos los zombies de la planta " + planta);
            System.out.println("______________________________\n");
            planta++;
            //Si no...
        } else {
            //Vuelven a atacar los zombies
            ataqueaSupervivientes(planta);
        }
    }

    /**
     * Método para el ataque de zombies a supervivientes
     *
     * @param planta
     */
    public static void ataqueaSupervivientes(int planta) {
        boolean zarpazo = false;
        //Si listaZombies no está vacío, entonces...
        if (!listaZombies.isEmpty()) {
            //Comienza el ataque de los Zombies.
            System.out.println("\n \n \n Es hora de que ataquen los zombies...");
            System.out.println("____________________________");
            System.out.println("Comienza la matanza:");
            //Creamos un contador para asegurarnos de que no se quede en bucle el ataque de unknown
            int contador = 1;
            //Recorremos listaZombies
            for (int i = 0; i < listaZombies.size(); i++) {
                // prueba
                if (listaZombies.get(i) instanceof Unknown) {
                    Unknown golpeadoble = (Unknown) listaZombies.get(i);
                    zarpazo = golpeadoble.zarpazo();
                }
                if (zarpazo) {
                    contador = 2;
                }

                for (int j = 0; j < contador; j++) {

                    // prueba
                    //Generamos un aleatorio para determinar a que superviviente va a atacar cada zombie.
                    int aleatorioAtaqueS = (int) (Math.random() * listaSupervivientes.size());

                    //Si vidas es mayor que 0 entonces...
                    if (!listaSupervivientes.isEmpty()) {

                        //Si el tipo de zombie es unknown matamos directamente al superviviente.
                        if (listaSupervivientes.get(aleatorioAtaqueS).getVidas() > 0) {
                            int vidas = listaSupervivientes.get(aleatorioAtaqueS).getVidas();
                            //Ya que los zombies cada vez que atacan quitan una vida si o sí simplemente modificamos el dato de los
                            //supervivientes quitandole una vida por cada zombie que le haya golpeado
                            listaSupervivientes.get(aleatorioAtaqueS).setVidas(vidas - 1);
                            System.out.println("El zombie " + i + " le ha quitado una vida a: " + listaSupervivientes.get(aleatorioAtaqueS).getNombre());
                            System.out.println("Zombie del tipo: " + listaZombies.get(i).getTipoZombie());
                            //Mostramos a los usuarios la información de la vida de sus jugadores.
                            if (listaSupervivientes.get(aleatorioAtaqueS).getVidas() > 1) {
                                System.out.println("Calma " + listaSupervivientes.get(aleatorioAtaqueS).getNombre() + ", aun te quedan " + listaSupervivientes.get(aleatorioAtaqueS).getVidas() + " vidas");
                                System.out.println("_________________________________");
                            } else if (listaSupervivientes.get(aleatorioAtaqueS).getVidas() == 1) {
                                System.out.println(listaSupervivientes.get(aleatorioAtaqueS).getNombre() + ", solo te queda una vida.. ¡Aprovechala!");
                                System.out.println("_________________________________");
                            } else if (listaSupervivientes.get(aleatorioAtaqueS).getVidas() == 0) {
                                System.out.println("Chicos... " + listaSupervivientes.get(aleatorioAtaqueS).getNombre() + " no ha sobrevivido a esta ronda.");
                                listaSupervivientes.remove(aleatorioAtaqueS);
                                System.out.println("_________________________________");
                            } else {
                                System.out.println("Problemas en ataqueaSupervivientes");
                            }
                        } else {
                            //Aquí no debería entrar nunca, pero por tenerlo controlado lo añado.
                            System.out.println(listaSupervivientes.get(aleatorioAtaqueS).getNombre() + " está muerto, no se le ha podido atacar");
                        }
//                        if (Unknown.zarpazo() == true && listaZombies.get(i).getTipoZombie() == TipoZombie.UNKNOW && contador == 0) {
//                            System.out.println("El unknown se ha cargado de un toque a: " + listaSupervivientes.get(aleatorioAtaqueS).getNombre());
//                            listaSupervivientes.remove(aleatorioAtaqueS);
//                            mostrarSuperviviente(listaSupervivientes);
//                        }
                    }
                }
                System.out.println("\n");
            }
            
        }

        //Si listaSupervivientes no está vacio...
        if (!listaSupervivientes.isEmpty()) {
            System.out.println("Sois " + listaSupervivientes.size() + " supervivientes, de momento...");
            //Vuelven a atacar los supervivientes
            metodos.ataqueaZombies(planta);
        } else {
            //El juego ha terminado, os han matado
            System.out.println("¡GAME OVER! Habeis muerto todos...");
        }
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
            //Si skill = rapido ...
            if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.RAPIDO) {
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

            //Al personaje con habilidades de buscador nos encargaremos de darle una katana.
            if (listaSupervivientes.get(i).getSkill() == SkillsPersonaje.BUSCADOR) {
                if (listaSupervivientes.get(i).getArma().getTipoarma() == TipoArma.KATANA) {
                    System.out.println("Perfecto " + listaSupervivientes.get(i).getNombre() + ", ya tienes la katana en tus manos.");
                } else {
                    listaSupervivientes.get(i).setArma(katana);
                    System.out.println("Se le asignará a :" + listaSupervivientes.get(i).getNombre() + " una katana"
                            + " por defecto ya que tiene la skill: 'BUSCADOR'.");
                }
            }

            //Al personaje con habilidades de fortachon le sumaremos una vida más en su personaje
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
    public static void batalla(ArrayList<Zombie> listaZombies, ArrayList<Superviviente> listaSupervivientes, int planta, int contador) {
        System.out.println("\n ¿Estáis preparados para la planta " + planta + "?");
        System.out.println("Pulsa 1 si lo estáis.");
        System.out.println("Pulsa 2 si os haceis caquita.");

        int eleccion = entrada.nextInt();
        switch (eleccion) {
            case 1:
                System.out.println("Genial... ¡COMENZEMOS!\n");
                System.out.println("_________________________");
                String zombies = "";
                switch (planta) {
                    case 1:
                        zombies = "8 caminantes... Lo demás es cosa vuestra.\n";
                        break;
                    case 2:
                        zombies = "6 caminantes y 2 gordos... ¿preparados?\n";
                        break;
                    default:
                        break;
                }
                System.out.println("\n \n \n Bienvenidos a la planta " + planta + " , aquí os encontrareis con: " + zombies);
                System.out.println("Vamos a situar un poco al público con algo de información sobre vostros..¡Saludad!");
                //Mostramos a todos los supervivientes con todos sus datos
                mostrarSuperviviente(listaSupervivientes);
                System.out.println("\n \n Vale vale... Comenzemos.");
                System.out.println("__________________________\n \n");
                ataqueaZombies(planta);
                ataqueaSupervivientes(planta);

                break;
            case 2:
                System.out.println("\n ¡Uy! ¿Alguien se ha echado para atrás? "
                        + "Esperamos verte pronto.");
                break;
            case 3:
                datosZombies(listaZombies);
                break;
            default:
                System.out.println(" \n No has pulsado una opción correcta, entendemos "
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
//                System.out.println(viveomuere + " vive");
                break;
            case 1:
//                System.out.println(viveomuere + " muerto");
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
            System.out.println("_______________________________\n \n");
        }
    }

    /**
     * Método que crea las plantas (planta se le pasa desde el main)
     *
     * @param listaZombies
     * @param planta
     */
    public static ArrayList<Zombie> crearPlanta(ArrayList<Zombie> listaZombies, int planta) {
        switch (planta) {
            case 1:
                System.out.println("\n \n Planta 1");
                System.out.println("_______________________________\n \n");
                //Limpiamos el array para cada planta
                listaZombies.removeAll(listaZombies);
                //Para la planta 1 vamos a crear:
                //8 caminantes
                crearPlanta1(listaZombies);
                //Mostramos todos los datos de los zombies
                //datosZombies(listaZombies);
                break;
            case 2:
                System.out.println("\n \n Planta 2");
                System.out.println("_______________________________\n \n");
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
                System.out.println("\n \n Planta 3");
                System.out.println("_______________________________\n \n");
                //Limpiamos el array para cada planta
                listaZombies.removeAll(listaZombies);
                //Para la planta 3 vamos a crear:
                //5 caminantes
                //2 gordo
                //1 unkonwn
                crearPlanta3(listaZombies);
                //Mostramos todos los datos de los zombies
//                datosZombies(listaZombies);
                break;
            case 0:
                System.out.println("No tienes asignada ninguna planta, ojito!");
                break;
            default:
                System.out.println("Algo va mal con las plantas.. revisalo!");
                break;
        }
        return listaZombies;
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
            System.out.println("_______________________________\n \n");
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

    public static void crearArmasYelegirSupervivientes(ArrayList<String> listaArmas, ArrayList<String> listaSkills) {
        Arma sarten = new Arma(1, 1, TipoArma.SARTEN);
        Arma pistola = new Arma(1, 2, TipoArma.PISTOLA);
        Arma escopeta = new Arma(1, 2, TipoArma.ESCOPETA);
        Arma katana = new Arma(2, 1, TipoArma.KATANA);
        Arma hacha = new Arma(2, 1, TipoArma.HACHA);
        elegirSupervivientes(listaSupervivientes, listaZombies, sarten, pistola, escopeta, katana, hacha, listaArmas, listaSkills);
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
        Caminante caminante1 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante2 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante3 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante4 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante5 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante6 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Gordo gordo1 = new Gordo(1, 2, TipoZombie.GORDO);
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
        Caminante caminante1 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante2 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante3 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante4 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Caminante caminante5 = new Caminante(1, 1, TipoZombie.CAMINANTE);
        Gordo gordo1 = new Gordo(1, 2, TipoZombie.GORDO);
        Gordo gordo2 = new Gordo(1, 2, TipoZombie.GORDO);
        Unknown unknown1 = new Unknown(3, 2, TipoZombie.UNKNOW);
        listaZombies.add(caminante1);
        listaZombies.add(caminante2);
        listaZombies.add(gordo1);
        listaZombies.add(caminante3);
        listaZombies.add(caminante4);
        listaZombies.add(gordo2);
        listaZombies.add(caminante5);
        listaZombies.add(unknown1);
    }

    /**
     * Metodo en el cual hacemos elegir a los jugadores sus skills y sus armas
     *
     * @param listaSupervivientes
     * @param listaZombies
     * @param sarten
     * @param pistola
     * @param escopeta
     * @param katana
     * @param hacha
     * @param listaArmas
     * @param listaSkills
     */
    public static void elegirSupervivientes(ArrayList<Superviviente> listaSupervivientes, ArrayList<Zombie> listaZombies, Arma sarten, Arma pistola, Arma escopeta, Arma katana, Arma hacha, ArrayList<String> listaArmas, ArrayList<String> listaSkills) {
        System.out.println("Bienvenido a ZOMBICIDE");
        System.out.println("____________________________\n");
        System.out.println("Lo primero es lo primero.. ¡A elegir personajes!");
        for (int i = 0; i < listaSupervivientes.size(); i++) {
            System.out.println("Es el turno de JUGADOR" + (i + 1) + ":");

            //Dejamos que el usuario introduzca su nombre y lo guardamos en la variable de tipo String
            System.out.println("Introduce tu nombre: ");
            //Modificamos el nombre por el que nos ha dado el usuario
            String nombre = entrada.next();
            listaSupervivientes.get(i).setNombre(nombre);

            System.out.println("\t Elije un skill");
            System.out.println("\t" + listaSupervivientes.get(i).getNombre() + ", deberás teclear el skill que desees escoger");
            for (int j = 0; j < listaSkills.size(); j++) {
                System.out.println("\t \t - " + listaSkills.get(j));

            }

            String elegirSkill = entrada.next();
            if (null == elegirSkill) {
                //Si se mete aquí es porque el usuario se ha salido del nuestro rando de posibilidades.
                System.out.println("Algo está fallando al elegir las skills de los personajes.");
            } else {
                switch (elegirSkill) {
                    case "rapido":
                    case "RAPIDO":
                        listaSupervivientes.get(i).setSkill(SkillsPersonaje.RAPIDO);
                        System.out.println("¡Perfecto! Has escogido 'RAPIDO'");
                        listaSkills.remove("RAPIDO");
                        break;
                    case "buscador":
                    case "BUSCADOR":
                        listaSupervivientes.get(i).setSkill(SkillsPersonaje.BUSCADOR);
                        System.out.println("¡Perfecto! Has escogido 'BUSCADOR'");
                        listaSkills.remove("BUSCADOR");
                        break;
                    case "fortachon":
                    case "FORTACHON":
                        listaSupervivientes.get(i).setSkill(SkillsPersonaje.FORTACHON);
                        System.out.println("¡Perfecto! Has escogido 'FORTACHON'");
                        listaSkills.remove("FORTACHON");
                        break;
                    case "escurridizo":
                    case "ESCURRIDIZO":
                        listaSupervivientes.get(i).setSkill(SkillsPersonaje.ESCURRIDIZO);
                        System.out.println("¡Perfecto! Has escogido 'ESCURRIDIZO'");
                        listaSkills.remove("ESCURRIDIZO");
                        break;
                    case "ambidiestro":
                    case "AMBIDIESTRO":
                        listaSupervivientes.get(i).setSkill(SkillsPersonaje.AMBIDIESTRO);
                        System.out.println("¡Perfecto! Has escogido 'AMBIDIESTRO'");
                        listaSkills.remove("AMBIDIESTRO");
                        break;
                    default:
                        //Si se mete aquí es porque el usuario se ha salido del nuestro rando de posibilidades.
                        System.out.println("Algo está fallando al elegir las skills de los personajes.");
                        break;
                }
            }

            //Mostramos al usuario todas las armas y el deberá elegir una marcando un número del 1 al 5
            System.out.println("\t Elige un arma:");
            System.out.println("\t Deberás teclear el arma que desees escoger");
            for (int j = 0; j < listaArmas.size(); j++) {
                System.out.println("\t \t - " + listaArmas.get(j));
            }

            String elegirArma = entrada.next();
            if (null == elegirArma) {
                System.out.println("Opcion incorrecta, no tienes arma\n");
            } else {
                switch (elegirArma) {
                    case "sarten":
                    case "SARTEN":
                        listaSupervivientes.get(i).getArma().setTipoarma(TipoArma.SARTEN);
                        System.out.println("Venga valiente... ¡Buena suerte!\n");
                        listaArmas.remove("SARTEN");
                        break;
                    case "pistola":
                    case "PISTOLA":
                        listaSupervivientes.get(i).getArma().setTipoarma(TipoArma.PISTOLA);
                        System.out.println("¡Si eres ambidiestro has acertado con tu elección!\n");
                        listaArmas.remove("PISTOLA");
                        break;
                    case "escopeta":
                    case "ESCOPETA":
                        listaSupervivientes.get(i).getArma().setTipoarma(TipoArma.ESCOPETA);
                        System.out.println("Exelente elección\n");
                        listaArmas.remove("ESCOPETA");
                        break;
                    case "katana":
                    case "KATANA":
                        listaSupervivientes.get(i).getArma().setTipoarma(TipoArma.KATANA);
                        System.out.println("Uuuh, una katana... ¿Seguro?\n");
                        listaArmas.remove("KATANA");
                        break;
                    case "hacha":
                    case "HACHA":
                        listaSupervivientes.get(i).getArma().setTipoarma(TipoArma.HACHA);
                        System.out.println("¡A repartir leña!\n");
                        listaArmas.remove("HACHA");
                        break;
                    default:
                        System.out.println("Opcion incorrecta, no tienes arma\n");
                        break;
                }
            }
        }
        configArmasSkills(sarten, pistola, escopeta, katana, hacha);
    }

    /**
     * Metodo que uso para rellenar los arrays comodines a la hora de
     * seleccionar a nuestros supervivientes.
     */
    public static void crearArraysAdicionales() {
        String SARTEN = "SARTEN", PISTOLA = "PISTOLA", KATANA = "KATANA", HACHA = "HACHA", ESCOPETA = "ESCOPETA";
        String AMBIDIESTRO = "AMBIDIESTRO", BUSCADOR = "BUSCADOR", ESCURRIDIZO = "ESCURRIDIZO", FORTACHON = "FORTACHON", RAPIDO = "RAPIDO";

        listaArmas.add(SARTEN);
        listaArmas.add(PISTOLA);
        listaArmas.add(ESCOPETA);
        listaArmas.add(KATANA);
        listaArmas.add(HACHA);

        listaSkills.add(RAPIDO);
        listaSkills.add(BUSCADOR);
        listaSkills.add(FORTACHON);
        listaSkills.add(ESCURRIDIZO);
        listaSkills.add(AMBIDIESTRO);
    }

    public static void infoZombies() {
        System.out.println("\n Tendreis que sobrevivir a tres plantas.");
        System.out.println("\t En la planta: 1, tendreis que sobrevivir a:");
        System.out.println("\t \t - 8 caminantes.");
        System.out.println("\t En la planta: 2, tendreis que sobrevivir a:");
        System.out.println("\t \t - 6 caminantes y 2 gordos.");
        System.out.println("\t En la planta: 3, tendreis que sobrevivir a:");
        System.out.println("\t \t - 5 caminantes, 2 gordos y 1 unknown");
        System.out.println("\n Si conseguis matar a todos los zombies y superar");
        System.out.println("cada planta con éxito, ganareis el juego. ¡BUENA SUERTE! \n \n");
    }

}
