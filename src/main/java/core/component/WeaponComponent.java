package core.component;

import java.io.Serializable;

public class WeaponComponent implements Component, Serializable {

    private static final long serialVersionUID = 1L;
    private float attackDamage;
    private float attackRange;
    private long cooldownTime;

    public WeaponComponent(float attackDamage, float attackRange, long cooldownTime) {
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.cooldownTime = cooldownTime;
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


}