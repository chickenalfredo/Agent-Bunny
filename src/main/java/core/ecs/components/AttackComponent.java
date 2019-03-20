package core.ecs.components;

import core.ecs.Component;
import core.external.entity.Enemy;
import core.math.Collision;
import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.Weapon;
import core.sprite.World;

public class AttackComponent extends Component {

    int attackPower, range;

    public AttackComponent() {}

    public void update(Entity actor, World world) {
        attackCollider(actor, world);
    }

    private void attackCollider(Entity actor, World world) {
        Collision collision = new Collision();
        Weapon weapon = actor.getWeaponsOwned().get(0);
        for (Sprite collider : world.getEntities()) {
            if (collider instanceof Enemy && !actor.equals(collider)) {
                if (collision.intersectAABB(weapon, collider)) {
                    System.out.println("Collision detected between " + weapon.getClass().getSimpleName() + " and " + collider.getClass().getSimpleName());
                }
            }
        }
    }

}
