package core.scenes;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import core.utils.MenuEventHandlers;
import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import core.App;
import core.utils.KeyBindings;
import core.scenes.GameSettings;

public class KeyBindingScene<ClickEvent> {

    private static Scene KeyBindingsScene;
    private static HBox keyMenu;

    public static HBox display() {
        try {
            if (App.getGameWindow().getScene() == GameScene.getScene()
                    && !GameScene.getGameMenu().getChildren().contains(keyMenu)) {
                keyMenu = initScene();
                GameScene.getGameMenu().getChildren().add(keyMenu);
            } else if (App.getGameWindow().getScene() == GameSettings.getScene()
                    && !GameSettings.getMenu().getChildren().contains(keyMenu)) {
                keyMenu = initScene();
                GameSettings.getMenu().getChildren().add(keyMenu);
            }
        } catch (IllegalArgumentException e) {
        }
        return keyMenu;
    }

    public static HBox initScene() {

        Label menuTitle = new Label("Actions:");
        Label leftKey = new Label("Move Left: ");
        Label rightKey = new Label("Move Right: ");
        Label jumpKey = new Label("Jump: ");
        Label attackKey = new Label("Attack: ");
        Label menuKey = new Label("Open Menu: ");
        VBox labels = new VBox(5, menuTitle, leftKey, rightKey, jumpKey, attackKey, menuKey);
        labels.setAlignment(Pos.CENTER);

        Label keyBindLabel = new Label("KeyBindings:");
        Button button_LeftKey = new Button(KeyBindings.getLeftKey());
        Button button_RightKey = new Button(KeyBindings.getRightKey());
        Button button_JumpKey = new Button(KeyBindings.getJumpKey());
        Button button_AttackKey = new Button(KeyBindings.getAttackKey());
        Button button_MenuKey = new Button(KeyBindings.getMenuKey());
        VBox buttons = new VBox(5, keyBindLabel, button_LeftKey, button_RightKey, button_JumpKey, button_AttackKey,
                button_MenuKey);
        buttons.setAlignment(Pos.CENTER);

        HBox menu = new HBox(5, labels, buttons);
        menu.setAlignment(Pos.CENTER);

        for (Node node : buttons.getChildren()) {
            if (node instanceof Button) {
                ((Button) node).setOnAction(new KeyBindings.BindKeyButtons());
            }
        }

        menu.setAlignment(Pos.CENTER);

        return menu;
    }

    public static HBox getKeyMenu() {
        return keyMenu;
    }

    public static void setOnKeyPressed(EventHandler<KeyEvent> handler) {
        if (handler != null) {
            KeyBindingsScene.setOnKeyPressed(handler);
        } else {
            KeyBindingsScene.setOnKeyPressed(new EscKey());
        }
    }

    public static void setOnKeyReleased(EventHandler<KeyEvent> handler) {
        KeyBindingsScene.setOnKeyReleased(handler);
    }

    public static class EscKey implements EventHandler<KeyEvent> {
        public void handle(KeyEvent key) {
            if (key.getCode() == KeyCode.ESCAPE) {
                App.getGameWindow().setScene(GameSettings.display());
            }
        }
    }
}
