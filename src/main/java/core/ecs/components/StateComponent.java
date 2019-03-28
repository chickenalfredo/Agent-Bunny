package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.external.entity.Hero;
import core.sprite.Sprite;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

public class StateComponent extends Component implements Serializable {

    private static final long serialVersionUID = -4659225797520082884L;

    public enum State {
        RUNNING, IDLE, 
    }

    public enum ConcurrentState {
        ATTACKING, JUMPING, FALLING, NONE
    }

    public enum Direction {
        LEFT, RIGHT
    }

    private State state;
    private ConcurrentState concurrentState;
    private Direction direction;

    public State getState() {
        return state;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setState(State state) {
        this.state = state;
    }


    public ConcurrentState getConcurrentState() {
        return concurrentState;
    }

    public void setConcurrentState(ConcurrentState concurrentState) {
        this.concurrentState = concurrentState;
    }

    @Override
    public void update(Sprite actor, World world) {
        // if (actor instanceof Hero)
        //     System.out.println(actor.getClass().getSimpleName() + " : " + getState());
    }

    @Override
    public void render(Sprite actor, GraphicsContext gc, long delta) {

    }
   
}
