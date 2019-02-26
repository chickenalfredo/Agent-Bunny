
import core.external.tile.*;
import core.external.entity.*;
import core.*;
import core.map.*;
import java.util.List;
import java.util.ArrayList;




public class Chapter1Level1 extends GameMap{
	
	public Chapter1Level1(){

		StandardBlock block1 = new StandardBlock('-', 0, 0, 5, 5);
		StandardBlobk block2 = new StandardBlock('-', 0, 5, 5, 5);
		StandardBlobk block3 = new StandardBlock('-', 0, 10, 5, 5);
		StandardBlobk block4 = new StandardBlock('-', 0, 15, 5, 5);
		StandardBlobk block5 = new StandardBlock('-', 0, 20, 5, 5);
		StandardBlobk block6 = new StandardBlock('-', 0, 25, 5, 5);

		Player player = new Player(0, 0, 5, 5, 'x', false, "Name");

		super.addSprite(block1);
		super.addSprite(block2);
		super.addSprite(block3);
		super.addSprite(block4);
		super.addSprite(block5);
		super.addSprite(block6);

		super.addSprite(player);


	}



}