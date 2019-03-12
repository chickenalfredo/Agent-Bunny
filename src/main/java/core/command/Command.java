package core.command;

import core.external.entity.Hero;

public abstract class Command {

    public Command() {}

    public abstract void execute(Hero hero);

}
