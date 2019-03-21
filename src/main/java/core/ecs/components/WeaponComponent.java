package core.ecs.components;

import java.util.ArrayList;

import core.ecs.Component;
import core.sprite.Sprite;
import core.sprite.Weapon;
import javafx.scene.canvas.GraphicsContext;

public class WeaponComponent extends Component {

    private ArrayList<Weapon> m_weapons = new ArrayList<Weapon>();

    public WeaponComponent(Weapon... weapon) {
        init(weapon);
    }

    public void update(Sprite actor, GraphicsContext gc) {
        getEquippedWeapon().setX(actor.getX() + actor.getWidth());
        getEquippedWeapon().setY(actor.getY() + actor.getHeight() / 2);
        getEquippedWeapon().setWidth(getEquippedWeaponRange());
        actor.getComponent("RenderComponent", RenderComponent.class).render(getEquippedWeapon(), gc);
    }

    public Weapon getEquippedWeapon() {
        return m_weapons.get(0);
    }

    public double getEquippedWeaponDamage() {
        return getEquippedWeapon().getDamage();
    }
    
    public double getEquippedWeaponRange() {
        return getEquippedWeapon().getRange();
    }

    public void addWeapons(Weapon... weapon) {
        init(weapon);
    }

    private void init(Weapon... weapon) {
        for (Weapon w : weapon) {
            m_weapons.add(w);
        }
    }

}
