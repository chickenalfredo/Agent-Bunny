package core.external.tile;

import core.sprite.*;

/**
 * Creates a standard collidable wall block that prevents entity's from
 */
public class Grass extends TileObject {

    /**
     * Constructor that creates a wall block with a specified coordinate and
     * dimension
     * 
     * @param terminalChar The terminal representation of the block
     * @param x            The x coordinate of the block
     * @param y            The y coordinate of the block
     * @param width        The width of the block
     * @param height       The height of the block
     */
    public Grass(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsCollidable(true);
        setTerminalChar('-');
    }

    public Grass(double x, double y, double width, double height, String image) {
        super(x, y, width, height, image);
        setIsCollidable(true);
    }

    public Grass(double x, double y) {
        super(x, y);
    }

}
