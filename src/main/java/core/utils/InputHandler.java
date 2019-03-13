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
        if (event.getEventType() == KeyEvent.KEY_RELEASED) return handleKeyRelease(event);
        if (event.getEventType() == KeyEvent.KEY_PRESSED) return handleKeyPress(event);
        return null;
    }

    private Command handleKeyRelease(KeyEvent event) {
        if (event.getCode() == KeyCode.A) return haltKeyA_;
        if (event.getCode() == KeyCode.D) return haltKeyD_;
        if (event.getCode() == KeyCode.W) return haltKeyW_;
        if (event.getCode() == KeyCode.S) return haltKeyS_;
        return null;
    }

    private Command handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.W) return keyW_;
        if (event.getCode() == KeyCode.A) return keyA_;
        if (event.getCode() == KeyCode.S) return keyS_;
        if (event.getCode() == KeyCode.D) return keyD_;
        if (event.getCode() == KeyCode.SPACE) return keySpaceBar_;
        if (event.getCode() == KeyCode.Z) return keyZ_;
        return null;
    }

}
