package core.external.level;

import core.external.entity.*;
import core.external.tile.*;
import core.map.GameMap;
import core.screens.ScreenBuilder;
import core.sprite.Sprite;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 */
public class Chapter1Level1 extends GameMap {

	public Chapter1Level1() {

		List<Sprite> sprites = new ArrayList<Sprite>();

		Monster monster = new Monster(1000, 200, 100, 100, "src/main/resources/assets/Beetle.png");
		BlackWolf wolf = new BlackWolf(200.0, 300.0, 100, 100, "src/main/resources/assets/Cyclops.png");
		EndPoint ep = new EndPoint(1200, 720, 100, 175, "src/main/resources/assets/Door.png");
		Grass block1 = new Grass(500.0, 350.0, 100, 100, "src/main/resources/assets/Grass.png");
		Wall wall = new Wall(0, ScreenBuilder.getPrimaryScreenBounds().getHeight() - 150, ScreenBuilder.getPrimaryScreenBounds().getWidth(), 150, "src/main/resources/assets/Grass.png");

		sprites.add(block1);
		sprites.add(monster);
		sprites.add(wolf);
		sprites.add(ep);
		sprites.add(wall);

		for (Sprite sprite : sprites) {
			super.addSprite(sprite);
		}

	}

}
