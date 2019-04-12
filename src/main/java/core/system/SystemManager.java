package core.system;

import java.io.Serializable;
import java.util.ArrayList;

import core.entity.EntityManager;
import core.system.systems.AnimationSystemComponent;
import core.system.systems.CollisionSystem;
import core.game.World;
import core.system.systems.HeroAnimationSystem;
import core.system.systems.RenderSystem;
import javafx.scene.canvas.GraphicsContext;

public class SystemManager implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<SystemComponent> m_systems = new ArrayList<SystemComponent>();

    public void init(EntityManager entityManager) {
        for (SystemComponent s : m_systems) {
            if (s.getSystemEntities().isEmpty()) {
                s.init(entityManager);
            } else if (s instanceof AnimationSystemComponent) {
                ((AnimationSystemComponent)s).initializeComponents(entityManager);
                s.setDefaultState();
            }else if (s instanceof CollisionSystem) {
                s.setDefaultState();
                ((CollisionSystem)s).addEntities(entityManager);
            }
        }
    }

    public void init(GraphicsContext gc) {
        for (SystemComponent s : m_systems) {
            if (s instanceof RenderSystem) {
                RenderSystem tmp = (RenderSystem) s;
                tmp.init(gc);
            } else if (s instanceof HeroAnimationSystem) {
                HeroAnimationSystem tmp = (HeroAnimationSystem) s;
                tmp.init(gc);
            }
        }
    }

    public void update(long delta, World world) {
        for (SystemComponent s : m_systems) {
            if (s.needsUpdate() && s.enabled())
                s.update(delta, world);
        }
    }

    public void render(GraphicsContext gc, long time, World world) {
        for (SystemComponent s : m_systems) {
            if (s.needsRender() && s.enabled()) {
                s.render(gc, time, world);
            }
        }
    }

    public void addSystems(SystemComponent... systems) {
        for (SystemComponent s : systems) {
            m_systems.add(s);
        }
    }

    public <T extends SystemComponent> T getSystem(Class<T> type) {
        for (SystemComponent c : m_systems) {
            if (type.isInstance(c)) {
                return type.cast(c);
            }
        }
        return null;
    }

    public ArrayList<SystemComponent> getSystemList() {
        return new ArrayList<SystemComponent>(m_systems);
    }

    public void enableSystem() {

    }

    public void disableSystem() {

    }

}
