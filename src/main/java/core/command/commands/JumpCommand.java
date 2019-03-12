package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;

public class JumpCommand extends Command {

    public JumpCommand() {}

    public void execute(Hero actor) {
        actor.jump();
    }
}