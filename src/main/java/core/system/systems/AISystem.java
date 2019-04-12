package core.system.systems;

import core.component.AIComponent;
import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.VelocityComponent;
import core.component.WeaponComponent;
import core.component.state.Direction;
import core.component.state.State;
import core.entity.Entity;
import core.entity.EntityManager;
import core.scenes.GameScene;
import core.game.World;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

public class AISystem extends SystemComponent {

    private static final long serialVersionUID = 1L;
    private double range = (GameScene.screenWidth * 0.3125);

    public AISystem() {
        setDefaultState();
    }

    @Override
    public void update(long delta, World world) {
        for (Entity e : getSystemEntities()) {
            if (isInRange(e))
                moveEntity(e);
            else
                stayIdle(e);
        }
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(AIComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(true);
        setNeedsRender(false);
    }

    public void render(GraphicsContext gc, long time, World world) {
    }

    public void moveEntity(Entity e) {
        
        String direction = Position(e);

        switch (direction) {
        case "left":
            e.getComponent(VelocityComponent.class).setVelocityX(0);
            e.getComponent(VelocityComponent.class).setVelocityX(-5);
            e.getComponent(StateComponent.class).setState(State.RUNNING);
            e.getComponent(StateComponent.class).setDirection(Direction.RIGHT);
            break;
        case "right":
            e.getComponent(VelocityComponent.class).setVelocityX(0);
            e.getComponent(VelocityComponent.class).setVelocityX(5);
            e.getComponent(StateComponent.class).setState(State.RUNNING);
            e.getComponent(StateComponent.class).setDirection(Direction.LEFT);
            break;
        case "on":
            e.getComponent(VelocityComponent.class).setVelocityX(0);
            e.getComponent(StateComponent.class).setConcurrentState(ConcurrentState.ATTACKING);
            world.getManager().getSystemManager().getSystem(CombatSystem.class).requestUpdate(e);
        }
    }

    public void stayIdle(Entity e) {
        e.getComponent(VelocityComponent.class).setVelocityX(0);
        e.getComponent(StateComponent.class).setState(State.IDLE);
    }

    private String Position(Entity e) {
        if (e.getComponent(PositionComponent.class).getX() + e.getComponent(WeaponComponent.class)
                .getAttackRange() > GameScene.getWorld().getHero().getComponent(PositionComponent.class).getX())
            return "right";
        else if (e.getComponent(PositionComponent.class).getX() + e.getComponent(WeaponComponent.class)
                .getAttackRange() < GameScene.getWorld().getHero().getComponent(PositionComponent.class).getX())
            return "left";
        else return "on"
    }

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
