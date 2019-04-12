package core.command;

import core.entity.Entity;
import core.game.World;
import core.system.systems.CombatSystem;

/**
 * 
 */
public class AttackCommand implements Command {

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
        world.getManager().getSystemManager().getSystem(CombatSystem.class).requestUpdate(actor);
    }
}
