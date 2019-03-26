package core.ecs.components;

import core.ecs.Component;
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
    private Sprite collider, actor;
    private WeaponComponent weaponComponent;

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
        if (weaponComponent != null) 
            attackPower = weaponComponent.getEquippedWeaponDamage();
        attackCollider(actor, world);
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
            if (collider instanceof Entity && !actor.equals(collider)) {
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
        System.out.println("Enemy health: " + collider.getComponent("HealthComponent", HealthComponent.class).getHealth());
        collider.getComponent("HealthComponent", HealthComponent.class).takeDamage(attackPower);
        System.out.println("Damage dealt by " + actor.getClass().getSimpleName() + ": " + attackPower);
        System.out.println("Enemy health: " + collider.getComponent("HealthComponent", HealthComponent.class).getHealth());
        
    }

    public void init(Entity actor) {
        this.actor = actor;
        if (actor.getComponent("WeaponComponent", WeaponComponent.class) != null)
            weaponComponent = actor.getComponent("WeaponComponent", WeaponComponent.class);
    }

}
