package core.command;

import core.entity.Entity;
import core.game.World;
import core.system.systems.MovementSystem;

/**
 * 
 */
public class JumpCommand implements Command {

    private String key;
    private boolean isKeyPressed;

    public JumpCommand(String key, boolean isKeyPressed) {
        this.key = key;
        this.isKeyPressed = isKeyPressed;
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
        world.getManager().getSystemManager().getSystem(MovementSystem.class).setKeyPressedEvent(isKeyPressed);
    }
}