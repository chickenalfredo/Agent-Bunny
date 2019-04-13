package core.system.systems;

import java.util.ArrayList;

import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.image.Image;

/**
 * Extension of SystemComponent that defines an Animation Component. This
 * sub-class allows for animation durations and iteration of ArrayLists.
 */
public abstract class AnimationSystemComponent extends SystemComponent {

    private static final long serialVersionUID = 643178160652430826L;
    private int i = 0;
    private long lastAnimation = 0;

    /**
     * Initializes all components of the Animation System. This method is used for
     * deserealization purposes
     * 
     * @param EntityManager
     */
    public abstract void initializeComponents(EntityManager EntityManager);

    /**
     * Iterates through the ArrayList of images
     * @param images
     * @return
     */
    protected int iterate(ArrayList<Image> images) {
        if (i >= images.size() - 1) {
            i = 0;
            return i;
        } else {
            i++;
            return i;
        }
    }

    /**
     * @param duration
     * @return  true or false if the animation duration is over
     */
    protected boolean animationTimerOver(long duration) {
        long time = System.currentTimeMillis();
        if (time > lastAnimation + duration) {
            lastAnimation = time;
            return true;
        }
        return false;
    }

}
