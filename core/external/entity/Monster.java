import java.util.Random;
import java.lang.Thread;

/**
 * This class implements the AI and behaviours of weak hostile npc in the game.
 * It is the extension of the Entity class.
 * 
 * @author Harry Lee
 */
public class Monster extends Entity {
    private int power = 20;

    /**
     * This is the constructor for this class that extends from Entity class.
     * 
     * @param entityName   This is the entity's name.
     * @param entityHealth This is the entity's health.
     * @param entitySpeed  This is the entity's speed.
     * @param enemy        This detemines whether if the entity is an enemy.
     * @param entityX      This is the x coordinate of the location of the entity.
     * @param entityY      This is the y coordinate of the location of the entity.
     * @param entityWidth  This is the width of the entity's size.
     * @param entityHeight This is the height of the entity's size.
     * @param power        This sets the overall strength of the enemy's attack.
     */
    public Monster(String entityName, int entityHealth, double entitySpeed, boolean enemy, float entityX, float entityY,
            float entityWidth, float entityHeight, int power) {
        super(entityName, entityHealth, entitySpeed, enemy, entityX, entityY, entityWidth, entityHeight);
        setPower(power);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int strength) {
        this.power = strength;
    }

    /**
     * This generates a random integer between a range of numbers for some
     * randomness in the behavior of the monster.
     * 
     * @param min the floor of the range of numbers
     * @param max the ceiling of the range of numbers
     * @return the integer that is randomly generated
     */
    public static int getRandomInt(int min, int max) {
        int num = (int) (Math.random() * ((max - min) + 1)) + min;
        return num;
    }

    /**
     * This is the initial state of the monster.
     */
    public void basicCharacteristics() {
        int randomNum = getRandomInt(0, 1);
        setHealth(200);
        setDirection(randomNum);
    }

    /**
     * This is what the monster will passively do when player is not nearby.
     */
    public void idle() {
        if (!action) {
            while (!isDead()) {
                int waitTime = getRandomInt(4000, 8000);
                int directionNum = getRandomInt(0, 1);
                int randNum = getRandomInt(50, 200);
                setDirection(directionNum);
                for (int i = 0; i <= randNum; i++) {
                    run();
                }
                sleep(waitTime);
            }

        }
    }

    /**
     * This sets monster's power when attacking.
     */
    public void attack() {
        Sprite.Player.setHealth(power * -1);
    }

    /**
     * This is the behaviour of enemy when the player is nearby. It will charge
     * towrds the player and attack.
     */
    public void charge() {
        if (!action) {
            action = true;
            List<Sprite> list = see();
            for (Sprite each : list) {
                if (each instanceof Player) {
                    if (each.getCoordinate().getx() <= Monster.x) {
                        setDirection(false);
                        while (isDead() == false) {
                            while (this.Monster.getx() - each.getCoordinate().getx() >= 20) {
                                run();
                            }
                            attack();
                        }
                    } else {
                        setDirection(true);
                        while (isDead() == false) {
                            while (each.getCoordinate().getx() - this.Monster.getx() >= 20) {
                                run();
                            }
                            attack();
                        }
                    }
                }
                action = false;
            }
        }
    }
}