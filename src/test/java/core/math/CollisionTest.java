// package core.math;

// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertTrue;

// import org.junit.Test;
// import core.external.entity.Hero;

// public class CollisionTest 
// {

//     @Test
//     public void test_intersectAABB_from_the_left_with_no_collision() 
//     {
//         Collision c = new Collision();
//         assertFalse(c.intersectAABB(new Hero(15.0, 20.0, 5.0, 5.0), new Hero(10.0, 20.0, 5.0, 5.0)));
//     }

//     @Test
//     public void test_intersectAABB_from_the_top_with_no_collision() 
//     {
//         Collision c = new Collision();
//         assertFalse(c.intersectAABB(new Hero(15.0, 20.0, 5.0, 5.0), new Hero(15.0, 25.0, 5.0, 5.0)));

//     }

//     @Test
//     public void test_intersectAABB_from_the_right_with_no_collision() 
//     {
//         Collision c = new Collision();
//         assertFalse(c.intersectAABB(new Hero(15.0, 20.0, 5.0, 5.0), new Hero(20.0, 20.0, 5.0, 5.0)));

//     }

//     @Test
//     public void test_intersectAABB_from_the_bottom_with_no_collision() 
//     {
//         Collision c = new Collision();
//         assertFalse(c.intersectAABB(new Hero(15.0, 20.0, 5.0, 5.0), new Hero(15.0, 15.0, 5.0, 5.0)));

//     }

//     @Test
//     public void test_intersectAABB_from_the_right_with_collision() 
//     {
//         Collision c = new Collision();
//         assertTrue(c.intersectAABB(new Hero(15.0, 20.0, 5.0, 5.0), new Hero(11.0, 20.0, 5.0, 5.0)));
//     }

//     @Test
//     public void test_intersectAABB_from_the_top_with_collision() 
//     {
//         Collision c = new Collision();
//         assertTrue(c.intersectAABB(new Hero(15.0, 20.0, 5.0, 5.0), new Hero(15.0, 24.0, 5.0, 5.0)));

//     }

//     @Test
//     public void test_intersectAABB_from_the_left_with_collision() 
//     {
//         Collision c = new Collision();
//         assertTrue(c.intersectAABB(new Hero(15.0, 20.0, 5.0, 5.0), new Hero(19.0, 20.0, 5.0, 5.0)));

//     }

//     @Test
//     public void test_intersectAABB_from_the_bottom_with_collision() 
//     {
//         Collision c = new Collision();
//         assertTrue(c.intersectAABB(new Hero(15.0, 20.0, 5.0, 5.0), new Hero(15.0, 16.0, 5.0, 5.0)));

//     }

//     @Test
//     public void test_collisionData() 
//     {
//         Hero h = new Hero(15.0, 20.0, 5.0, 5.0);
//         Hero h1 = new Hero(15.0, 16.0, 5.0, 5.0);
//         Collision c = new Collision();
//         assertTrue(c.collisionData(h, h1) instanceof CollisionPacket);
//     }

// }
