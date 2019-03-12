package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;

public class HaltMoveLeftCommand extends Command {

    public HaltMoveLeftCommand() {}

    @Override
    public void execute(Hero actor) {
        actor.stopEntity("a");
    }
}
