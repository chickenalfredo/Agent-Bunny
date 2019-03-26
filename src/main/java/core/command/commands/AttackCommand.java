package core.command.commands;

import core.animations.Animation;
import core.command.Command;
import core.ecs.components.RenderComponent;
import core.external.entity.Hero;
import core.sprite.Sprite;
import core.sprite.World;

/**
 * 
 */
public class AttackCommand extends Command {

    private boolean isKeyPressed;

    /**
     * 
     * @param isKeyPressed
     */
    public AttackCommand(boolean isKeyPressed) {
        this.isKeyPressed = isKeyPressed;

    }

    /**
     * 
     * @param actor
     * @param world
     */
    @Override
    public void execute(Hero actor, World world) {
        if (isKeyPressed) {
            actor.attackCollider(world);
            world.getHero().getComponent("RenderComponent", RenderComponent.class).setViewPort(world.getHero().getComponent("RenderComponent", RenderComponent.class).getAnimationSystem().animate(
                world.getHero().getComponent("RenderComponent", RenderComponent.class).getImage(), (Sprite) actor,
                "attack"));
        } else {
            world.getHero().getComponent("RenderComponent", RenderComponent.class).getAnimationSystem().animate(
                world.getHero().getComponent("RenderComponent", RenderComponent.class).getImage(), (Sprite) actor,
                "idle");
        }
    }
}