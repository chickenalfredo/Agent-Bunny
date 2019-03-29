package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.external.entity.Enemy;
import core.external.entity.Hero;
import core.math.Collision;
import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.Weapon;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

public class AttackComponent extends Component implements Serializable {

    private static final long serialVersionUID = 3268417276316679100L;
    private double attackPower;
    private Sprite collider, actor;
    private WeaponComponent weaponComponent;
    private long lastAttack = 0;
    private long cooldownTime = 1000;

    public AttackComponent() {}

    /**
     * 
     * @param actor
     * @param world
     */
    @Override
    public void update(Sprite actor, World world) {
        // TODO
    }

    /**
     * 
     * @param actor
     * @param gc
     * @param delta
     */
    @Override
    public void render(Sprite actor, GraphicsContext gc, long delta) {
        // TODO: Render attack animations using sprite sheets
    }

    /**
     * 
     * @param actor
     * @param world
     */
    public void update(Entity actor, World world) {
        init(actor);
        if (weaponComponent != null) {
            attackPower = weaponComponent.getEquippedWeaponDamage();
        }
        if (!attackOffCooldown()) {
            attackCollider(actor, world);
            if (actor instanceof Hero) {
                System.out.println("Attacking...");
            }
        }
    }

    /**
     * 
     * @param actor
     * @param world
     */
    private void attackCollider(Entity actor, World world) {
        Weapon weapon = weaponComponent.getEquippedWeapon();
        if (collisionDetected(actor, weapon, world)) {
            resolveAttackCollision();
        }
    }

    /**
     * 
     * @param actor
     * @param weapon
     * @param world
     * @return
     */
    boolean collisionDetected(Entity actor, Weapon weapon, World world) {
        Collision collision = new Collision();
        for (Sprite collider : world.getEntities()) {
            if (collider instanceof Entity && !actor.equals(collider) && !(collider instanceof Enemy && actor instanceof Enemy)) {
                if (collision.intersectAABB(weapon, collider)) {
                    this.collider = collider;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     */
    private void resolveAttackCollision() {
        collider.getComponent("HealthComponent", HealthComponent.class).takeDamage(attackPower);
        
    }

    public void init(Entity actor) {
        this.actor = actor;
        if (actor.getComponent("WeaponComponent", WeaponComponent.class) != null)
            weaponComponent = actor.getComponent("WeaponComponent", WeaponComponent.class);
    }

    public boolean attackOffCooldown() {
        long time = System.currentTimeMillis();
        if (time > lastAttack + cooldownTime) {
            lastAttack = time;
            return true;
        }
        return false;
    }

}
