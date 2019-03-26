package core.ecs.components;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

import core.ecs.Component;
import core.external.entity.Hero;
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
        if (actor instanceof Hero) {
            switch (actor.getComponent("StateComponent", StateComponent.class).getState()) {
            case RUNNING:
                animate(actor, "src/main/resources/assets/move_right/");
                break;
            case ATTACKING:
                animate(actor, "src/main/resources/assets/attack/");
                break;
            case JUMPING:
                animate(actor, "src/main/resources/assets/jump/");
                break;
            case FALLING:
                animate(actor, "src/main/resources/assets/falling/");
                break;
            default:
                animate(actor, "src/main/resources/assets/idle/");
            }
        }
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

    private void animate(Sprite actor, String directory) {
        File dir = new File(directory);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File c : directoryListing) {
                setImage(actor, c.toString());
            }
        } 
    }

}