package core.external.level;

import core.animations.Animation;
import core.ecs.components.*;
import core.external.entity.*;
import core.external.weapon.Sword;
import core.map.GameMap;
import core.screens.ScreenBuilder;
import core.sprite.Sprite;
import core.sprite.TileObject;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 */
public class Chapter1Level1 extends GameMap {

	private static double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
    private static double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();

    /**
     * 
     */
	public Chapter1Level1() {

		List<Sprite> sprites = new ArrayList<Sprite>();

		Sword sword = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        sword.addComponents(new RenderComponent(sword, "src/main/resources/assets/Float_Tile_Middle.png"));

        Sword sword2 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        sword2.addComponents(new RenderComponent(sword2, "src/main/resources/assets/Float_Tile_Middle.png"));

        Sword sword3 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        sword3.addComponents(new RenderComponent(sword3, "src/main/resources/assets/Float_Tile_Middle.png"));

		Hero hero = new Hero(0, 0, (screenWidth * 0.035), (screenHeight * 0.063));
        hero.addComponents(new PhysicsComponent(), new AttackComponent(), new RenderComponent(hero, "src/main/resources/assets/adventurer-1.3-Sheet.png", new Animation()), new HealthComponent(), new CollidableComponent(), new WeaponComponent(sword));

		Enemy monster = new Enemy(1000, 200, (screenWidth * 0.035), (screenHeight * 0.063));
		monster.addComponents(new PhysicsComponent(), new AttackComponent(), new RenderComponent(monster, "src/main/resources/assets/Beetle.png", new Animation()), new HealthComponent(), new AIComponent(), new CollidableComponent(), new WeaponComponent(sword2));
		
		Enemy wolf = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063));
		wolf.addComponents(new PhysicsComponent(), new AttackComponent(), new RenderComponent(wolf, "src/main/resources/assets/Cyclops.png", new Animation()), new HealthComponent(), new AIComponent(), new CollidableComponent(), new WeaponComponent(sword3));
		
		TileObject endPoint = new TileObject(1200, 900, (screenWidth * 0.035), (screenHeight * 0.063));
		endPoint.addComponents(new RenderComponent(endPoint, "src/main/resources/assets/Door.png"), new CollidableComponent(), new EndPointComponent());

		TileObject checkPoint = new TileObject(2000, 900, (screenWidth * 0.035), (screenHeight * 0.063));
		checkPoint.addComponents(new RenderComponent(checkPoint, "src/main/resources/assets/Door.png"), new CollidableComponent(), new EndPointComponent());
		
		TileObject block1 = new TileObject(500.0, 1050.0, (screenWidth * 0.035), (screenHeight * 0.063));
		block1.addComponents(new RenderComponent(block1, "src/main/resources/assets/Grass.png"), new CollidableComponent());
		
		TileObject block2 = new TileObject((block1.getWidth() + block1.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063));
		block2.addComponents(new RenderComponent(block2, "src/main/resources/assets/Grass.png"), new CollidableComponent());
		
		TileObject block3 = new TileObject((block2.getWidth() + block2.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063));
		block3.addComponents(new RenderComponent(block3, "src/main/resources/assets/Grass.png"), new CollidableComponent());
		
		TileObject block4 = new TileObject((block3.getWidth() + block3.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063));
		block4.addComponents(new RenderComponent(block4, "src/main/resources/assets/Grass.png"), new CollidableComponent());


		for (int i = 0; i < screenWidth * 3; i += (screenWidth * 0.035)) {
			TileObject wall = new TileObject(i, screenHeight - (screenHeight * 0.063), (screenWidth * 0.035), (screenHeight * 0.063));
			wall.addComponents(new RenderComponent(wall, "src/main/resources/assets/Grass.png"), new CollidableComponent());
			sprites.add(wall);
		}
		
		sprites.add(hero);
		sprites.add(block1);
		sprites.add(block2);
		sprites.add(block3);
		sprites.add(block4);
		sprites.add(monster);
		sprites.add(wolf);
		sprites.add(endPoint);
		sprites.add(checkPoint);

		for (Sprite sprite : sprites) {
			super.addSprite(sprite);
		}

	}

}
