package core.physics.collision;

import core.component.components.DimensionComponent;
import core.component.components.PositionComponent;
import core.entity.GameObject;

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
     * Returns true or false, depending on whether the provided GameObject objects
     * intersect or not.
     * 
     * @return True or False
     */
    public boolean intersectAABB(GameObject boundingBoxA, GameObject boundingBoxB) {
        return boundingBoxA.getComponent(PositionComponent.class).getX() < boundingBoxB.getComponent(PositionComponent.class).getX() + boundingBoxB.getComponent(DimensionComponent.class).getWidth()
                && boundingBoxA.getComponent(PositionComponent.class).getX() + boundingBoxA.getComponent(DimensionComponent.class).getWidth() > boundingBoxB.getComponent(PositionComponent.class).getX()
                && boundingBoxA.getComponent(PositionComponent.class).getY() < boundingBoxB.getComponent(PositionComponent.class).getY() + boundingBoxB.getComponent(DimensionComponent.class).getHeight()
                && boundingBoxA.getComponent(PositionComponent.class).getY() + boundingBoxA.getComponent(DimensionComponent.class).getHeight() > boundingBoxB.getComponent(PositionComponent.class).getY();
    }

    /**
     * 
     * @param actor
     * @param collider
     * @return
     */
    public CollisionPacket collisionData(GameObject actor, GameObject collider) {
        return new CollisionPacket(actor, collider);
    }

}
