package core.component;

import java.io.File;
import java.util.ArrayList;

import core.entity.Entity;
import javafx.scene.image.Image;

public class AlienBugAnimationComponent implements Component {

    private final double ACTOR_WIDTH;
    private final double ACTOR_HEIGHT;

    private Image currentRender;

    private ArrayList<Image> runningAnimations = new ArrayList<Image>();
    private ArrayList<Image> idleAnimations = new ArrayList<Image>();
    private ArrayList<Image> attackAnimations = new ArrayList<Image>();

    private static Image run_1, run_2, run_3, run_4, run_5, run_6;

    private static Image idle_1, idle_2, idle_3, idle_4, idle_5, idle_6, idle_7, idle_8, idle_9, idle_10, idle_11,
            idle_12;

    private static Image attack_1, attack_2, attack_3, attack_4, attack_5, attack_6, attack_7;

    public AlienBugAnimationComponent(Entity actor) {
        ACTOR_WIDTH = actor.getComponent(DimensionComponent.class).getWidth();
        ACTOR_HEIGHT = actor.getComponent(DimensionComponent.class).getHeight();
        try {
            run_1 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0001.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_2 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0002.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_3 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0003.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_4 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0004.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_5 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0005.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            run_6 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0006.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            idle_1 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0011.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_2 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0012.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_3 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0013.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_4 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0014.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_5 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0015.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_6 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0016.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_7 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0017.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_8 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0018.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_9 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0019.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_10 = new Image(
                    new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0020.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_11 = new Image(
                    new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0021.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            idle_12 = new Image(
                    new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0022.png").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);

            attack_1 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0035").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_2 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0036").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_3 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0037").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_4 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0038").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_5 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0039").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_6 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0040").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
            attack_7 = new Image(new File("resources/assets/Enemy/alien_bug/Alien_Bug_Export0041").toURI().toString(),
                    ACTOR_WIDTH, ACTOR_HEIGHT, false, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setRunningAnimation();
        setIdleAnimation();
        setAttackAnimation();
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
    }

    public ArrayList<Image> animateAttack() {
        return attackAnimations;
    }

}
