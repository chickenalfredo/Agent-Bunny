package core.command;

import core.entity.Entity;
import core.game.World;
import core.system.systems.MovementSystem;

/**
 * This Command will execute a jump command. Execution of this object will 
 * send an update request the MovementSystem.
 */
public class JumpCommand implements Command {

    private String key;
    private boolean isKeyPressed;

    /**
     * Constructs a Jump Command with the key that was pressed and whether or not
     * the event was a key pressed event
     * 
     * @param key
     * @param isKeyPressed
     */
    public JumpCommand(String key, boolean isKeyPressed) {
        this.key = key;
        this.isKeyPressed = isKeyPressed;
    }

    /**
     * Executes the Jump Command by request an update to the Movement System
     * 
     * @param actor
     * @param world
     */
    @Override
    public void execute(Entity actor, World world) {
        world.getManager().getSystemManager().getSystem(MovementSystem.class).requestUpdate(actor);
        world.getManager().getSystemManager().getSystem(MovementSystem.class).setKey(key);
        world.getManager().getSystemManager().getSystem(MovementSystem.class).setKeyPressedEvent(isKeyPressed);
    }
}