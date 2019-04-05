package core.component.components;

import core.component.Component;
import core.component.state.*;

public class StateComponent implements Component {
    
    private State state;
    private ConcurrentState concurrentState;
    private Direction direction;

    /**
     * @return the state
     */
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

    /**
     * @return the concurrentState
     */
    public ConcurrentState getConcurrentState() {
        return concurrentState;
    }

    /**
     * @param concurrentState the concurrentState to set
     */
    public void setConcurrentState(ConcurrentState concurrentState) {
        this.concurrentState = concurrentState;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state) {
        this.state = state;
    }

}
