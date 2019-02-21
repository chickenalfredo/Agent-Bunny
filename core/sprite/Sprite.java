public class Sprite {

    private Coordinate origin;
    private double width;
    private double height;
    private char terminalChar;
    private String avatar;

    public Sprite() {

    }

    public Sprite(Sprite sprite) {

    }

    public Rectangle getBoundingRectangle() {

    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getOriginX() {
        return origin.getX();
    }

    public double getOriginY() {
        return origin.getY();
    }

    public char getTerminalChar() {
        return terminalChar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setBoundingRectangle(double x, double y, double width, double height) {

    }

    public void setOrigin(double originX, double originY) {

    }

    public void setPosition(double x, double y) {

    }

    public void setSize() {

    }

    public void setTerminalChar(char terminalChar) {
        this.terminalChar = terminalChar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean equals(Object obj) {
        return false;
    }

    public String toString() {
        return "";
    }

}
