package core.component;

import java.io.FileInputStream;
import java.io.Serializable;

import core.entity.Entity;
import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import core.savablejfx.*;

public class RenderComponent implements Component, Serializable {

    private Image image;
    private static final long serialVersionUID = 1L;
    private SavableGroup group;
    private SavableImageView imageView;

    public RenderComponent(Entity actor, String filename) {
        setImage(filename, actor.getComponent(DimensionComponent.class).getWidth(), actor.getComponent(DimensionComponent.class).getHeight());
        setImageView();
    }

    public void setImage(String filename, float width, float height) {
        try {
            image = new Image(new FileInputStream(filename), width, height, false, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setImageView() {
        imageView = new SavableImageView();
        imageView.setImage(image);
        imageView.setCache(true);
        imageView.setCacheHint(CacheHint.SPEED);
    }

    public Image getImage() {
        return image;
    }

    public SavableImageView getImageView() {
        return imageView;
    }

    public void createGroup() {
        group = new SavableGroup(imageView);
    }

    /**
     * @return the entityGroup
     */
    public SavableGroup getGroup() {
        return group;
    }

}
