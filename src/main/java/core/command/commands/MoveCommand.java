package core.command.commands;

import core.command.Command;
import core.entity.Entity;
import core.game.World;
import core.system.systems.MovementSystem;

/**
 * 
 */
public class MoveCommand extends Command {

    private String key;
    private boolean isKeyPressedEvent;

    /**
     * 
     * @param key
     * @param isKeyPressedEvent
     */
    public MoveCommand(String key, boolean isKeyPressedEvent) {
        this.key = key;
        this.isKeyPressedEvent = isKeyPressedEvent;
    }

    /**
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
