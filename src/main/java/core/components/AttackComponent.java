package core.components;

import java.util.ArrayList;
import java.util.List;

import core.math.Collision;
import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.Weapon;

public class AttackComponent {

    int attackPower, range;

    public AttackComponent() {}

    public void update(Entity actor, List<Sprite> world) {
        attackCollider(actor, world);
    }

    private void attackCollider(Entity actor, List<Sprite> world) {
        Collision collision = new Collision();
        Weapon weapon = actor.getWeaponsOwned().get(0);
        
        for (Sprite collider : world) {
            if (collision.intersectAABB(weapon, collider)) {
                System.out.println("guess an attack collision occured...");
            }
        }
    }

}