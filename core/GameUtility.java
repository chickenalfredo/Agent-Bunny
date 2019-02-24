package core;

import java.net.URL;
import java.net.URLClassLoader;

public class GameUtility{

	private String path;

	public static GameClass importClass(String path, String className) throws Exception{
		this.path = path;
		URL[] classLoaderUrls = new URL[]{
			new URL(path)
		};
		Class<?> classObj = urlClassLoader.loadClass(className);
		return new GameClass(classObj);
	}

}