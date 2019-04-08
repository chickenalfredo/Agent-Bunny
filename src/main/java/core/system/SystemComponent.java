package core.system;

import java.util.ArrayList;

import core.entity.Entity;
import core.entity.EntityManager;
import javafx.scene.layout.StackPane;

/**
 * An interface with the purpose of being implemented to define a child class as
 * a System type.
 */
public abstract class SystemComponent {

    private boolean enabled = true;
    private boolean needsUpdate = false;
    private boolean needsRender = false;
    private ArrayList<Entity> systemEntities = new ArrayList<Entity>();

    public abstract void init(EntityManager entityManager);

    /**
     * @return the systemEntities
     */
    public ArrayList<Entity> getSystemEntities() {
        return systemEntities;
    }

    public void setSystemEntities(ArrayList<Entity> m_entities) {
        systemEntities = m_entities;
    }

    public void addSystemEntity(Entity actor) {
        systemEntities.add(actor);
    }

    public void removeSystemEntity(Entity actor) {
        systemEntities.remove(actor);
    }

    /**
     * @return the needsUpdate
     */
    public boolean needsUpdate() {
        return needsUpdate;
    }

    /**
     * @param needsUpdate the needsUpdate to set
     */
    public void setNeedsUpdate(boolean needsUpdate) {
        this.needsUpdate = needsUpdate;
    }

    public boolean needsRender() {
		return needsRender;
    }
    
    public void setNeedsRender(boolean needsRender) {
        this.needsRender = needsRender;
    }

    /**
     * @return the enabled
     */
    public boolean enabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public abstract void preUpdate();

    public abstract void update(long delta);

    public abstract void postUpdate();

	public abstract void render(StackPane root, long time);

	

}
