package core;

 

import java.net.URL;
import java.net.URLClassLoader;

public class GameUtility{

	private static String path;

	public static GameClass importClass(String path_, String className){

		try{
			path = path_;
			URL[] classLoaderUrls = {new URL(path)};
			
			URLClassLoader urlClassLoader = new URLClassLoader(this.class.getClassLoader(), classLoaderUrls);
			Class<?> classObj = urlClassLoader.loadClass(className);
			return new GameClass(classObj);
		}catch(Exception e){
			//System.out.println(e);
			e.printStackTrace();
		}

		return null;

	}

	public static void importSpriteClass(){

		
	}

}