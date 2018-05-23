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
public class Caminante extends Zombie {
    
    private int muere = 1;
    
    public Caminante(int dano, int movimiento, TipoZombie tipoZombie) {
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
    
    @Override
    public int calcularGolpeo(SkillsPersonaje skill) {
        return super.calcularGolpeo(skill)+5;
    }
        
}
