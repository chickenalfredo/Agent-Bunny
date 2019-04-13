package core.command;

import core.entity.Entity;
import core.game.World;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public interface Command {

    /**
     * Execute the command of the specified Command object
     * 
     * @param hero
     * @param world
     */
    public abstract void execute(Entity hero, World world);

}
