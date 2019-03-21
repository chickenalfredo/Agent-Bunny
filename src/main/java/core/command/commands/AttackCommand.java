package core.command.commands;

import core.command.Command;
import core.external.entity.Hero;
import core.sprite.World;

public class AttackCommand extends Command {

    public AttackCommand() {}

    public void execute(Hero actor, World world) {
        actor.attackCollider(world);
    }
}