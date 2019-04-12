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
import javafx.scene.control.ProgressBar;
import core.utils.InputHandler;
import java.io.File;
import core.command.Command;
import core.screens.ScreenBuilder;
import core.sprite.World;

/**
 * 
 */
public class GameScene {

    private static StackPane root;
    private static HBox gameMenu;
    private static Scene GameScene;
    private static Canvas canvas;
    private static GraphicsContext gc;
    private static InputHandler inputHandler = new InputHandler();
    public static double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
    public static double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();
    private static World world;
    private static boolean animationTimer = false;

    public static Scene display(World aWorld) {
        world = aWorld;
        root = new StackPane();
        initScene();

        System.out.println(screenWidth + ": " + screenWidth * 0.031);
        System.out.println(screenHeight + ": " + screenHeight * 0.057);

        GameScene.setOnKeyPressed(new GameLoop());
        GameScene.setOnKeyReleased(new GameLoop());

        if (animationTimer == false) {
            new AnimationTimer() {
                public void handle(long time) {
                    if (world.getHero().getX() > (screenWidth / 2) - world.getHero().getWidth() / 2)
                        canvas.relocate(-world.getHero().getX() + ((screenWidth - world.getHero().getWidth()) / 2), 0);
                    gc.clearRect(0, 0, 3 * screenWidth, screenHeight);
                    world.update(gc, time);
                }
            }.start();
        }
        animationTimer = true;
        return GameScene;
    }

    /**
     * 
     */
    public static class GameLoop implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            Command command = inputHandler.handleInput(event);
            if (command != null) {
                command.execute(world.getHero(), world);
            }
        }
    }

    public static void initScene() {
        Pane camera = new Pane();

        root.getChildren().add(camera);

        canvas = new Canvas(3 * screenWidth, screenHeight);
        camera.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        gc.strokeText("hi", 150, 100);

        // StackPane healthBar = new
        // StackPane(world.getHero().getComponent("HealthComponent",
        // HealthComponent.class).getHealthBar(),
        // world.getHero().getComponent("HealthComponent",
        // HealthComponent.class).getHealthDisplay());
        // healthBar.setAlignment(Pos.TOP_LEFT);
        // root.getChildren().add(healthBar);

        GameScene = new Scene(root);
        GameScene.getStylesheets().add((new File("resources/css/style.css")).toURI().toString());
    }

    /**
     * 
     * @return
     */
    public static Scene getScene() {
        return GameScene;
    }

    /**
     * 
     * @return
     */
    public static Pane getRoot() {
        return root;
    }

    /**
     * 
     * @param toAdd
     */
    public static void addToRoot(Node toAdd) {
        gameMenu = (HBox) toAdd;
        root.getChildren().add(gameMenu);
        root.setAlignment(Pos.CENTER);
        gameMenu.setAlignment(Pos.CENTER);
    }

    /**
     * 
     */
    public static void removeGameMenu() {
        root.getChildren().remove(gameMenu);
    }

    /**
     * 
     * @return
     */
    public static HBox getGameMenu() {
        return gameMenu;
    }

    /**
     * @return the world
     */
    public static World getWorld() {
        return world;
    }
}