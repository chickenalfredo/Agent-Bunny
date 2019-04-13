package core.component;

import java.io.FileInputStream;
import java.io.Serializable;

import core.entity.Entity;
import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class sets the Statuc Objects's render component by storing and
 * retrieving Image's beloning to the instance
 */
public class RenderComponent implements Component, Serializable {

    private static final long serialVersionUID = 1L;
    private transient ImageView imageView;
    private transient Image image;
    private String filename;

    /**
     * Constructs a Render Component for the specified actor with the specified
     * Image as described in the filename
     * 
     * @param actor
     * @param filename
     */
    public RenderComponent(Entity actor, String filename) {
        this.filename = filename;
        init(actor);
    }

    /**
     * Initializes this Render Component by setting the Image and ImageView for
     * rendering
     * 
     * @param actor
     */
    public void init(Entity actor) {
        setImage(this.filename, actor.getComponent(DimensionComponent.class).getWidth(),
                actor.getComponent(DimensionComponent.class).getHeight());
        setImageView();
    }

    /**
     * Sets the Image as specified by the filename, width and height
     * 
     * @param filename
     * @param width
     * @param height
     */
    public void setImage(String filename, float width, float height) {
        try {
            image = new Image(new FileInputStream(filename), width, height, false, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the ImageView with the now-initialized Image
     */
    public void setImageView() {
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setCache(true);
        imageView.setCacheHint(CacheHint.SPEED);
    }

    /**
     * @return  image that will be rendered
     */
    public Image getImage() {
        return image;
    }

    /**
     * @return  ImageView containing the Image to be rendered
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * @return  true or false if Image has been initialzied
     */
    public boolean isInit() {
        if (image == null)
            return false;
        else
            return true;
    }

}
