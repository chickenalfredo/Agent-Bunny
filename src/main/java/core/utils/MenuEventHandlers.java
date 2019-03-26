package core.utils;

import core.scenes.*;
import core.sprite.World;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import core.App;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class MenuEventHandlers {

    public static class NewGameEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            App.getGameWindow().setScene(GameScene.display(new World()));
        }
    }

    public static class LoadGameEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            App.getGameWindow().setScene(GameScene.display(loadGame()));
        }
    }

    public static class OpenSettingsEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            App.getGameWindow().setScene(GameSettings.display());
        }
    }

    public static class goToTitle implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            saveGame(GameScene.getWorld());
            App.getGameWindow().setScene(TitleScene.display());
        }
    }

    public static class ExitGameEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            saveGame(GameScene.getWorld());
            App.getGameWindow().close();
        }
    }

    public static class GraphicsMenuEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            GameSettings.graphicsMenu();
        }
    }

    public static class setFullScreen implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            if (!App.getGameWindow().isFullScreen()) {
                App.getGameWindow().setFullScreen(true);
            } else {
                App.getGameWindow().setFullScreen(false);
            }
        }
    }

    public static class resumeGame implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            GameScene.removeGameMenu();
        }
    }

    public static class KeyBinding implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            KeyBindingScene.display();
        }
    }

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

    public static World loadGame() {
        try
  {
   FileInputStream fileIn =new FileInputStream("world.ser");
   ObjectInputStream in = new ObjectInputStream(fileIn);
   World world = (World) in.readObject();
   in.close();
   fileIn.close();
   return world;
  }catch(IOException i)
  {
   i.printStackTrace();
   return null;
  }catch(ClassNotFoundException c)
  {
   System.out.println("Employee class not found");
   c.printStackTrace();
   return null;
  }
    }
}