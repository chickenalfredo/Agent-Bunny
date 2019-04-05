package core.game.map;

import core.component.components.*;
import core.entity.Entity;
import core.entity.attributes.CollidableAttribute;
import core.entity.attributes.NameAttribute;
import core.entity.attributes.Type;
import core.entity.attributes.TypeAttribute;
import core.game.GameMap;
import core.screens.ScreenBuilder;

import java.util.List;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */
public class Level extends GameMap implements Serializable {

	private static final long serialVersionUID = -5314502460219934264L;
	private static double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
    private static double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();

    /**
     * 
     */
	public Level() {

		List<Entity> sprites = new ArrayList<Entity>();

        Entity hero = new Entity();
        // Entity healthBar = new Entity();
        hero.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        hero.addAttribute(new TypeAttribute(Type.HERO), new CollidableAttribute(true), new NameAttribute("Hero"));
        sprites.add(hero);

        Entity alienBug = new Entity();
        // Entity healthBar2 = new Entity();
        alienBug.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        alienBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(alienBug);
        
        Entity alienCrabPurple = new Entity();
        // Entity healthBar3 = new Entity();
        alienCrabPurple.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        alienCrabPurple.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(alienCrabPurple);

        Entity alienCrabRed = new Entity();
        // Entity healthBar4 = new Entity();
        alienCrabRed.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        alienCrabRed.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(alienCrabRed);

        Entity alienDragon = new Entity();
        // Entity healthBar5 = new Entity();
        alienDragon.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        alienDragon.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(alienDragon);

        Entity alienTentacle = new Entity();
        // Entity healthBar6 = new Entity();
        alienTentacle.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        alienTentacle.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(alienTentacle);

        Entity blob = new Entity();
        // Entity healthBar7 = new Entity();
        blob.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        blob.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(blob);

        
        Entity blueBug = new Entity();
        // Entity healthBar8 = new Entity();
        blueBug.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        blueBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(blueBug);

        Entity greenBug = new Entity();
        // Entity healthBar9 = new Entity();
        greenBug.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        greenBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(greenBug);
        
        Entity orangeBug = new Entity();
        // Entity healthBar10 = new Entity();
        orangeBug.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        orangeBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(orangeBug);

        Entity purpleBug = new Entity();
        // Entity healthBar11 = new Entity();
        purpleBug.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        purpleBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(purpleBug);
        
        Entity fatty = new Entity();
        // Entity healthBar12 = new Entity();
        fatty.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        fatty.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(fatty);

        Entity endPoint = new Entity();
        endPoint.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        endPoint.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(endPoint);

        Entity checkPoint = new Entity();
        checkPoint.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        checkPoint.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(checkPoint);

        Entity block1 = new Entity();
        block1.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        block1.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(block1);
        
        Entity block2 = new Entity();
        block2.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        block2.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(block2);
        
        Entity block3 = new Entity();
        block3.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        block3.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(block3);
        
        Entity block4 = new Entity();
        block4.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
        block4.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true), new NameAttribute(""));
        sprites.add(block4);

        // TODO: This is very inefficient
		for (int i = 0; i < screenWidth * 3; i += (screenWidth * 0.035)) {
            Entity wall = new Entity();
            wall.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(), new RenderComponent(), new HealthComponent(), new DimensionComponent(), new PositionComponent(), new MovementComponent());
            wall.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true), new NameAttribute("wall"));
            File dir = new File("resources/assets/ground/");
            File[] directoryListing = dir.listFiles();
            if (directoryListing != null) {
                for (File c : directoryListing) {
                    // wall.addComponents(new RenderComponent(wall, c.toString()));
                }
            }
			sprites.add(wall);
		}

		for (Entity e : sprites) {
			super.addEntity(e);
		}

    }
    
}