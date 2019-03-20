package core.utils;

import core.scenes.*;
import core.App;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import core.screens.ScreenBuilder;

public class MenuEventHandlers {

    public static class NewGameEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            App.getGameWindow().setScene(GameScene.display());
        }
    }

    public static class LoadGameEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            App.getGameWindow().setScene(GameScene.display());
        }
    }

    public static class OpenSettingsEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
                App.getGameWindow().setScene(GameSettings.display());
        }
    }

    public static class goToTitle implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            App.getGameWindow().setScene(TitleScene.display());
        }
    }

    public static class ExitGameEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
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
            if(!App.getGameWindow().isFullScreen()) {
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
}