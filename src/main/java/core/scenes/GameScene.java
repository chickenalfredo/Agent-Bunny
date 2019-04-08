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
import java.util.ArrayList;

import core.command.Command;
import core.component.components.DimensionComponent;
import core.component.components.PositionComponent;
import core.screens.ScreenBuilder;
import core.game.World;

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

    static Image RUN_1;
    static Image RUN_2;
    static Image RUN_3;
    static Image RUN_4;
    static Image RUN_5;
    static Image RUN_6;
    static Image RUN_7;
    static Image RUN_8;
    static Image RUN_9;
    static Image RUN_10;
    static Image RUN_11;
    static Image RUN_12;
    static Image RUN_13;
    static Image RUN_14;
    static Image RUN_15;
    static Image RUN_16;

    private static Group hero = new Group();

    private static void initImages() {
        try {
            RUN_1 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_1.png"));
            // RUN_2 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_2.png"));
            // RUN_3 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_3.png"));
            // RUN_4 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_4.png"));
            // RUN_5 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_5.png"));
            // RUN_6 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_6.png"));
            // RUN_7 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_7.png"));
            // RUN_8 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_8.png"));
            // RUN_9 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_9.png"));
            // RUN_10 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_10.png"));
            // RUN_11 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_11.png"));
            // RUN_12 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_12.png"));
            // RUN_13 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_13.png"));
            // RUN_14 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_14.png"));
            // RUN_15 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_15.png"));
            // RUN_16 = new Image(new FileInputStream("resources/assets/Hero/move_right/r_run_16.png"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public static Scene display(World aWorld) {
        world = aWorld;
        root = new StackPane();
        initImages();
        initScene();

        System.out.println(screenWidth);
        System.out.println(screenHeight);

        GameScene.setOnKeyPressed(new GameLoop());
        GameScene.setOnKeyReleased(new GameLoop());

        ImageView run1 = new ImageView(RUN_1);
        // ImageView run2 = new ImageView(RUN_2);
        // ImageView run3 = new ImageView(RUN_3);
        // ImageView run4 = new ImageView(RUN_4);
        // ImageView run5 = new ImageView(RUN_5);
        // ImageView run6 = new ImageView(RUN_6);
        // ImageView run7 = new ImageView(RUN_7);
        // ImageView run8 = new ImageView(RUN_8);
        // ImageView run9 = new ImageView(RUN_9);
        // ImageView run10 = new ImageView(RUN_10);
        // ImageView run11 = new ImageView(RUN_11);
        // ImageView run12 = new ImageView(RUN_12);
        // ImageView run13 = new ImageView(RUN_13);
        // ImageView run14 = new ImageView(RUN_14);
        // ImageView run15 = new ImageView(RUN_15);
        // ImageView run16 = new ImageView(RUN_16);

        // ArrayList<ImageView> runs = new ArrayList<ImageView>();
        // runs.add(run1);
        // runs.add(run2);
        // runs.add(run3);
        // runs.add(run4);
        // runs.add(run5);
        // runs.add(run6);
        // runs.add(run7);
        // runs.add(run8);
        // runs.add(run9);
        // runs.add(run10);
        // runs.add(run11);
        // runs.add(run12);
        // runs.add(run13);
        // runs.add(run14);
        // runs.add(run15);
        // runs.add(run16);

        // hero = new Group(run1);
        // root.getChildren().add(hero);

        // final double xOffset = -(screenWidth / 2);
        // final double yOffset = -(screenHeight / 2);

        // hero.setTranslateX(xOffset + (hero.getBoundsInLocal().getWidth()/2));
        // hero.setTranslateY(yOffset + (hero.getBoundsInLocal().getHeight()/2));
        
        world.init(root);

        if (animationTimer == false) {
            new AnimationTimer() {
                // long lastTime = 0;
                // int i = 0;
                public void handle(long time) {
                    if (world.getHero().getComponent(PositionComponent.class).getX() > (screenWidth / 2) - world.getHero().getComponent(DimensionComponent.class).getWidth() / 2)
                        canvas.relocate(-world.getHero().getComponent(PositionComponent.class).getX() + ((screenWidth - world.getHero().getComponent(DimensionComponent.class).getWidth()) / 2), 0);
                    gc.clearRect(0, 0, 3 * screenWidth, screenHeight);
                    world.update(time);
                    world.render(root, time);
                    // long curTime = System.currentTimeMillis();
                    // if (curTime > lastTime + 50) {
                    //     if (i > 15) i = 0;
                    //     hero.getChildren().setAll(runs.get(i));
                    //     lastTime = curTime;
                    //     i++;
                    // }  
                    
                }
            }.start();
        }
        animationTimer = true;


        return GameScene;
    }

    private static String FileInputStream(String string) {
        return null;
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