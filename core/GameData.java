
package core;

import java.io.*;
import java.util.List;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import core.map.GameMap;


/**
* Game data storage class, for I/O
* @author Cloudy Yunfan
* @since 2019/02/23 12:01
*/

public class GameData{
	
	private List<GameMap> map;
	private GameMap reachedGameMap;
	private Map<String, Map> gameMapRecord;
	private Map<String, Map> gameCharacterRecord;

	public static void loadGameMap(){
		String path = "map\\";
		List<String> fileList = getFileNamesByPath(path);

		for(int t = 0; t < fileList.size(); t ++){
			String fileName = fileList.get(t);
			//System.out.println(fileName);
			GameClass mapClass = GameUtility.importClass(fileName, "Level.java");
		}

	}


	private static ArrayList<String> getFileNamesByPath(String path) throws NullPointerException{
		ArrayList<String> files = new ArrayList<String>(); 
		File file = new File(path); 
		File[] tempList = file.listFiles();
		System.out.println(tempList);
		if(tempList.length == 0){
		    return new ArrayList<String>();
		}
		for (int i = 0; i < tempList.length; i++){
			if (tempList[i].isFile()){
			 	files.add(tempList[i].toString());
			}else if(tempList[i].isDirectory()){
				// Not include sub-folder, no action
			}
		} 
		return files;
	}

}