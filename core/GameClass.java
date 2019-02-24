package core;



import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.Class;
import java.lang.reflect.InvocationTargetException;

public class GameClass<T>{

    Class<T> classObj;
    Constructor<T> constructorObj;
    
    public GameClass(Class<T> classObj){
        this.classObj = classObj;
    }
    
    /**
     * @link https://www.sczyh30.com/posts/Java/java-reflection-1/
     */
    public Object getConstructor() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        this.constructorObj = this.classObj.getConstructor();
        Object instanceConstructor = this.constructorObj.newInstance();
        return instanceConstructor;
    }
    
    /**
     * @link https://www.sczyh30.com/posts/Java/java-reflection-1/
     */
    public Object invokeMethod(String method) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Method methodObj = this.classObj.getMethod("sayHello");
        return methodObj.invoke(method);
    }
    

}