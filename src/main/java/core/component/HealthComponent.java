package core.component;

import java.io.Serializable;

/**
 * This component will allow an Entity to have the data necessary for having health
 * data. This class defines the Entities current health, max health and whether or not
 * the Object is alive.
 */
public class HealthComponent implements Component, Serializable {
 
    private static final long serialVersionUID = 1L;
    private final float MAX_HP;
    private float currentHP;

    /**
     * Constructs this health component with the default max health value
     * of 100
     */
    public HealthComponent() {
        MAX_HP = 100f;
        setCurrentHP(MAX_HP);
    }

    /**
     * Constructs this health component with the specified max health. Max health
     * must be a value larger than 25. If a value less than 25 is provided, the default
     * 25 will be used instead
     * 
     * @param maxHP
     */
    public HealthComponent(float maxHP) {
        if (maxHP >= 25) {
            MAX_HP = maxHP;
        } else {
            MAX_HP = 25f;
        }
        setCurrentHP(MAX_HP);
    }

    /**
     * @return the isAlive
     */
    public boolean isAlive() {
        return currentHP > 0;
    }

    /**
     * @return the currentHP
     */
    public float getCurrentHP() {
        return currentHP;
    }

    /**
     * @param currentHP the currentHP to set
     */
    public void setCurrentHP(float currentHP) {
        this.currentHP = currentHP;
    }

    /**
     * @return the MAX_HP
     */
    public float getMaxHP() {
        return MAX_HP;
    }

    /**
     * Deals damage to this Entity by the described attackDamage as 
     * specified via the parameter
     * 
     * @param attackDamage
     */
	public void takeDamage(float attackDamage) {
        currentHP -= attackDamage;
	}

}
