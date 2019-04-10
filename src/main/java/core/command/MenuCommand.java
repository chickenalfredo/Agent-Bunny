package core.command;

import core.entity.Entity;
import core.game.World;
import javafx.scene.layout.HBox;
import core.scenes.*;

/**
 * 
 */
public class MenuCommand implements Command {

    private boolean isKeyPressed;

    /**
     * 
     * @param isKeyPressed
     */
    public MenuCommand(boolean isKeyPressed) {
        this.isKeyPressed = isKeyPressed;
    }

    /**
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