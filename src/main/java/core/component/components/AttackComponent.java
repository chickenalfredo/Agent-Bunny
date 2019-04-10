package core.component.components;

import core.component.Component;

/**
 * This component will allow an Entity to have the data necessary for attacking
 * other Entities. This class defines damage, range, speed and cooldown data for
 * this component.
 */
public class AttackComponent implements Component {

    private float attackDamage;
    private float attackRange;
    private long cooldownTime;

    public AttackComponent() {}

    public AttackComponent(float attackDamage, float attackRange, long cooldownTime) {
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.cooldownTime = cooldownTime;
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
     * @return the attackDamage
     */
    public float getAttackDamage() {
        return attackDamage;
    }

    /**
     * @param attackDamage the attackDamage to set
     */
    public void setAttackDamage(float attackDamage) {
        this.attackDamage = attackDamage;
    }

}
