package core.sprite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Decoration extends Sprite {

    private boolean isCollidable;
    private Collision collisionDetection = new Collision();

    public Decoration() {}

    public Decoration(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public boolean getIsCollidable() {
        return isCollidable;
    }
y
    public void setIsCollidable(boolean isCollidable) {
        this.isCollidable = isCollidable;
    }

    public void collisionReaction(Sprite spriteCollidedWith) {
        
    }

    public String toString() {
        return this.getClass().getSimpleName() + " Object "
                + new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}