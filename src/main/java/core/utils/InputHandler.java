package core.utils;

import javafx.scene.input.KeyEvent;
import core.command.*;
import core.utils.KeyBindings;

/**
 * 
 */
public class InputHandler {

    public InputHandler() {}

    /**
     * 
     * @param event
     * @return
     */
    public Command handleInput(KeyEvent event) {
        Command command;
        String key = String.valueOf(event.getCode());
        boolean isKeyPressed = event.getEventType() == KeyEvent.KEY_PRESSED;

        if (key.equalsIgnoreCase(KeyBindings.getLeftKey())) {
            command = new MoveCommand("a", isKeyPressed);
        } else if (key.equalsIgnoreCase(KeyBindings.getRightKey())) {
            command = new MoveCommand("d", isKeyPressed);
        } else if (key.equalsIgnoreCase(KeyBindings.getJumpKey())) {
            command = new JumpCommand("jump", isKeyPressed);
        } else if (key.equalsIgnoreCase(KeyBindings.getAttackKey())) {
            command = new AttackCommand(isKeyPressed);
        } else if (key.equalsIgnoreCase(KeyBindings.getMenuKey())) {
            command = new MenuCommand(isKeyPressed);
        } else {
            command = null;
        }
        return command;
    }
}