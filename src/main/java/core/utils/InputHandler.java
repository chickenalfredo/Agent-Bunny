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
    private DoubleJumpCommand keyR_ = new DoubleJumpCommand();       
    private DashCommand keyE_ = new DashCommand();             
    private AttackCommand keyZ_ = new AttackCommand();   
    
    private HaltMoveLeftCommand haltKeyA_ = new HaltMoveLeftCommand();
    private HaltMoveRightCommand haltKeyD_ = new HaltMoveRightCommand();
    private HaltMoveUpCommand haltKeyW_ = new HaltMoveUpCommand();
    private HaltMoveDownCommand haltKeyS_ = new HaltMoveDownCommand();

    public InputHandler() {}

    public Command handleInput(KeyEvent event) {
        if (event.getEventType() == KeyEvent.KEY_RELEASED && event.getCode() == KeyCode.A) return haltKeyA_;
        if (event.getEventType() == KeyEvent.KEY_RELEASED && event.getCode() == KeyCode.D) return haltKeyD_;
        if (event.getEventType() == KeyEvent.KEY_RELEASED && event.getCode() == KeyCode.W) return haltKeyW_;
        if (event.getEventType() == KeyEvent.KEY_RELEASED && event.getCode() == KeyCode.S) return haltKeyS_;

        if (event.getCode() == KeyCode.W) return keyW_;
        if (event.getCode() == KeyCode.A) return keyA_;
        if (event.getCode() == KeyCode.S) return keyS_;
        if (event.getCode() == KeyCode.D) return keyD_;
        if (event.getCode() == KeyCode.SPACE) return keySpaceBar_;
        if (event.getCode() == KeyCode.R) return keyR_;
        if (event.getCode() == KeyCode.E) return keyE_;
        if (event.getCode() == KeyCode.Z) return keyZ_;

        return null;
    }

}
