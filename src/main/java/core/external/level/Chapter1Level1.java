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

		// Monster monster = new Monster(130.0, 35.0, 5.0, 5.0);
		// BlackWolf wolf = new BlackWolf(30.0, 50.0, 5.0, 5.0);
		// Hero player = new Hero(15.0, 60.0, 5.0, 5.0);
		// CheckPoint cp = new CheckPoint(100, 55.0, 5.0, 5.0);
		// Clouds cloud = new Clouds(100.0, 10.0, 5.0, 5.0);
		// EndPoint ep = new EndPoint(230.0, 10.0, 5.0, 5.0);
		// Water water = new Water(35.0, 15.0, 5.0, 5.0);
		// StandardBlock block1 = new StandardBlock(230.0, 55.0, 5, 5);

		Monster monster = new Monster(1000, 200);
		BlackWolf wolf = new BlackWolf(200.0, 1000.0);
		Hero player = new Hero(500, 500);
		CheckPoint cp = new CheckPoint(200, 500.0);
		Clouds cloud = new Clouds(100.0, 100.0);
		EndPoint ep = new EndPoint(50.0, 600.0);
		Water water = new Water(600, 20);
		StandardBlock block1 = new StandardBlock(2000.0, 1000.0);
		Wall wall = new Wall(0, ScreenBuilder.getPrimaryScreenBounds().getHeight() - 150);

		sprites.add(block1);
		sprites.add(monster);
		sprites.add(wolf);
		sprites.add(player);
		sprites.add(cp);
		sprites.add(cloud);
		sprites.add(ep);
		sprites.add(water);
		sprites.add(wall);

		for (Sprite sprite : sprites) {
			super.addSprite(sprite);
		}

	}

}
