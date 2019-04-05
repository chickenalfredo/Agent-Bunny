package core.component.components;

import core.component.Component;

public class HealthComponent implements Component {
 
    private float maxHP;
    private float currentHP;
    private boolean isAlive = true;

    public HealthComponent() {}

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
     * @return the maxHP
     */
    public float getMaxHP() {
        return maxHP;
    }

    /**
     * @param maxHP the maxHP to set
     */
    public void setMaxHP(float maxHP) {
        this.maxHP = maxHP;
    }

}
