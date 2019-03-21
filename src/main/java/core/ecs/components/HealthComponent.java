package core.ecs.components;

import core.ecs.Component;
import core.external.entity.Enemy;
import core.sprite.Sprite;
import core.sprite.World;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class HealthComponent extends Component {

    private double health = 100;

    public HealthComponent() {}

    public void update(Sprite actor, World world) {
        if (actor instanceof Enemy) {
            if (!isAlive()) {
                System.out.println("Removing enemy");
                world.destroyEntity(actor);
            }
        }
    }

    /**
     * @return the health
     */
    public double getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(double health) {
        this.health = health;
    }

    public void takeDamage(double damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

}
