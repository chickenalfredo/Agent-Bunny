package core.scenes;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import core.utils.InputHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import core.App;
import core.command.Command;
import core.component.DimensionComponent;
import core.component.HealthComponent;
import core.component.PositionComponent;
import core.screens.ScreenBuilder;
import core.game.World;

/**
 * Primary scene of the application. This scene is the container where the game
 * will be played.
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

    /**
     * Displays all the output, including the updated systems and renders
     * 
     * @param aWorld
     * @return the scene
     */
    public static Scene display(World aWorld) {
        world = aWorld;
        root = new StackPane();
        initScene();

        GameScene.setOnKeyPressed(new GameLoop());
        GameScene.setOnKeyReleased(new GameLoop());

        world.init();

        if (animationTimer == false) {
            new AnimationTimer() {
                public void handle(long time) {
                    if (world.getHero().getComponent(PositionComponent.class).getX() > (screenWidth / 2)
                            - world.getHero().getComponent(DimensionComponent.class).getWidth() / 2)
                        canvas.relocate(-world.getHero().getComponent(PositionComponent.class).getX()
                                + ((screenWidth - world.getHero().getComponent(DimensionComponent.class).getWidth()) / 2), 0);
                    gc.clearRect(0, 0, 3 * screenWidth, screenHeight);
                    if (world.getHero().getComponent(HealthComponent.class).isAlive()) {
                        world.update();
                        world.render(gc);
                    } else {
                        App.getGameWindow().setScene(TitleScene.display());
                        animationTimer = false;
                        stop();
                    }
                }
            }.start();
        }
        animationTimer = true;
        return GameScene;
    }

    /**
     * Primary input loop of the game
     */
    public static class GameLoop implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            Command command = inputHandler.handleInput(event);
            if (command != null) {
                command.execute(world.getHero(), world);
            }
        }
    }

    /**
     * Initializes the nodes of the scene
     */
    private static void initScene() {
        Pane camera = new Pane();

        root.getChildren().add(camera);
        Image helpPane;
        try {
            helpPane = new Image(new FileInputStream("resources/assets/Instruction_Final.png"), screenWidth * 0.30,
                    screenHeight * 0.30, false, true);
            ImageView imageview = new ImageView(helpPane);
            Group controlHelpPane = new Group(imageview);
            controlHelpPane.setTranslateX(-(screenWidth / 2) + controlHelpPane.getBoundsInLocal().getWidth() / 4);
            controlHelpPane.setTranslateY(-(screenHeight / 2) + controlHelpPane.getBoundsInLocal().getHeight() / 2);
            canvas = new Canvas(3 * screenWidth, screenHeight);
            camera.getChildren().add(canvas);
            root.getChildren().add(controlHelpPane);
            gc = canvas.getGraphicsContext2D();

            GameScene = new Scene(root);
            GameScene.getStylesheets().add((new File("resources/css/style.css")).toURI().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the scene to set
     */
    public static Scene getScene() {
        return GameScene;
    }

    /**
     * @return the root node
     */
    public static Pane getRoot() {
        return root;
    }

    /**
     * Adds the node to the root node
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
     * Removes the game menu from the root node
     */
    public static void removeGameMenu() {
        root.getChildren().remove(gameMenu);
    }

    /**
     * @return the game menu HBox
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
