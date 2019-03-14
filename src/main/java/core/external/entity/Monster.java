package core.external.entity;

import core.sprite.AbstractEnemy;

/**
 * This class implements the AI and behaviours of weak hostile npc in the game.
 * It is the extension of the Entity class.
 * 
 * @author Harry Lee
 */
public class Monster extends AbstractEnemy {

    /**
     * This is the constructor for this class that extends from Entity class.
     * 
     * @param entityX      This is the x coordinate of the location of the entity.
     * @param entityY      This is the y coordinate of the location of the entity.
     * @param entityWidth  This is the width of the entity's size.
     * @param entityHeight This is the height of the entity's size.
     */
    public Monster(double x, double y, double width, double height) {
        super(x, y, width, height);
        setTerminalChar('M');
    }

    public Monster(double x, double y, double width, double height, String image) {
        super(x, y, width, height, image);
    }

    public Monster(double x, double y) {
        super(x, y);
    }

}
