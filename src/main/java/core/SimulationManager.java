package core;

import core.external.entity.*;
import core.sprite.*;
import java.util.List;

/**
 * @author Daniel Contreras
 */
public class SimulationManager {

    private String key;

    private enum inputList {
        w, a, s, d, z
    }

    /**
     * 
     */
    public SimulationManager() {}

    /**
     * 
     */
    public SimulationManager(String key) {
        this.key = key;
    }

    /**
     * 
     */
    public boolean simulateCollision(Player player, List<Sprite> list) {
        Player simulatedPlayer = new Player(player);
        Collision collision = new Collision();
        simulatedPlayer.move(key);
        for (Sprite sprite : list) {
            if (collision.intersectAABB(simulatedPlayer, sprite)) 
                return true;
        }
        return false;
    }

    /**
     * 
     */
    public boolean isSimulationInput(String key) {
        for (inputList inputs : inputList.values()) {
            if (inputs.name().equals(key))
                return true;
        }
        return false;
    }
}