package core.external.entity;

import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.interfaces.Physics;
import core.sprite.interfaces.HeroDefense;;

/**
 * 
 */
public class Hero extends Entity implements Physics, HeroDefense {

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

    @Override
    public void attack(Entity enemyToAttack) {
        enemyToAttack.setHealth(enemyToAttack.getHealth() - this.getAttackPower());
    }

    public void attack() {
        System.out.println("Hero attacks...");
    }

    @Override
    public void jump() {
        getPhysicsComponent().jump();
        System.out.println("Hero jumps...");
    }

    @Override
    public void doubleJump() {
        System.out.println("Hero double jumps...");
        getPhysicsComponent().doubleJump();
    }

    @Override
    public void dash() {
        System.out.println("Hero dashes...");
        getPhysicsComponent().dash();
    }

    @Override
    public void duck() {
        System.out.println("Hero ducks...");
        getPhysicsComponent().duck();
    }

    @Override
    public void collisionResolution(Sprite sprite) {

    }

}
