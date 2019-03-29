package core.external.entity;

import java.io.Serializable;

import core.sprite.Entity;

/**
 * This class implements the AI and behaviours of weak hostile npc in the game.
 * It is the extension of the Entity class.
 * 
 * @author Harry Lee
 */
public class Enemy extends Entity implements Serializable {

    private static final long serialVersionUID = 2769579462364610950L;
    private String name;

    /**
     * This is the constructor for this class that extends from Entity class.
     * 
     * @param entityX      This is the x coordinate of the location of the entity.
     * @param entityY      This is the y coordinate of the location of the entity.
     * @param entityWidth  This is the width of the entity's size.
     * @param entityHeight This is the height of the entity's size.
     */
    public Enemy(double x, double y, double width, double height, String name) {
        super(x, y, width, height);
        setTerminalChar('M');
        this.setName(name);
    }
    
    /**
     * 
     * @param enemy
     */
    public Enemy(Enemy enemy) {
        this(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight(), enemy.getName());
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


}
