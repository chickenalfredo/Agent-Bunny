package core.command.commands;

import java.util.List;

import core.command.Command;
import core.external.entity.Hero;
import core.sprite.Sprite;
import javafx.scene.layout.HBox;
import core.scenes.*;

public class MenuCommand extends Command {

    private boolean isKeyPressed;

    public MenuCommand(boolean isKeyPressed) {
        this.isKeyPressed = isKeyPressed;
    }

    public void execute(Hero actor, List<Sprite> world) {
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