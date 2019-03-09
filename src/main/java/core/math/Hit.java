package core.math;

import core.sprite.Coordinate;
import core.sprite.Sprite;

public class Hit {

    private Sprite collider;
    private Coordinate pos;
    private Coordinate delta;
    private Coordinate normal;
    private double time;

    public Hit(Sprite collider) {
        this.setCollider(collider);
        setPos(new Coordinate());
        setDelta(new Coordinate());
        setNormal(new Coordinate());
        setTime(0.0);
    }

    /**
     * @return the time
     */
    public double getTime() {
        return time;
    }

    /**
     * @param time
     *                 the time to set
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * @return the normal
     */
    public Coordinate getNormal() {
        return normal;
    }

    /**
     * @param normal
     *                   the normal to set
     */
    public void setNormal(Coordinate normal) {
        this.normal = normal;
    }

    /**
     * @return the delta
     */
    public Coordinate getDelta() {
        return delta;
    }

    /**
     * @param delta
     *                  the delta to set
     */
    public void setDelta(Coordinate delta) {
        this.delta = delta;
    }

    /**
     * @return the pos
     */
    public Coordinate getPos() {
        return pos;
    }

    /**
     * @param pos
     *                the pos to set
     */
    public void setPos(Coordinate pos) {
        this.pos = pos;
    }

    /**
     * @return the collider
     */
    public Sprite getCollider() {
        return collider;
    }

    /**
     * @param collider
     *                     the collider to set
     */
    public void setCollider(Sprite collider) {
        this.collider = collider;
    }

}
