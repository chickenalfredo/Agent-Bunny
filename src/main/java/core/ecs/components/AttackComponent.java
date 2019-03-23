package core.ecs.components;

import core.ecs.Component;
import core.external.entity.Enemy;
import core.external.entity.Hero;
import core.math.Collision;
import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.Weapon;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

/**
 * 
 */
public class AttackComponent extends Component {

    private double attackPower;
    private Sprite collider;
    private WeaponComponent weaponComponent;

    public AttackComponent() {}

    /**
     * 
     * @param actor
     * @param world
     */
    public void update(Entity actor, World world) {
        weaponComponent = actor.getComponent("WeaponComponent", WeaponComponent.class);
        attackCollider(actor, world);
        if (actor instanceof Hero) {
            attackPower = weaponComponent.getEquippedWeaponDamage();
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
    private boolean collisionDetected(Entity actor, Weapon weapon, World world) {
        Collision collision = new Collision();
        for (Sprite collider : world.getEntities()) {
            if (collider instanceof Enemy && !actor.equals(collider)) {
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
        // Get weapon + attackpower + attack type
        collider.getComponent("HealthComponent", HealthComponent.class).takeDamage(attackPower);
        System.out.println("attacking...");
    }

    /**
     * 
     * @param actor
     * @param world
     */
    @Override
    public void update(Sprite actor, World world) {

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

}
