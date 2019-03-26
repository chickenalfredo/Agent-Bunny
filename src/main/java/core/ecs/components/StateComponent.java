package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.sprite.Sprite;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

public class StateComponent extends Component implements Serializable {

    private static final long serialVersionUID = -4659225797520082884L;

    public enum State {
        RUNNING, JUMPING, FALLING, IDLE, ATTACKING
    }

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void update(Sprite actor, World world) {
        // System.out.println(actor.getClass().getSimpleName() + " : " + getState());
    }

    @Override
    public void render(Sprite actor, GraphicsContext gc, long delta) {

    }
   
}
