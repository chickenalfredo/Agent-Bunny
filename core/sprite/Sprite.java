import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Field;

public class Sprite {

    private static final Logger LOGGER = Logger.getLogger(Sprite.class.getName());
    private Coordinate coordinate = new Coordinate();
    private float width, height;
    private char terminalChar = 'x';

    public Sprite() {}

    public Sprite(float x, float y, float width, float height) {
        coordinate = new Coordinate(x, y);
        this.width = width;
        this.height = height;
    }

    public Sprite(Sprite sprite) {
        if (coordinate == null)
            coordinate = new Coordinate();
        coordinate.setLocation(sprite.getCoordinate());
        width = sprite.width;
        height = sprite.height;
    }

    public Coordinate getCoordinate() {
        return new Coordinate(coordinate);
    }

    public double getX() {
        return coordinate.getX();
    }

    public double getY() {
        return coordinate.getY();
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public char getTerminalChar() {
        return terminalChar;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setTerminalChar(char terminalChar) {
        this.terminalChar = terminalChar;
    }

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
