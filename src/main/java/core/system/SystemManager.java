package core.system;

import java.util.ArrayList;

import core.entity.EntityManager;
import core.system.systems.AnimationSystem;
import core.system.systems.RenderSystem;
import javafx.scene.layout.StackPane;

public class SystemManager {

    private ArrayList<SystemComponent> m_systems = new ArrayList<SystemComponent>();

    public void init(EntityManager entityManager) {
        for (SystemComponent s : m_systems) {
            s.init(entityManager);
        }
    }

    public void init(StackPane root) {
        for (SystemComponent s : m_systems) {
            if (s instanceof RenderSystem) {
                RenderSystem tmp = (RenderSystem) s;
                tmp.init(root);
            } else if (s instanceof AnimationSystem) {
                AnimationSystem tmp = (AnimationSystem) s;
                tmp.init(root);
            }
        }
    }

    public void update(long delta) {
        for (SystemComponent s : m_systems) {
            if (s.needsUpdate() && s.enabled())
                s.update(delta);
        }
    }

    public void render(StackPane root, long time) {
        for (SystemComponent s : m_systems) {
            if (s.needsRender() && s.enabled()) {
                s.render(root, time);
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
