package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;

public class MoveUpCommand extends Command {

    public MoveUpCommand() {}

    @Override
    public void execute(Hero actor) {
        // actor.move("w");
    }
}
