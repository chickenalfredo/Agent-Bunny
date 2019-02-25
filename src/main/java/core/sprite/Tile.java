package core.sprite;

public class Tile extends Sprite {

    private boolean isCollidable;

    public Tile() {}

    public Tile(char terminalChar, float x, float y, float width, float height) {
        super(terminalChar, x, y, width, height);
    }

    public boolean getIsCollidable() {
        return isCollidable;
    }

    public void setIsCollidable(boolean isCollidable) {
        this.isCollidable = isCollidable;
    }
}
