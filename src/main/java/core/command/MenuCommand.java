package core.command;

import core.entity.Entity;
import core.game.World;
import javafx.scene.layout.HBox;
import core.scenes.*;

/**
 * This Command will execute a menu command. Execution of this object will 
 * bring up the game menu.
 */
public class MenuCommand implements Command {

    private boolean isKeyPressed;

    /**
     * Constructs a menu command object that specifies whether or not the 
     * key event was a keypress
     * 
     * @param isKeyPressed
     */
    public MenuCommand(boolean isKeyPressed) {
        this.isKeyPressed = isKeyPressed;
    }

    /**
     * Executes the Menu Command by bringing up the game menu
     * 
     * @param actor
     * @param world
     */
    @Override
    public void execute(Entity actor, World world) {
        if (isKeyPressed) {
            if (!GameScene.getRoot().getChildren().contains(GameScene.getGameMenu())) {
                HBox gameMenu = GameSettings.mainMenu();
                GameScene.addToRoot(gameMenu);
            }else {
                GameScene.removeGameMenu();
            }
        }
        
    }
}