package core.system.systems;

import core.component.components.PositionComponent;
import core.component.components.StateComponent;
import core.component.components.VelocityComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.layout.StackPane;

public class MovementSystem extends SystemComponent {

    private String key;
    private boolean isKeyPressedEvent;

    public MovementSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(false);
    }

    /**
     * @return the isKeyPressedEvent
     */
    public boolean isKeyPressedEvent() {
        return isKeyPressedEvent;
    }

    /**
     * @param isKeyPressedEvent the isKeyPressedEvent to set
     */
    public void setKeyPressedEvent(boolean isKeyPressedEvent) {
        this.isKeyPressedEvent = isKeyPressedEvent;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public void update(long delta) {
        moveEntity(key, isKeyPressedEvent);
        setNeedsUpdate(false);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(VelocityComponent.class) != null && e.getComponent(PositionComponent.class) != null
                    && e.getComponent(StateComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    @Override
    public void render(StackPane root, long time) {

    }

    private void moveEntity(String key, boolean isKeyPressedEvent) {
        if (isKeyPressedEvent) {
            switch (key) {
                case "a":
                    getRequester().getComponent(VelocityComponent.class).setVelocityX(0);
                    getRequester().getComponent(VelocityComponent.class).setVelocityX(-10);
                    break;
                case "d":
                    getRequester().getComponent(VelocityComponent.class).setVelocityX(0);
                    getRequester().getComponent(VelocityComponent.class).setVelocityX(10);
                    break;
            }
        } else {
            getRequester().getComponent(VelocityComponent.class).setVelocityX(0);
        }
    }

}
