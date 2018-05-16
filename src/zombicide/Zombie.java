/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombicide;

/**
 *
 * @author alu520994162
 */
public class Zombie {

    private int dano;
    private int movimiento;

    public Zombie(int danho, int movimiento){
        this.dano = danho;
        this.movimiento = movimiento;
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

    /**
     * Método que hace que el respawn de un zombie reste 1 paso para su
     * siguiente ataque.
     */
    /**
     * Metodo que después de morder un zombie reinializa su rewpawn
     */
}
