package core;

import core.scenes.TitleScene;
import core.screens.ScreenBuilder;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

        private static Stage gameWindow;

    public void start(Stage primaryStage) {
        init();
        gameWindow = ScreenBuilder.defaultScreen(primaryStage);
        gameWindow.setScene(TitleScene.display());
        gameWindow.show();
    }

    public void init() {
    }

    public static Stage getGameWindow() {
        return gameWindow;
    }
}
