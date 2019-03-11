package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;

public class DashCommand extends Command {

    public DashCommand() {}

    public void execute(Hero actor) {
        actor.dash();
    }
}