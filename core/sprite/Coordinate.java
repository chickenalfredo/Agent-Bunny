/**
 * A point in a coordinate space representing a location (x, y) 
 */
public class Coordinate {

    private double x;
    private double y;

    /**
     * Constructs and initializes a coordinate point at location (0, 0)
     */
    public Coordinate() {
        this(0.0, 0.0);
    }

    /**
     * Constructs and initializes a coordinate point at the specified location (x, y)
     * @param x     - The x coordinate of the new point
     * @param y     - The y coordinate of the new point
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs and initializes a coordinate point at the location (x, y) as specified by the Coordinate object
     * @param coordinate    - The new coordinates for the new point
     */
    public Coordinate(Coordinate coordinate) {
        this(coordinate.getX(), coordinate.getY());
    }

    /**
     * Returns the x coordinate of the Coordinate object
     * @return      The x coordinate of the point
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the Coordinate object
     * @return      The y coordinate of the point
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the location of this coordinate point
     * @return  A copy of this point
     */
    public Coordinate getLocation() {
        return new Coordinate(x, y);
    }

    /**
     * Sets the location of the point to the specified x and y coordinates
     * @param x     - The x coordinate of the point
     * @param y     - The y coordinate of the point
     */
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the location of the point to the specified coordinate
     * @param coordinate    - The new coordinates for this point
     */
    public void setLocation(Coordinate coordinate) {
        x = coordinate.getX();
        y = coordinate.getX();
    }

    /**
     * Returns the distance between two points
     * @param coordinate    - The coordinate that you are testing the distance from
     * @return              The distance from the two points
     */
    public double distanceFrom(Coordinate coordinate) {
        return Math.sqrt((this.x - coordinate.x)*(this.x - coordinate.x) + (this.y - coordinate.y)*(this.y - coordinate.y));
    }

    /**
     * Determines whether or not two Coordinates are equal
     * @param   obj     - The object to be compared
     * @return          true if the object being compared is is an instance of the Coordinate class, and has the same values as this 
     *                  coordinate
     */
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        Coordinate coordinate = (Coordinate) obj;
        return x == coordinate.getX() && y == coordinate.getY();
    }

    /**
     * Returns a string representation of this point
     * @return      A string representation of this point
     */
    public String toString() {
        return this.getClass().getName() + ": (" + (int)x + "," + (int)y + ")";
    }
    
}
