package core.external.level;

import core.ecs.components.*;
import core.external.entity.*;
import core.external.tile.*;
import core.external.weapon.Sword;
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

		Hero hero = new Hero(0, 0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Hero.png");
        hero.addComponents(new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new CollidableComponent(), new WeaponComponent());
        
        Sword sword = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Float_Tile_Middle.png");
        hero.addWeapon(sword);

		Enemy monster = new Enemy(1000, 200, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Beetle.png");
		monster.addComponents(new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new AIComponent(), new CollidableComponent());
		
		Enemy wolf = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Cyclops.png");
		wolf.addComponents(new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new AIComponent(), new CollidableComponent());
		
		EndPoint ep = new EndPoint(1200, 900, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Door.png");
		ep.addComponents(new RenderComponent(), new CollidableComponent(), new EndPointComponent());

		CheckPoint cp = new CheckPoint(2000, 900, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Door.png");
		cp.addComponents(new RenderComponent(), new CollidableComponent(), new EndPointComponent());
		
		Grass block1 = new Grass(500.0, 1050.0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Grass.png");
		block1.addComponents(new RenderComponent(), new CollidableComponent());
		
		Grass block2 = new Grass((block1.getWidth() + block1.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Grass.png");
		block2.addComponents(new RenderComponent(), new CollidableComponent());
		
		Grass block3 = new Grass((block2.getWidth() + block2.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Grass.png");
		block3.addComponents(new RenderComponent(), new CollidableComponent());
		
		Grass block4 = new Grass((block3.getWidth() + block3.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Grass.png");
		block4.addComponents(new RenderComponent(), new CollidableComponent());


		for (int i = 0; i < screenWidth * 3; i += (screenWidth * 0.035)) {
			Wall wall = new Wall(i, screenHeight - (screenHeight * 0.063), (screenWidth * 0.035), (screenHeight * 0.063), "src/main/resources/assets/Grass.png");
			wall.addComponents(new RenderComponent(), new CollidableComponent());
			sprites.add(wall);
		}
		
		sprites.add(hero);
		sprites.add(block1);
		sprites.add(block2);
		sprites.add(block3);
		sprites.add(block4);
		sprites.add(monster);
		sprites.add(wolf);
		sprites.add(ep);
		sprites.add(cp);

		for (Sprite sprite : sprites) {
			super.addSprite(sprite);
		}

	}

}
