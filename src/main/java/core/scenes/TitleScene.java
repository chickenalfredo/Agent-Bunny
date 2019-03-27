package core.scenes;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import core.utils.MenuEventHandlers;
import java.io.File;
import javafx.geometry.*;

/**
 * 
 */
public class TitleScene {

    private static Scene TitleScene;

    /**
     * 
     * @return
     */
    public static Scene display() {
        VBox root = initScene();
        TitleScene = new Scene(root);
        TitleScene.getStylesheets().clear();
        TitleScene.getStylesheets().add((new File("resources/css/style.css")).toURI().toString());
        return TitleScene;
    }
       
    /**
     * 
     * @return
     */
    public static VBox initScene() {

        Label gameTitle = new Label("AGENT BUNNY");
        Button startNewGame = new Button("New Game");
        Button startLoadGame = new Button("Continue");
        Button Settings = new Button("Settings");
        Button Exit = new Button("Exit Game");

        startNewGame.setOnAction(new MenuEventHandlers.NewGameEvent());
        startLoadGame.setOnAction(new MenuEventHandlers.LoadGameEvent());
        Settings.setOnAction(new MenuEventHandlers.OpenSettingsEvent());
        Exit.setOnAction(new MenuEventHandlers.ExitGameEvent());

        VBox menu = new VBox(5, gameTitle, startNewGame, startLoadGame, Settings, Exit);

        menu.setAlignment(Pos.CENTER);

        return menu;
    }

} 
