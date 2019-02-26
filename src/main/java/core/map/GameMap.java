package core.map;

import java.util.List;
import java.util.ArrayList;
import core.sprite.*;
import core.map.*;

/**
 * Storing all the sprites inside a map
 * @author Cloudy Yunfan
 * @since 2019/02/23 11:36
 * @param String name of the level
 */

public class GameMap{

	private List<Sprite> sprite = new ArrayList<Sprite>();
	private Sprite checkPoint;
	private String name;
	private int highestGamePoint;
	
	/**
	 * 
	 */
	public GameMap() {}
	   
	/**
	 * 
	 */
	public GameMap(String name){
		this.name = name;
	}


	/**
	* Get all the sprite in this map
	* @return List<Sprite> - all sprite in the map
	*/
	public List<Sprite> getSprite(){
		return new ArrayList<Sprite>(this.sprite);
	}

	/**
	* Set recent check point
	* @param Sprite: checkPoint object
	*/
	public void setCheckPoint(Sprite checkPoint){
		this.checkPoint = checkPoint;
	}

	/**
	* Get recent check point
	* @return Sprite: checkPoint object
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
	* @return String - terminal string
	*/
	public String generateMapTerminal(){
		String ret = "";
		char[][] map;
		int maxRowLength = 1;
		int maxColumnHeight = 1;

		for(Sprite each : sprite){
			Coordinate currentCoord = each.getCoordinate();
			maxRowLength = Math.max((int)maxRowLength, (int)(currentCoord.getX() / 5)) + 1;
			maxColumnHeight = Math.max((int)maxColumnHeight, (int)(currentCoord.getY() / 5)) + 1;
		}

		map = new char[maxRowLength][maxColumnHeight];

		for (int i = 0; i < maxRowLength; i++) {
			for (int j = 0; j < maxColumnHeight; j++) {
				map[i][j] = ' ';
			}
		}

		for(Sprite each : sprite){
			Coordinate currentCoord = each.getCoordinate();
			
			int columnY = (int)(currentCoord.getY() / 5); // assume 5px is one block in terminal version(way more than 5px in finished version)
			int rowX = (int)(currentCoord.getX() / 5);

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
	* @param Sprite - sprite object to be added
	*/
	public void addSprite(Sprite sprite){
		this.sprite.add(sprite);
	}

	/**
	* Remove a sprite from the map by object
	* @param Sprite - sprite object to be removed
	*/
	public void removeSprite(Sprite sprite){
		this.sprite.remove(sprite);
	}

	/**
	* remove a sprite from the map by index
	* @param int - sprite index to be added
	*/
	public void removeSprite(int index){
		this.sprite.remove(index);
	}

	/**
	* Get the level name of map
	* @return String - level map name
	*/
	public String getName(){
		return this.name;
	}

	/**
	* Get the highest game point
	* @return int - game point
	*/
	public int getHighestGamePoint(){
		return this.highestGamePoint;
	}

	/**
	* Set the highest game point
	* @param int - game point
	*/
	public void setHighestGamePoint(int point){
		this.highestGamePoint = point;
	}
}
