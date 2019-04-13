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

    /**
     * Sets the systems entities that it will need to update
     * 
     * @param m_entities
     */
    public void setSystemEntities(ArrayList<Entity> m_entities) {
        systemEntities = m_entities;
    }

    /**
     * Adds an entity to the System Entity list
     * 
     * @param actor
     */
    public void addSystemEntity(Entity actor) {
        systemEntities.add(actor);
    }

    /**
     * Removes the specified Entity from the System Entity list
     * 
     * @param actor
     */
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

    /**
     * @return true or false if the System needs a render update
     */
    public boolean needsRender() {
        return needsRender;
    }

    /**
     * Set whether or not this System requires a render update
     * 
     * @param needsRender
     */
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

    /**
     * Sets the specified Entity as the Entity who has initialized a request for a
     * System update. This will set a flag to true in this System and will therefore
     * begin to update
     * 
     * @param requester
     */
    public void requestUpdate(Entity requester) {
        this.setRequester(requester);
        setNeedsUpdate(true);
    }

    /**
     * Updates this System
     * 
     * @param world
     */
    public abstract void update(World world);

    /**
     * Sets the default state of the system. By default all Systems are enabled but
     * not all Systems are set to update or to render
     */
    public abstract void setDefaultState();

    /**
     * Renders this System
     * 
     * @param gc
     * @param world
     */
    public abstract void render(GraphicsContext gc, World world);

}
