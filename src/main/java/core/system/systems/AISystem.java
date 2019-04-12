package core.system.systems;

import core.component.AIComponent;
import core.component.StateComponent;
import core.component.VelocityComponent;
import core.component.state.Direction;
import core.component.state.State;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

public class AISystem extends SystemComponent {

    private static final long serialVersionUID = 1L;

    public AISystem() {
        setDefaultState();
    }

    @Override
    public void update(long delta) {
        System.out.println("Updating AI System...");
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(AIComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(true);
        setNeedsRender(false);
    }

    @Override
    public void render(GraphicsContext gc, long time) {}
    
    private void moveEntity(String direction) {
        switch (direction) {
            case "left":
                getRequester().getComponent(VelocityComponent.class).setVelocityX(0);
                getRequester().getComponent(VelocityComponent.class).setVelocityX(-15);
                getRequester().getComponent(StateComponent.class).setState(State.RUNNING);
                getRequester().getComponent(StateComponent.class).setDirection(Direction.LEFT);

                break;
            case "right":
                getRequester().getComponent(VelocityComponent.class).setVelocityX(0);
                getRequester().getComponent(VelocityComponent.class).setVelocityX(15);
                getRequester().getComponent(StateComponent.class).setState(State.RUNNING);
                getRequester().getComponent(StateComponent.class).setDirection(Direction.RIGHT);
                break;
            case "idle": 
                getRequester().getComponent(VelocityComponent.class).setVelocityX(0);
                getRequester().getComponent(StateComponent.class).setState(State.IDLE);
        }
    }
}
