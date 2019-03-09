package core.scenes;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import core.utils.MenuEventHandlers;
import core.App;
import javafx.geometry.*;

public class GameScene {

    private static Scene GameScene;

    public static Scene display() {
        GridPane root = initScene();
        GameScene = new Scene(root);
        return GameScene;
    }

    public static GridPane initScene() {
        GridPane gameUI = new GridPane();
        return gameUI;
    } 
}
       