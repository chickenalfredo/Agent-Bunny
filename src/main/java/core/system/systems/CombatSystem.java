package core.system.systems;

import core.component.AttackComponent;
import core.component.HealthComponent;
import core.component.StateComponent;
import core.component.WeaponComponent;
import core.component.state.ConcurrentState;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

public class CombatSystem extends SystemComponent {

    private static final long serialVersionUID = 1L;

    public CombatSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(false);
    }

    @Override
    public void update(long delta) {
        if (getRequester().getComponent(AttackComponent.class).attackOffCooldown(getRequester().getComponent(WeaponComponent.class).getCooldownTime())) {
            getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.ATTACKING);
            System.out.println("attacking...");
        } else {
            getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.NONE);
        }
        setNeedsUpdate(false);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(AttackComponent.class) != null && e.getComponent(HealthComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    @Override
    public void render(GraphicsContext gc, long time) {}

}
