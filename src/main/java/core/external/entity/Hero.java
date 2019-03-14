package core.external.entity;

import core.sprite.Entity;

/**
 * 
 */
public class Hero extends Entity {

    private int lives = 3;

    public Hero(double x, double y, double width, double height) {
        super(x, y, width, height);
        setTerminalChar('H');
        setAttackPower(25);
    }

    public Hero(double x, double y, double width, double height, String image) {
        super(x, y, width, height, image);
        setTerminalChar('H');
        setAttackPower(25);
    }

    public Hero(Hero player) {
        super(player.getX(), player.getY(), player.getWidth(), player.getHeight());
    }

    public Hero(double x, double y) {
        super(x, y);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int oneUp) {
        lives += oneUp;
    }

    public void attack(Entity enemyToAttack) {
        enemyToAttack.setHealth(enemyToAttack.getHealth() - this.getAttackPower());
    }

    public void jump() {
        getPhysicsComponent().jump();
    }

}
