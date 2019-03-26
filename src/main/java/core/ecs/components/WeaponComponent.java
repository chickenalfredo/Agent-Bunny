package core.ecs.components;

import java.io.Serializable;
import java.util.ArrayList;

import core.ecs.Component;
import core.sprite.Sprite;
import core.sprite.Weapon;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

public class WeaponComponent extends Component implements Serializable {

    private ArrayList<Weapon> m_weapons = new ArrayList<Weapon>();

    /**
     * 
     * @param weapon
     */
    public WeaponComponent(Weapon... weapon) {
        init(weapon);
    }

    /**
     * 
     * @param actor
     * @param world
     */
    @Override
    public void update(Sprite actor, World world) {
        getEquippedWeapon().setX(actor.getX() + actor.getWidth());
        getEquippedWeapon().setY(actor.getY());
        getEquippedWeapon().setWidth(getEquippedWeaponRange());
    }

    /**
     * 
     * @param actor
     * @param gc
     * @param delta
     */
    @Override
    public void render(Sprite actor, GraphicsContext gc, long delta) {
        // TODO: Render weapon animations using sprite sheets

        getEquippedWeapon().getComponent("RenderComponent", RenderComponent.class).render(getEquippedWeapon(), gc, delta);
    }

    /**
     * 
     * @return
     */
    public Weapon getEquippedWeapon() {
        return m_weapons.get(0);
    }

    /**
     * 
     * @return
     */
    public double getEquippedWeaponDamage() {
        return getEquippedWeapon().getDamage();
    }

    /**
     * 
     * @return
     */
    public double getEquippedWeaponRange() {
        return getEquippedWeapon().getRange();
    }

    /**
     * 
     * @param weapon
     */
    public void addWeapons(Weapon... weapon) {
        init(weapon);
    }

    /**
     * 
     * @param weapon
     */
    private void init(Weapon... weapon) {
        for (Weapon w : weapon) {
            m_weapons.add(w);
        }
    }

}
