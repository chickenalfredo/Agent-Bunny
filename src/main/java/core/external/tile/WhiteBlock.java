package main.java.core.external.tile;

import core.sprite.tile;

public class WhiteBlock extends Tile {

    public WhiteBlock(char terminalChar, float x, float y, float width, float height) {
        super(terminalChar, x, y, width, height);
        setIsCollidable(true);
    }
}