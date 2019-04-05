package core.command.commands;

import core.command.Command;
import core.entity.Entity;
import core.game.World;

/**
 * 
 */
public class JumpCommand extends Command {

    public JumpCommand() {}

    /**
     * 
     * @param actor
     * @param world
     */
    @Override
    public void execute(Entity actor, World world) {
        // actor.jump();
        System.out.println("Jumping...");
    }
}