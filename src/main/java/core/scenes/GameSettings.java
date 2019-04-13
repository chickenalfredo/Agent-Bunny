package core.scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import core.App;
import core.utils.MenuEventHandlers;
import javafx.geometry.*;
import java.io.*;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

/**
 * The scene containig all the nodes of the game settings
 */
public class GameSettings {

    private static Scene GameSettings;
    private static HBox menu;
    private static VBox mainMenu;
    private static VBox graphicsMenu;

    /**
     * @return  the scene to display
     */
    public static Scene display() {
        menu = mainMenu();
        GameSettings = new Scene(menu);
        GameSettings.getStylesheets().clear();
        GameSettings.getStylesheets().add((new File("resources/css/style.css")).toURI().toString());
        GameSettings.setOnKeyPressed(new EscKey());
        return GameSettings;
    }

    /**
     * Returns the user back to the title scen
     */
    public static class EscKey implements EventHandler<KeyEvent> {
        public void handle(KeyEvent key) {
            if (key.getCode() == KeyCode.ESCAPE) {
                if (menu.getChildren().contains(graphicsMenu)) {
                    menu.getChildren().remove(graphicsMenu);
                } else if (menu.getChildren().contains(KeyBindingScene.getKeyMenu())) {
                    menu.getChildren().remove(KeyBindingScene.getKeyMenu());
                } else {
                    App.getGameWindow().setScene(TitleScene.display());
                }
            }
        }
    }

    /**
     * @return  the HBox containing the menu's nodes
     */
    static public HBox mainMenu() {
        if (App.getGameWindow().getScene() == GameScene.getScene()) {
            Button resumeGame = new Button("Resume Game");
            resumeGame.setOnAction(new MenuEventHandlers.resumeGame());
            mainMenu = new VBox(5, resumeGame);
        } else {
            mainMenu = new VBox(5);
        }

        Button keymapping = new Button("Keybinds");
        Button graphics = new Button("Video Settings");
        Button TitleMenu = new Button("Return to Title Screen");
        Button exit = new Button("Exit Game");

        keymapping.setOnAction(new MenuEventHandlers.KeyBinding());
        graphics.setOnAction(new MenuEventHandlers.GraphicsMenuEvent());
        TitleMenu.setOnAction(new MenuEventHandlers.goToTitle());
        exit.setOnAction(new MenuEventHandlers.ExitGameEvent());

        mainMenu.getChildren().addAll(keymapping, graphics, TitleMenu, exit);
        mainMenu.setAlignment(Pos.CENTER);
        HBox menu = new HBox(5, mainMenu);
        menu.setAlignment(Pos.CENTER);
        return menu;
    }

    /**
     * Sets up the graphics menu
     */
    public static void graphicsMenu() {
        CheckBox fullscreen = new CheckBox("Toggle Fullscreen");
        fullscreen.setStyle("-fx-text-fill: white;");
        Label resolutionLabel = new Label("Available Resolutions: ");
        ComboBox<String> graphicsOptions = new ComboBox<String>();

        try (BufferedReader br = new BufferedReader(new FileReader("resources/configs/settings.config"))) {
            ObservableList<String> resolutions = FXCollections.observableArrayList();
            String line;
            while ((line = br.readLine()) != null) {
                resolutions.add(line);
            }
            graphicsOptions.setItems(resolutions);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file");
        } catch (IOException h) {
            System.out.println("an IO exception occured");
        }

        fullscreen.setOnAction(new MenuEventHandlers.setFullScreen());
        if (graphicsMenu == null) {
            HBox screenResolutions = new HBox(5, resolutionLabel, graphicsOptions);
            screenResolutions.setAlignment(Pos.CENTER);
            graphicsMenu = new VBox(5, fullscreen, screenResolutions);
            graphicsMenu.setAlignment(Pos.CENTER);
        }
        try {
            if (App.getGameWindow().getScene() == GameScene.getScene()) {
                GameScene.getGameMenu().getChildren().add(graphicsMenu);
            } else {
                menu.getChildren().add(graphicsMenu);
            }
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * @return  the game settings scene 
     */
    public static Scene getScene() {
        return GameSettings;
    }

    /**
     * Sets the game setting scene
     * @param scene
     */
    public static void setScene(Scene scene) {
        GameSettings = scene;
    }

    /**
     * @return  the HBox containign the menu
     */
    public static HBox getMenu() {
        return menu;
    }
}
