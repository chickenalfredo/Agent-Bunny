package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;

public class MoveRightCommand extends Command {

    public MoveRightCommand() {}

    public void execute(Hero actor) {
        actor.move("d");
    }
}