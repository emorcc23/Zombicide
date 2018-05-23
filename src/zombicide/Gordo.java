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
public class Gordo extends Zombie{
  
    private int muere = 2;
    
    public Gordo(int dano, int movimiento, TipoZombie tipoZombie) {
        super(dano, movimiento, tipoZombie);
    }

    @Override
    public int calcularGolpeo(SkillsPersonaje skill) {
        return super.calcularGolpeo(skill)+2*getMovimiento();               
    }

    @Override
    public void setMuere(int muere) {
        super.setMuere(muere); 
    }

    @Override
    public int getMuere() {
        return this.muere;
    }

    
    
}
