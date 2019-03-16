package core.command.commands;

import java.util.List;

import core.command.Command;
import core.external.entity.Hero;
import core.sprite.Sprite;
import core.utils.MenuEventHandlers;
import core.utils.MenuEventHandlers.OpenSettingsEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.event.Event;

public class MenuCommand extends Command {

    Button settings = new Button();

    public MenuCommand() {
        settings.setOnAction(new MenuEventHandlers.OpenSettingsEvent());
    }

    public void execute(Hero actor, List<Sprite> world) {
        Event.fireEvent(settings, new ActionEvent());
    }
}