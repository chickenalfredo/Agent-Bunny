package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;

public class HaltMoveRightCommand extends Command {

    public HaltMoveRightCommand() {}

    @Override
    public void execute(Hero actor) {
        actor.stopEntity("d");
    }
}
