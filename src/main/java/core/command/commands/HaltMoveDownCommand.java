package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;

public class HaltMoveDownCommand extends Command {

    public HaltMoveDownCommand() {}

    @Override
    public void execute(Hero actor) {
        actor.stopEntity("s");
    }
}
