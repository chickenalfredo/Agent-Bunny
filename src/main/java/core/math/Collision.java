package core.math;

import core.sprite.Coordinate;
import core.sprite.Sprite;

/**
 * Collection of methods for detecting intersections between two objects
 * <source: https://noonat.github.io/intersect/>
 * <source: https://www.gamedev.net/articles/programming/general-and-gameplay-programming/swept-aabb-collision-detection-and-response-r3084>
 * 
 * @author Daniel Contreras
 */
public class Collision {

    /**
     * Returns whether a collision has occured between two static objects.
     */
    public boolean intersection() {
        return false;
    }

    /**
     * Returns whether a collision has occured between a moving object and a static
     * object
     */
    public boolean sweep() {
        return false;
    }

    /**
     * Returns whether a collision has occured between an AABB and a point
     */
    public boolean intersectPoint(Coordinate point) {
        return false;
    }

    /**
     * Returns whether a collision has occured between an AABB and a segment
     * (raycast)
     */
    public boolean intersectRaySegment(Coordinate pos, Coordinate delta, int paddingX, int paddingY) {
        return false;
    }

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
     * Returns whether a collision has occured between an AABB object and a swept
     * AABB object
     */
    public boolean sweptAABB(Sprite box, Coordinate delta) {
        return false;
    }

    /**
     * Returns whether a single object has swept into a static object
     */
    public boolean sweepInto(Sprite staticColliders, Coordinate delta) {
        return false;
    }

}
