import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Field;

/**
 * Holds data for goemetry and textures for drawing sprites on the screen. A Sprite
 * has information regarding position and size of the geometric shape. A Sprite is always
 * rectangular and its position (x,y) is located in the top left corner of the rectangle. 
 */
public class Sprite {

    private static final Logger LOGGER = Logger.getLogger(Sprite.class.getName());
    private Coordinate coordinate = new Coordinate();
    private float width, height;
    private char terminalChar = 'x';

    /**
     * Constructs and initializes a default Sprite with position and size all being set to the 
     * default value 0.
     */
    public Sprite() {}

    /**
     * Constructs and initializes a Sprite with specified position and size. 
     * @param   x       - The x position on the coordinate plane of the top left corner of the
     *                  bounding rectangle 
     * @param   y       - The y position on the coordinate plane of the top left corner of the
     *                  bounding rectangle 
     * @param   width   - The width of the Sprites bounding rectangle
     * @param   height  - The height of the Sprites bounding rectangle
     */
    public Sprite(float x, float y, float width, float height) {
        coordinate = new Coordinate(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructs and initializes a Sprite as specified by the Sprite object
     * @param sprite    - The Sprite to copy to this object
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
     * @return  The coordinates of the top left corner of the bounding rectangle
     */
    public Coordinate getCoordinate() {
        return new Coordinate(coordinate);
    }

    /**
     * Returns the x position of this Sprites top left coordinate
     * @return  x position of the top left corner
     */
    public double getX() {
        return coordinate.getX();
    }

    /**
     * Returns the y position of this Sprites top left coordinate
     * @return  y position of the top left corner
     */
    public double getY() {
        return coordinate.getY();
    }

    /**
     * Returns the height of this Sprites bounding rectangle
     * @return  This bounding rectangles height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the width of this Sprites bounding rectangle
     * @return  This bounding rectangles width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns the character that represents this Sprites texture on the
     * terminal. 
     * @return  This sprites character that represents the texture
     */
    public char getTerminalChar() {
        return terminalChar;
    }

    /**
     * Set the size of this Sprites bounding rectangle with a specified
     * width and height.
     * @param width     - The bounding boxes width to set
     * @param height    - The bounding boxes height to set
     */
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Sets this Sprites terminal character. This character is meant to 
     * represent a texture in the terminal.
     * @param terminalChar  - The character to set
     */
    public void setTerminalChar(char terminalChar) {
        this.terminalChar = terminalChar;
    }

    /*
     * For testing only
     * Returns a string representation of this object
     * @return the string representation of the object
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        String nl = System.getProperty("line.separator");

        result.append(this.getClass().getName());
        result.append(" Object {");
        result.append(nl);

        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            result.append("    ");
            try {
                result.append(field.getName());
                result.append(" : ");
                result.append(field.get(this));
            } catch (IllegalAccessException ex) {
                LOGGER.log(Level.INFO, ex.toString());
            }
            result.append(nl);
        }
        result.append("}");
        return result.toString();
    }

}
