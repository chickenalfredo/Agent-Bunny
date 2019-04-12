package core.savablejfx;

import java.io.Serializable;

import javafx.scene.Group;
import javafx.scene.Node;

/**
 * Extension of the JavaFX Group class to allow for the implementation of the
 * Serialization interface
 */

public class SavableGroup extends Group implements Serializable {

    private static final long serialVersionUID = 1L;

    public SavableGroup() {
        super();
    }

    public SavableGroup(Node... children) {
        super(children);
    }
}