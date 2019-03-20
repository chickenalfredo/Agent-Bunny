package core.command;

import core.external.entity.Hero;
import core.sprite.World;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public abstract class Command {

    public Command() {}

    public abstract void execute(Hero hero, World world);

}
