package core;

import java.net.URL;
import java.net.URLClassLoader;

public class GameUtility{

	private static String path;

	public static GameClass importClass(String path_, String className) throws Exception{
		path = path;
		URL[] classLoaderUrls = new URL[]{
			new URL(path)
		};
		
		URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);
		Class<?> classObj = urlClassLoader.loadClass(className);
		return new GameClass(classObj);
	}

}