package core.component;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import core.entity.Entity;
import javafx.scene.image.Image;

/**
 * This class sets the Red Crab's animation component by populating sets of
 * ArrayList's containing the Images of the animation.
 */
public class AlienRedCrabAnimationComponent implements Component, Serializable {

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

    private static transient Image attack_1, attack_2, attack_3, attack_4, attack_5, attack_6, attack_7, attack_8;

    /**
     * Constructs an AlienCrabAnimationComponent for the Entity passed in via
     * parameter
     * 
     * @param actor
     */
    public AlienRedCrabAnimationComponent(Entity actor) {
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
            run_1 = new Image(new File("resources/assets/Enemy/alien_crab_red/run1.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_2 = new Image(new File("resources/assets/Enemy/alien_crab_red/run2.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_3 = new Image(new File("resources/assets/Enemy/alien_crab_red/run3.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_4 = new Image(new File("resources/assets/Enemy/alien_crab_red/run4.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_5 = new Image(new File("resources/assets/Enemy/alien_crab_red/run5.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_6 = new Image(new File("resources/assets/Enemy/alien_crab_red/run6.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_7 = new Image(new File("resources/assets/Enemy/alien_crab_red/run7.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_8 = new Image(new File("resources/assets/Enemy/alien_crab_red/run8.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_9 = new Image(new File("resources/assets/Enemy/alien_crab_red/run9.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            idle_1 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle1.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_2 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle2.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_3 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle3.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_4 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle4.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_5 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle5.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_6 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle6.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_7 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle7.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_8 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle8.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_9 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle9.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_10 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle10.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_11 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle11.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_12 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle12.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_13 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle13.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_14 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle14.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_15 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle15.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_16 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle16.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_17 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle17.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_18 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle18.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_19 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle19.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_20 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle20.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_21 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle21.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_22 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle22.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_23 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle23.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_24 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle24.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_25 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle25.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_26 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle26.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_27 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle27.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_28 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle28.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_29 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle29.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_30 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle30.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_31 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle31.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_32 = new Image(new File("resources/assets/Enemy/alien_crab_red/idle32.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            attack_1 = new Image(new File("resources/assets/Enemy/alien_crab_red/attack1").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_2 = new Image(new File("resources/assets/Enemy/alien_crab_red/attack2").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_3 = new Image(new File("resources/assets/Enemy/alien_crab_red/attack3").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_4 = new Image(new File("resources/assets/Enemy/alien_crab_red/attack4").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_5 = new Image(new File("resources/assets/Enemy/alien_crab_red/attack5").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_6 = new Image(new File("resources/assets/Enemy/alien_crab_red/attack6").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_7 = new Image(new File("resources/assets/Enemy/alien_crab_red/attack7").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_8 = new Image(new File("resources/assets/Enemy/alien_crab_red/attack8").toURI().toString(),
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
     * Set running animation
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
     * @return  running animation ArrayList
     */
    public ArrayList<Image> animateRunning() {
        return runningAnimations;
    }

    /**
     * set idle animation
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
     * @return  idle animation ArrayList
     */
    public ArrayList<Image> animateIdle() {
        return idleAnimations;
    }

    /**
     * set attack animation
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
    }

    /**
     * @return  attack animation ArrayList
     */
    public ArrayList<Image> animateAttack() {
        return attackAnimations;
    }

}
