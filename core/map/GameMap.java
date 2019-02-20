import java.util.List;

public class GameMap{

	private List<Sprite> sprite;
	private Sprite checkPoint;
	private String name;

	public List<Sprite> getSprite(){
		return new List<Sprite>(this.sprite);
	}

	public void setCheckPoint(Sprite checkPoint){
		this.checkPoint = checkPoint
	}

	public Sprite getCheckPoint(){
		return this.checkPoint;
	}

	public void generateMap(){

	}

	public String generateMapTerminal(){
		for(Sprite each : sprite){

		}
	}

	public void addSprite(Sprite sprite){
		this.sprite.add(sprite);
	}

	public void removeSprite(Sprite sprite){
		this.sprite.remove(sprite);
	}

	public void removeSprite(int index){
		this.sprite.remove(index);
	}

	public String getName(){
		return this.name;
	}

	

}