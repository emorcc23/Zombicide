package zombicide;

/**
 *
 * @author alu520994162
 */
public class Zombie {
    
    private int dano;
    private int movimiento;
    private TipoZombie tipoZombie = TipoZombie.CAMINANTE;
    Horda horda = new Horda();
    private int muere = 0;
    private int maxgolpeo = 0;

    int P = 1;
    int G = 10;
    // zomrandom devolverá un valor entre P y G, ambos incluidos.
    int zomrandom = (int) Math.floor(Math.random() * (P - G + 1) + G);  
    
    public int getZomrandom() {
        return zomrandom;
    }

    public void setZomrandom(int zomrandom) {
        this.zomrandom = zomrandom;
    }

    public Zombie(int dano, int movimiento, TipoZombie tipoZombie) {
        this.dano = dano;
        this.movimiento = movimiento;
        this.tipoZombie = tipoZombie;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }

    public TipoZombie getTipoZombie() {
        return tipoZombie;
    }

    public Horda getHorda() {
        return horda;
    }

    public void setHorda(Horda horda) {
        this.horda = horda;
    }

    public void setTipoZombie(TipoZombie tipoZombie) {
        this.tipoZombie = tipoZombie;
    }

    public int getMuere() {
        return muere;
    }

    public void setMuere(int muere) {
        this.muere = muere;
    }
    
    

    //Método que permite calcular el nivel de golpeo zombie. 
    public int calcularGolpeo(SkillsPersonaje skill) {
        int puntos = 0;
        if (null != skill) switch (skill) {
            case RAPIDO:
                puntos = 5;
                break;
            case BUSCADOR:
                puntos = 3;
                break;
            case FORTACHON:
                puntos = 7;
                break;
            case AMBIDIESTRO:
                puntos = 8;
                break;
            case ESCURRIDIZO:
                puntos = 9;
                break;
            default:
                break;
        }
        
        int valorgolpeo = 10 * puntos + zomrandom;
        return valorgolpeo;
    }
    
    public boolean getMaxGolpeo(int valorgolpeo) {
        boolean superado = false;
        if (valorgolpeo > maxgolpeo) {
            maxgolpeo = valorgolpeo;
            superado = true;
        } else {
            superado = false;
        }
        
        if (superado == true) {
            System.out.println("¡Guau! Se ha batido un nuevo record");
            System.out.println("El nuevo record está en: "+maxgolpeo);
        } else {
            System.out.println("¡Vaya, parece imposible superar el record!");
        }
        return superado;
    }
}