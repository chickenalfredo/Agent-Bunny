package core.ecs.components;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

import core.ecs.Component;
import core.external.entity.Enemy;
import core.external.entity.Hero;
import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.Weapon;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class RenderComponent extends Component implements Serializable {

    private static final long serialVersionUID = 1898382905294065884L;
    private transient Image image;
    private long lastAnimation = 0;
    private long durationTime = 115;
    private int index = 0;
    private String lastDirectory = "";
    private String lastAttackDirectory = "";
    private String filename;
    private String actorSimpleName;
    private String actorName = "";

    /**
     * 
     * @param actor
     * @param filename
     */
    public RenderComponent(Sprite actor, String filename) {
        if (filename != null) {
            setImage(actor, filename);
            actorSimpleName = actor.getClass().getSimpleName() + "/";
        }
        if (actor instanceof Enemy) {
            actorName = Enemy.class.cast(actor).getName() + "/";
        }
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
            if (actor.getComponent("StateComponent", StateComponent.class)
                    .getConcurrentState() == StateComponent.ConcurrentState.NONE) {
                if (actor.getComponent("StateComponent", StateComponent.class)
                        .getDirection() == StateComponent.Direction.LEFT) {
                    switch (actor.getComponent("StateComponent", StateComponent.class).getState()) {
                    case RUNNING:
                        animate(actor, "resources/assets/" + actorSimpleName + actorName + "move_left/");
                        break;
                    case IDLE:
                        animate(actor, "resources/assets/" + actorSimpleName + actorName + "idle_left/");
                        break;
                    }
                } else {
                    switch (actor.getComponent("StateComponent", StateComponent.class).getState()) {
                    case RUNNING:
                        animate(actor, "resources/assets/" + actorSimpleName + actorName + "move_right/");
                        break;
                    case IDLE:
                        animate(actor, "resources/assets/" + actorSimpleName + actorName + "idle_right/");
                        break;
                    }
                }
            } else {
                if (actor.getComponent("StateComponent", StateComponent.class)
                        .getDirection() == StateComponent.Direction.LEFT) {
                    // facing left + concurrent
                    switch (actor.getComponent("StateComponent", StateComponent.class).getConcurrentState()) {
                    case ATTACKING:
                        // animate(actor, "resources/assets/attack_left/");
                        animateAttacks(actor);
                        break;
                    case JUMPING:
                        animate(actor, "resources/assets/" + actorSimpleName + actorName + "jump_left/");
                        break;
                    case FALLING:
                        animate(actor, "resources/assets/" + actorSimpleName + actorName + "falling_left/");
                        break;
                    case NONE:
                        break;
                    }
                } else {
                    // facing right + concurrent
                    switch (actor.getComponent("StateComponent", StateComponent.class).getConcurrentState()) {
                    case ATTACKING:
                        // animate(actor, "resources/assets/attack/k1/");
                        animateAttacks(actor);
                        // animate(actor, "resources/assets/attack/k3/");
                        break;
                    case JUMPING:
                        animate(actor, "resources/assets/" + actorSimpleName + actorName + "jump_right/");
                        break;
                    case FALLING:
                        animate(actor, "resources/assets/" + actorSimpleName + actorName + "falling_right/");
                        break;
                    case NONE:
                        break;
                    }
                }
            }
        }
        if (image == null) {
            if (actor instanceof Weapon) {
                drawRectangle(actor, gc);
            } else {
                setImage(actor, filename);
            }
        } else {
            gc.drawImage(image, actor.getX(), actor.getY());
        }
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
        if (animationTimerOver()) {
            if (directory.equals(lastDirectory) && index < directoryListing.length) {
                setImage(actor, directoryListing[index].toString());
                index++;
            } else if (directory.equals(lastDirectory) && index >= directoryListing.length) {
                index = 0;
                setImage(actor, directoryListing[index].toString());
            } else {
                index = 0;
                setImage(actor, directoryListing[index].toString());
            }
        }
        lastDirectory = directory;
    }

    private void drawRectangle(Sprite actor, GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillRect(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
    }

    private boolean animationTimerOver() {
        long time = System.currentTimeMillis();
        if (time > lastAnimation + durationTime) {
            lastAnimation = time;
            return true;
        }
        return false;
    }

    private void animateAttacks(Sprite actor) {

        if (actor.getComponent("StateComponent", StateComponent.class).getState() == StateComponent.State.RUNNING) {
            if (actor.getComponent("StateComponent", StateComponent.class).getDirection() == StateComponent.Direction.RIGHT) {
                animate(actor, "resources/assets/" + actorSimpleName + actorName + "attack_right_running/");
            } else {
                animate(actor, "resources/assets/" + actorSimpleName + actorName + "attack_left_running/");
            }
        } else {
            if (actor.getComponent("StateComponent", StateComponent.class).getDirection() == StateComponent.Direction.RIGHT) {
                animate(actor, "resources/assets/" + actorSimpleName + actorName + "attack_right_idle/");
            } else {
                animate(actor, "resources/assets/" + actorSimpleName + actorName + "attack_left_idle/");
            }
        }

        if (actor.getComponent("StateComponent", StateComponent.class).getState() == StateComponent.State.RUNNING
                && actor.getComponent("StateComponent", StateComponent.class).getDirection() == StateComponent.Direction.RIGHT) {
            animate(actor, "directory");
        } else {

        }

    }

}