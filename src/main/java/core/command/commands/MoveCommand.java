package core.command.commands;

import java.util.List;

import core.command.Command;
import core.external.entity.Hero;
import core.sprite.Sprite;

public class MoveCommand extends Command {

    private String key;
    private boolean isKeyPressedEvent;

    public MoveCommand(String key, boolean isKeyPressedEvent) {
        this.key = key;
        this.isKeyPressedEvent = isKeyPressedEvent;
    }

    @Override
    public void execute(Hero actor, List<Sprite> world) {
        actor.move(key, isKeyPressedEvent);
    }
}
