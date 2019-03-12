package core.scenes;

import javafx.animation.AnimationTimer;
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
import core.external.level.Chapter1Level1;
import core.map.GameMap;
import core.screens.ScreenBuilder;
import core.sprite.Sprite;

import java.util.List;

public class GameScene {

    private static Hero hero = new Hero(0,0);
    private static Scene GameScene;
    private static GraphicsContext gc;
    private static InputHandler inputHandler = new InputHandler();
    private static double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
    private static double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();
    private static GameMap level1 = new Chapter1Level1();
    private static List<Sprite> spritesList = level1.getSprite();

    public static Scene display() {
        Group root = initScene();
        GameScene = new Scene(root);
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
        try {
            hero.setImage(new Image(new FileInputStream("char.jpg"), 100, 100, true, true));
            for (Sprite sprite : spritesList) {
                sprite.setImage(new Image(new FileInputStream("char.jpg"), 100, 100, true, true));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        class GameLoop implements EventHandler<KeyEvent> {
            public void handle(KeyEvent event) {
                Command command = inputHandler.handleInput(event);
                if (command != null) {
                    command.execute(hero);
                }
            }
        }
        GameScene.setOnKeyPressed(new GameLoop());
        GameScene.setOnKeyReleased(new GameLoop());
        new AnimationTimer() {
            public void handle(long time) {
                gc.clearRect(0,0, screenWidth, screenHeight);
                for (Sprite sprite : spritesList) {
                    sprite.update(spritesList, gc);
                }
                hero.update(spritesList, gc);
            }
        }.start();

        return GameScene;
    }

    public static Group initScene() {
        Group gameUI = new Group();
        return gameUI;
    }
}
