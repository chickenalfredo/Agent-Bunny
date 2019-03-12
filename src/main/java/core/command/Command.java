package core.command;

import core.external.entity.Hero;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public abstract class Command {

    public Command() {}

    public abstract void execute(Hero hero);

}
