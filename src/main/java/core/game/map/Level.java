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
        hero.addComponents(new StateComponent(), new PhysicsComponent(), new WeaponComponent(25, 50, 250),
                new AttackComponent(), new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(200, 210), new VelocityComponent());
        hero.addComponents(new HeroAnimationComponent(hero));
        hero.addAttribute(new TypeAttribute(Type.HERO), new CollidableAttribute(true), new NameAttribute("Hero"));
        sprites.add(hero);

        Entity alienBug = new Entity();
        alienBug.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(),
                new WeaponComponent(25, 50, 250), new AttackComponent(), new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(0, 0), new VelocityComponent());
        alienBug.addComponents(new AlienBugAnimationComponent(alienBug));
        alienBug.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienBug"));
        sprites.add(alienBug);

        Entity alienCrabPurple = new Entity();
        alienCrabPurple.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(),
                new WeaponComponent(25, 50, 250), new AttackComponent(), new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(200, 0), new VelocityComponent());
        alienCrabPurple.addComponents(new AlienCrabAnimationComponent(alienCrabPurple));
        alienCrabPurple.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienCrabPurple"));
        sprites.add(alienCrabPurple);

        Entity alienDragon = new Entity();
        alienDragon.addComponents(new AIComponent(), new StateComponent(), new PhysicsComponent(),
                new WeaponComponent(25, 50, 250), new AttackComponent(), new HealthComponent(),
                new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(900, 0), new VelocityComponent());
        alienDragon.addComponents(new AlienDragonAnimationComponent(alienDragon));
        alienDragon.addAttribute(new TypeAttribute(Type.ENEMY), new CollidableAttribute(true),
                new NameAttribute("alienDragon"));
        sprites.add(alienDragon);

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

        //first platform
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

        //second platform
        Entity block5 = new Entity();
        block5.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * .60), (float) (screenHeight * .75)));
        block5.addComponents(new RenderComponent(block5, "resources/assets/Block_floatblock_left.png"));
        block5.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block5"));
        sprites.add(block5);

        Entity block6 = new Entity();
        block6.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block5.getComponent(PositionComponent.class).getX()
                                + block5.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block6.addComponents(new RenderComponent(block6, "resources/assets/Block_floatblock_middle_1.png"));
        block6.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block6"));
        sprites.add(block6);

        Entity block7 = new Entity();
        block7.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block6.getComponent(PositionComponent.class).getX()
                                + block5.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block7.addComponents(new RenderComponent(block7, "resources/assets/Block_floatblock_middle_2.png"));
        block7.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block7"));
        sprites.add(block7);

        Entity block8 = new Entity();
        block8.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block7.getComponent(PositionComponent.class).getX()
                                + block5.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block8.addComponents(new RenderComponent(block8, "resources/assets/Block_floatblock_right.png"));
        block8.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block8"));
        sprites.add(block8);

        //third platform
        Entity block9 = new Entity();
        block9.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * .40), (float) (screenHeight * .50)));
        block9.addComponents(new RenderComponent(block9, "resources/assets/Block_floatblock_left.png"));
        block9.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block9"));
        sprites.add(block9);

        Entity block10 = new Entity();
        block10.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block9.getComponent(PositionComponent.class).getX()
                                + block9.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .50)));
        block10.addComponents(new RenderComponent(block10, "resources/assets/Block_floatblock_middle_1.png"));
        block10.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block10"));
        sprites.add(block10);

        Entity block11 = new Entity();
        block11.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block10.getComponent(PositionComponent.class).getX()
                                + block9.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .50)));
        block11.addComponents(new RenderComponent(block11, "resources/assets/Block_floatblock_middle_2.png"));
        block11.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block7"));
        sprites.add(block11);

        Entity block12 = new Entity();
        block12.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block11.getComponent(PositionComponent.class).getX()
                                + block9.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .50)));
        block12.addComponents(new RenderComponent(block12, "resources/assets/Block_floatblock_middle_1.png"));
        block12.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block12"));
        sprites.add(block12);

        Entity block13 = new Entity();
        block13.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block12.getComponent(PositionComponent.class).getX()
                                + block9.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .50)));
        block13.addComponents(new RenderComponent(block13, "resources/assets/Block_floatblock_middle_2.png"));
        block13.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block13"));
        sprites.add(block13);

        Entity block14 = new Entity();
        block14.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block13.getComponent(PositionComponent.class).getX()
                                + block9.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .50)));
        block14.addComponents(new RenderComponent(block14, "resources/assets/Block_floatblock_right.png"));
        block14.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block14"));
        sprites.add(block14);

        //fourth platform
        Entity block15 = new Entity();
        block15.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * .75), (float) (screenHeight * .30)));
        block15.addComponents(new RenderComponent(block15, "resources/assets/Block_floatblock_left.png"));
        block15.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block15"));
        sprites.add(block15);

        Entity block16 = new Entity();
        block16.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block15.getComponent(PositionComponent.class).getX()
                                + block15.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .30)));
        block16.addComponents(new RenderComponent(block14, "resources/assets/Block_floatblock_right.png"));
        block16.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block16"));
        sprites.add(block16);

        //fifth platform
        Entity block17 = new Entity();
        block17.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * .95), (float) (screenHeight * .25)));
        block17.addComponents(new RenderComponent(block17, "resources/assets/Block_floatblock_left.png"));
        block17.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block17"));
        sprites.add(block17);

        Entity block18 = new Entity();
        block18.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block17.getComponent(PositionComponent.class).getX()
                                + block17.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .25)));
        block18.addComponents(new RenderComponent(block18, "resources/assets/Block_floatblock_middle_1.png"));
        block18.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block18"));
        sprites.add(block18);

        Entity block19 = new Entity();
        block19.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block18.getComponent(PositionComponent.class).getX()
                                + block17.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .25)));
        block19.addComponents(new RenderComponent(block19, "resources/assets/Block_floatblock_middle_2.png"));
        block19.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block19"));
        sprites.add(block19);

        Entity block20 = new Entity();
        block20.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block19.getComponent(PositionComponent.class).getX()
                                + block17.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .25)));
        block20.addComponents(new RenderComponent(block20, "resources/assets/Block_floatblock_middle_1.png"));
        block20.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block20"));
        sprites.add(block20);

        Entity block21 = new Entity();
        block21.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block20.getComponent(PositionComponent.class).getX()
                                + block17.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .25)));
        block21.addComponents(new RenderComponent(block21, "resources/assets/Block_floatblock_middle_2.png"));
        block21.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block21"));
        sprites.add(block21);

        Entity block22 = new Entity();
        block22.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block21.getComponent(PositionComponent.class).getX()
                                + block17.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .25)));
        block22.addComponents(new RenderComponent(block22, "resources/assets/Block_floatblock_middle_1.png"));
        block22.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block22"));
        sprites.add(block22);

        Entity block23 = new Entity();
        block23.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block22.getComponent(PositionComponent.class).getX()
                                + block17.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .25)));
        block23.addComponents(new RenderComponent(block11, "resources/assets/Block_floatblock_middle_2.png"));
        block23.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block23"));
        sprites.add(block23);

        Entity block24 = new Entity();
        block24.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block23.getComponent(PositionComponent.class).getX()
                                + block17.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .25)));
        block24.addComponents(new RenderComponent(block24, "resources/assets/Block_floatblock_right.png"));
        block24.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block24"));
        sprites.add(block24);

        //sixth platform
        Entity block25 = new Entity();
        block25.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * 1.25), (float) (screenHeight * .75)));
        block25.addComponents(new RenderComponent(block25, "resources/assets/Block_floatblock_left.png"));
        block25.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block25"));
        sprites.add(block25);

        Entity block26 = new Entity();
        block26.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block25.getComponent(PositionComponent.class).getX()
                                + block25.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block26.addComponents(new RenderComponent(block26, "resources/assets/Block_floatblock_middle_1.png"));
        block26.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block26"));
        sprites.add(block26);

        Entity block27 = new Entity();
        block27.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block26.getComponent(PositionComponent.class).getX()
                                + block25.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block27.addComponents(new RenderComponent(block11, "resources/assets/Block_floatblock_middle_2.png"));
        block27.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block27"));
        sprites.add(block27);

        Entity block28 = new Entity();
        block28.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block27.getComponent(PositionComponent.class).getX()
                                + block25.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .75)));
        block28.addComponents(new RenderComponent(block14, "resources/assets/Block_floatblock_right.png"));
        block28.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block28"));
        sprites.add(block28);

        //seventh platform
        Entity block29 = new Entity();
        block29.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * 1.45), (float) (screenHeight * .40)));
        block29.addComponents(new RenderComponent(block29, "resources/assets/Block_floatblock_left.png"));
        block29.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block29"));
        sprites.add(block29);

        Entity block30 = new Entity();
        block30.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block29.getComponent(PositionComponent.class).getX()
                                + block29.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .40)));
        block30.addComponents(new RenderComponent(block30, "resources/assets/Block_floatblock_right.png"));
        block30.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block30"));
        sprites.add(block30);

        //eighth platform
        Entity block31 = new Entity();
        block31.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * 1.80), (float) (screenHeight * .70)));
        block31.addComponents(new RenderComponent(block31, "resources/assets/Block_floatblock_left.png"));
        block31.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block31"));
        sprites.add(block31);

        Entity block32 = new Entity();
        block32.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block31.getComponent(PositionComponent.class).getX()
                                + block31.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .70)));
        block32.addComponents(new RenderComponent(block32, "resources/assets/Block_floatblock_middle_1.png"));
        block32.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block32"));
        sprites.add(block32);

        Entity block33 = new Entity();
        block33.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block32.getComponent(PositionComponent.class).getX()
                                + block31.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .70)));
        block33.addComponents(new RenderComponent(block33, "resources/assets/Block_floatblock_middle_2.png"));
        block33.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block33"));
        sprites.add(block33);

        Entity block34 = new Entity();
        block34.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block33.getComponent(PositionComponent.class).getX()
                                + block31.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .70)));
        block34.addComponents(new RenderComponent(block34, "resources/assets/Block_floatblock_right.png"));
        block34.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block34"));
        sprites.add(block34);

        //ninth platform
        Entity block35 = new Entity();
        block35.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * 2.10), (float) (screenHeight * .50)));
        block35.addComponents(new RenderComponent(block35, "resources/assets/Block_floatblock_left.png"));
        block35.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block35"));
        sprites.add(block35);

        Entity block36 = new Entity();
        block36.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block35.getComponent(PositionComponent.class).getX()
                                + block35.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .50)));
        block36.addComponents(new RenderComponent(block30, "resources/assets/Block_floatblock_right.png"));
        block36.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block36"));
        sprites.add(block36);

        //tenth blocks
        Entity block37 = new Entity();
        block37.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * 2.30), (float) (screenHeight * .55)));
        block37.addComponents(new RenderComponent(block37, "resources/assets/Block_floatblock_left.png"));
        block37.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block37"));
        sprites.add(block37);

        Entity block38 = new Entity();
        block38.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block37.getComponent(PositionComponent.class).getX()
                                + block37.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .55)));
        block38.addComponents(new RenderComponent(block38, "resources/assets/Block_floatblock_middle_1.png"));
        block38.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block38"));
        sprites.add(block38);

        Entity block39 = new Entity();
        block39.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block38.getComponent(PositionComponent.class).getX()
                                + block37.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .55)));
        block39.addComponents(new RenderComponent(block39, "resources/assets/Block_floatblock_middle_2.png"));
        block39.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block39"));
        sprites.add(block39);

        Entity block40 = new Entity();
        block40.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block39.getComponent(PositionComponent.class).getX()
                                + block37.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .55)));
        block40.addComponents(new RenderComponent(block40, "resources/assets/Block_floatblock_right.png"));
        block40.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block40"));
        sprites.add(block40);

        //eleventh platform
        Entity block41 = new Entity();
        block41.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * 2.20), (float) (screenHeight * .20)));
        block41.addComponents(new RenderComponent(block41, "resources/assets/Block_floatblock_left.png"));
        block41.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block41"));
        sprites.add(block41);

        Entity block42 = new Entity();
        block42.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block41.getComponent(PositionComponent.class).getX()
                                + block41.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .20)));
        block42.addComponents(new RenderComponent(block42, "resources/assets/Block_floatblock_right.png"));
        block42.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block42"));
        sprites.add(block42);

        //twelfth platform
        Entity block43 = new Entity();
        block43.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * 1.90), (float) (screenHeight * .15)));
        block43.addComponents(new RenderComponent(block43, "resources/assets/Block_floatblock_left.png"));
        block43.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block43"));
        sprites.add(block43);

        Entity block44 = new Entity();
        block44.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block43.getComponent(PositionComponent.class).getX()
                                + block43.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .15)));
        block44.addComponents(new RenderComponent(block44, "resources/assets/Block_floatblock_middle_1.png"));
        block44.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block44"));
        sprites.add(block44);

        Entity block45 = new Entity();
        block45.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block44.getComponent(PositionComponent.class).getX()
                                + block43.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .15)));
        block45.addComponents(new RenderComponent(block45, "resources/assets/Block_floatblock_middle_2.png"));
        block45.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block45"));
        sprites.add(block45);

        Entity block46 = new Entity();
        block46.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block45.getComponent(PositionComponent.class).getX()
                                + block43.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .15)));
        block46.addComponents(new RenderComponent(block46, "resources/assets/Block_floatblock_right.png"));
        block46.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block46"));
        sprites.add(block46);

        //thirteenth platform
        Entity block47 = new Entity();
        block47.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * 2.40), (float) (screenHeight * .15)));
        block47.addComponents(new RenderComponent(block47, "resources/assets/Block_floatblock_left.png"));
        block47.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block47"));
        sprites.add(block47);

        Entity block48 = new Entity();
        block48.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block47.getComponent(PositionComponent.class).getX()
                                + block47.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .15)));
        block48.addComponents(new RenderComponent(block44, "resources/assets/Block_floatblock_middle_1.png"));
        block48.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block48"));
        sprites.add(block48);

        Entity block49 = new Entity();
        block49.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block48.getComponent(PositionComponent.class).getX()
                                + block47.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .15)));
        block49.addComponents(new RenderComponent(block49, "resources/assets/Block_floatblock_middle_2.png"));
        block49.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block49"));
        sprites.add(block49);

        Entity block50 = new Entity();
        block50.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent(
                        (block49.getComponent(PositionComponent.class).getX()
                                + block47.getComponent(DimensionComponent.class).getWidth() - 1),
                        (float) (screenHeight * .15)));
        block50.addComponents(new RenderComponent(block50, "resources/assets/Block_floatblock_right.png"));
        block50.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("block50"));
        sprites.add(block50);

        //endpoint door
        Entity door = new Entity();
        door.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                new PositionComponent((float) (screenWidth * 2.95), (float) (screenHeight - 2 * screenHeight * 0.063)));
        door.addComponents(new RenderComponent(door, "resources/assets/Door.png"));
        door.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                new NameAttribute("door"));
        sprites.add(door);

        float blockW = (float) (screenWidth * 0.035);
        float blockH = (float) (screenHeight * 0.063);
        int count = 0;
        int counter = 0;

        for (int i = 0; i < screenWidth * 3; i += (screenWidth * 0.035)) {
            Entity wall = new Entity();
            wall.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                    new PositionComponent(i, (float) (screenHeight - (screenHeight * 0.063))));
            wall.addComponents(new RenderComponent(wall, "resources/assets/Block_grass4_1.png"));
            wall.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                    new NameAttribute("wall"));

            sprites.add(wall);
            if (count % 25 == 0 && count != 0) {
                if (counter % 2 == 1) {
                    for (float k = 0; k < screenHeight - 3 * blockH; k += blockH) {
                        Entity verticalWall = new Entity();
                        verticalWall.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                                new PositionComponent(i, k));
                        verticalWall.addComponents(new RenderComponent(verticalWall, "resources/assets/Block_wall.png"));
                        verticalWall.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                                new NameAttribute("verticalWall"));
                        
                        sprites.add(verticalWall);
                    }
                    counter++;
                } else if (counter % 2 == 0) {
                    for (float k = 2 * blockH; k < screenHeight - blockH; k += blockH) {
                        Entity verticalWall = new Entity();
                        verticalWall.addComponents(new DimensionComponent((float) (screenWidth * 0.035), (float) (screenHeight * 0.063)),
                                new PositionComponent(i, k));
                        verticalWall.addComponents(new RenderComponent(verticalWall, "resources/assets/Block_wall.png"));
                        verticalWall.addAttribute(new TypeAttribute(Type.STATIC_OBJECT), new CollidableAttribute(true),
                                new NameAttribute("verticalWall"));
                        
                        sprites.add(verticalWall);
                    }
                    counter++;
                }
            }
            count++;
        }

        for (Entity e : sprites) {
            super.addEntity(e);
        }

    }

}