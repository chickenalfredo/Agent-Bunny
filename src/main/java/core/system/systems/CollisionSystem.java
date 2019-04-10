package core.system.systems;

import java.util.ArrayList;

import core.component.components.DimensionComponent;
import core.component.components.PhysicsComponent;
import core.component.components.PositionComponent;
import core.component.components.VelocityComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.entity.attributes.CollidableAttribute;
import core.entity.attributes.Type;
import core.entity.attributes.TypeAttribute;
import core.physics.collision.Collision;
import core.physics.collision.CollisionPacket;
import core.physics.collision.Side;
import core.system.SystemComponent;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.GraphicsContext;

public class CollisionSystem extends SystemComponent {

    private static ArrayList<Entity> static_entities = new ArrayList<Entity>();
    private static ArrayList<Entity> m_entities = new ArrayList<Entity>();

    public CollisionSystem() {
        setEnabled(true);
        setNeedsUpdate(true);
        setNeedsRender(false);
    }

    @Override
    public void update(long delta) {
        detectCollisionsWithWalls();
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
    public void render(GraphicsContext gc, long time) {}

    private void detectCollisionsWithWalls() {
        Collision collision = new Collision();
        for (Entity actor : m_entities) {
            for (Entity collider : static_entities) {
                if (collision.intersectAABB(actor, collider)) {
                    resolveWallCollision(actor, collider);
                }
            }
        }
    }

    private void resolveWallCollision(Entity actor, Entity collider) {
        CollisionPacket packet = new CollisionPacket(actor, collider);
        if (packet.getCollisionSide() == Side.TOP) {
            actor.getComponent(PositionComponent.class).setY(collider.getComponent(PositionComponent.class).getY()
                    - actor.getComponent(DimensionComponent.class).getHeight());
            actor.getComponent(VelocityComponent.class).setVelocityY(0);
            actor.getComponent(PhysicsComponent.class).setFalling(false);
            actor.getComponent(PhysicsComponent.class).setJumping(false);
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
                    + actor.getComponent(DimensionComponent.class).getWidth() + 1);
        }
        if (packet.getCollisionSide() == Side.LEFT) {
            actor.getComponent(PositionComponent.class).setX(collider.getComponent(PositionComponent.class).getX()
                    - actor.getComponent(DimensionComponent.class).getWidth() - 1);
        }
    }

}
