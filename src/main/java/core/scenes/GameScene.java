package core.scenes;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import core.utils.InputHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import core.command.Command;
import core.external.entity.Hero;
import core.screens.ScreenBuilder;

public class GameScene {

    private static Hero hero;
    private static Scene GameScene;
    private static GraphicsContext gc;
    private static InputHandler inputHandler = new InputHandler();

    public static Scene display() {
        Group root = initScene();
        GameScene = new Scene(root);
        Canvas canvas = new Canvas(ScreenBuilder.getPrimaryScreenBounds().getWidth(), ScreenBuilder.getPrimaryScreenBounds().getHeight());
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
        hero = new Hero(0, 0);
        try {
            hero.setImage(new Image(new FileInputStream("char.jpg")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        hero.draw(gc);

        class GameLoop implements EventHandler<KeyEvent> {
            public void handle(KeyEvent event) {
                Command command = inputHandler.handleInput(event);
                if (command != null) {
                    System.out.println("command was null");
                } 
                command.execute(hero);
                hero.draw(gc);
            }
        }
        GameScene.setOnKeyPressed(new GameLoop());

        return GameScene;
    }

    public static Group initScene() {
        Group gameUI = new Group();
        return gameUI;
    }
}
