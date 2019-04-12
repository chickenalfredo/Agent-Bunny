package core.system.systems;

import core.component.WeaponComponent;

import java.io.File;

import core.component.DimensionComponent;
import core.component.HealthComponent;
import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.state.ConcurrentState;
import core.component.state.Direction;
import core.entity.Entity;
import core.entity.EntityManager;
import core.game.World;
import core.physics.Collision;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CombatSystem extends SystemComponent {

    private static Image projectile = new Image(
            new File("resources/assets/Hero/projectile/Beam_Thin.png").toURI().toString());

    private static final long serialVersionUID = 1L;

    public CombatSystem() {
        setDefaultState();
    }

    @Override
    public void update(long delta, World world) {
        updateWeapon(world);
        if (getRequester() != null) {
            if (getRequester().getComponent(WeaponComponent.class).attackOffCooldown()) {
                getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.ATTACKING);
                for (Entity e : world.getEntities()) {
                    if (!e.equals(getRequester())) {
                        checkCollisions(getRequester(), e);
                    }
                }
            } else {
                getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.NONE);
            }
        }
        setNeedsUpdate(false);
        setNeedsRender(true);
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
        for (Entity e : world.getEntities()) {
            if (e.getComponent(WeaponComponent.class) != null) {
                gc.drawImage(projectile,
                        e.getComponent(WeaponComponent.class).getWeapon().getComponent(PositionComponent.class).getX(),
                        e.getComponent(WeaponComponent.class).getWeapon().getComponent(PositionComponent.class).getY()
                                + 15,
                        e.getComponent(WeaponComponent.class).getWeapon().getComponent(DimensionComponent.class)
                                .getWidth(),
                        e.getComponent(WeaponComponent.class).getWeapon().getComponent(DimensionComponent.class)
                                .getHeight());
            }
        }
        setNeedsRender(false);
    }

    private void updateWeapon(World world) {
        for (Entity e : world.getEntities()) {
            if (e.getComponent(WeaponComponent.class) != null) {
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
    }

    private void checkCollisions(Entity attacker, Entity collider) {
        Collision collision = new Collision();
        if (collision.intersectAABB(attacker.getComponent(WeaponComponent.class).getWeapon(), collider)) {
            resolveCombat(attacker, collider);
        }
    }

    private void resolveCombat(Entity attacker, Entity collider) {
        if (collider.getComponent(HealthComponent.class) != null) {
            collider.getComponent(HealthComponent.class)
                    .takeDamage(attacker.getComponent(WeaponComponent.class).getAttackDamage());
        }

    }

}
