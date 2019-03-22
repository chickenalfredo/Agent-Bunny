package core.scenes;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import core.utils.InputHandler;
import java.io.File;

import core.command.Command;
import core.screens.ScreenBuilder;
import core.sprite.World;

public class GameScene {

    private static StackPane root;
    private static HBox gameMenu;
    private static Scene GameScene;
    private static GraphicsContext gc;
    private static InputHandler inputHandler = new InputHandler();
    private static double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
    private static double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();
    private static World world;
    

    public static Scene display() {
        world = new World();
        root = initScene();
        Pane camera = new Pane();
        root.getChildren().add(camera);

        GameScene = new Scene(root);
        GameScene.getStylesheets().add((new File("src/main/resources/css/style.css")).toURI().toString());

        Canvas canvas = new Canvas(3 * screenWidth, screenHeight);
        camera.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        System.out.println(screenWidth + ": " + screenWidth * 0.031);
        System.out.println(screenHeight + ": " + screenHeight * 0.057);

        GameScene.setOnKeyPressed(new GameLoop());
        GameScene.setOnKeyReleased(new GameLoop());

        new AnimationTimer() {
            public void handle(long time) {
                if (world.getHero().getX() > (screenWidth / 2) - world.getHero().getWidth() / 2)
                    canvas.relocate(-world.getHero().getX() + ((screenWidth - world.getHero().getWidth())/2), 0);               
                gc.clearRect(0,0, 3*screenWidth, screenHeight);
                world.update(gc);
            }
        }.start();
        return GameScene;
    }

    public static class GameLoop implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            Command command = inputHandler.handleInput(event);
            if (command != null) {
                command.execute(hero, spritesList);
            }
        }
    }

    public static StackPane initScene() {
        StackPane gameUI = new StackPane();
        return gameUI;
    }

    public static Scene getScene() {
        return GameScene;
    }

    public static Pane getRoot() {
        return root;
    }

    public static void addToRoot(Node toAdd) {
        gameMenu = (HBox)toAdd;
        root.getChildren().add(gameMenu);
        root.setAlignment(Pos.CENTER);
        gameMenu.setAlignment(Pos.CENTER);    
    }

    public static void removeGameMenu() {
        root.getChildren().remove(gameMenu);
    }

    public static HBox getGameMenu() {
        return gameMenu;
    }
}