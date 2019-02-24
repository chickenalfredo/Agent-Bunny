package core;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.Class;

public class GameClass<T>{

	Class<T> classObj;
	Constructor<T> constructorObj;
	
	public GameClass<T>(Class<T> class){
		this.classObj = class;
		return this.class;
	}

	public Object<T> getConstructor(){
		this.constructorObj = this.classObj.getConstructor();
        Object<T> instanceConstructor = this.constructorObj.newInstance();
		return instanceConstructor;
	}

	public Object<?> invokeMethod(String method){
		Method method = this.classObj.getMethod("sayHello");
        return method.invoke(method);
	}


}