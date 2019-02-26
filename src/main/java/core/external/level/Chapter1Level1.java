package core.external.level;

import core.external.entity.*;
import core.sprite.*;
import core.map.*;

/**
 * 
 */
public class Chapter1Level1 extends GameMap {

	public Chapter1Level1() {

		Sprite block1 = new Sprite('-', 0, 0, 5, 5);
		Sprite block2 = new Sprite('-', 0, 5, 5, 5);
		Sprite block3 = new Sprite('-', 0, 10, 5, 5);
		Sprite block4 = new Sprite('-', 15, 15, 5, 5);
		Sprite block5 = new Sprite('-', 10, 20, 5, 5);
		Sprite block6 = new Sprite('-', 5, 25, 5, 5);

		Sprite player = new Player((float) 5.0, (float) 0.0, (float) 5.0, (float) 5.0, 'x', false, "Name", 1,
				(float) 1.0);

		super.addSprite(block1);
		super.addSprite(block2);
		super.addSprite(block3);
		super.addSprite(block4);
		super.addSprite(block5);
		super.addSprite(block6);

		super.addSprite(player);

	}

}
