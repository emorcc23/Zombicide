
package zombicide;

/**
 *
 * @author alu520994162
 */
public class Arma {
    
    /**
     * Atributos de la clase arma
     */
    private int dano = 1;
    private int distancia = 0;
    private TipoArma tipoarma = TipoArma.SARTEN;
    private String grito = "COWABUNGA";

    /**
     * Constructor por defecto donde se inicia con una sartén.
     */
    public Arma() {}

    /**
     * Constructor con todos los parámetros
     * @param daño
     * @param distancia 
     */
    public Arma(int daño, int distancia) {
        this.dano = daño;
        this.distancia = distancia;
        TipoArma tipoarma = TipoArma.SARTEN;
    }
    
    public Arma(int dano, int distancia, TipoArma tipoarma) {
        this.dano = dano;
        this.distancia = distancia;
        this.tipoarma = tipoarma;
    }
    
    public Arma(TipoArma tipoarma) {
        this.tipoarma = tipoarma;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public TipoArma getTipoarma() {
        return tipoarma;
    }

    public void setTipoarma(TipoArma tipoarma) {
        this.tipoarma = tipoarma;
    }

    public String getGrito() {
        return grito;
    }

    public void setGrito(String grito) {
        this.grito = grito;
    }
    
    /**
     * Constructos con todos los parámetros incluido grito
     * @param dano
     * @param distancia
     * @param tipoarma
     * @param grito 
     */
    public Arma(int dano, int distancia, TipoArma tipoarma, String grito) {
        this.dano = dano;
        this.distancia = distancia;
        this.tipoarma = tipoarma;
    }
    
    /**
     * Método que muestra vuestro grito de guerra
     * @param grito 
     */
    public void Armarse(String grito) {
        this.grito = grito;
    }
    
    public String getArmarse() {
        return grito;
    }

}
