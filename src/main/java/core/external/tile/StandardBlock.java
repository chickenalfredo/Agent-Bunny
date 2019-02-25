package main.java.core.external.tile;

import core.sprite.*;

/**
 * Creates a standard collidable wall block that prevents entity's from
 */
public class StandardBlock extends TileObject {

    /** 
     * Constructor that creates a wall block with a specified coordinate and dimension
     * 
     * @param terminalChar  The terminal representation of the block
     * @param x             The x coordinate of the block
     * @param y             The y coordinate of the block
     * @param width         The width of the block
     * @param height        The height of the block
    */
    public StandardBlock(char terminalChar, float x, float y, float width, float height) {
        super(terminalChar, x, y, width, height);
        setIsCollidable(true);
    }

    /** 
     * Collision Reaction with Entity's that prevents movement into it
    */
    public void coolisionReaction(Entity spriteCollideWith) {
            if(spriteCollideWith.getCoordinate().getX() == this.getCoordinate().getX()+1) {
                spriteCollideWith.setCollision("Left");
            } else if(spriteCollideWith.getCoordinate().getX() == this.getCoordinate().getX()-1) {
                spriteCollideWith.setCollision("Right");
            } else if(spriteCollideWith.getCoordinate().getY() == this.getCoordinate().getY()+1) {
                spriteCollideWith.setCollision("Up");
            } else if(spriteCollideWith.getCoordinate().getY() == this.getCoordinate().getY()-1) {
                spriteCollideWith.setCollision("Down");
            }
    }
}