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
     * @return 
     */
     public boolean zarpazo() {
         boolean salir;
        int dobleAtaque = (int) (Math.random()* 10 + 1);
        if (dobleAtaque >= 7) {
            salir = true;
            System.out.println("El Unknown golpea, y además, ataca dos veces");
        } else {
            System.out.println("El Unknown golpea, pero solo ataca una vez... Te has salvado campeón");
            salir = false;
        }
        return salir;
    }
}
