package core.system.systems;

import java.util.ArrayList;

import core.component.DimensionComponent;
import core.component.PhysicsComponent;
import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.VelocityComponent;
import core.component.state.ConcurrentState;
import core.entity.Entity;
import core.entity.EntityManager;
import core.entity.attributes.CollidableAttribute;
import core.entity.attributes.Type;
import core.entity.attributes.TypeAttribute;
import core.game.World;
import core.physics.Collision;
import core.physics.CollisionPacket;
import core.physics.Side;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

/**
 * This System will update all Entites with the Collidable attribute and with
 * the Dimension and Position components. This System specifically checks for
 * collisions between non-static entities vs static entities.
 */
public class CollisionSystem extends SystemComponent {

    private static final long serialVersionUID = 1L;
    private static transient ArrayList<Entity> static_entities;
    private static transient ArrayList<Entity> m_entities;

    /**
     * Constructs the CollisionSystem with the default values. By default, this
     * system will update on every frame
     */
    public CollisionSystem() {
        setDefaultState();
    }

    @Override
    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(true);
        setNeedsRender(false);
        m_entities = new ArrayList<Entity>();
        static_entities = new ArrayList<Entity>();
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getAttribute(CollidableAttribute.class).isCollidable()
                    && e.getComponent(DimensionComponent.class) != null
                    && e.getComponent(PositionComponent.class) != null) {
                addSystemEntity(e);
                if (e.getAttribute(TypeAttribute.class).getType() == Type.STATIC_OBJECT) {
                    static_entities.add(e);
                } else {
                    m_entities.add(e);
                }
            }
        }
    }

    @Override
    public void update(World world) {
        detectCollisionsWithWalls(world);
    }

    @Override
    public void render(GraphicsContext gc, World world) {
    }

    /**
     * Detects collisions between non-static entities and static entities
     * 
     * @param world
     */
    private void detectCollisionsWithWalls(World world) {
        Collision collision = new Collision();
        for (Entity actor : m_entities) {
            for (Entity collider : static_entities) {
                if (collision.intersectAABB(actor, collider)) {
                    resolveWallCollision(actor, collider);
                }
            }
        }
    }

    /**
     * Resolves all collisions between non-static and static entities. This will
     * ensure that an Entity cannot go through walls
     * 
     * @param actor
     * @param collider
     */
    private void resolveWallCollision(Entity actor, Entity collider) {
        CollisionPacket packet = new CollisionPacket(actor, collider);
        if (packet.getCollisionSide() == Side.TOP) {
            actor.getComponent(PositionComponent.class).setY(collider.getComponent(PositionComponent.class).getY()
                    - actor.getComponent(DimensionComponent.class).getHeight());
            actor.getComponent(VelocityComponent.class).setVelocityY(0);
            actor.getComponent(PhysicsComponent.class).setFalling(false);
            actor.getComponent(PhysicsComponent.class).setJumping(false);
            if (actor.getComponent(StateComponent.class).getConcurrentState() == ConcurrentState.FALLING) {
                actor.getComponent(StateComponent.class).setConcurrentState(ConcurrentState.NONE);
            }
        } else {
            actor.getComponent(PhysicsComponent.class).setFalling(true);
        }
        if (packet.getCollisionSide() == Side.BOTTOM) {
            actor.getComponent(PositionComponent.class).setY(collider.getComponent(PositionComponent.class).getY()
                    + actor.getComponent(DimensionComponent.class).getHeight());
            actor.getComponent(VelocityComponent.class).setVelocityY(0);
        }
        if (packet.getCollisionSide() == Side.RIGHT) {
            actor.getComponent(PositionComponent.class).setX(collider.getComponent(PositionComponent.class).getX()
                    + actor.getComponent(DimensionComponent.class).getWidth() + 9);
        }
        if (packet.getCollisionSide() == Side.LEFT) {
            actor.getComponent(PositionComponent.class).setX(collider.getComponent(PositionComponent.class).getX()
                    - actor.getComponent(DimensionComponent.class).getWidth() - 9);
        }
    }

    /**
     * Separates entities into their respective groups, non-static and static
     * 
     * @param entityManager
     */
    public void addEntities(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getAttribute(CollidableAttribute.class).isCollidable()
                    && e.getComponent(DimensionComponent.class) != null
                    && e.getComponent(PositionComponent.class) != null) {
                if (e.getAttribute(TypeAttribute.class).getType() == Type.STATIC_OBJECT) {
                    static_entities.add(e);
                } else {
                    m_entities.add(e);
                }
            }
        }
    }

}
