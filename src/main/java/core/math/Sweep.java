package core.math;

import core.sprite.Coordinate;

public class Sweep {

    private Hit hit;
    private Coordinate pos;
    private double time;

    public Sweep() {
        hit = null;
        pos = new Coordinate();
        time = 1.0;
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
     * @return the hit
     */
    public Hit getHit() {
        return hit;
    }

    /**
     * @param hit
     *                the hit to set
     */
    public void setHit(Hit hit) {
        this.hit = hit;
    }

}
