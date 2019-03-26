package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;
import core.sprite.World;

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
    public void execute(Hero actor, World world) {
        actor.jump();
    }
}