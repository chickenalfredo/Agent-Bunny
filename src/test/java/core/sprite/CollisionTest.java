package core.sprite;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import core.sprite.*;

public class CollisionTest 
{

    @Test
    public void testIntersection() 
    {
        Collision c = new Collision();
        assertTrue(c.intersection());
    }

    @Test
    public void testSweep() 
    {
        Collision c = new Collision();
        assertTrue(c.sweep());
    }

    @Test
    public void testIntersectPoint() 
    {
        Collision c = new Collision();
        assertTrue(c.intersectPoint(new Coordinate(1, 1)));
    }

    @Test
    public void testIntersectRaySegment() 
    {
        Collision c = new Collision();
        assertTrue(c.intersectRaySegment(new Coordinate(1,2), new Coordinate(2,2), 1, 1));
    }

    @Test
    public void testIntersectAABB() 
    {
        Collision c = new Collision();
        assertTrue(c.intersectAABB(new Sprite(), new Sprite()));
    }

    @Test
    public void testSweptAABB() 
    {
        Collision c = new Collision();
        assertTrue(c.sweptAABB(new Sprite(), new Coordinate(2,2)));
    }

    @Test
    public void testSweepInto() 
    {
        Collision c = new Collision();
        assertTrue(c.sweepInto(new Sprite(), new Coordinate());
    }
    
}
