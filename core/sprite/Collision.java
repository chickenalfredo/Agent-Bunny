package core.sprite;

/**
 * 
 */
public class Collision {
    
    /**
     * Returns whether a collision has occured between two static objects.
     */
    public boolean intersection() {}

    /**
     * Returns whether a collision has occured between a moving object and a static object
     */
    public boolean sweep() {}

    /**
     * Returns whether a collision has occured between an AABB and a point
     */
    public boolean intersectPoint(Coordinate point) {}

    /**
     * Returns whether a collision has occured between an AABB and a segment (raycast)
     */
    public boolean intersectsSegment(Coordinate pos, Coordinate delta, int paddingX, int paddingY) {}

    /**
     * Returns whether a collision has occured between two AABB objects
     */
    public boolean intersectAABB(Sprite box) {}

    /**
     * Returns whether a collision has occured between an AABB object and a swept AABB object
     */
    public boolean sweptAABB(Sprite box, Coordinate delta) {}

    /**
     * Returns whether a single object has swept into a static object
     */
    public boolean sweepInto(Sprite staticColliders, Coordinate delta) {}

}
