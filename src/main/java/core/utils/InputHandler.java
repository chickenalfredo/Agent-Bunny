package core.utils;

import javafx.scene.input.KeyEvent;
import core.command.Command;
import core.command.commands.*;

public class InputHandler {

    private JumpCommand keySpaceBar_ = new JumpCommand();      
    private AttackCommand keyZ_ = new AttackCommand();   
   // private MenuCommand keyEscape = new MenuCommand(); 
    
    public InputHandler() {}

    public Command handleInput(KeyEvent event) {
        Command command;
        boolean isKeyPressed = event.getEventType() == KeyEvent.KEY_PRESSED;
        switch (event.getCode()) {
            case A:
                command = new MoveCommand("a", isKeyPressed);
                break;
            case D:
                command = new MoveCommand("d", isKeyPressed);
                break;
            case SPACE:
                command = keySpaceBar_;
                break;
            case Z:
                command = keyZ_;
                break;
            case ESCAPE:
                command = new MenuCommand(isKeyPressed);
                break;
            default:
                command = null;
        }
        return command;
    }

}
