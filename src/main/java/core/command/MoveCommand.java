package core.command;

import core.entity.Entity;
import core.game.World;
import core.system.systems.MovementSystem;

/**
 * This Command will execute a move command. Execution of this object will 
 * send an update request the MovementSystem.
 */
public class MoveCommand implements Command {

    private String key;
    private boolean isKeyPressedEvent;

    /**
     * Constructs a Move Command with the key that was pressed and whether or not
     * the event was a key pressed event
     * 
     * @param key
     * @param isKeyPressed
     */
    public MoveCommand(String key, boolean isKeyPressedEvent) {
        this.key = key;
        this.isKeyPressedEvent = isKeyPressedEvent;
    }

    /**
     * Executes the Move Command by request an update to the Movement System
     * 
     * @param actor
     * @param world
     */
    @Override
    public void execute(Entity actor, World world) {
        world.getManager().getSystemManager().getSystem(MovementSystem.class).requestUpdate(actor);
        world.getManager().getSystemManager().getSystem(MovementSystem.class).setKey(key);
        world.getManager().getSystemManager().getSystem(MovementSystem.class).setKeyPressedEvent(isKeyPressedEvent);
    }
}
