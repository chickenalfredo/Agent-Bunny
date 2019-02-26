package core.sprite;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
        assertFalse(c.intersectAABB(new Sprite('a', 15, 20, 5, 5), new Sprite('b', 10, 20, 5, 5)));
    }

    @Test
    public void test_intersectAABB_from_the_top_with_no_collision() 
    {
        Collision c = new Collision();
        assertFalse(c.intersectAABB(new Sprite('a', 15, 20, 5, 5), new Sprite('b', 15, 25, 5, 5)));

    }

    @Test
    public void test_intersectAABB_from_the_right_with_no_collision() 
    {
        Collision c = new Collision();
        assertFalse(c.intersectAABB(new Sprite('a', 15, 20, 5, 5), new Sprite('b', 20, 20, 5, 5)));

    }

    @Test
    public void test_intersectAABB_from_the_bottom_with_no_collision() 
    {
        Collision c = new Collision();
        assertFalse(c.intersectAABB(new Sprite('a', 15, 20, 5, 5), new Sprite('b', 15, 15, 5, 5)));

    }

    @Test
    public void test_intersectAABB_from_the_left_with_collision() 
    {
        Collision c = new Collision();
        assertTrue(c.intersectAABB(new Sprite('a', 15, 20, 5, 5), new Sprite('b', 11, 20, 5, 5)));
    }

    @Test
    public void test_intersectAABB_from_the_top_with_collision() 
    {
        Collision c = new Collision();
        assertTrue(c.intersectAABB(new Sprite('a', 15, 20, 5, 5), new Sprite('b', 15, 24, 5, 5)));

    }

    @Test
    public void test_intersectAABB_from_the_right_with_collision() 
    {
        Collision c = new Collision();
        assertTrue(c.intersectAABB(new Sprite('a', 15, 20, 5, 5), new Sprite('b', 19, 20, 5, 5)));

    }

    @Test
    public void test_intersectAABB_from_the_bottom_with_collision() 
    {
        Collision c = new Collision();
        assertTrue(c.intersectAABB(new Sprite('a', 15, 20, 5, 5), new Sprite('b', 15, 16, 5, 5)));

    }

    @Test
    public void testSweptAABB() 
    {
        Collision c = new Collision();
        assertFalse(c.sweptAABB(new Sprite(), new Coordinate(2,2)));
    }

    @Test
    public void testSweepInto() 
    {
        Collision c = new Collision();
        assertFalse(c.sweepInto(new Sprite(), new Coordinate()));
    }
    
}
