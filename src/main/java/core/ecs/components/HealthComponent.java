package core.ecs.components;

import core.ecs.Component;
import core.external.entity.Enemy;
import core.sprite.Sprite;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class HealthComponent extends Component {

    private double health = 100;

    public HealthComponent() {}

    /**
     * 
     * @param actor
     * @param world
     */
    @Override
    public void update(Sprite actor, World world) {
        if (actor instanceof Enemy) {
            if (!isAlive()) {
                System.out.println("Removing enemy");
                world.destroyEntity(actor);
            }
        }
    }

    /**
     * 
     * @param actor
     * @param gc
     * @param delta
     */
    @Override
    public void render(Sprite actor, GraphicsContext gc, long delta) {
        // TODO: Render health animations using sprite sheets
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

    /**
     * 
     * @param damage
     */
    public void takeDamage(double damage) {
        health -= damage;
    }

    /**
     * 
     * @return
     */
    public boolean isAlive() {
        return health > 0;
    }

}
