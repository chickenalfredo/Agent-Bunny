package core.scenes;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.geometry.*;
import core.App;
import core.utils.KeyBindings;
import core.scenes.GameSettings;

/**
 * The scene where keybinding's are made
 * @param <ClickEvent>
 */
public class KeyBindingScene<ClickEvent> {

    private static Scene KeyBindingsScene;
    private static VBox keyMenu;

    /**
     * @return  the VBox containing the display
     */
    public static VBox display() {
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

    /**
     * @return  the initialized VBox scene
     */
    public static VBox initScene() {

        Label menuTitle = new Label("Actions:");
        Label leftKey = new Label("Move Left: ");
        Label rightKey = new Label("Move Right: ");
        Label jumpKey = new Label("Jump: ");
        Label attackKey = new Label("Attack: ");
        Label menuKey = new Label("Open Menu: ");

        Label keyBindLabel = new Label("KeyBindings:");
        Button button_LeftKey = new Button(KeyBindings.getLeftKey());
        Button button_RightKey = new Button(KeyBindings.getRightKey());
        Button button_JumpKey = new Button(KeyBindings.getJumpKey());
        Button button_AttackKey = new Button(KeyBindings.getAttackKey());
        Button button_MenuKey = new Button(KeyBindings.getMenuKey());

        HBox headers = new HBox(20, menuTitle, keyBindLabel);
        HBox moveLeft = new HBox(20, leftKey, button_LeftKey);
        HBox moveRight = new HBox(20, rightKey, button_RightKey);
        HBox jump = new HBox(20, jumpKey, button_JumpKey);
        HBox attack = new HBox(20, attackKey, button_AttackKey);
        HBox menu = new HBox(20, menuKey, button_MenuKey);

        VBox keyMenu = new VBox(8, headers, moveLeft, moveRight, jump, attack, menu);
        keyMenu.setAlignment(Pos.CENTER);

        for (Node node : keyMenu.getChildren()) {
            ((HBox) node).setAlignment(Pos.CENTER);
            for (Node button : ((HBox) node).getChildren()) {
                if (button instanceof Button) {
                    ((Button) button).setOnAction(new KeyBindings.BindKeyButtons());
                }
            }
        }
        menu.setAlignment(Pos.CENTER);
        return keyMenu;
    }

    /**
     * @return  the VBox containing the key menu
     */
    public static VBox getKeyMenu() {
        return keyMenu;
    }

    /**
     * Sets the new keybinding key-press
     * @param handler
     */
    public static void setOnKeyPressed(EventHandler<KeyEvent> handler) {
        if (handler != null) {
            KeyBindingsScene.setOnKeyPressed(handler);
        } else {
            KeyBindingsScene.setOnKeyPressed(new EscKey());
        }
    }

    /**
     * Sets the new keybinding on key-release
     * @param handler
     */
    public static void setOnKeyReleased(EventHandler<KeyEvent> handler) {
        KeyBindingsScene.setOnKeyReleased(handler);
    }

    /**
     * Escapes out of this scene's menu
     */
    public static class EscKey implements EventHandler<KeyEvent> {
        public void handle(KeyEvent key) {
            if (key.getCode() == KeyCode.ESCAPE) {
                App.getGameWindow().setScene(GameSettings.display());
            }
        }
    }
}
