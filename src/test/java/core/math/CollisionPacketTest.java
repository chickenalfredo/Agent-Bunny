// package core.math;

// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertTrue;

// import org.junit.Test;

// import core.external.entity.Enemy;
// import core.external.entity.Hero;
// import core.utils.TestUtils;

// public class CollisionPacketTest 
// {

//     @Test
//     public void test_CollisionPacket_getActor() 
//     {
//         Hero h = new Hero(0,0,0,0);
//         Enemy e = new Enemy(0,0,0,0);
//         CollisionPacket cp = new CollisionPacket(h, e);
//         assertTrue(cp.getActor().equals(h));
//     }

//     @Test
//     public void test_CollisionPacket_getCollider() 
//     {
//         Hero h = new Hero(0,0,0,0);
//         Enemy e = new Enemy(0,0,0,0);
//         CollisionPacket cp = new CollisionPacket(h, e);
//         assertTrue(cp.getCollider().equals(e));
//     }

//     @Test
//     public void test_CollisionPacket_isColliding() 
//     {
//         Hero h = new Hero(15.0, 20.0, 5.0, 5.0);
//         Enemy e = new Enemy(15.0, 16.0, 5.0, 5.0);
//         CollisionPacket cp = new CollisionPacket(h, e);
//         assertTrue(cp.isColliding());
//     }

//     @Test
//     public void test_CollisionPacket_getCollisionSide_bottom_true() 
//     {
//         Hero h = new Hero(15.0, 20.0, 5.0, 5.0);
//         Enemy e = new Enemy(15.0, 16.0, 5.0, 5.0);
//         CollisionPacket cp = new CollisionPacket(h, e);
//         assertTrue(cp.getCollisionSide().equals("bottom"));
//     }

//     @Test
//     public void test_CollisionPacket_getCollisionSide_top_true() 
//     {
//         Hero h = new Hero(15.0, 20.0, 5.0, 5.0);
//         Enemy e = new Enemy(15.0, 24.0, 5.0, 5.0);
//         CollisionPacket cp = new CollisionPacket(h, e);
//         assertTrue(cp.getCollisionSide().equals("top"));
//     }

//     @Test
//     public void test_CollisionPacket_getCollisionSide_right_true() 
//     {
//         Hero h = new Hero(15.0, 20.0, 5.0, 5.0);
//         Enemy e = new Enemy(11.0, 20.0, 5.0, 5.0);
//         CollisionPacket cp = new CollisionPacket(h, e);
//         assertTrue(cp.getCollisionSide().equals("right"));
//     }

//     @Test
//     public void test_CollisionPacket_getCollisionSide_left_true() 
//     {
//         Hero h = new Hero(15.0, 20.0, 5.0, 5.0);
//         Enemy e = new Enemy(19.0, 20.0, 5.0, 5.0);
//         CollisionPacket cp = new CollisionPacket(h, e);
//         System.out.println(cp.getCollisionSide());
//         assertTrue(cp.getCollisionSide().equals("left"));
//     }

// }
