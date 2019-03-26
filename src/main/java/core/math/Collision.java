package core.math;

import core.sprite.Sprite;

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
     * Returns true or false, depending on whether the provided Sprite objects
     * intersect or not.
     * 
     * @return True or False
     */
    public boolean intersectAABB(Sprite boundingBoxA, Sprite boundingBoxB) {
        return boundingBoxA.getX() < boundingBoxB.getX() + boundingBoxB.getWidth()
                && boundingBoxA.getX() + boundingBoxA.getWidth() > boundingBoxB.getX()
                && boundingBoxA.getY() < boundingBoxB.getY() + boundingBoxB.getHeight()
                && boundingBoxA.getY() + boundingBoxA.getHeight() > boundingBoxB.getY();
    }

    /**
     * 
     * @param actor
     * @param collider
     * @return
     */
    public CollisionPacket collisionData(Sprite actor, Sprite collider) {
        return new CollisionPacket(actor, collider);
    }

}
