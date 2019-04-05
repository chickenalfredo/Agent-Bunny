package core.component.components;

import core.component.Component;

/**
 * This component will allow an Entity to have the data necessary for having health
 * data. This class defines the Entities current health, max health and whether or not
 * the Object is alive.
 */
public class HealthComponent implements Component {
 
    private final float MAX_HP;
    private float currentHP;
    private boolean isAlive = true;

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
        return isAlive;
    }

    /**
     * @param isAlive the isAlive to set
     */
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
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

}
