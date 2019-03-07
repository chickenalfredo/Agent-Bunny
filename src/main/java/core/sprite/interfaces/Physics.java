package core.sprite.interfaces;

import core.sprite.Sprite;

public interface Physics {

    public static final double GRAVITY = 9.8;

    public abstract void collisionResolution(Sprite sprite);

}
