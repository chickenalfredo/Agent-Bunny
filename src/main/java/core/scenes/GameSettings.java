package core.scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import core.utils.MenuEventHandlers;
import javafx.geometry.*;
import java.io.*;

public class GameSettings {

    private static Scene GameSettings;
    private static HBox menu;
    private static VBox mainMenu;
    private static VBox graphicsMenu;

    public static Scene display() {
        menu = mainMenu();
        GameSettings = new Scene(menu);
        GameSettings.getStylesheets().clear();
        GameSettings.getStylesheets().add((new File("Style.css")).toURI().toString());
        return GameSettings;
    }

    public static HBox mainMenu() {

        Label menuHeading = new Label("Game Menu");
        Button controls = new Button("View Controls");
        Button keymapping = new Button("Keybinds");
        Button graphics = new Button("Video Settings");
        Button TitleMenu = new Button("Return to Title Screen");
        Button exit = new Button("Exit Game");

        graphics.setOnAction(new MenuEventHandlers.GraphicsMenuEvent());
        TitleMenu.setOnAction(new MenuEventHandlers.goToTitle());
        exit.setOnAction(new MenuEventHandlers.ExitGameEvent()); 

        mainMenu = new VBox(5, menuHeading, controls, keymapping, graphics, TitleMenu, exit);
        mainMenu.setAlignment(Pos.CENTER);
        HBox menu = new HBox(5, mainMenu);
        menu.setAlignment(Pos.CENTER);
        return menu;
    } 

    public static void graphicsMenu() {

        RadioButton fullscreen = new RadioButton("Toggle Fullscreen");
        Label resolutionLabel = new Label("Available Resolutions: ");
        ComboBox<String> graphicsOptions = new ComboBox<String>();

        try (BufferedReader br = new BufferedReader(new FileReader("settings.config"))) {
            ObservableList<String> resolutions = FXCollections.observableArrayList();
            String line;
            while ((line = br.readLine()) != null) {
               resolutions.add(line);
            }
            graphicsOptions.setItems(resolutions);
        }
        catch (FileNotFoundException e ) {
            System.out.println("Unable to find file");
        }
        catch (IOException h) {
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
        menu.getChildren().add(graphicsMenu);
        }
        catch(IllegalArgumentException e) {}
    }
}
