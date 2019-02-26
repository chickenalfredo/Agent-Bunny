package core;

 

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URL;

public class GameUtility{

	private static String path;

	public static GameClass importClass(String path_, String className){

		try{
			path = path_;
			URL[] classLoaderUrls = new URL[]{new URL(path)};

			GameClass<?> gameClass = new GameClass();
			
			URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls, GameUtility.class.getClassLoader());

			Class<?> classObj = urlClassLoader.loadClass(className);

			gameClass.setClassObj((Class)classObj);

			return gameClass;
		}catch(Exception e){
			//System.out.println(e);
			e.printStackTrace();
		}

		return null;

	}


}