import java.util.Scanner;
import java.lang.System;

public class CharacterPlayer {

    int lives;
    int gamePoints;

    CharacterPlayer(String n, int heal, Sprite spri, double spe, int l, int g) {
        super(n, heal, spri, spe);
        lives = l;
        gamePoints = g; 
    }


    public static void controlList() {

        System.out.println(
            "\n----------------------------\n"
          + "w: move up\n"
          + "a: move left\n"
          + "s: move down\n"
          + "d: move right\n\n"
          + "exit: close the game\n"
          + "restart: return gamestate to startup position\n"
          + "cp: return to last checkpoint"
          + "\n----------------------------"
            );  

    }
    public void receiveInput() {
        controlList();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter an action");
        String in = userInput.nextLine();

        if (in.equalsIgnoreCase("w")) {
            playerCollision();
            //moveUp();
        }
        if (in.equalsIgnoreCase("a")) {
            if (isColliding(this)) {
                playerCollision(collidable)
            }
            playerCollision();
            setDirection(false);
            run();
            //moveLeft();
        }
        if (in.equalsIgnoreCase("s")) {
            playerCollision();
            //moveDown();
        }
        if (in.equalsIgnoreCase("d")) {
            playerCollision();
            setDirection(true);
            run();
            //moveRight();
        }
        if (in.equalsIgnoreCase("exit")) {
            //Application.exit();
            return;
        }
        if (in.equalsIgnoreCase("restart")) {
            //Map(Map startup);
        }
        if (in.equalsIgnoreCase("cp")) {
            //Map(Map lastCP);
        }
        receiveInput();
    }

    public void playerCollision() {
        if (isColliding(this)  ) {

        } else {

        }
    }

}