package core.external.tile;

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
    public StandardBlock(double x, double y, double width, double height, char terminalChar) {
        super(terminalChar, x, y, width, height);
        setIsCollidable(true);
    }

    @Override
    public void collisionReaction(Sprite spriteCollidedWith) {

    }
}
