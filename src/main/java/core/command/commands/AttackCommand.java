package core.command.commands;

import core.command.Command;
import core.entity.Entity;
import core.game.World;

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
    public void execute(Entity actor, World world) {
        // actor.attackCollider(world);
        System.out.println("Attacking...");
    }
}
