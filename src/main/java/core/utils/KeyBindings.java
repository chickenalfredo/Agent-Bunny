package core.utils;

import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import core.App;
import core.scenes.GameScene;
import core.scenes.GameSettings;
import core.scenes.KeyBindingScene;

/**
 * This class will handle keybindings in the game. Through this interface, the
 * user may change the default keys that are set.
 */
public class KeyBindings {

    private static String left = "LEFT";
    private static String right = "RIGHT";
    private static String jump = "UP";
    private static String attack = "DOWN";
    private static String menu = "ESCAPE";

    /**
     * @return the current left key
     */
    public static String getLeftKey() {
        return left;
    }

    /**
     * Sets the left key
     */
    public static class setLeftKey implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            if (String.valueOf(event.getCode()) != right && String.valueOf(event.getCode()) != jump
                    && String.valueOf(event.getCode()) != attack && String.valueOf(event.getCode()) != menu) {

                left = String.valueOf(event.getCode());
                ((Button) ((HBox) KeyBindingScene.getKeyMenu().getChildren().get(1)).getChildren().get(1))
                        .setText(getLeftKey());
            }
        }
    }

    /**
     * @return the current right key
     */
    public static String getRightKey() {
        return right;
    }

    /**
     * Sets the right
     */
    public static class setRightKey implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            if (String.valueOf(event.getCode()) != left && String.valueOf(event.getCode()) != jump
                    && String.valueOf(event.getCode()) != attack && String.valueOf(event.getCode()) != menu) {

                right = String.valueOf(event.getCode());
                ((Button) ((HBox) KeyBindingScene.getKeyMenu().getChildren().get(2)).getChildren().get(1))
                        .setText(getRightKey());
            }
        }
    }

    /**
     * @return the current jump key
     */
    public static String getJumpKey() {
        return jump;
    }

    /**
     * Sets the jump key
     */
    public static class setJumpKey implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            if (String.valueOf(event.getCode()) != left && String.valueOf(event.getCode()) != right
                    && String.valueOf(event.getCode()) != attack && String.valueOf(event.getCode()) != menu) {

                jump = String.valueOf(event.getCode());
                ((Button) ((HBox) KeyBindingScene.getKeyMenu().getChildren().get(3)).getChildren().get(1))
                        .setText(getJumpKey());
            }
        }
    }

    /**
     * @return the current attack key
     */
    public static String getAttackKey() {
        return attack;
    }

    /**
     * sets the attack key
     */
    public static class setAttackKey implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            if (String.valueOf(event.getCode()) != left && String.valueOf(event.getCode()) != jump
                    && String.valueOf(event.getCode()) != right && String.valueOf(event.getCode()) != menu) {

                attack = String.valueOf(event.getCode());
                ((Button) ((HBox) KeyBindingScene.getKeyMenu().getChildren().get(4)).getChildren().get(1))
                        .setText(getAttackKey());
            }
        }
    }

    /**
     * @return the current menu key
     */
    public static String getMenuKey() {
        return menu;
    }

    /**
     * sets the menu key
     */
    public static class setMenuKey implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            if (String.valueOf(event.getCode()) != left && String.valueOf(event.getCode()) != jump
                    && String.valueOf(event.getCode()) != attack && String.valueOf(event.getCode()) != right) {

                menu = String.valueOf(event.getCode());
                ((Button) ((HBox) KeyBindingScene.getKeyMenu().getChildren().get(5)).getChildren().get(1))
                        .setText(getMenuKey());
            }
        }
    }

    /**
     * Removes a current key binding
     */
    public static class removeKeyListener implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            if (App.getGameWindow().getScene() == GameScene.getScene()) {
                App.getGameWindow().getScene().setOnKeyReleased(new GameScene.GameLoop());
                App.getGameWindow().getScene().setOnKeyPressed(new GameScene.GameLoop());
            } else {
                App.getGameWindow().getScene().setOnKeyPressed(new GameSettings.EscKey());
            }
        }
    }

    /**
     * Binds the key buttons
     */
    public static class BindKeyButtons implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Object source = event.getSource();
            if (source instanceof Button) {
                if (((Button) source).getText().equals(getLeftKey())) {
                    App.getGameWindow().getScene().setOnKeyPressed(new setLeftKey());
                } else if (((Button) source).getText().equals(getRightKey())) {
                    App.getGameWindow().getScene().setOnKeyPressed(new setRightKey());
                } else if (((Button) source).getText().equals(getJumpKey())) {
                    App.getGameWindow().getScene().setOnKeyPressed(new setJumpKey());
                } else if (((Button) source).getText().equals(getAttackKey())) {
                    App.getGameWindow().getScene().setOnKeyPressed(new setAttackKey());
                } else if (((Button) source).getText().equals(getMenuKey())) {
                    App.getGameWindow().getScene().setOnKeyPressed(new setMenuKey());
                } else {
                }
                App.getGameWindow().getScene().setOnKeyReleased(new removeKeyListener());
            }
        }
    }

}