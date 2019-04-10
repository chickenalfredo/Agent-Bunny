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
        hero.addComponents(new StateComponent(), new PhysicsComponent(), new AttackComponent(25, 50, 250),
                new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(200, 210), new VelocityComponent());
        hero.addComponents(new HeroAnimationComponent(hero));
        hero.addAttribute(new TypeAttribute(Type.HERO), new CollidableAttribute(true), new NameAttribute("Hero"));
        sprites.add(hero);

        Entity alienBug = new Entity();
        alienBug.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(), new AttackComponent(),
                new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(0, 0), new VelocityComponent());
        alienBug.addComponents(new HeroAnimationComponent(alienBug));
        alienBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienBug"));
        sprites.add(alienBug);

        Entity alienCrabPurple = new Entity();
        alienCrabPurple.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(),
                new AttackComponent(), new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(), new VelocityComponent());
        alienCrabPurple.addComponents(new HeroAnimationComponent(alienCrabPurple));
        alienCrabPurple.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienCrabPurple"));
        sprites.add(alienCrabPurple);

        Entity alienCrabRed = new Entity();
        alienCrabRed.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(),
                new AttackComponent(), new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(), new VelocityComponent());
        alienCrabRed.addComponents(new HeroAnimationComponent(alienCrabRed));
        alienCrabRed.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienCrabRed"));
        sprites.add(alienCrabRed);

        Entity alienDragon = new Entity();
        alienDragon.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(),
                new AttackComponent(), new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(), new VelocityComponent());
        alienDragon.addComponents(new HeroAnimationComponent(alienDragon));
        alienDragon.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienDragon"));
        sprites.add(alienDragon);

        Entity alienTentacle = new Entity();
        alienTentacle.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(),
                new AttackComponent(), new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(), new VelocityComponent());
        alienTentacle.addComponents(new HeroAnimationComponent(alienTentacle));
        alienTentacle.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienTentacle"));
        sprites.add(alienTentacle);

        Entity blob = new Entity();
        blob.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(), new AttackComponent(),
                new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(), new VelocityComponent());
        blob.addComponents(new HeroAnimationComponent(blob));
        blob.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute("blob"));
        sprites.add(blob);

        Entity blueBug = new Entity();
        blueBug.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(), new AttackComponent(),
                new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(), new VelocityComponent());
        blueBug.addComponents(new HeroAnimationComponent(blueBug));
        blueBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("blueBug"));
        sprites.add(blueBug);

        Entity greenBug = new Entity();
        greenBug.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(), new AttackComponent(),
                new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(), new VelocityComponent());
        greenBug.addComponents(new HeroAnimationComponent(greenBug));
        greenBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("greenBug"));
        sprites.add(greenBug);

        Entity orangeBug = new Entity();
        orangeBug.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(), new AttackComponent(),
                new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(), new VelocityComponent());
        orangeBug.addComponents(new HeroAnimationComponent(orangeBug));
        orangeBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("orangeBug"));
        sprites.add(orangeBug);

        Entity purpleBug = new Entity();
        purpleBug.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(), new AttackComponent(),
                new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(), new VelocityComponent());
        purpleBug.addComponents(new HeroAnimationComponent(purpleBug));
        purpleBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("purpleBug"));
        sprites.add(purpleBug);

        Entity fatty = new Entity();
        fatty.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(), new AttackComponent(),
                new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(), new VelocityComponent());
        fatty.addComponents(new HeroAnimationComponent(fatty));
        fatty.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true), new NameAttribute("fatty"));
        sprites.add(fatty);

        Entity endPoint = new Entity();
        endPoint.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(1200, 900));
        endPoint.addComponents(new RenderComponent(endPoint, "resources/assets/Door.png"));
        endPoint.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("endPoint"));
        sprites.add(endPoint);

        Entity checkPoint = new Entity();
        checkPoint.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(2000, 900));
        checkPoint.addComponents(new RenderComponent(checkPoint, "resources/assets/CheckPoint_checkpoint_1.png"));
        checkPoint.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("checkPoint"));
        sprites.add(checkPoint);

        Entity block1 = new Entity();
        block1.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * .20), (float) (screenHeight * .75)));
        block1.addComponents(new RenderComponent(block1, "resources/assets/Block_floatblock_left.png"));
        block1.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block1"));
        sprites.add(block1);

        Entity block2 = new Entity();
        block2.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block1.getComponent(PositionComponent.class).getX()
                                + block1.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block2.addComponents(new RenderComponent(block2, "resources/assets/Block_floatblock_middle_1.png"));
        block2.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block2"));
        sprites.add(block2);

        Entity block3 = new Entity();
        block3.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block2.getComponent(PositionComponent.class).getX()
                                + block1.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block3.addComponents(new RenderComponent(block3, "resources/assets/Block_floatblock_middle_2.png"));
        block3.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block3"));
        sprites.add(block3);

        Entity block4 = new Entity();
        block4.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block3.getComponent(PositionComponent.class).getX()
                                + block1.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block4.addComponents(new RenderComponent(block4, "resources/assets/Block_floatblock_right.png"));
        block4.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block4"));
        sprites.add(block4);

        for (int i = 0; i < screenWidth * 3; i += (screenWidth * 0.035)) {
            Entity wall = new Entity();
            wall.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                    new PositionComponent(i, (float) (screenHeight - (screenHeight * 0.063))));
            wall.addComponents(new RenderComponent(wall, "resources/assets/Block_grass4_1.png"));
            wall.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                    new NameAttribute("wall"));

            sprites.add(wall);
        }

        for (Entity e : sprites) {
            super.addEntity(e);
        }

    }

}