package core.external.level;


import core.external.tile.*;
import core.external.entity.*;
import core.*;
import core.sprite.*;
import core.map.*;
import java.util.List;
import java.util.ArrayList;




public class Chapter1Level1 extends GameMap{
	
	public Chapter1Level1(){

		StandardBlock block1 = new StandardBlock('-', 0, 0, 5, 5);
		StandardBlock block2 = new StandardBlock('-', 0, 5, 5, 5);
		StandardBlock block3 = new StandardBlock('-', 0, 10, 5, 5);
		StandardBlock block4 = new StandardBlock('-', 0, 15, 5, 5);
		StandardBlock block5 = new StandardBlock('-', 0, 20, 5, 5);
		StandardBlock block6 = new StandardBlock('-', 0, 25, 5, 5);

		Sprite player = new Player((float)0.0, (float)0.0, (float)5.0, (float)5.0, 'x', false, "Name", 1, (float)5.0);

		super.addSprite(block1);
		super.addSprite(block2);
		super.addSprite(block3);
		super.addSprite(block4);
		super.addSprite(block5);
		super.addSprite(block6);

		super.addSprite(player);


	}



}