package core.game.map;

import core.component.*;
import core.entity.Entity;
import core.entity.attributes.CollidableAttribute;
import core.entity.attributes.NameAttribute;
import core.entity.attributes.Type;
import core.entity.attributes.TypeAttribute;
import core.game.GameMap;
import core.screens.ScreenBuilder;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Level extends GameMap implements Serializable {

    private static final long serialVersionUID = -5314502460219934264L;
    private static float screenHeight = (float) ScreenBuilder.getPrimaryScreenBounds().getHeight();
    private static float screenWidth = (float) ScreenBuilder.getPrimaryScreenBounds().getWidth();

    public Level() {
        List<Entity> sprites = new ArrayList<Entity>();

        Entity hero = new Entity();
        hero.addComponents(new StateComponent(), new PhysicsComponent(), 
                new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(200, 210), new VelocityComponent());
        hero.addComponents(new WeaponComponent(hero, 25, 800, 250));
        hero.addComponents(new HeroAnimationComponent(hero));
        hero.addAttribute(new TypeAttribute(Type.HERO), new CollidableAttribute(true), new NameAttribute("Hero"));
        sprites.add(hero);

        Entity alienBug = new Entity();
        alienBug.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(),
                 new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(0, 0), new VelocityComponent());
        alienBug.addComponents(new WeaponComponent(alienBug, 25, 50, 250));
        alienBug.addComponents(new AlienBugAnimationComponent(alienBug));
        alienBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienBug"));
        sprites.add(alienBug);

        Entity alienCrabPurple = new Entity();
        alienCrabPurple.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(),
                 new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 1.50), (float) (screenHeight * 0.063)),
                new PositionComponent(200, 0), new VelocityComponent());
        alienCrabPurple.addComponents(new WeaponComponent(alienCrabPurple, 25, 50, 250));
        alienCrabPurple.addComponents(new AlienCrabAnimationComponent(alienCrabPurple));
        alienCrabPurple.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienCrabPurple"));
        sprites.add(alienCrabPurple);

        Entity alienCrabRed = new Entity();
        alienCrabRed.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(),
                 new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(500, 0), new VelocityComponent());
        alienCrabRed.addComponents(new WeaponComponent(alienCrabRed, 25, 50, 250));
        alienCrabRed.addComponents(new AlienRedCrabAnimationComponent(alienCrabRed));
        alienCrabRed.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienCrabRed"));
        sprites.add(alienCrabRed);

        Entity alienDragon = new Entity();
        alienDragon.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(),
                 new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 2.0), (float) (screenHeight * 0.063)),
                new PositionComponent(900, 0), new VelocityComponent());
        alienDragon.addComponents(new WeaponComponent(alienDragon, 25, 50, 250));
        alienDragon.addComponents(new AlienDragonAnimationComponent(alienDragon));
        alienDragon.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienDragon"));
        sprites.add(alienDragon);

        Entity endPoint = new Entity();
        endPoint.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(1200, 900));
        endPoint.addComponents(new RenderComponent(endPoint, "resources/assets/Asset 9.png"));
        endPoint.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("endPoint"));
        sprites.add(endPoint);

        Entity checkPoint = new Entity();
        checkPoint.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(2000, 900));
        checkPoint.addComponents(new RenderComponent(checkPoint, "resources/assets/Asset 1.png"));
        checkPoint.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("checkPoint"));
        sprites.add(checkPoint);

        Entity block1 = new Entity();
        block1.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * .20), (float) (screenHeight * .75)));
        block1.addComponents(new RenderComponent(block1, "resources/assets/GrassMid.png"));
        block1.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block1"));
        sprites.add(block1);

        Entity block2 = new Entity();
        block2.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block1.getComponent(PositionComponent.class).getX()
                                + block1.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block2.addComponents(new RenderComponent(block2, "resources/assets/GrassMid.png"));
        block2.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block2"));
        sprites.add(block2);

        Entity block3 = new Entity();
        block3.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block2.getComponent(PositionComponent.class).getX()
                                + block1.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block3.addComponents(new RenderComponent(block3, "resources/assets/GrassMid.png"));
        block3.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block3"));
        sprites.add(block3);

        Entity block4 = new Entity();
        block4.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block3.getComponent(PositionComponent.class).getX()
                                + block1.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block4.addComponents(new RenderComponent(block4, "resources/assets/GrassMid.png"));
        block4.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block4"));
        sprites.add(block4);

        //first hill
        Entity block5 = new Entity();
        block5.addComponents(new DimensionComponent((float) (screenWidth * 0.037), (float) (screenHeight * 0.067)),
                new PositionComponent((float) (screenWidth * .95), (float) (screenHeight - (2 * screenHeight * 0.063))));
        block5.addComponents(new RenderComponent(block5, "resources/assets/Dirt.png"));
        block5.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block5"));
        sprites.add(block5);

        Entity block6 = new Entity();
        block6.addComponents(new DimensionComponent((float) (screenWidth * 0.037), (float) (screenHeight * 0.067)),
                new PositionComponent(
                        (block5.getComponent(PositionComponent.class).getX()
                                + block5.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight - (2 * screenHeight * 0.063))));
        block6.addComponents(new RenderComponent(block6, "resources/assets/Dirt.png"));
        block6.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block6"));
        sprites.add(block6);

        Entity block7 = new Entity();
        block7.addComponents(new DimensionComponent((float) (screenWidth * 0.037), (float) (screenHeight * 0.067)),
                new PositionComponent(
                        (block5.getComponent(PositionComponent.class).getX()),
                        (float) (screenHeight - (3 * screenHeight * 0.063))));
        block7.addComponents(new RenderComponent(block7, "resources/assets/Dirt.png"));
        block7.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block7"));
        sprites.add(block7);

        Entity block8 = new Entity();
        block8.addComponents(new DimensionComponent((float) (screenWidth * 0.037), (float) (screenHeight * 0.067)),
                new PositionComponent(
                        (block7.getComponent(PositionComponent.class).getX())
                        + block7.getComponent(DimensionComponent.class).getWidth() - 1,
                        (float) (screenHeight - (3 * screenHeight * 0.063))));
        block8.addComponents(new RenderComponent(block8, "resources/assets/GrassMid.png"));
        block8.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block8"));
        sprites.add(block8);

        Entity block9 = new Entity();
        block9.addComponents(new DimensionComponent((float) (screenWidth * 0.037), (float) (screenHeight * 0.067)),
                new PositionComponent(
                        (block7.getComponent(PositionComponent.class).getX()),
                        (float) (screenHeight - (4 * screenHeight * 0.063))));
        block9.addComponents(new RenderComponent(block9, "resources/assets/GrassMid.png"));
        block9.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block9"));
        sprites.add(block9);
        
        //second hill
        Entity block10 = new Entity();
        block10.addComponents(new DimensionComponent((float) (screenWidth * 0.037), (float) (screenHeight * 0.067)),
                new PositionComponent((float) (screenWidth * 1.90), (float) (screenHeight - (2 * screenHeight * 0.063))));
        block10.addComponents(new RenderComponent(block10, "resources/assets/Dirt.png"));
        block10.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block10"));
        sprites.add(block10);

        Entity block11 = new Entity();
        block11.addComponents(new DimensionComponent((float) (screenWidth * 0.037), (float) (screenHeight * 0.067)),
                new PositionComponent(
                        (block10.getComponent(PositionComponent.class).getX()
                                - block10.getComponent(DimensionComponent.class).getWidth() + 1),
                        (float) (screenHeight - (2 * screenHeight * 0.063))));
        block11.addComponents(new RenderComponent(block11, "resources/assets/Grass.png"));
        block11.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block11"));
        sprites.add(block11);

        Entity block12 = new Entity();
        block12.addComponents(new DimensionComponent((float) (screenWidth * 0.037), (float) (screenHeight * 0.067)),
                new PositionComponent(
                        (block10.getComponent(PositionComponent.class).getX()
                                + block10.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight - (2 * screenHeight * 0.063))));
        block12.addComponents(new RenderComponent(block12, "resources/assets/Dirt.png"));
        block12.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block12"));
        sprites.add(block12);

        Entity block13 = new Entity();
        block13.addComponents(new DimensionComponent((float) (screenWidth * 0.037), (float) (screenHeight * 0.067)),
                new PositionComponent(
                        (block10.getComponent(PositionComponent.class).getX()),
                        (float) (screenHeight - (3 * screenHeight * 0.063))));
        block13.addComponents(new RenderComponent(block13, "resources/assets/Dirt.png"));
        block13.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block13"));
        sprites.add(block13);

        Entity block14 = new Entity();
        block14.addComponents(new DimensionComponent((float) (screenWidth * 0.037), (float) (screenHeight * 0.067)),
                new PositionComponent(
                        (block12.getComponent(PositionComponent.class).getX()),
                        //+ block12.getComponent(DimensionComponent.class).getWidth() - 1,
                        (float) (screenHeight - (3 * screenHeight * 0.063))));
        block14.addComponents(new RenderComponent(block14, "resources/assets/GrassMid.png"));
        block14.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block14"));
        sprites.add(block14);

        Entity block15 = new Entity();
        block15.addComponents(new DimensionComponent((float) (screenWidth * 0.037), (float) (screenHeight * 0.067)),
                new PositionComponent(
                        (block12.getComponent(PositionComponent.class).getX())
                        - block12.getComponent(DimensionComponent.class).getWidth(),
                        (float) (screenHeight - (4 * screenHeight * 0.063))));
        block15.addComponents(new RenderComponent(block15, "resources/assets/GrassMid.png"));
        block15.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block15"));
        sprites.add(block15);

        //trees


        for (int i = 0; i < screenWidth * 3; i += (screenWidth * 0.035)) {
            Entity wall = new Entity();
            wall.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                    new PositionComponent(i, (float) (screenHeight - (screenHeight * 0.063))));
            wall.addComponents(new RenderComponent(wall, "resources/assets/GrassMid.png"));
            wall.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                    new NameAttribute("wall"));

            sprites.add(wall);
            }
        for (Entity e : sprites) {
            super.addEntity(e);
        }

    }

}