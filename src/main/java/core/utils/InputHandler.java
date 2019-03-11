package core.utils;

import javafx.event.EventHandler;
import javafx.scene.input.*;

public class InputHandler { 

    public static class KeyPressed implements EventHandler<KeyEvent> {
        public void handle(KeyEvent key) {
            switch(key.getCode()) {

                case W:
                case A:
                case S:
                case D:

                case ESCAPE:

                case SPACE:
                


            }
        }
    }

    public static class MouseClick implements EventHandler<MouseEvent> {
        public void handle(MouseEvent click) {
            if (click.isPrimaryButtonDown()) {

            } else if (click.isSecondaryButtonDown()) {

            }
        }

    }
}
