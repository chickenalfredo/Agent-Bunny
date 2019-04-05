package core.command.commands;

import core.command.Command;
import core.entity.Entity;
import core.game.World;

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
        // actor.move(key, isKeyPressedEvent);
        System.out.println("Moving...");
    }
}
