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
public class Horda {
    private int respawn = 2;

    public int getRespawn() {
        return respawn;
    }
    
    public void camina() {
        this.respawn = respawn - 1;
    }
    
    public void resetRespawn() {
        this.respawn = 2;
    }
}
