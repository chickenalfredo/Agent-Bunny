// package core.external.level;

// import core.ecs.components.*;
// import core.external.entity.*;
// import core.external.weapon.Sword;
// import core.map.GameMap;
// import core.screens.ScreenBuilder;
// import core.sprite.Sprite;
// import core.sprite.TileObject;

// import java.util.List;
// import java.io.Serializable;
// import java.util.ArrayList;

// /**
//  * 
//  */
// public class Chapter1Level1 extends GameMap implements Serializable {

// 	private static final long serialVersionUID = -5314502460219934264L;
// 	private static double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
//     private static double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();

//     /**
//      * 
//      */
// 	public Chapter1Level1() {

// 		List<Sprite> sprites = new ArrayList<Sprite>();

// 		Sword sword = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
//         // sword.addComponents(new RenderComponent(sword, "resources/assets/Float_Tile_Middle.png"));

//         Sword sword2 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
//         // sword2.addComponents(new RenderComponent(sword2, "resources/assets/Float_Tile_Middle.png"));

//         Sword sword3 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
//         // sword3.addComponents(new RenderComponent(sword3, "resources/assets/Float_Tile_Middle.png"));

// 		TileObject healthBar = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
// 		healthBar.addComponents(new RenderComponent(healthBar, "resources/assets/Float_Tile_Middle.png"));
		
// 		TileObject healthBar2 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
// 		healthBar2.addComponents(new RenderComponent(healthBar2, "resources/assets/Float_Tile_Middle.png"));
		
// 		TileObject healthBar3 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
//         healthBar3.addComponents(new RenderComponent(healthBar3, "resources/assets/Float_Tile_Middle.png"));

// 		// Hero hero = new Hero(0, 0, (screenWidth * 0.062), (screenHeight * 0.074));
// 		Hero hero = new Hero(0, 0, (screenWidth * 0.035), (screenHeight * 0.063));
//         hero.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(hero, "resources/assets/Hero.png"), new HealthComponent(healthBar), new CollidableComponent(), new WeaponComponent(sword));

// 		Enemy monster = new Enemy(1000, 200, (screenWidth * 0.035), (screenHeight * 0.063));
// 		monster.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(monster, "resources/assets/Beetle.png"), new HealthComponent(healthBar2), new AIComponent(monster), new CollidableComponent(), new WeaponComponent(sword2));
		
// 		Enemy wolf = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063));
// 		wolf.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(wolf, "resources/assets/Cyclops.png"), new HealthComponent(healthBar3), new AIComponent(wolf), new CollidableComponent(), new WeaponComponent(sword3));
		
// 		TileObject endPoint = new TileObject(1200, 900, (screenWidth * 0.035), (screenHeight * 0.063));
// 		endPoint.addComponents(new RenderComponent(endPoint, "resources/assets/Door.png"), new CollidableComponent(), new EndPointComponent());

// 		TileObject checkPoint = new TileObject(2000, 900, (screenWidth * 0.035), (screenHeight * 0.063));
// 		checkPoint.addComponents(new RenderComponent(checkPoint, "resources/assets/Door.png"), new CollidableComponent(), new EndPointComponent());
		
// 		TileObject block1 = new TileObject(500.0, 1050.0, (screenWidth * 0.035), (screenHeight * 0.063));
// 		block1.addComponents(new RenderComponent(block1, "resources/assets/Grass.png"), new CollidableComponent());
		
// 		TileObject block2 = new TileObject((block1.getWidth() + block1.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063));
// 		block2.addComponents(new RenderComponent(block2, "resources/assets/Grass.png"), new CollidableComponent());
		
// 		TileObject block3 = new TileObject((block2.getWidth() + block2.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063));
// 		block3.addComponents(new RenderComponent(block3, "resources/assets/Grass.png"), new CollidableComponent());
		
// 		TileObject block4 = new TileObject((block3.getWidth() + block3.getX()), 1050.0, (screenWidth * 0.035), (screenHeight * 0.063));
// 		block4.addComponents(new RenderComponent(block4, "resources/assets/Grass.png"), new CollidableComponent());


// 		for (int i = 0; i < screenWidth * 3; i += (screenWidth * 0.035)) {
// 			TileObject wall = new TileObject(i, screenHeight - (screenHeight * 0.063), (screenWidth * 0.035), (screenHeight * 0.063));
// 			wall.addComponents(new RenderComponent(wall, "resources/assets/Grass.png"), new CollidableComponent());
// 			sprites.add(wall);
// 		}
		
// 		sprites.add(hero);
// 		sprites.add(block1);
// 		sprites.add(block2);
// 		sprites.add(block3);
// 		sprites.add(block4);
// 		sprites.add(monster);
// 		sprites.add(wolf);
// 		sprites.add(endPoint);
// 		sprites.add(checkPoint);

// 		for (Sprite sprite : sprites) {
// 			super.addSprite(sprite);
// 		}

// 	}

// }