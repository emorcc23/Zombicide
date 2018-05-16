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
    
    public Zombie() {}

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

    
    /**
     * Método que hace que el respawn de un zombie reste 1 paso para su
     * siguiente ataque.
     */
    
    
    /**
     * Metodo que después de morder un zombie reinializa su rewpawn
     */
    
}
