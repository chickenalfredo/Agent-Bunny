package core.command.commands;

import java.util.List;

import core.command.Command;
import core.external.entity.Hero;
import core.sprite.Sprite;

public class HaltMoveLeftCommand extends Command {

    public HaltMoveLeftCommand() {}

    @Override
    public void execute(Hero actor, List<Sprite> world) {
        actor.stopEntity("a");
    }
}
