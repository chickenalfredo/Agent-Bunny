abstract public class Character extends Sprite {
    
    private String name;
    private double gravity;
    private int health;
    private int action = 0;
    private boolean direction; 
    private double speed;

    public Character(String n, int heal, Sprite spri, double spe) {
        super(spri);
        name = n;
        health = h;
        speed = spe;
    }

    public void dead() {

    }

    public boolean isDead() {
        return (health <= 0);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int h) {
        health = h;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double g) {
        gravity = g;
    }

    public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean d) {
        direction = d;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double s) {
        speed = s;
    }

    public void run() {
        if (!isColliding(this)) {

            //True = Right, False = Left
            if (direction) {
                Coordinate moveTo = new Coordinate(this.x+1*speed, this.y);  
                super.setCoordinate(moveTo);   
            } else {
                Coordinate moveTo = new Coordinate(this.x-1*speed, this.y);
                super.setCoordinate(moveTo); 
            }
        }
    }

    public void attack() {

    } 

   
}