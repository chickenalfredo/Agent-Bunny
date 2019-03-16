package core.scenes;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import core.utils.InputHandler;
import java.io.File;

import core.command.Command;
import core.external.entity.Hero;
import core.external.level.Chapter1Level1;
import core.external.weapon.Sword;
import core.map.GameMap;
import core.screens.ScreenBuilder;
import core.sprite.Sprite;

import java.util.List;

public class GameScene {

    private static Hero hero = new Hero(0, 0, 100, 100, "src/main/resources/assets/Hero.png");
    private static Sword sword = new Sword(0.0, 0.0, 100, 20, "src/main/resources/assets/Float_Tile_Middle.png");
    private static Scene GameScene;
    private static GraphicsContext gc;
    private static InputHandler inputHandler = new InputHandler();
    private static double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
    private static double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();
    private static GameMap level1 = new Chapter1Level1();
    private static List<Sprite> spritesList = level1.getSprite();

    public static Scene display() {
        Pane root = initScene();
        Pane camera = new Pane();
        root.getChildren().add(camera);

        GameScene = new Scene(root);
        GameScene.getStylesheets().add((new File("src/main/resources/css/style.css")).toURI().toString());

        Canvas canvas = new Canvas(3*screenWidth, screenHeight);
        camera.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        hero.addWeapon(sword);

        class GameLoop implements EventHandler<KeyEvent> {
            public void handle(KeyEvent event) {
                Command command = inputHandler.handleInput(event);
                if (command != null) {
                    command.execute(hero, spritesList);
                }
            }
        }

        GameScene.setOnKeyPressed(new GameLoop());
        GameScene.setOnKeyReleased(new GameLoop());
        new AnimationTimer() {
            public void handle(long time) {
                camera.relocate(-hero.getX() + ((screenWidth - hero.getWidth())/2), 0);               
                gc.clearRect(0,0, 3*screenWidth, screenHeight);
                for (Sprite sprite : spritesList) {
                    sprite.update(spritesList, gc);
                }
                hero.update(spritesList, gc);
            }
        }.start();
        return GameScene;
    }

    public static Pane initScene() {
        Pane gameUI = new Pane();
        return gameUI;
    }

    public static Scene getScene() {
        return GameScene;
    }
}