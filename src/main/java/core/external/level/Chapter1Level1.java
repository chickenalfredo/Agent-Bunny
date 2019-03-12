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

		Monster monster = new Monster(1000, 200, 100, 100, "Beetle.png");
		BlackWolf wolf = new BlackWolf(200.0, 300.0, 100, 100, "Cyclops.png");
		EndPoint ep = new EndPoint(50.0, 600.0, 100, 100, "Door.png");
		Grass block1 = new Grass(300.0, 500.0, 100, 100, "Float_Tile_Middle.png");
		Wall wall = new Wall(0, ScreenBuilder.getPrimaryScreenBounds().getHeight() - 150, ScreenBuilder.getPrimaryScreenBounds().getWidth(), 150, "Float_Tile_Middle.png");

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
