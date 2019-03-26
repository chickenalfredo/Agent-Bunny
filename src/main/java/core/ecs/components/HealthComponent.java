package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.external.entity.Hero;
import core.scenes.GameScene;
import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.World;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.scene.canvas.GraphicsContext;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class HealthComponent extends Component implements Serializable {

    private double health = 100;
    private double maxHealth = 100;
    //private transient Text healthDisplay = new Text();
    //private transient ProgressBar healthBar = new ProgressBar();

    public HealthComponent() {
        /*
        healthBar.setMinHeight(GameScene.screenHeight*0.03);
        healthBar.setMinWidth(GameScene.screenWidth*0.15);
        healthBar.setStyle("-fx-accent: maroon; -fx-control-inner-background: tomato;");
        healthDisplay.setStyle("-fx-fill: white; -fx-font-size: 18pt;");
        */
    }

    /**
     * 
     * @param actor
     * @param world
     */
    @Override
    public void update(Sprite actor, World world) {
        if (actor instanceof Entity) {
            if (actor instanceof Hero) {
              //  syncHealthBar(health);
            }
            if (!isAlive()) {
                System.out.println("Removing enemy");
                world.destroyEntity(actor);
            }
        }
    }

    /**
     * 
     * @param actor
     * @param gc
     * @param delta
     */
    @Override
    public void render(Sprite actor, GraphicsContext gc, long delta) {
        // TODO: Render health animations using sprite sheets
    }

    /**
     * @return the health
     */
    public double getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * 
     * @param damage
     */
    public void takeDamage(double damage) {
        health -= damage;
    }

    /**
     * 
     * @return
     */
    public boolean isAlive() {
        return health > 0;
    }

    // /*
    // public void syncHealthBar(double currentHealth) {
    //     healthDisplay.setText(String.valueOf(health));
    //     healthBar.setProgress(health/maxHealth);
    // }

    // /**
    //  * @return the healthBar
    //  */
    // public ProgressBar getHealthBar() {
    //     return healthBar;
    // }

    // /**
    //  * @return the healthDisplay
    //  */
    // public Text getHealthDisplay() {
    //     return healthDisplay;
    // }
    
}
