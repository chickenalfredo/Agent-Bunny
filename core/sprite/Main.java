package core.sprite;

public class Main {
    public static void main(String[] args) {
        Collision collisionDetection = new Collision();
        Sprite a = new Sprite(5, 5, 1, 1);
        Sprite b = new Sprite(4, 5, 1, 1);
        System.out.println(collisionDetection.intersectAABB(a, b));
    }
}