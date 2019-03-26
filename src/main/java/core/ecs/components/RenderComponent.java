package core.ecs.components;

import java.io.FileInputStream;

import core.animations.Animation;
import core.ecs.Component;
import core.sprite.Sprite;
import core.sprite.World;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class RenderComponent extends Component {

    private Image image;
    private Animation animationSystem;
    private ImageView view;
    private Rectangle2D viewPort;

    /**
     * 
     * @param actor
     * @param filename
     */
    public RenderComponent(Sprite actor, String filename) {
        setImage(actor, filename);
    }

    public RenderComponent(Sprite actor, String filename, Animation animationSystem) {
        setImage(actor, filename);
        this.animationSystem = animationSystem;
    }

    /**
     * 
     * @param actor
     * @param world
     */
    @Override
    public void update(Sprite actor, World world) {

    }

    /**
     * 
     * @param actor
     * @param gc
     * @param delta
     */
    @Override
    public void render(Sprite actor, GraphicsContext gc, long delta) {
        if (view == null) {
            System.out.println("imageview created");
            view = new ImageView(image);
            view.setPreserveRatio(false);
            view.setSmooth(true);
            view.setCache(true);
            view.setViewport(new Rectangle2D(65, 40, actor.getWidth(), actor.getHeight()));
            System.out.println(view.getViewport());
        }
        if (view.getViewport() != this.viewPort && view != null) {
            view.setViewport(viewPort);
        } 
        gc.drawImage(image, actor.getX(), actor.getY());
    }

    /**
     * 
     * @param actor
     * @param filename
     */
    private void setImage(Sprite actor, String filename) {
        try {
            image = new Image(new FileInputStream(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Image getImage() {
        return image;
    }

    /**
     * @return the animationSystem
     */
    public Animation getAnimationSystem() {
        return animationSystem;
    }

    public void setImageView(ImageView view) {
        this.view = view;
    }

    public ImageView getImageView() {
        return view;
    }

    /**
     * @param viewPort the viewPort to set
     */
    public void setViewPort(Rectangle2D viewPort) {
        this.viewPort = viewPort;
    }

}
