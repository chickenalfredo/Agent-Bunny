package core.scenes;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import core.utils.MenuEventHandlers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.*;

/**
 * This class is the Title Scene that is loaded on startup of the GUI.
 */
public class TitleScene {

    private static Scene TitleScene;

    /**
     * @return  the scene to display
     */
    public static Scene display() {
        VBox root = initScene();
        TitleScene = new Scene(root);
        TitleScene.getStylesheets().clear();
        TitleScene.getStylesheets().add((new File("resources/css/style.css")).toURI().toString());
        return TitleScene;
    }

    /**
     * @return  The VBox containing all the nodes of this scene
     */
    public static VBox initScene() {

        Label gameTitle = new Label();
        try {
            gameTitle.setGraphic(new ImageView(new Image(new FileInputStream("resources/assets/Game_title_cropped.png"), GameScene.screenWidth * 0.483, GameScene.screenHeight * 0.155, true, true)));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
