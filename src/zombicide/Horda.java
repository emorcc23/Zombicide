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
