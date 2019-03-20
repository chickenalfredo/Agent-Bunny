package core.sprite;

import java.util.ArrayList;

import core.ecs.Component;
import core.external.entity.Hero;
import core.external.level.Chapter1Level1;
import core.map.GameMap;
import javafx.scene.canvas.GraphicsContext;

public class World {

    private ArrayList<Component> m_components = new ArrayList<Component>();
    private ArrayList<Sprite> m_entities = new ArrayList<Sprite>();
    private Hero hero;
    private GameMap level;

    public World() {
        level = new Chapter1Level1();
        m_entities = level.getSprites();
        setHero();
    }

    public void createEntity() {}
    public void destroyEntity() {}

    public void addComponent() {}
    public void removeComponent() {}
    public void getComponent() {}

    public void addSystem() {}
    public void updateSystems() {}
    public void removeSystem() {}

    public Hero getHero() {
        return hero;
    }

    private void setHero() {
        for (Sprite s : m_entities) {
            if (s instanceof Hero) {
                hero = (Hero)s;
            }
        }
    }

    public ArrayList<Sprite> getEntities() {
        return m_entities;
    }

    public void update(GraphicsContext gc) {
        for (Sprite s : m_entities) {
            s.update(this, gc);
        }
    }

}
