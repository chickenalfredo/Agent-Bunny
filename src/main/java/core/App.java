package core;

import core.scenes.TitleScene;
import core.screens.ScreenBuilder;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This is the JavaFX GUI that is run when the user selects "g" as their option
 * for which program to run. From here the entire GUI version is loaded.
 */
public class App extends Application {

    private static Stage gameWindow;

    @Override
    public void start(Stage primaryStage) {
        init();
        gameWindow = ScreenBuilder.defaultScreen(primaryStage);
        gameWindow.setScene(TitleScene.display());
        gameWindow.isFocused();
        gameWindow.setMaximized(true);
        gameWindow.show();
    }

    public void init() {
    }

    public static Stage getGameWindow() {
        return gameWindow;
    }

}
