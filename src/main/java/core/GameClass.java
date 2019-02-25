package core;



import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.Class;
import java.lang.reflect.InvocationTargetException;

public class GameClass<T>{

    private Class<T> classObj;
    private Constructor<T> constructorObj;
    
    public GameClass(Class<T> classObj){
        this.classObj = classObj;
    }

    public Object getConstructor() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{
        this.constructorObj = this.classObj.getConstructor();
        Object instanceConstructor = this.constructorObj.newInstance();
        return instanceConstructor;
    }

    public Object invokeMethod(String method) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{
        Method methodObj = this.classObj.getMethod("sayHello");
        return methodObj.invoke(method);
    }

    public Object newInstance() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{
    	return classObj.newInstance();
    }


}