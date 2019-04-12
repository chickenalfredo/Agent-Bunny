package core.component;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import core.entity.Entity;
import javafx.scene.image.Image;

public class HeroAnimationComponent implements Component, Serializable {

    private static final long serialVersionUID = 1L;
    private double ACTOR_WIDTH;
    private double ACTOR_HEIGHT;

    private transient Image currentRender;

    private transient ArrayList<Image> runningAnimations;
    private transient ArrayList<Image> jumpingAnimations;
    private transient ArrayList<Image> idleAnimations;
    private transient ArrayList<Image> fallingAnimations;
    private transient ArrayList<Image> runShootAnimations;
    private transient ArrayList<Image> idleShootAnimations;

    private static transient Image run_1, run_2, run_3, run_4, run_5, run_6, run_7, run_8, run_9, run_10, run_11, run_12, run_13,
            run_14, run_15, run_16;

    private static transient Image jump_1, jump_2, jump_3, jump_4;

    private static transient Image idle_1, idle_2, idle_3, idle_4, idle_5, idle_6, idle_7, idle_8, idle_9, idle_10, idle_11,
            idle_12, idle_13, idle_14, idle_15, idle_16, idle_17, idle_18, idle_19, idle_20;

    private static transient Image falling_1, falling_2, falling_3, falling_4, falling_5, falling_6, falling_7, falling_8,
            falling_9, falling_10, falling_11;

    private static transient Image run_shoot_1, run_shoot_2, run_shoot_3, run_shoot_4, run_shoot_5, run_shoot_6, run_shoot_7,
            run_shoot_8, run_shoot_9, run_shoot_10, run_shoot_11, run_shoot_12, run_shoot_13, run_shoot_14,
            run_shoot_15, run_shoot_16;

    private static transient Image idle_shoot;

    public HeroAnimationComponent(Entity actor) {
        init(actor);
    }

