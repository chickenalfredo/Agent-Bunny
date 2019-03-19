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

	private static double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
    private static double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();

	public Chapter1Level1() {

		List<Sprite> sprites = new ArrayList<Sprite>();

		Monster monster = new Monster(1000, 200, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Beetle.png");
		BlackWolf wolf = new BlackWolf(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Cyclops.png");
		EndPoint ep = new EndPoint(1200, 900, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Door.png");
		Grass block1 = new Grass(500.0, 1050.0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Grass.png");
		Grass block2 = new Grass((block1.getWidth() + block1.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Grass.png");
		Grass block3 = new Grass((block2.getWidth() + block2.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Grass.png");
		Grass block4 = new Grass((block3.getWidth() + block3.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Grass.png");


		for (int i = 0; i < screenWidth * 3; i += (screenWidth * 0.035)) {
			Wall wall = new Wall(i, screenHeight - (screenHeight * 0.063), (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Grass.png");
			sprites.add(wall);
		}
		
		System.out.println("Screen height: " + screenHeight);
		System.out.println("wall offset: " + (screenHeight - (screenHeight * 0.063)));
		System.out.println("Difference: " + (screenHeight - (screenHeight - (screenHeight * 0.063))));
		System.out.println("wall height: " + (screenHeight * 0.063));
	
		sprites.add(block1);
		sprites.add(block2);
		sprites.add(block3);
		sprites.add(block4);
		sprites.add(monster);
		sprites.add(wolf);
		sprites.add(ep);

		for (Sprite sprite : sprites) {
			super.addSprite(sprite);
		}

	}

}
