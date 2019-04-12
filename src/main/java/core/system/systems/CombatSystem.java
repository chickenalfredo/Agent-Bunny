package core.system.systems;

import core.component.WeaponComponent;
import core.component.DimensionComponent;
import core.component.HealthComponent;
import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.state.ConcurrentState;
import core.component.state.Direction;
import core.entity.Entity;
import core.entity.EntityManager;
import core.entity.attributes.NameAttribute;
import core.game.World;
import core.physics.Collision;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CombatSystem extends SystemComponent {

    private static final long serialVersionUID = 1L;

    public CombatSystem() {
        setDefaultState();
    }

    @Override
    public void update(long delta, World world) {
        updateWeapon();
        if (getRequester() != null) {
            if (getRequester().getComponent(WeaponComponent.class).attackOffCooldown()) {
                getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.ATTACKING);
                for (Entity e : getSystemEntities()) {
                    if (!e.equals(getRequester())) {
                        checkCollisions(getRequester(), e);
                    }
                }
            } else {
                getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.NONE);
            }
        }
        setNeedsUpdate(false);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(WeaponComponent.class) != null && e.getComponent(HealthComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(false);
    }

    @Override
    public void render(GraphicsContext gc, long time, World world) {
        for (Entity e : getSystemEntities()) {
            gc.setFill(Color.GREEN);
            gc.fillRect(e.getComponent(WeaponComponent.class).getWeapon().getComponent(PositionComponent.class).getX(),
                    e.getComponent(WeaponComponent.class).getWeapon().getComponent(PositionComponent.class).getY(),
                    e.getComponent(WeaponComponent.class).getWeapon().getComponent(DimensionComponent.class).getWidth(),
                    e.getComponent(WeaponComponent.class).getWeapon().getComponent(DimensionComponent.class)
                            .getHeight());
        }
        setNeedsRender(false);
    }

    private void updateWeapon() {
        for (Entity e : getSystemEntities()) {
            if (e.getComponent(StateComponent.class).getDirection() == Direction.RIGHT) {
                e.getComponent(WeaponComponent.class).getWeapon().getComponent(PositionComponent.class)
                        .setX(e.getComponent(PositionComponent.class).getX()
                                + e.getComponent(DimensionComponent.class).getWidth());
            } else {
                e.getComponent(WeaponComponent.class).getWeapon().getComponent(PositionComponent.class)
                        .setX(e.getComponent(PositionComponent.class).getX() - e.getComponent(WeaponComponent.class)
                                .getWeapon().getComponent(DimensionComponent.class).getWidth());
            }
            e.getComponent(WeaponComponent.class).getWeapon().getComponent(PositionComponent.class)
                    .setY(e.getComponent(PositionComponent.class).getY());
        }
    }

    private void checkCollisions(Entity attacker, Entity collider) {
        Collision collision = new Collision();
        if (collision.intersectAABB(attacker.getComponent(WeaponComponent.class).getWeapon(), collider)) {
            resolveCombat(attacker, collider);
        }
    }

    private void resolveCombat(Entity attacker, Entity collider) {
        System.out.println(collider.getAttribute(NameAttribute.class).getName() + " : "
                + collider.getComponent(HealthComponent.class).getCurrentHP());
        collider.getComponent(HealthComponent.class)
                .takeDamage(attacker.getComponent(WeaponComponent.class).getAttackDamage());
    }

}
