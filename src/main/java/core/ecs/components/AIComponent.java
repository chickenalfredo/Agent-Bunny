package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.external.entity.Enemy;
import core.sprite.Sprite;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class AIComponent extends Component implements Serializable {

    private static final long serialVersionUID = 7300058353639188186L;

    private Enemy enemy;
    private double initialX;
    private double initialY;
    private double maxDistance = 600;
    private boolean travellingRight = true;

    public AIComponent(Sprite actor) {
        enemy = Enemy.class.cast(actor);
        initialX = enemy.getX();
        initialY = enemy.getY();
    }

    /**
     * 
     * @param actor
     * @param world
     */
    @Override
    public void update(Sprite actor, World world) {
        enemy.attackCollider(world);
        moveScript(enemy);
    }

    /**
     * 
     * @param actor
     * @param gc
     * @param delta
     */
    @Override
    public void render(Sprite actor, GraphicsContext gc, long delta) {
        
    }

    private void moveScript(Enemy actor) {

        if (travellingRight && actor.getX() < (initialX + maxDistance)) {

            actor.move("d", true);
        } else {

        }

        // travelRight(actor);
        // travelLeft(actor);

        // if (actor.getX() < (initialX + maxDistance)) {
        //     actor.move("d", true);

        // } else if (actor.getX() > (initialX + maxDistance)){
        //     actor.move("a", true); 
        // }

        // if (actor.getX() < (initialX + maxDistance)) {
        //     actor.move("d", true);
        // } else {
        //     actor.move("d", false); 
        // }

        // if (actor.getX() > (initialX + maxDistance)) {
        //     actor.move("a", true);
        // } else {
        //     actor.move("a", false); 
        // }


    }

    private void travelRight(Enemy actor) {
        if (actor.getX() < (initialX + maxDistance)) {
            actor.move("d", true);

        }
    }

    private void travelLeft(Enemy actor) {
        if (actor.getX() > (initialX + maxDistance)) {
            actor.move("a", true);

        }
    }
    
}
