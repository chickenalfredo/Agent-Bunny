package core.utils;

import core.scenes.*;
import core.App;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class EventHandlers {

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
            App.getGameWindow().setScene(mainSettingsScene.display());
        }
    }

    public static class ExitGameEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            App.getGameWindow().close();
        }
    }
}