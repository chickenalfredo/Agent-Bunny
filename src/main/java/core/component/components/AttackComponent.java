package core.component.components;

import core.component.Component;

public class AttackComponent implements Component {
    
    private float attackDamage;
    private float attackRange;
    private float attackSpeed;
    private long cooldownTime;

    public AttackComponent() {}

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
     * @return the attackSpeed
     */
    public float getAttackSpeed() {
        return attackSpeed;
    }

    /**
     * @param attackSpeed the attackSpeed to set
     */
    public void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
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
