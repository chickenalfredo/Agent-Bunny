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
        Command command = null;
        if (event.getCode() == KeyCode.A) command = haltKeyA_;
        if (event.getCode() == KeyCode.D) command =  haltKeyD_;
        if (event.getCode() == KeyCode.W) command =  haltKeyW_;
        if (event.getCode() == KeyCode.S) command =  haltKeyS_;
        return command;
    }

    private Command handleKeyPress(KeyEvent event) {
        Command command = null;
        if (event.getCode() == KeyCode.W) command =  keyW_;
        if (event.getCode() == KeyCode.A) command =  keyA_;
        if (event.getCode() == KeyCode.S) command =  keyS_;
        if (event.getCode() == KeyCode.D) command =  keyD_;
        if (event.getCode() == KeyCode.SPACE) command =  keySpaceBar_;
        if (event.getCode() == KeyCode.Z) command =  keyZ_;
        return command;
    }

}
