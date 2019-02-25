
 

import java.io.*;
import java.util.List;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import core.map.GameMap;
import java.lang.reflect.InvocationTargetException;
import com.google.code.gson.*;


/**
* Game data storage class, for I/O
* @author Cloudy Yunfan
* @since 2019/02/23 12:01
*/

public class GameData{
    
    private static List<GameMap> map;
    private static List<Sprite> character;
    private static GameMap reachedGameMap;
    private static Map<String, Map> gameMapRecord;
    private static Map<String, Map> gameCharacterRecord;

    public static void loadGameMap(){
        String path = "map/";

        String reachedRecord = path + "record.json";

        List<String> fileList = getFileNamesByPath(path);

        for(int t = 0; t < fileList.size(); t ++) {
            String fileName = fileList.get(t);
            //System.out.println(fileName);
            try{
                GameClass mapClass = GameUtility.importClass(fileName, "Level.java");
                GameMap gameMap = (GameMap)(mapClass.newInstance());
                map.add(gameMap);
            }catch(Exception e){
                System.out.println(e);
            }
            
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

    public static GameMap reachedGameMap(){
        return reachedGameMap;
    }

    public void loadGameMapRecord(){
        // TODO read reached game map here
    }
    
    public void loadGameCharacterRecord(){
        
    }

    public void saveGameMapRecord(){
        JsonArray arr = new JsonArray();
        for(GameMap each : map){
            JsonObject obj = new JsonObject();
            obj.addProperty("name", each.getName());
            obj.addProperty("highestGamePoint", each.getHighestGamePoint());

            arr.add(obj);
        }
        String res = arr.toString();

        try {
            File file = new File("map/record.json");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(res);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveGameCharacterRecord(){
        JsonArray arr = new JsonArray();
        for(GameMap each : character){
            JsonObject obj = new JsonObject();
            obj.addProperty("name", each.getName());
            obj.addProperty("highestGamePoint", each.getHighestGamePoint());

            arr.add(obj);
        }
        String res = arr.toString();

        try {
            File file = new File("map/record.json");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(res);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public Map<Character> getMapRecordByName(String name){
        
    }
    
    public Map<String> getCharacterRecordByName(String name){
        
    }
    
    public GameMap getGameMapByName(String name){
        
    }
    
    

}