package core.scenes;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import core.utils.MenuEventHandlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.imageio.stream.FileImageInputStream;

import core.App;
import core.external.entity.Hero;
import javafx.geometry.*;

public class GameScene {

    private static Hero hero;
    private static Scene GameScene;

    public static Scene display() {
        Group root = initScene();
        Canvas canvas = new Canvas(1000, 1000);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        hero = new Hero(0, 0);
        try {
            hero.setImage(new Image(new FileInputStream("char.jpg")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        hero.draw(gc);

        GameScene.setOnKeyPressed(new InputHandler());


        GameScene = new Scene(root);
        return GameScene;
    }

    public static Group initScene() {
        Group gameUI = new Group();
        return gameUI;
    }
}
