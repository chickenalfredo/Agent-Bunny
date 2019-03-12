package core.external.entity;

import core.sprite.AbstractEnemy;
import core.sprite.Entity;
import core.sprite.Sprite;

/**
 * This class implements the AI and behaviours of strong hostile npc in the
 * game. It is the extension of the Entity class.
 * 
 * @author Harry Lee
 */
public class BlackWolf extends AbstractEnemy {

    /**
     * This is the constructor for this class that extends from Entity class.
     * 
     * @param entityX      This is the x coordinate of the location of the entity.
     * @param entityY      This is the y coordinate of the location of the entity.
     * @param entityWidth  This is the width of the entity's size.
     * @param entityHeight This is the height of the entity's size.
     */
    public BlackWolf(double x, double y, double width, double height) {
        super(x, y, width, height);
        setTerminalChar('W');
    }

    public BlackWolf(double x, double y, double width, double height, String image) {
        super(x, y, width, height, image);
    }

    public BlackWolf(double x, double y) {
        super(x, y);
    }

    
    public void dodge() {
    }

    
    public void guard() {
    }

    
    public void attack(Entity entityToAttack) {
    }

    
    public void collisionResolution(Sprite sprite) {
    }

}
