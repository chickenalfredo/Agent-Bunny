package core.component;

import java.io.Serializable;

/**
 * This component will allow an Entity to have the data necessary for attacking
 * other Entities. This class defines damage, range, speed and cooldown data for
 * this component.
 */
public class AttackComponent implements Component, Serializable {

    private static final long serialVersionUID = 1L;
    private float attackDamage;
    private float attackRange;
    private long cooldownTime;

    public AttackComponent() {}

    public AttackComponent(float attackDamage, float attackRange, long cooldownTime) {
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.cooldownTime = cooldownTime;
    }
    private long lastAttack = 0;

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

    public boolean attackOffCooldown(long cooldownTime) {
        long time = System.currentTimeMillis();
        if (time > lastAttack + cooldownTime) {
            setLastAttack(time);
            return true;
        }
        return false;
    }

}
