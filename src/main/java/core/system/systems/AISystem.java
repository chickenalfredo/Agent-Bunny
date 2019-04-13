package core.system.systems;

import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.VelocityComponent;
import core.component.WeaponComponent;
import core.component.state.ConcurrentState;
import core.component.state.Direction;
import core.component.state.State;
import core.entity.Entity;
import core.entity.EntityManager;
import core.entity.attributes.Type;
import core.entity.attributes.TypeAttribute;
import core.scenes.GameScene;
import core.game.World;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

/**
 * This System defines all actions and scripts that an AI entity will follow. This 
 * System handles attacks, movements and states of the AI.
 */
public class AISystem extends SystemComponent {

    private static final long serialVersionUID = 1L;
    private double range = (GameScene.screenWidth * 0.3125);

    public AISystem() {
        setDefaultState();
    }

    @Override
    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(true);
        setNeedsRender(false);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getAttribute(TypeAttribute.class).getType() == Type.ENEMY) {
                addSystemEntity(e);
            }
        }
    }

    @Override
    public void update(World world) {
        for (Entity e : world.getEntities()) {
            if (e.getAttribute(TypeAttribute.class).getType() == Type.ENEMY) {
                if (isInRange(e))
                    moveEntity(e, world);
                else
                    stayIdle(e);
            }
        }
    }

    @Override
    public void render(GraphicsContext gc, World world) {
    }

    /**
     * Moves the AI
     * @param e
     * @param world
     */
    public void moveEntity(Entity e, World world) {

        String direction = Position(e);

        switch (direction) {
        case "left":
            e.getComponent(VelocityComponent.class).setVelocityX(0);
            e.getComponent(VelocityComponent.class).setVelocityX(-5);
            e.getComponent(StateComponent.class).setState(State.RUNNING);
            e.getComponent(StateComponent.class).setDirection(Direction.LEFT);
            break;
        case "right":
            e.getComponent(VelocityComponent.class).setVelocityX(0);
            e.getComponent(VelocityComponent.class).setVelocityX(5);
            e.getComponent(StateComponent.class).setState(State.RUNNING);
            e.getComponent(StateComponent.class).setDirection(Direction.RIGHT);
            break;
        case "on":
            e.getComponent(VelocityComponent.class).setVelocityX(0);
            e.getComponent(StateComponent.class).setConcurrentState(ConcurrentState.ATTACKING);
            world.getManager().getSystemManager().getSystem(CombatSystem.class).requestUpdate(e);

        }
    }

    /**
     * Sets the AI's state to idle
     * @param e
     */
    public void stayIdle(Entity e) {
        e.getComponent(VelocityComponent.class).setVelocityX(0);
        e.getComponent(StateComponent.class).setState(State.IDLE);
    }

    /**
     * @param e
     * @return  the position of the Entity relative to the Hero
     */
    private String Position(Entity e) {
        if (e.getComponent(PositionComponent.class).getX() + e.getComponent(WeaponComponent.class)
                .getAttackRange() < GameScene.getWorld().getHero().getComponent(PositionComponent.class).getX())
            return "right";
        else if (e.getComponent(PositionComponent.class).getX() + e.getComponent(WeaponComponent.class)
                .getAttackRange() > GameScene.getWorld().getHero().getComponent(PositionComponent.class).getX())
            return "left";
        else
            return "on";
    }

    /**
     * Checks if the Entity is in range of the AI
     * @param e
     * @return
     */
    private boolean isInRange(Entity e) {
        if ((e.getComponent(PositionComponent.class).getX()
                - GameScene.getWorld().getHero().getComponent(PositionComponent.class).getX() <= range
                || GameScene.getWorld().getHero().getComponent(PositionComponent.class).getX()
                        - e.getComponent(PositionComponent.class).getX() >= -range)
                && e.getComponent(PositionComponent.class).getY() == GameScene.getWorld().getHero()
                        .getComponent(PositionComponent.class).getY())
            return true;
        else
            return false;
    }
}
