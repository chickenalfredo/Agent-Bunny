package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;

public class DoubleJumpCommand extends Command {

    public DoubleJumpCommand() {}

    public void execute(Hero actor) {
        actor.doubleJump();
    }
}