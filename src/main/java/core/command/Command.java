package core.command;

import core.entity.Entity;
import core.game.World;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public abstract class Command {

    public Command() {}

    /**
     * 
     * @param hero
     * @param world
     */
    public abstract void execute(Entity hero, World world);

}
