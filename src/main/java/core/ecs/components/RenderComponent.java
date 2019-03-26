package core.ecs.components;

import java.io.FileInputStream;
import java.io.Serializable;

import core.ecs.Component;
import core.sprite.Sprite;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class RenderComponent extends Component implements Serializable {

    private static final long serialVersionUID = 1898382905294065884L;
    private transient Image image;
    private String fileName;

    /**
     * 
     * @param actor
     * @param filename
     */
    public RenderComponent(Sprite actor, String filename) {
        setImage(actor, filename);
        this.fileName = filename;
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
        if (image == null) {
            setImage(actor, fileName);
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
            image = new Image(new FileInputStream(filename), actor.getWidth(), actor.getHeight(), false, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}