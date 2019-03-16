package core.external.entity;

import core.sprite.AbstractEnemy;

public class Boss extends AbstractEnemy {

    public Boss(double x, double y, double width, double height) {
        super(x, y, width, height);
        setTerminalChar('B');
    }

    public Boss(double x, double y) {
        super(x, y);
    }
    
}
