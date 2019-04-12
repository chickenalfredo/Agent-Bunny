package core.system;

import java.io.Serializable;
import java.util.ArrayList;

import core.entity.Entity;
import core.entity.EntityManager;
import core.game.World;
import javafx.scene.canvas.GraphicsContext;

/**
 * An interface with the purpose of being implemented to define a child class as
 * a System type.
 */
public abstract class SystemComponent implements Serializable {

    private static final long serialVersionUID = 1L;
    private Entity requester;
    private boolean enabled = true;
    private boolean needsUpdate = false;
    private boolean needsRender = false;
    private ArrayList<Entity> systemEntities = new ArrayList<Entity>();

    public abstract void init(EntityManager entityManager);

    /**
     * @return the requester
     */
    public Entity getRequester() {
        return requester;
    }

    /**
     * @param requester the requester to set
     */
    protected void setRequester(Entity requester) {
        this.requester = requester;
    }

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

    public void requestUpdate(Entity requester) {
        this.setRequester(requester);
        setNeedsUpdate(true);
    }

    public abstract void update(long delta, World world);

    public abstract void setDefaultState();

    public abstract void render(GraphicsContext gc, long time, World world);

}
