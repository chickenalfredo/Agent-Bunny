package core.map;

import java.util.List;
import java.util.ArrayList;
import core.sprite.*;
import core.map.*;

public class GameMap{

	private List<Sprite> sprite;
	private Sprite checkPoint;
	private String name;


	/**
	* Get all the sprite in this map
	* @return List<Sprite>
	*/
	public List<Sprite> getSprite(){
		return new ArrayList<Sprite>(this.sprite);
	}

	/**
	* Set recent check point
	* @param Sprite
	*/
	public void setCheckPoint(Sprite checkPoint){
		this.checkPoint = checkPoint;
	}

	/**
	* Get recent check point
	* @return Sprite
	*/
	public Sprite getCheckPoint(){
		return this.checkPoint;
	}

	/**
	* Generate the graphical map after Demo 1
	*/
	public void generateMap(){

	}

	/**
	* Get the terminal character map for Demo 1
	* @return String
	*/
	public String generateMapTerminal(){
		String ret = "";
		char[][] map;
		int maxRowLength = 0;
		int maxColumnHeight = 0;

		for(Sprite each : sprite){
			Coordinate currentCoord = each.getCoordinate();
			maxRowLength = Math.max((int)maxRowLength, (int)(currentCoord.getX() % 5));
			maxColumnHeight = Math.max((int)maxColumnHeight, (int)(currentCoord.getY() % 5));
		}

		map = new char[maxColumnHeight][maxRowLength];

		for(Sprite each : sprite){
			Coordinate currentCoord = each.getCoordinate();
			
			int columnY = (int)(currentCoord.getY() % 5); // assume 5px is one block in terminal version(way more than 5px in finished version)
			int rowX = (int)(currentCoord.getX() % 5);

			map[columnY][rowX] = each.getTerminalChar();
		}

		for(char[] column : map){
			for(char row : column){
				ret += row;
			}
			ret += "\n";
		}

		return ret;
	}

	/**
	* Add a sprite to the map
	* @param Sprite
	*/
	public void addSprite(Sprite sprite){
		this.sprite.add(sprite);
	}

	/**
	* Remove a sprite from the map by object
	* @param Sprite
	*/
	public void removeSprite(Sprite sprite){
		this.sprite.remove(sprite);
	}

	/**
	* remove a sprite from the map by index
	* @param int
	*/
	public void removeSprite(int index){
		this.sprite.remove(index);
	}

	/**
	* Get the level name of map
	* @return String
	*/
	public String getName(){
		return this.name;
	}

	

}