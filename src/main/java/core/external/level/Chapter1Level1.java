package core.external.level;

import core.external.entity.*;
import core.external.tile.*;
import core.map.GameMap;
import core.sprite.Sprite;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 */
public class Chapter1Level1 extends GameMap {

	public Chapter1Level1() {

		List<Sprite> sprites = new ArrayList<Sprite>();

		Monster monster = new Monster(10.0, 5.0, 5.0, 5.0, 'm', "Monster", 1, 1.0);
		BlackWolf wolf = new BlackWolf(15.0, 10.0, 5.0, 5.0, 'w', "Wolf", 1, 1.0);
		Hero player = new Hero(5.0, 0.0, 5.0, 5.0, 'x', "Hero", 1, 1.0);
		CheckPoint cp = new CheckPoint(20.0, 15.0, 5.0, 5.0, '!');
		Clouds cloud = new Clouds(25.0, 10.0, 5.0, 5.0, '=');
		EndPoint ep = new EndPoint(30.0, 25.0, 5.0, 5.0, 'e');
		Water water = new Water(35.0, 15.0, 5.0, 5.0, 'w');
		StandardBlock block1 = new StandardBlock(0, 0, 5, 5, '-');

		sprites.add(block1);
		sprites.add(monster);
		sprites.add(wolf);
		sprites.add(player);
		sprites.add(cp);
		sprites.add(cloud);
		sprites.add(ep);
		sprites.add(water);

		for (Sprite sprite : sprites) {
			super.addSprite(sprite);
			System.out.println(sprite.toString());
		}

	}

}
