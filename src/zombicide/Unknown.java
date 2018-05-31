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
public class Unknown extends Zombie {
    
    private int muere = 2;
    
    public Unknown(int dano, int movimiento, TipoZombie tipoZombie) {
        super(dano, movimiento, tipoZombie);
    }

    @Override
    public void setMuere(int muere) {
        super.setMuere(muere); 
    }

    @Override
    public int getMuere() {
        return this.muere;
    }
    
    /**
     * Método del zombie Unknown y comprueba mediante un aleatorio
     * si el Unknown ataca de nuevo o no. 
     */
    public static int zarpazo() {
        int dobleAtaque = (int) (Math.random()* 10 + 1);
        if (dobleAtaque >= 7) {
            System.out.println(dobleAtaque + " Uy me da que ataca de nuevo");
        } else {
            System.out.println(dobleAtaque + " Te has salvado campeón");
        }
        return dobleAtaque;
    }
}
