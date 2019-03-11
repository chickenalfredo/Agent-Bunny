package core.command;

public class GameActor {

    private int x, y;

    public GameActor(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y
     *              the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x
     *              the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    public void jump() {
    }
    public void doubleJump() {}
    public void dash() {}
    public void duck() {}

    public void defend() {}
    public void guard() {}
    public void dodge() {}

    public void move() {}
    
    public void attack() {}
    
}