    public void init(Entity actor) {
        ACTOR_WIDTH = actor.getComponent(DimensionComponent.class).getWidth();
        ACTOR_HEIGHT = actor.getComponent(DimensionComponent.class).getHeight();
        runningAnimations = new ArrayList<Image>();
        jumpingAnimations = new ArrayList<Image>();
        idleAnimations = new ArrayList<Image>();
        fallingAnimations = new ArrayList<Image>();
        runShootAnimations = new ArrayList<Image>();
        idleShootAnimations = new ArrayList<Image>();
        try {
            run_1 = new Image(new File("resources/assets/Hero/move_right/r_run_1.png").toURI().toString(), ACTOR_WIDTH,
                    ACTOR_HEIGHT, false, true);
            run_2 = new Image(new File("resources/assets/Hero/move_right/r_run_2.png").toURI().toString(), ACTOR_WIDTH,
                    ACTOR_HEIGHT, false, true);
            run_3 = new Image(new File("resources/assets/Hero/move_right/r_run_3.png").toURI().toString(), ACTOR_WIDTH,
                    ACTOR_HEIGHT, false, true);
            run_4 = new Image(new File("resources/assets/Hero/move_right/r_run_4.png").toURI().toString(), ACTOR_WIDTH,
                    ACTOR_HEIGHT, false, true);
            run_5 = new Image(new File("resources/assets/Hero/move_right/r_run_5.png").toURI().toString(), ACTOR_WIDTH,
                    ACTOR_HEIGHT, false, true);
            run_6 = new Image(new File("resources/assets/Hero/move_right/r_run_6.png").toURI().toString(), ACTOR_WIDTH,
                    ACTOR_HEIGHT, false, true);
            run_7 = new Image(new File("resources/assets/Hero/move_right/r_run_7.png").toURI().toString(), ACTOR_WIDTH,
                    ACTOR_HEIGHT, false, true);
            run_8 = new Image(new File("resources/assets/Hero/move_right/r_run_8.png").toURI().toString(), ACTOR_WIDTH,
                    ACTOR_HEIGHT, false, true);
            run_9 = new Image(new File("resources/assets/Hero/move_right/r_run_9.png").toURI().toString(), ACTOR_WIDTH,
                    ACTOR_HEIGHT, false, true);
            run_10 = new Image(new File("resources/assets/Hero/move_right/r_run_10.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_11 = new Image(new File("resources/assets/Hero/move_right/r_run_11.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_12 = new Image(new File("resources/assets/Hero/move_right/r_run_12.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_13 = new Image(new File("resources/assets/Hero/move_right/r_run_13.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_14 = new Image(new File("resources/assets/Hero/move_right/r_run_14.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_15 = new Image(new File("resources/assets/Hero/move_right/r_run_15.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_16 = new Image(new File("resources/assets/Hero/move_right/r_run_16.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            jump_1 = new Image(new File("resources/assets/Hero/jump_right/r_jump_1.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            jump_2 = new Image(new File("resources/assets/Hero/jump_right/r_jump_2.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            jump_3 = new Image(new File("resources/assets/Hero/jump_right/r_jump_3.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            jump_4 = new Image(new File("resources/assets/Hero/jump_right/r_jump_4.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            idle_1 = new Image(new File("resources/assets/Hero/idle_right/r_idle_1.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_2 = new Image(new File("resources/assets/Hero/idle_right/r_idle_2.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_3 = new Image(new File("resources/assets/Hero/idle_right/r_idle_3.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_4 = new Image(new File("resources/assets/Hero/idle_right/r_idle_4.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_5 = new Image(new File("resources/assets/Hero/idle_right/r_idle_5.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_6 = new Image(new File("resources/assets/Hero/idle_right/r_idle_6.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_7 = new Image(new File("resources/assets/Hero/idle_right/r_idle_7.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_8 = new Image(new File("resources/assets/Hero/idle_right/r_idle_8.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_9 = new Image(new File("resources/assets/Hero/idle_right/r_idle_9.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_10 = new Image(new File("resources/assets/Hero/idle_right/r_idle_10.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_11 = new Image(new File("resources/assets/Hero/idle_right/r_idle_11.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_12 = new Image(new File("resources/assets/Hero/idle_right/r_idle_12.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_13 = new Image(new File("resources/assets/Hero/idle_right/r_idle_13.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_14 = new Image(new File("resources/assets/Hero/idle_right/r_idle_14.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_15 = new Image(new File("resources/assets/Hero/idle_right/r_idle_15.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_16 = new Image(new File("resources/assets/Hero/idle_right/r_idle_16.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_17 = new Image(new File("resources/assets/Hero/idle_right/r_idle_17.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_18 = new Image(new File("resources/assets/Hero/idle_right/r_idle_18.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_19 = new Image(new File("resources/assets/Hero/idle_right/r_idle_19.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_20 = new Image(new File("resources/assets/Hero/idle_right/r_idle_20.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            falling_1 = new Image(new File("resources/assets/Hero/falling_right/r_falling_1.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            falling_2 = new Image(new File("resources/assets/Hero/falling_right/r_falling_2.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            falling_3 = new Image(new File("resources/assets/Hero/falling_right/r_falling_3.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            falling_4 = new Image(new File("resources/assets/Hero/falling_right/r_falling_4.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            falling_5 = new Image(new File("resources/assets/Hero/falling_right/r_falling_5.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            falling_6 = new Image(new File("resources/assets/Hero/falling_right/r_falling_6.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            falling_7 = new Image(new File("resources/assets/Hero/falling_right/r_falling_7.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            falling_8 = new Image(new File("resources/assets/Hero/falling_right/r_falling_8.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            falling_9 = new Image(new File("resources/assets/Hero/falling_right/r_falling_9.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            falling_10 = new Image(new File("resources/assets/Hero/falling_right/r_falling_10.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            falling_11 = new Image(new File("resources/assets/Hero/falling_right/r_falling_11.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            run_shoot_1 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_1.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_2 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_2.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_3 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_3.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_4 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_4.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_5 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_5.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_6 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_6.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_7 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_7.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_8 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_8.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_9 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_9.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_10 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_10.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_11 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_11.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_12 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_12.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_13 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_13.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_14 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_14.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_15 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_15.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_shoot_16 = new Image(
                    new File("resources/assets/Hero/attack_right_running/r_run_shoot_16.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            idle_shoot = new Image(
                    new File("resources/assets/Hero/attack_right_idle/r_stand_shoot.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setRunningAnimation();
        setIdleAnimation();
        setFallingAnimation();
        setIdleShootingAnimation();
        setJumpingAnimation();
        setRunningAndShootingAnimation();
    }
    /**
     * FOR SERIALIZATION 
     * 
     * returns a boolean whether or not images for this entity are initialized
     * 
     * @return boolean          true: are initalized
     *                          false: not initialized
     */
    public boolean isInit() {
        if(fallingAnimations == null) 
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
        runningAnimations.add(run_12);
        runningAnimations.add(run_13);
        runningAnimations.add(run_14);
        runningAnimations.add(run_15);
        runningAnimations.add(run_16);

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
    }

    public ArrayList<Image> animateIdle() {
        return idleAnimations;
    }

    private void setRunningAndShootingAnimation() {
        runShootAnimations.add(run_shoot_1);
        runShootAnimations.add(run_shoot_2);
        runShootAnimations.add(run_shoot_3);
        runShootAnimations.add(run_shoot_4);
        runShootAnimations.add(run_shoot_5);
        runShootAnimations.add(run_shoot_6);
        runShootAnimations.add(run_shoot_7);
        runShootAnimations.add(run_shoot_8);
        runShootAnimations.add(run_shoot_9);
        runShootAnimations.add(run_shoot_10);
        runShootAnimations.add(run_shoot_11);
        runShootAnimations.add(run_shoot_12);
        runShootAnimations.add(run_shoot_13);
        runShootAnimations.add(run_shoot_14);
        runShootAnimations.add(run_shoot_15);
        runShootAnimations.add(run_shoot_16);
    }

    public ArrayList<Image> animateRunAndShoot() {
        return runShootAnimations;
    }

    private void setIdleShootingAnimation() {
        idleShootAnimations.add(idle_shoot);
    }

    public ArrayList<Image> animateIdleAndShoot() {
        return idleShootAnimations;
    }

    private void setJumpingAnimation() {
        jumpingAnimations.add(jump_1);
        jumpingAnimations.add(jump_2);
        jumpingAnimations.add(jump_3);
        jumpingAnimations.add(jump_4);
    }

    public ArrayList<Image> AnimateJump() {
        return jumpingAnimations;
    }

    private void setFallingAnimation() {
        fallingAnimations.add(falling_1);
        fallingAnimations.add(falling_2);
        fallingAnimations.add(falling_3);
        fallingAnimations.add(falling_4);
        fallingAnimations.add(falling_5);
        fallingAnimations.add(falling_6);
        fallingAnimations.add(falling_7);
        fallingAnimations.add(falling_8);
        fallingAnimations.add(falling_9);
        fallingAnimations.add(falling_10);
        fallingAnimations.add(falling_11);
    }

    public ArrayList<Image> animateFalling() {
        return fallingAnimations;
    }
}
