package zombicide;

/**
 *
 * @author alu520994162
 */
public class Superviviente {
    /**
     * Atributos de la clase Superviviente
     */
    private String nombre = "Novato";
    private int vidas = 3;
    private int nivel = 0;
    
    // Por defecto, un superviviente será 'RAPIDO'.
    private SkillsPersonaje skill = SkillsPersonaje.RAPIDO;
    //Hacemos una composición de la clase Arma.
    private Arma arma;
    
    //Constructor por defecto. 
    public Superviviente() {}
    
    public Superviviente(String nombre) {
        this.nombre = nombre;
    }

    //Constructor con todos los parámetros.
    public Superviviente(String nombre, int vidas, int nivel, SkillsPersonaje skill) {
        this.nombre = nombre;
        this.vidas = vidas;
        this.nivel = nivel;
        this.skill = skill;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public SkillsPersonaje getSkill() {
        return skill;
    }

    public void setSkill(SkillsPersonaje skill) {
        this.skill = skill;
    }
    
    /**
     * Metodo que devuelve si un superviviente tiene arma o no.
     * @return 
     */
    public boolean tieneArma() {
        return !(arma == null);
    }
    
    public void deleteArma() {
        this.arma = null;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }   
}