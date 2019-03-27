package core.ecs.components;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

import core.ecs.Component;
import core.sprite.Entity;
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
        if (actor instanceof Entity) {
            if (actor.getComponent("StateComponent", StateComponent.class).getConcurrentState() == StateComponent.ConcurrentState.NONE) {
                if (actor.getComponent("StateComponent", StateComponent.class).getDirection() == StateComponent.Direction.LEFT) {
                    switch (actor.getComponent("StateComponent", StateComponent.class).getState()) {
                        case RUNNING:
                            animate(actor, "resources/assets/move_left/");
                            break;
                        case IDLE:
                            animate(actor, "resources/assets/idle_left/");
                            break;
                    }
                } else {
                    switch (actor.getComponent("StateComponent", StateComponent.class).getState()) {
                        case RUNNING:
                            animate(actor, "resources/assets/move_right/");
                            break;
                        case IDLE:
                            animate(actor, "resources/assets/idle_right/");
                            break;
                    }
                }
            } else {
                if (actor.getComponent("StateComponent", StateComponent.class).getDirection() == StateComponent.Direction.LEFT) {
                    // facing left + concurrent
                    switch (actor.getComponent("StateComponent", StateComponent.class).getConcurrentState()) {
                        case ATTACKING:
                            animate(actor, "resources/assets/attack_left/");
                            break;
                        case JUMPING:
                            animate(actor, "resources/assets/jump_left/");
                            break;
                        case FALLING:
                            animate(actor, "resources/assets/falling_left/");
                            break;
                        case NONE:
                            break;
                    }
                } else {
                    // facing right + concurrent
                    switch (actor.getComponent("StateComponent", StateComponent.class).getConcurrentState()) {
                        case ATTACKING:
                            animate(actor, "resources/assets/attack_right/");
                            break;
                        case JUMPING:
                            animate(actor, "resources/assets/jump_right/");
                            break;
                        case FALLING:
                            animate(actor, "resources/assets/falling_right/");
                            break;
                        case NONE:
                            break;
                    }
                }
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