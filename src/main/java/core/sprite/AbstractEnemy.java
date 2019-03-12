package core.sprite;

public abstract class AbstractEnemy extends Entity  {

    public AbstractEnemy(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsEnemy(true);
    }

    public AbstractEnemy(double x, double y, double width, double height, String image) {
        super(x, y, width, height, image);
        setIsEnemy(true);
    }

    public AbstractEnemy(double x, double y) {
        super(x, y);
    }

}
