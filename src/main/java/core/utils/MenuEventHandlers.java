package core.utils;

import core.scenes.*;
import core.game.World;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import core.App;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
 * This class handles all menu event handlers. This class defines the behaviour
 * of each button.
 */
public class MenuEventHandlers {

    /**
     * Sets the new game when the new game button is clicked
     */
    public static class NewGameEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            App.getGameWindow().setScene(GameScene.display(new World()));
        }
    }

    /**
     * Loads an old game when the button is clicked
     */
    public static class LoadGameEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            App.getGameWindow().setScene(GameScene.display(loadGame()));
        }
    }

    /**
     * Loads the settings menu when the button is clicked
     */
    public static class OpenSettingsEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            App.getGameWindow().setScene(GameSettings.display());
        }
    }

    /**
     * Loads the title scene when the button is clicked
     */
    public static class goToTitle implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            saveGame(GameScene.getWorld());
            App.getGameWindow().setScene(TitleScene.display());
        }
    }

    /**
     * Exists the game when the button is clicked
     */
    public static class ExitGameEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            saveGame(GameScene.getWorld());
            App.getGameWindow().close();
        }
    }

    /**
     * Goes the graphics settings menu when the button is clicked
     */
    public static class GraphicsMenuEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            GameSettings.graphicsMenu();
        }
    }

    /**
     * Sets the screen ratio to fullscreen when the option is selected
     */
    public static class setFullScreen implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            if (!App.getGameWindow().isFullScreen()) {
                App.getGameWindow().setFullScreen(true);
            } else {
                App.getGameWindow().setFullScreen(false);
            }
        }
    }

    /**
     * Resumes the game when the button is clicked
     */
    public static class resumeGame implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            GameScene.removeGameMenu();
        }
    }

    /**
     * Opens the keybinding scene when the button is clicked
     */
    public static class KeyBinding implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            KeyBindingScene.display();
        }
    }

    /**
     * Handles serialization upon exiting the game
     * 
     * @param world the world being serealized
     */
    public static void saveGame(World world) {
        try {
            FileOutputStream fileOut = new FileOutputStream("world.ser");
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(world);
            outStream.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Handles deserealization upon loading the game
     * 
     * @return the World being deserealized
     */
    public static World loadGame() {
        try {
            FileInputStream fileIn = new FileInputStream("world.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            World world = (World) in.readObject();
            in.close();
            fileIn.close();
            return world;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return null;
        }
    }
}