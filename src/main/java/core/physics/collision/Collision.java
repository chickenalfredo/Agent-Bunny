package core.physics.collision;

import core.component.components.DimensionComponent;
import core.component.components.PositionComponent;
import core.entity.Entity;

/**
 * Collection of methods for detecting intersections between two objects
 * <source: https://noonat.github.io/intersect/> <source:
 * https://www.gamedev.net/articles/programming/general-and-gameplay-programming/swept-aabb-collision-detection-and-response-r3084>
 * 
 * @author Daniel Contreras
 */
public class Collision {

    public Collision() {}

    /**
     * Returns true or false, depending on whether the provided Entity objects
     * intersect or not.
     * 
     * @return True or False
     */
    public boolean intersectAABB(Entity boundingBoxA, Entity boundingBoxB) {
        return boundingBoxA.getComponent(PositionComponent.class).getX() < boundingBoxB.getComponent(PositionComponent.class).getX() + boundingBoxB.getComponent(DimensionComponent.class).getWidth()
                && boundingBoxA.getComponent(PositionComponent.class).getX() + boundingBoxA.getComponent(DimensionComponent.class).getWidth() > boundingBoxB.getComponent(PositionComponent.class).getX()
                && boundingBoxA.getComponent(PositionComponent.class).getY() < boundingBoxB.getComponent(PositionComponent.class).getY() + boundingBoxB.getComponent(DimensionComponent.class).getHeight()
                && boundingBoxA.getComponent(PositionComponent.class).getY() + boundingBoxA.getComponent(DimensionComponent.class).getHeight() > boundingBoxB.getComponent(PositionComponent.class).getY();
    }

    /**
     * Returns a packet of information regarding the collision. The packet will
     * include the side the collision occured and who was involved in the collision
     * 
     * @param actor
     * @param collider
     * @return
     */
    public CollisionPacket collisionData(Entity actor, Entity collider) {
        return new CollisionPacket(actor, collider);
    }

}
