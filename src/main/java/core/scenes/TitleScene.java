package core.scenes;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import core.utils.EventHandlers;
import core.App;
import javafx.geometry.*;

public class TitleScene {

    static Scene TitleScene;

    static  public Scene display() {
        VBox root = initScene();
        TitleScene = new Scene(root);
        return TitleScene;
    }
       
    static public VBox initScene() {

        Label gameTitle = new Label("AGENT BUNNY");
        Button startNewGame = new Button("New Game");
        Button startLoadGame = new Button("Continue");
        Button Settings = new Button("Settings");
        Button Exit = new Button("Exit Game");

        startNewGame.setOnAction(new EventHandlers.NewGameEvent());
        startLoadGame.setOnAction(new EventHandlers.LoadGameEvent());
        Settings.setOnAction(new EventHandlers.OpenSettingsEvent());
        Exit.setOnAction(new EventHandlers.ExitGameEvent());

        VBox menu = new VBox(5, gameTitle, startNewGame, startLoadGame, Settings, Exit);
        menu.setAlignment(Pos.CENTER);

        return menu;
    }
} 

