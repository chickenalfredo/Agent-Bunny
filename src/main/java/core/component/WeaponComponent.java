package core.component;

import java.io.Serializable;
import core.entity.Entity;
import core.entity.attributes.NameAttribute;

public class WeaponComponent implements Component, Serializable {

    private static final long serialVersionUID = 1L;
    private Entity actor;
    private Entity weapon;
    private Entity[] projectile;
    private float attackDamage;
    private float attackRange;
    private long cooldownTime;
    private long lastAttack = 0;

    public WeaponComponent(Entity actor, float attackDamage, float attackRange, long cooldownTime) {
        setActor(actor);
        setAttackDamage(attackDamage);
        setAttackRange(attackRange);
        setCooldownTime(cooldownTime);
        initWeapon();
    }

    /**
     * @return the actor
     */
    public Entity getActor() {
        return actor;
    }

    /**
     * @param actor the actor to set
     */
    public void setActor(Entity actor) {
        this.actor = actor;
    }

    private void initWeapon() {
        weapon = new Entity();
        weapon.addComponents(
                new PositionComponent(
                        actor.getComponent(PositionComponent.class).getX()
                                + actor.getComponent(DimensionComponent.class).getWidth() + 1,
                        actor.getComponent(PositionComponent.class).getY()),
                new DimensionComponent(attackRange, actor.getComponent(DimensionComponent.class).getHeight()));
        weapon.addAttribute(new NameAttribute("weapon"));
    }

    /**
     * @return the weapon
     */
    public Entity getWeapon() {
        return weapon;
    }

    /**
     * @param weapon the weapon to set
     */
    public void setWeapon(Entity weapon) {
        this.weapon = weapon;
    }

    /**
     * @return the attackDamage
     */
    public float getAttackDamage() {
        return attackDamage;
    }

    /**
     * @return the cooldownTime
     */
    public long getCooldownTime() {
        return cooldownTime;
    }

    /**
     * @param cooldownTime the cooldownTime to set
     */
    public void setCooldownTime(long cooldownTime) {
        this.cooldownTime = cooldownTime;
    }

    /**
     * @return the attackRange
     */
    public float getAttackRange() {
        return attackRange;
    }

    /**
     * @param attackRange the attackRange to set
     */
    public void setAttackRange(float attackRange) {
        this.attackRange = attackRange;
    }

    /**
     * @param attackDamage the attackDamage to set
     */
    public void setAttackDamage(float attackDamage) {
        this.attackDamage = attackDamage;
    }

    /**
     * @return the lastAttack
     */
    public long getLastAttack() {
        return lastAttack;
    }

    /**
     * @param lastAttack the lastAttack to set
     */
    private void setLastAttack(long lastAttack) {
        this.lastAttack = lastAttack;
    }

    public boolean attackOffCooldown() {
        long time = System.currentTimeMillis();
        if (time > lastAttack + cooldownTime) {
            setLastAttack(time);
            return true;
        }
        return false;
    }

}