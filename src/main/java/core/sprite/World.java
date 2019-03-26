package core.sprite;

import java.io.Serializable;
import java.util.ArrayList;

import core.external.entity.Hero;
import core.external.level.Chapter1Level1;
import core.map.GameMap;
import javafx.scene.canvas.GraphicsContext;

public class World implements Serializable {

    private static final long serialVersionUID = -593390538413494469L;
    private ArrayList<Sprite> m_entities = new ArrayList<Sprite>();
    private Hero hero;
    private GameMap level;

    /**
     * 
     */
    public World() {
        init();
    }

    /**
     * 
     * @param gc
     * @param delta
     */
    public void update(GraphicsContext gc, long delta) {
        m_entities = level.getSprites();
        for (Sprite s : m_entities) {
            s.update(this);
            s.render(gc, delta);
        }
    }

    /**
     * 
     * @param actor
     */
    public void destroyEntity(Sprite actor) {
        level.removeSprite(actor);
    }

    /**
     * 
     * @return
     */
    public Hero getHero() {
        return hero;
    }

    /**
     * 
     */
    private void setHero() {
        for (Sprite s : m_entities) {
            if (s instanceof Hero) {
                hero = (Hero) s;
            }
        }
    }

    /**
     * 
     * @return
     */
    public ArrayList<Sprite> getEntities() {
        return m_entities;
    }

    /**
     * 
     */
    private void init() {
        level = new Chapter1Level1();
        m_entities = level.getSprites();
        setHero();
    }

}
