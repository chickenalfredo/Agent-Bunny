package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;
import core.sprite.World;

/**
 * 
 */
public class AttackCommand extends Command {

    private boolean isKeyPressed;

    /**
     * 
     * @param isKeyPressed
     */
    public AttackCommand(boolean isKeyPressed) {
        this.isKeyPressed = isKeyPressed;
    }

    /**
     * 
     * @param actor
     * @param world
     */
    @Override
    public void execute(Hero actor, World world) {
        if (isKeyPressed)
            actor.attackCollider(world);
    }
}
