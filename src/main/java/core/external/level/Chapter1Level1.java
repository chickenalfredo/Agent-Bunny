package core.external.level;

import core.ecs.components.*;
import core.external.entity.*;
import core.external.weapon.Sword;
import core.map.GameMap;
import core.screens.ScreenBuilder;
import core.sprite.Sprite;
import core.sprite.TileObject;

import java.util.List;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */
public class Chapter1Level1 extends GameMap implements Serializable {

	private static final long serialVersionUID = -5314502460219934264L;
	private static double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
    private static double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();

    /**
     * 
     */
	public Chapter1Level1() {

		List<Sprite> sprites = new ArrayList<Sprite>();

        Hero hero = new Hero(0, 0, (screenWidth * 0.035), (screenHeight * 0.063));
        Sword sword = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword.addComponents(new RenderComponent(sword, null));
        TileObject healthBar = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
		healthBar.addComponents(new RenderComponent(healthBar, null));
        hero.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(hero, null), new HealthComponent(healthBar), new WeaponComponent(sword));
        sprites.add(hero);

        Enemy alienBug = new Enemy(100.00, 200.0, (screenWidth * 0.035), (screenHeight * 0.063), "alien_bug");
        Sword sword2 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword2.addComponents(new RenderComponent(sword2, null));
        TileObject healthBar2 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
		healthBar2.addComponents(new RenderComponent(healthBar2, null));
		alienBug.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(alienBug, null), new HealthComponent(healthBar2), new AIComponent(alienBug), new WeaponComponent(sword2));
        sprites.add(alienBug);
        
        Enemy alienCrabPurple = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063) , "alien_crab_purple");
        Sword sword3 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword3.addComponents(new RenderComponent(sword3, null));
        TileObject healthBar3 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        healthBar3.addComponents(new RenderComponent(healthBar3, null));
		alienCrabPurple.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(alienCrabPurple, null), new HealthComponent(healthBar3), new AIComponent(alienCrabPurple), new WeaponComponent(sword3));
        sprites.add(alienCrabPurple);

        Enemy alienCrabRed = new Enemy(600.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063) , "alien_crab_red");
        Sword sword4 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword4.addComponents(new RenderComponent(sword4, null));
        TileObject healthBar4 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        healthBar4.addComponents(new RenderComponent(healthBar4, null));
        alienCrabRed.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(alienCrabRed, null), new HealthComponent(healthBar4), new AIComponent(alienCrabRed), new WeaponComponent(sword4));
        sprites.add(alienCrabRed);

        Enemy alienDragon = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063) , "alien_crab_purple");
        Sword sword5 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword5.addComponents(new RenderComponent(sword5, null));
        TileObject healthBar5 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        healthBar5.addComponents(new RenderComponent(healthBar5, null));
        alienDragon.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(alienDragon, null), new HealthComponent(healthBar5), new AIComponent(alienDragon), new WeaponComponent(sword5));
        sprites.add(alienDragon);

        Enemy alienTentacle = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063) , "alien_crab_purple");
        Sword sword6 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword6.addComponents(new RenderComponent(sword6, null));
        TileObject healthBar6 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        healthBar6.addComponents(new RenderComponent(healthBar6, null));
        alienTentacle.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(alienTentacle, null), new HealthComponent(healthBar6), new AIComponent(alienTentacle), new WeaponComponent(sword6));
        sprites.add(alienTentacle);

        Enemy blob = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063) , "alien_crab_purple");
        Sword sword7 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword7.addComponents(new RenderComponent(sword7, null));
        TileObject healthBar7 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        healthBar7.addComponents(new RenderComponent(healthBar7, null));
        blob.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(blob, null), new HealthComponent(healthBar7), new AIComponent(blob), new WeaponComponent(sword7));
        sprites.add(blob);

        
        Enemy blueBug = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063) , "alien_crab_purple");
        Sword sword8 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword8.addComponents(new RenderComponent(sword8, null));
        TileObject healthBar8 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        healthBar8.addComponents(new RenderComponent(healthBar8, null));
        blueBug.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(blueBug, null), new HealthComponent(healthBar8), new AIComponent(blueBug), new WeaponComponent(sword8));
        sprites.add(blueBug);

        Enemy greenBug = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063) , "alien_crab_purple");
        Sword sword9 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword9.addComponents(new RenderComponent(sword9, null));
        TileObject healthBar9 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        healthBar9.addComponents(new RenderComponent(healthBar9, null));
        greenBug.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(greenBug, null), new HealthComponent(healthBar9), new AIComponent(greenBug), new WeaponComponent(sword9));
        sprites.add(greenBug);
        
        Enemy orangeBug = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063) , "alien_crab_purple");
        Sword sword10 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword10.addComponents(new RenderComponent(sword10, null));
        TileObject healthBar10 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        healthBar10.addComponents(new RenderComponent(healthBar10, null));
        orangeBug.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(orangeBug, null), new HealthComponent(healthBar10), new AIComponent(orangeBug), new WeaponComponent(sword10));
        // sprites.add(orangeBug);

        Enemy purpleBug = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063) , "alien_crab_purple");
        Sword sword11 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword11.addComponents(new RenderComponent(sword11, null));
        TileObject healthBar11 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        healthBar11.addComponents(new RenderComponent(healthBar11, null));
        purpleBug.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(purpleBug, null), new HealthComponent(healthBar11), new AIComponent(purpleBug), new WeaponComponent(sword11));
        sprites.add(purpleBug);
        
        Enemy fatty = new Enemy(200.0, 300.0, (screenWidth * 0.035), (screenHeight * 0.063) , "alien_crab_purple");
        Sword sword12 = new Sword(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        // sword12.addComponents(new RenderComponent(sword12, null));
        TileObject healthBar12 = new TileObject(0.0, 0.0, (screenWidth * 0.035), (screenHeight * 0.063));
        healthBar12.addComponents(new RenderComponent(healthBar12, null));
		fatty.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(fatty, null), new HealthComponent(healthBar12), new AIComponent(fatty), new WeaponComponent(sword12));
        sprites.add(fatty);

		TileObject endPoint = new TileObject(1200, 900, (screenWidth * 0.035), (screenHeight * 0.063));
		endPoint.addComponents(new RenderComponent(endPoint, "resources/assets/Door.png"), new EndPointComponent());
        sprites.add(endPoint);

		TileObject checkPoint = new TileObject(2000, 900, (screenWidth * 0.035), (screenHeight * 0.063));
		checkPoint.addComponents(new RenderComponent(checkPoint, "resources/assets/CheckPoint_checkpoint_1.png"), new EndPointComponent());
        sprites.add(checkPoint);

		TileObject block1 = new TileObject(screenWidth*.20, screenHeight*.75, (screenWidth * 0.035), (screenHeight * 0.063));
		block1.addComponents(new RenderComponent(block1, "resources/assets/Block_floatblock_left.png"));
        sprites.add(block1);
        
		TileObject block2 = new TileObject((block1.getWidth() + block1.getX() - 1), screenHeight*.75, (screenWidth * 0.035), (screenHeight * 0.063));
		block2.addComponents(new RenderComponent(block2, "resources/assets/Block_floatblock_middle_1.png"));
        sprites.add(block2);
        
		TileObject block3 = new TileObject((block2.getWidth() + block2.getX() - 1), screenHeight*.75, (screenWidth * 0.035), (screenHeight * 0.063));
		block3.addComponents(new RenderComponent(block3, "resources/assets/Block_floatblock_middle_2.png"));
        sprites.add(block3);
        
		TileObject block4 = new TileObject((block3.getWidth() + block3.getX() - 1), screenHeight*.75, (screenWidth * 0.035), (screenHeight * 0.063));
		block4.addComponents(new RenderComponent(block4, "resources/assets/Block_floatblock_right.png"));
        sprites.add(block4);

        // TODO: This is very inefficient
		for (int i = 0; i < screenWidth * 3; i += (screenWidth * 0.035)) {
            TileObject wall = new TileObject(i, screenHeight - (screenHeight * 0.063), (screenWidth * 0.035), (screenHeight * 0.063));
            File dir = new File("resources/assets/ground/");
            File[] directoryListing = dir.listFiles();
            if (directoryListing != null) {
                for (File c : directoryListing) {
                    wall.addComponents(new RenderComponent(wall, c.toString()));
                }
            }
			sprites.add(wall);
		}

		for (Sprite sprite : sprites) {
			super.addSprite(sprite);
		}

	}

}