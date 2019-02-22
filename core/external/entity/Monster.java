import java.util.Random;

/**
 * This class implements a weak hostile npc in the game.
 * 
 * @author Harry Lee
 */
public class Monster extends Character {
    private int power = 20;

    /**
     * This generates a random integer between a range of numbers for some
     * randomness in the behavior of the monster.
     * 
     * @param min the floor of the range of numbers
     * @param max the ceiling of the range of numbers
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
     * This is what the monster will do when player is not nearby.
     */
    public void idle() {
        while (isDead() == false) {
            int waitTime = getRandomInt(4000, 8000);
            int directionNum = getRandomInt(0, 1);
            int randNum = getRandomInt(50, 200);
            setDirection(directionNum);
            for (int i = 0; i <= randNum; i++) {
                run();
                sleep(waitTime);
            }

        }
    }

    /**
     * This sets monster's power when attacking.
     */
    public void attack() {
        Sprite.changeHP(power * -1);
    }

    /**
     * This is the behaviour of enemy when the player is nearby. It will charge
     * towrds the player and attack.
     */
    public void charge() {
        List<Sprite> list = see();
        for (Sprite each : list) {
            if (each instanceof Player) {
                if (each.getCoordinate().x() <= Monster.x) {
                    setDirection(0);
                    while (isDead() == false) {
                        while (Monster.x - each.getCoordinate().x() >= 20) {
                            run();
                        }
                        attack();
                    }
                } else {
                    setDirection(1);
                    while (isDead() == false) {
                        while (each.getCoordinate().x() - Monster.x >= 20) {
                            run();
                        }
                        attack();
                    }
                }
            }
        }
    }
}
