package core.sprite;

import core.sprite.interfaces.Physics;
import core.sprite.interfaces.Render;
import com.google.gson.GsonBuilder;

/**
 * Holds data for goemetry and textures for drawing sprites on the screen. A
 * Sprite has information regarding position and size of the geometric shape. A
 * Sprite is always rectangular and its position (x,y) is located in the top
 * left corner of the rectangle.
 * 
 * @author Daniel Contreras
 */
public abstract class Sprite implements Render, Physics {

    private Coordinate coordinate = new Coordinate();
    private double width, height, velocityX, velocityY;
    private char terminalChar;

    /**
     * Constructs and initializes a Sprite with specified position and size.
     * 
     * @param x      - The x position on the coordinate plane of the top left corner
     *               of the bounding rectangle
     * @param y      - The y position on the coordinate plane of the top left corner
     *               of the bounding rectangle
     * @param width  - The width of the Sprites bounding rectangle
     * @param height - The height of the Sprites bounding rectangle
     */
    public Sprite(double x, double y, double width, double height) {
        coordinate = new Coordinate(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * @return the velocityY
     */
    public double getVelocityY() {
        return velocityY;
    }

    /**
     * @param velocityY the velocityY to set
     */
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    /**
     * @return the velocityX
     */
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * @param velocityX the velocityX to set
     */
    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * Constructs and initializes a Sprite as specified by the Sprite object
     * 
     * @param sprite - The Sprite to copy to this object
     */
    public Sprite(Sprite sprite) {
        if (coordinate == null)
            coordinate = new Coordinate();
        coordinate.setLocation(sprite.getCoordinate());
        width = sprite.width;
        height = sprite.height;
    }

    /**
     * Returns the coordinate of this Sprites bounding rectangles top left corner
     * 
     * @return The coordinates of the top left corner of the bounding rectangle
     */
    public Coordinate getCoordinate() {
        return new Coordinate(coordinate);
    }

    /**
     * Returns the x position of this Sprites top left coordinate
     * 
     * @return x position of the top left corner
     */
    public double getX() {
        return coordinate.getX();
    }

    /**
     * Returns the y position of this Sprites top left coordinate
     * 
     * @return y position of the top left corner
     */
    public double getY() {
        return coordinate.getY();
    }

    /**
     * Returns the height of this Sprites bounding rectangle
     * 
     * @return This bounding rectangles height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the width of this Sprites bounding rectangle
     * 
     * @return This bounding rectangles width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns the character that represents this Sprites texture on the terminal.
     * 
     * @return This sprites character that represents the texture
     */
    public char getTerminalChar() {
        return terminalChar;
    }

    /**
     * Set the size of this Sprites bounding rectangle with a specified width and
     * height.
     * 
     * @param width  - The bounding boxes width to set
     * @param height - The bounding boxes height to set
     */
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Sets the coordinate of the Sprite which represents the top-left most
     * corner of the bounding box. 
     * 
     * @param x      - The x position on the coordinate plane of the top left corner
     *               of the bounding rectangle
     * @param y      - The y position on the coordinate plane of the top left corner
     *               of the bounding rectangle
     */
    public void setCoordinate(double x, double y) {
        coordinate.setLocation(x, y);
    }

    /**
     * Sets this Sprites terminal character. This character is meant to represent a
     * texture in the terminal.
     * 
     * @param terminalChar - The character to set
     */
    public void setTerminalChar(char terminalChar) {
        this.terminalChar = terminalChar;
    }

    /*
     * For testing only Returns a string representation of this object
     * 
     * @return the string representation of the object
     */
    public String toString() {
        return this.getClass().getSimpleName() + " Object "
                + new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
