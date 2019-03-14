package core.utils;

import core.scenes.*;
import core.App;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import core.screens.ScreenBuilder;

public class MenuEventHandlers {

    private static Stage popUpMenu;

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
            System.out.println(App.getGameWindow().getScene());
            System.out.println(GameScene.getScene());
            if (App.getGameWindow().getScene() == GameScene.getScene()) {
                popUpMenu = new Stage();
                popUpMenu.setWidth(ScreenBuilder.getPrimaryScreenBounds().getWidth() / 2);
                popUpMenu.setHeight(ScreenBuilder.getPrimaryScreenBounds().getHeight() / 2);
                popUpMenu.initModality(Modality.APPLICATION_MODAL);
                popUpMenu.setTitle("AGENT BUNNY: Game Settings");
                popUpMenu.setScene(GameSettings.display());
                popUpMenu.showAndWait();
            } else {
                App.getGameWindow().setScene(GameSettings.display());
            }
        }
    }

    public static class goToTitle implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            if (popUpMenu != null) {
                popUpMenu.hide();
            }
            App.getGameWindow().setScene(TitleScene.display());
        }
    }

    public static class ExitGameEvent implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            if (popUpMenu != null) {
                popUpMenu.hide();
            }
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
            if (popUpMenu.getScene() != null) {
                popUpMenu.hide();
            }
            if(!App.getGameWindow().isFullScreen()) {
                App.getGameWindow().setFullScreen(true);
            } else {
                App.getGameWindow().setFullScreen(false);
            }
        }
    }

    public static class resumeGame implements EventHandler<ActionEvent> {
        public void handle(ActionEvent leftClick) {
            popUpMenu.hide();
            popUpMenu = null;
        }
    }

    /**
     * @return the popUpMenu
     */
    public static Stage getPopUpMenu() {
        return popUpMenu;
    }

}
