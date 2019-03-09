package core.utils;

import core.external.entity.Hero;
import core.math.Collision;
import core.sprite.Sprite;
import java.util.List;

/**
 * A simulation manager meant to simulate collisions, movement, and attacks.
 * 
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
    public boolean simulateCollision(Hero player, List<Sprite> list) {
        Hero simulatedPlayer = new Hero(player);
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
