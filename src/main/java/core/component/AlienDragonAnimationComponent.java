package core.component;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import core.entity.Entity;
import javafx.scene.image.Image;

public class AlienDragonAnimationComponent implements Component, Serializable {

    private static final long serialVersionUID = 1L;
    private double ACTOR_WIDTH;
    private double ACTOR_HEIGHT;

    private transient Image currentRender;

    private transient ArrayList<Image> runningAnimations;
    private transient ArrayList<Image> idleAnimations;
    private transient ArrayList<Image> attackAnimations;

    private static transient Image run_1, run_2, run_3, run_4, run_5, run_6, run_7, run_8, run_9, run_10, run_11;

    private static transient Image idle_1, idle_2, idle_3, idle_4, idle_5, idle_6, idle_7, idle_8, idle_9, idle_10, idle_11,
            idle_12, idle_13, idle_14, idle_15, idle_16, idle_17, idle_18, idle_19, idle_20, idle_21, idle_22;

    private static transient Image attack_1, attack_2, attack_3, attack_4, attack_5, attack_6, attack_7, attack_8, attack_9,
            attack_10, attack_11, attack_12, attack_13;

    public AlienDragonAnimationComponent(Entity actor) {
        init(actor);
    }

    /**
     * Initializes the Animation Images of the entity
     * 
     * @param actor     The entity to have images initialized
     */
    public void init(Entity actor) {
        ACTOR_WIDTH = actor.getComponent(DimensionComponent.class).getWidth();
        ACTOR_HEIGHT = actor.getComponent(DimensionComponent.class).getHeight();
        runningAnimations = new ArrayList<Image>();
        idleAnimations = new ArrayList<Image>();
        attackAnimations = new ArrayList<Image>();
        try {
            run_1 = new Image(new File("resources/assets/Enemy/alien_dragon/d_hopp_1.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_2 = new Image(new File("resources/assets/Enemy/alien_dragon/d_hopp_2.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_3 = new Image(new File("resources/assets/Enemy/alien_dragon/d_hopp_3.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_4 = new Image(new File("resources/assets/Enemy/alien_dragon/d_hopp_4.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_5 = new Image(new File("resources/assets/Enemy/alien_dragon/d_hopp_5.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_6 = new Image(new File("resources/assets/Enemy/alien_dragon/d_hopp_6.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_7 = new Image(new File("resources/assets/Enemy/alien_dragon/d_hopp_7.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_8 = new Image(new File("resources/assets/Enemy/alien_dragon/d_hopp_8.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_9 = new Image(new File("resources/assets/Enemy/alien_dragon/d_hopp_9.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_10 = new Image(new File("resources/assets/Enemy/alien_dragon/d_hopp_10.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_11 = new Image(new File("resources/assets/Enemy/alien_dragon/d_hopp_11.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            idle_1 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_1.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_2 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_2.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_3 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_3.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_4 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_4.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_5 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_5.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_6 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_6.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_7 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_7.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_8 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_8.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_9 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_9.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_10 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_10.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_11 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_11.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_12 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_12.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_13 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_13.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_14 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_14.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_15 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_15.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_16 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_16.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_17 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_17.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_18 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_18.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_19 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_19.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_20 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_20.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_21 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_21.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_22 = new Image(new File("resources/assets/Enemy/alien_dragon/d_sleep_22.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            attack_1 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_1").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_2 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_2").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_3 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_3").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_4 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_4").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_5 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_5").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_6 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_6").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_7 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_7").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_8 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_8").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_9 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_9").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_10 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_10").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_11 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_11").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_12 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_12").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_13 = new Image(new File("resources/assets/Enemy/alien_dragon/d_attack_13").toURI().toString(),
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
     * @return boolean      true: are initalized 
     *                      false: not initialized
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
        runningAnimations.add(run_10);
        runningAnimations.add(run_11);
    }

    public ArrayList<Image> animateRunning() {
        return runningAnimations;
    }

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
    }

    public ArrayList<Image> animateIdle() {
        return idleAnimations;
    }

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
    }

    public ArrayList<Image> animateAttack() {
        return attackAnimations;
    }

}
