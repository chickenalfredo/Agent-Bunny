package core.math;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import core.sprite.Coordinate;
import core.external.entity.Player;

public class CollisionTest 
{

    @Test
    public void testIntersection() 
    {
        Collision c = new Collision();
        assertFalse(c.intersection());
    }

    @Test
    public void testSweep() 
    {
        Collision c = new Collision();
        assertFalse(c.sweep());
    }

    @Test
    public void testIntersectPoint() 
    {
        Collision c = new Collision();
        assertFalse(c.intersectPoint(new Coordinate(1, 1)));
    }

    @Test
    public void testIntersectRaySegment() 
    {
        Collision c = new Collision();
        assertFalse(c.intersectRaySegment(new Coordinate(1,2), new Coordinate(2,2), 1, 1));
    }

    @Test
    public void test_intersectAABB_from_the_left_with_no_collision() 
    {
        Collision c = new Collision();
        assertFalse(c.intersectAABB(new Player(15.0, 20.0, 5.0, 5.0, 'x', "a", 1, 1.0), new Player(10.0, 20.0, 5.0, 5.0, 'x', "b", 1, 1.0)));
    }

    @Test
    public void test_intersectAABB_from_the_top_with_no_collision() 
    {
        Collision c = new Collision();
        assertFalse(c.intersectAABB(new Player(15.0, 20.0, 5.0, 5.0, 'x', "a", 1, 1.0), new Player(15.0, 25.0, 5.0, 5.0, 'x', "b", 1, 1.0)));

    }

    @Test
    public void test_intersectAABB_from_the_right_with_no_collision() 
    {
        Collision c = new Collision();
        assertFalse(c.intersectAABB(new Player(15.0, 20.0, 5.0, 5.0, 'x', "a", 1, 1.0), new Player(20.0, 20.0, 5.0, 5.0, 'x', "b", 1, 1.0)));

    }

    @Test
    public void test_intersectAABB_from_the_bottom_with_no_collision() 
    {
        Collision c = new Collision();
        assertFalse(c.intersectAABB(new Player(15.0, 20.0, 5.0, 5.0, 'x', "a", 1, 1.0), new Player(15.0, 15.0, 5.0, 5.0, 'x', "b", 1, 1.0)));

    }

    @Test
    public void test_intersectAABB_from_the_left_with_collision() 
    {
        Collision c = new Collision();
        assertTrue(c.intersectAABB(new Player(15.0, 20.0, 5.0, 5.0, 'x', "a", 1, 1.0), new Player(11.0, 20.0, 5.0, 5.0, 'x', "b", 1, 1.0)));
    }

    @Test
    public void test_intersectAABB_from_the_top_with_collision() 
    {
        Collision c = new Collision();
        assertTrue(c.intersectAABB(new Player(15.0, 20.0, 5.0, 5.0, 'x', "a", 1, 1.0), new Player(15.0, 24.0, 5.0, 5.0, 'x', "b", 1, 1.0)));

    }

    @Test
    public void test_intersectAABB_from_the_right_with_collision() 
    {
        Collision c = new Collision();
        assertTrue(c.intersectAABB(new Player(15.0, 20.0, 5.0, 5.0, 'x', "a", 1, 1.0), new Player(19.0, 20.0, 5.0, 5.0, 'x', "b", 1, 1.0)));

    }

    @Test
    public void test_intersectAABB_from_the_bottom_with_collision() 
    {
        Collision c = new Collision();
        assertTrue(c.intersectAABB(new Player(15.0, 20.0, 5.0, 5.0, 'x', "a", 1, 1.0), new Player(15.0, 16.0, 5.0, 5.0, 'x', "b", 1, 1.0)));

    }

    @Test
    public void testSweptAABB() 
    {
        Collision c = new Collision();
        assertFalse(c.sweptAABB(new Player(15.0, 20.0, 5.0, 5.0, 'x', "a", 1, 1.0), new Coordinate(2,2)));
    }

    @Test
    public void testSweepInto() 
    {
        Collision c = new Collision();
        assertFalse(c.sweepInto(new Player(15.0, 20.0, 5.0, 5.0, 'x', "a", 1, 1.0), new Coordinate()));
    }
    
}
