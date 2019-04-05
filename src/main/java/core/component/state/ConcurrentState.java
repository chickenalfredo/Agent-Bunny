package core.component.state;

/**
 * This class defines the different concurrent states of an Entity. That is, 
 * this state is meant to run concurrent to the State type.
 * 
 * @see State
 */
public enum ConcurrentState {
    ATTACKING, JUMPING, FALLING, NONE
}
