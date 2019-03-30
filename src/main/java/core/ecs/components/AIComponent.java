package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.external.entity.Enemy;
import core.external.entity.Hero;
import core.scenes.GameScene;
import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.Weapon;
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
    private double maxDistance = (GameScene.screenWidth * 0.3125);
    private boolean travellingRight = true;
    private double lastMove = 0;

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
        if (actor.getComponent("AttackComponent", AttackComponent.class).attackOffCooldown() && (enemy.getComponent("AttackComponent", AttackComponent.class).collisionDetected((Entity)world.getHero(), enemy.getComponent("WeaponComponent", WeaponComponent.class).getEquippedWeapon(), world))) {
            // enemy.attackCollider(world);
        }
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
        if (travellingRight && actor.getX() + enemy.getComponent("WeaponComponent", WeaponComponent.class).getEquippedWeapon().getRange() < (GameScene.getWorld().getHero().getX())) {
            actor.move("d", true);
        } else {
            travellingRight = false;
            actor.move("a", true);
            if (actor.getX() + enemy.getComponent("WeaponComponent", WeaponComponent.class).getEquippedWeapon().getRange() >= GameScene.getWorld().getHero().getX()) {
                travellingRight = true;
            }
        }
        lastMove = actor.getX();
    }
}