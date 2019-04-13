package core.component;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import core.entity.Entity;
import javafx.scene.image.Image;

/**
 * This class sets the Crab's animation component by populating sets of
 * ArrayList's containing the Images of the animation.
 */
public class AlienCrabAnimationComponent implements Component, Serializable {

    private static final long serialVersionUID = 1L;
    private double ACTOR_WIDTH;
    private double ACTOR_HEIGHT;

    private transient Image currentRender;

    private transient ArrayList<Image> runningAnimations;
    private transient ArrayList<Image> idleAnimations;
    private transient ArrayList<Image> attackAnimations;

    private static transient Image run_1, run_2, run_3, run_4, run_5, run_6, run_7, run_8, run_9;

    private static transient Image idle_1, idle_2, idle_3, idle_4, idle_5, idle_6, idle_7, idle_8, idle_9, idle_10,
            idle_11, idle_12, idle_13, idle_14, idle_15, idle_16, idle_17, idle_18, idle_19, idle_20, idle_21, idle_22,
            idle_23, idle_24, idle_25, idle_26, idle_27, idle_28, idle_29, idle_30, idle_31, idle_32;

    private static transient Image attack_1, attack_2, attack_3, attack_4, attack_5, attack_6, attack_7, attack_8,
            attack_9, attack_10, attack_11, attack_12, attack_13, attack_14;

    /**
     * Constructs an AlienCrabAnimationComponent for the Entity passed in via
     * parameter
     * 
     * @param actor
     */
    public AlienCrabAnimationComponent(Entity actor) {
        init(actor);
    }

    /**
     * Initializes the Animation Images of the entity
     * 
     * @param actor The entity to have images initialized
     */
    public void init(Entity actor) {
        ACTOR_WIDTH = actor.getComponent(DimensionComponent.class).getWidth();
        ACTOR_HEIGHT = actor.getComponent(DimensionComponent.class).getHeight();
        runningAnimations = new ArrayList<Image>();
        idleAnimations = new ArrayList<Image>();
        attackAnimations = new ArrayList<Image>();
        try {
            run_1 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0033.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_2 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0034.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_3 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0035.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_4 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0036.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_5 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0037.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_6 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0038.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_7 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0039.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_8 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0040.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_9 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0041.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            idle_1 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0001.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_2 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0002.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_3 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0003.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_4 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0004.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_5 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0005.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_6 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0006.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_7 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0007.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_8 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0008.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_9 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame009.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_10 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0010.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_11 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0011.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_12 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0012.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_13 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0013.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_14 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0014.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_15 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0015.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_16 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0016.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_17 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0017.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_18 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0018.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_19 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0019.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_20 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0020.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_21 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0021.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_22 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0022.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_23 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0023.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_24 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0024.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_25 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0025.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_26 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0026.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_27 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0027.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_28 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0028.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_29 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0029.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_30 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0030.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_31 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0031.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_32 = new Image(new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0032.png")
                    .toURI().toString(), ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            attack_1 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0052").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_2 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0053").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_3 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0054").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_4 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0055").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_5 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0056").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_6 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0057").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_7 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0058").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_8 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0059").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_9 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0060").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_10 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0061").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_11 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0062").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_12 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0063").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_13 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0064").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_14 = new Image(
                    new File("resources/assets/Enemy/alien_crab_purple/Alien_Crab_Purple_Frame0065").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setRunningAnimation();
        setIdleAnimation();
        setAttackAnimation();
    }

    /**
     * FOR SERIALIZATION
     * 
     * returns a boolean whether or not images for this entity are initialized
     * 
     * @return boolean true: are initalized false: not initialized
     */
    public boolean isInit() {
        if (runningAnimations == null)
            return false;
        else
            return true;
    }

    /**
     * @return the currentRender
     */
    public Image getCurrentRender() {
        return currentRender;
    }

    /**
     * @param currentRender the currentRender to set
     */
    public void setCurrentRender(Image currentRender) {
        this.currentRender = currentRender;
    }

    /**
     * Set the running animation
     */
    private void setRunningAnimation() {
        runningAnimations.add(run_1);
        runningAnimations.add(run_2);
        runningAnimations.add(run_3);
        runningAnimations.add(run_4);
        runningAnimations.add(run_5);
        runningAnimations.add(run_6);
        runningAnimations.add(run_7);
        runningAnimations.add(run_8);
        runningAnimations.add(run_9);
    }

    /**
     * Get the running animation ArrayList
     * @return
     */
    public ArrayList<Image> animateRunning() {
        return runningAnimations;
    }

    /**
     * Set the idle animation
     */
    private void setIdleAnimation() {
        idleAnimations.add(idle_1);
        idleAnimations.add(idle_2);
        idleAnimations.add(idle_3);
        idleAnimations.add(idle_4);
        idleAnimations.add(idle_5);
        idleAnimations.add(idle_6);
        idleAnimations.add(idle_7);
        idleAnimations.add(idle_8);
        idleAnimations.add(idle_9);
        idleAnimations.add(idle_10);
        idleAnimations.add(idle_11);
        idleAnimations.add(idle_12);
        idleAnimations.add(idle_13);
        idleAnimations.add(idle_14);
        idleAnimations.add(idle_15);
        idleAnimations.add(idle_16);
        idleAnimations.add(idle_17);
        idleAnimations.add(idle_18);
        idleAnimations.add(idle_19);
        idleAnimations.add(idle_20);
        idleAnimations.add(idle_21);
        idleAnimations.add(idle_22);
        idleAnimations.add(idle_23);
        idleAnimations.add(idle_24);
        idleAnimations.add(idle_25);
        idleAnimations.add(idle_26);
        idleAnimations.add(idle_27);
        idleAnimations.add(idle_28);
        idleAnimations.add(idle_29);
        idleAnimations.add(idle_30);
        idleAnimations.add(idle_31);
        idleAnimations.add(idle_32);
    }

    /**
     * Get the idle animation ArrayList
     * 
     * @return
     */
    public ArrayList<Image> animateIdle() {
        return idleAnimations;
    }

    /**
     * Set the attack animation
     */
    private void setAttackAnimation() {
        attackAnimations.add(attack_1);
        attackAnimations.add(attack_2);
        attackAnimations.add(attack_3);
        attackAnimations.add(attack_4);
        attackAnimations.add(attack_5);
        attackAnimations.add(attack_6);
        attackAnimations.add(attack_7);
        attackAnimations.add(attack_8);
        attackAnimations.add(attack_9);
        attackAnimations.add(attack_10);
        attackAnimations.add(attack_11);
        attackAnimations.add(attack_12);
        attackAnimations.add(attack_13);
        attackAnimations.add(attack_14);
    }

    /**
     * Get the attack animation
     * 
     * @return
     */
    public ArrayList<Image> animateAttack() {
        return attackAnimations;
    }

}
