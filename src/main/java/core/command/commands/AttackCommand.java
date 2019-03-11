package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;

public class AttackCommand extends Command {

    public AttackCommand() {}

    public void execute(Hero actor) {
        actor.attack();
    }
}