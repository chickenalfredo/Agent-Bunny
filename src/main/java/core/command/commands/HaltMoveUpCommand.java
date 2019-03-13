package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;

public class HaltMoveUpCommand extends Command {

    public HaltMoveUpCommand() {}

    @Override
    public void execute(Hero actor) {
        // actor.stopEntity("w");
    }
}
