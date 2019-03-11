package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;

public class MoveLeftCommand extends Command {

    public MoveLeftCommand() {}

    public void execute(Hero actor) {
        actor.move("a");
    }
}