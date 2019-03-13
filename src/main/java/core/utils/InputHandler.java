package core.utils;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import core.command.Command;
import core.command.commands.*;

public class InputHandler {

    private MoveUpCommand keyW_ = new MoveUpCommand();          
    private MoveLeftCommand keyA_ = new MoveLeftCommand();      
    private MoveDownCommand keyS_ = new MoveDownCommand();     
    private MoveRightCommand keyD_ = new MoveRightCommand();       
    private JumpCommand keySpaceBar_ = new JumpCommand();      
    private AttackCommand keyZ_ = new AttackCommand();   
    
    private HaltMoveLeftCommand haltKeyA_ = new HaltMoveLeftCommand();
    private HaltMoveRightCommand haltKeyD_ = new HaltMoveRightCommand();
    private HaltMoveUpCommand haltKeyW_ = new HaltMoveUpCommand();
    private HaltMoveDownCommand haltKeyS_ = new HaltMoveDownCommand();

    public InputHandler() {}

    public Command handleInput(KeyEvent event) {
        if (event.getEventType() == KeyEvent.KEY_RELEASED) return keyReleasedHandler(event.getCode());
        if (event.getEventType() == KeyEvent.KEY_PRESSED) return keyPressHandler(event.getCode());
        return null;
    }

    private Command keyPressHandler(KeyCode key) {
        Command command;
        switch (key) {
            case W:
                command = keyW_;
                break;
            case A:
                command = keyA_;
                break;
            case S:
                command = keyS_;
                break;
            case D:
                command = keyD_;
                break;
            case SPACE:
                command = keySpaceBar_;
                break;
            case Z:
                command = keyZ_;
                break;
            default:
                command = null;
        }
        return command;
    }

    private Command keyReleasedHandler(KeyCode key) {
        Command command;
        switch (key) {
            case W:
                command = haltKeyW_;
                break;
            case A:
                command = haltKeyA_;
                break;
            case S:
                command = haltKeyS_;
                break;
            case D:
                command = haltKeyD_;
                break;
            default:
                command = null;
        }
        return command;
    }

}
