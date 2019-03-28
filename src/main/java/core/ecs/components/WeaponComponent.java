package core.ecs.components;

import java.io.Serializable;
import java.util.ArrayList;

import core.ecs.Component;
import core.sprite.Sprite;
import core.sprite.Weapon;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

public class WeaponComponent extends Component implements Serializable {

    private static final long serialVersionUID = 636995901865278898L;
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
        if (actor.getComponent("StateComponent", StateComponent.class).getDirection() == StateComponent.Direction.RIGHT) {
            getEquippedWeapon().setX(actor.getX() + actor.getWidth());
        } else {
            getEquippedWeapon().setX(actor.getX());
        }
        getEquippedWeapon().setY(actor.getY());
        getEquippedWeapon().setWidth(getEquippedWeaponRange());
        getEquippedWeapon().setHeight(actor.getHeight());
    }

    /**
     * 
     * @param actor
     * @param gc
     * @param delta
     */
    @Override
    public void render(Sprite actor, GraphicsContext gc, long delta) {
        if (getEquippedWeapon().getComponent("RenderComponent", RenderComponent.class) != null) {
            getEquippedWeapon().getComponent("RenderComponent", RenderComponent.class).render(getEquippedWeapon(), gc, delta);
        }
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
