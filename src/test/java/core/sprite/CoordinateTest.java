// package core.sprite;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;
// import static org.junit.Assert.assertFalse;

// import org.junit.Test;
// import com.jparams.verifier.tostring.ToStringVerifier;
// import core.utils.*;
// import core.sprite.Coordinate;

// public class CoordinateTest 
// {

//     @Test
//     public void testAccessors_shouldAccessProperField() {
//         TestUtils.validateAccessors(Coordinate.class);
//     }


//     @Test
//     public void test_getLocation() 
//     {
//         Coordinate c = new Coordinate(5, 10);
//         assertEquals(new Coordinate(5, 10), c.getLocation());
//     }

//     @Test
//     public void test_setLocation_with_parametrized_doubles() 
//     {
//         Coordinate c = new Coordinate();
//         c.setLocation(5, 10);
//         assertEquals("Coordinates expected are (5,10)", new Coordinate(5, 10), c.getLocation());
//     }

//     @Test
//     public void test_setLocation_with_parametrized_coordinate() 
//     {
//         Coordinate c = new Coordinate();
//         c.setLocation(new Coordinate(10, 10));
//         assertEquals("Coordinates expected are (10,10)", new Coordinate(10, 10), c.getLocation());
//     }

//     @Test
//     public void test_distanceFrom_xy_both_positive() 
//     {
//         Coordinate c = new Coordinate(0, 0);
//         Coordinate b = new Coordinate(1, 2);
//         assertEquals(2.23606797749979, c.distanceFrom(b), 0);
//     }

//     @Test
//     public void test_distanceFrom_xy_both_negative() 
//     {
//         Coordinate c = new Coordinate(0, 0);
//         Coordinate b = new Coordinate(-1, -2);
//         assertEquals(2.23606797749979, c.distanceFrom(b), 0);
//     }

//     @Test
//     public void test_distanceFrom_x_positive_y_negative() 
//     {
//         Coordinate c = new Coordinate(0, 0);
//         Coordinate b = new Coordinate(1, -2);
//         assertEquals(2.23606797749979, c.distanceFrom(b), 0);
//     }

//     @Test
//     public void test_distanceFrom_x_negative_y_positive() 
//     {
//         Coordinate c = new Coordinate(0, 0);
//         Coordinate b = new Coordinate(-1, 2);
//         assertEquals(2.23606797749979, c.distanceFrom(b), 0);
//     }

//     @Test
//     public void test_distanceFrom_xy_both_at_origin() 
//     {
//         Coordinate c = new Coordinate(0, 0);
//         Coordinate b = new Coordinate(0, 0);
//         assertEquals(0, c.distanceFrom(b), 0);
//     }

//     @Test
//     public void test_equals_false_with_only_x_coordinate_difference() 
//     {
//         Coordinate c = new Coordinate(5, 20);
//         Coordinate a = new Coordinate(1, 20);
//         assertFalse(c.equals(a));
//     }

//     @Test
//     public void test_equals_false_with_only_y_coordinate_difference()  
//     {
//         Coordinate c = new Coordinate(5, 20);
//         Coordinate a = new Coordinate(5, 1);
//         assertFalse(c.equals(a));
//     }

//     public void test_equals_false_with_xy_coordinate_difference() 
//     {
//         Coordinate c = new Coordinate(5, 20);
//         Coordinate a = new Coordinate(1, 1);
//         assertFalse(c.equals(a));
//     }

//     @Test
//     public void test_equals_true() 
//     {
//         Coordinate c = new Coordinate(5, 20);
//         Coordinate a = new Coordinate(5, 20);
//         assertTrue(c.equals(a));
//     }

//     @Test
//     public void test_equals_true_by_copy_constructor() 
//     {
//         Coordinate c = new Coordinate(5, 20);
//         Coordinate a = new Coordinate(c);
//         assertTrue(c.equals(a));
//     }

//     @Test
//     public void test_equals_true_same_reference() 
//     {
//         Coordinate c = new Coordinate(5, 20);
//         assertTrue(c.equals(c));
//     }

//     @Test
//     public void test_equals_false_null_object() 
//     {
//         Coordinate c = new Coordinate();
//         assertFalse(c.equals(null));
//     }

//     @Test
//     public void test_equals_false_not_same_object_type() 
//     {
//         Coordinate c = new Coordinate();
//         assertFalse(c.equals(new Object()));
//     }

//     @Test
//     public void test_toString() 
//     {
//         ToStringVerifier.forClass(Coordinate.class).verify();
//     }

//     @Test
//     public void test_normalize_length_greater_than_zero() 
//     {
//         Coordinate c = new Coordinate(5,10);
//         Double n = c.normalize();
//         assertEquals(11.180339887498949, n, 0);
//     }

//     @Test
//     public void test_normalize_length_less_than_zero() 
//     {
//         Coordinate c = new Coordinate(0,0);
//         Double n = c.normalize();
//         assertEquals(0, n, 0);
//     }

// }
