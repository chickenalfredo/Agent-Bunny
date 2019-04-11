package core.component;

import java.io.FileInputStream;

import core.entity.Entity;
import javafx.scene.CacheHint;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RenderComponent implements Component {

    private Group group;
    private ImageView imageView;
    private Image image;

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
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setCache(true);
        imageView.setCacheHint(CacheHint.SPEED);
    }

    public Image getImage() {
        return image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void createGroup() {
        group = new Group(imageView);
    }

    /**
     * @return the entityGroup
     */
    public Group getGroup() {
        return group;
    }

}
