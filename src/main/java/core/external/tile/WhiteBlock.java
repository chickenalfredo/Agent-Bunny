package main.java.core.external.tile;

import core.sprite;

public class WhiteBlock extends Tile {

    public WhiteBlock(char terminalChar, float x, float y, float width, float height) {
        super(terminalChar, x, y, width, height);
        setIsCollidable(true);
    }

    public coolisionReaction(Entity spriteCollideWith) {
        if(spriteCollideWith.getCoordinate().getX() == this.getCoordinate().getX()+1) {
            spriteCollideWith.setCollision("Left");
        } else if(spriteCollideWith.getCoordinate().getX() == this.getCoordinate().getX()-1) {
            spriteCollideWith.setCollision("Right");
        } else if(spriteCollideWith.getCoordinate().getY() == this.getCoordinate().getY()+1) {
            spriteCollideWith.setCollision("Up");
        } else if(spriteCollideWith.getCoordinate().getY() == this.getCoordinate().getY()-1) {
            spriteCollideWith.setCollision("Down");
        }
    }
}