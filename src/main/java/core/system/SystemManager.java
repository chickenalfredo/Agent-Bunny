package core.system;

import java.util.ArrayList;

import core.entity.EntityManager;
import core.game.World;
import core.system.systems.HeroAnimationSystem;
import core.system.systems.RenderSystem;
import javafx.scene.canvas.GraphicsContext;

public class SystemManager {

    private ArrayList<SystemComponent> m_systems = new ArrayList<SystemComponent>();

    public void init(EntityManager entityManager) {
        for (SystemComponent s : m_systems) {
            s.init(entityManager);
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

    public void enableSystem() {

    }

    public void disableSystem() {

    }

}
