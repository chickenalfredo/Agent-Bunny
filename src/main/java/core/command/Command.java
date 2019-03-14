package core.command;

import java.util.List;

import core.external.entity.Hero;
import core.sprite.Sprite;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public abstract class Command {

    public Command() {}

    public abstract void execute(Hero hero, List<Sprite> world);

}
