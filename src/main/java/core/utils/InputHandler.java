package core.utils;

import javafx.scene.input.KeyEvent;
import core.command.*;
import core.utils.KeyBindings;

/**
 * This class returns a new Command depending on the type of input the user
 * enters. If the user enters invalid input, the Command is not instantiated and
 * therefore the user recieves a null pointer.
 */
public class InputHandler {

    public InputHandler() {
    }

    /**
     * Handles input recieved as a KeyEvent type. Depending on what keybindings
     * currently exist, this method will return a new Command.
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