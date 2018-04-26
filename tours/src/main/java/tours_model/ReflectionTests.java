package tours_model;

import java.io.ObjectInputStream;
import java.lang.reflect.*;

public class ReflectionTests {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       Tour rc = new Tour();
        //получаем обьект типа класс
        Class obj = rc.getClass();
       /* Field field = obj.getField("test");
        System.out.println(field);*/
    /*    System.out.println(obj.toString());
        Class obj1 = RecreationTour.class;
        System.out.println(obj1);
        //получаем имя класса
        System.out.println(obj.getName());
        //получаем каноническое имя
        System.out.println(obj.getCanonicalName());*/
 /*String s = obj.getName();
        System.out.println(s);*/
 int mods = obj.getModifiers();
 if(Modifier.isPublic(mods)){
     System.out.println("P");
 }
        if(Modifier.isAbstract(mods)){
            System.out.println("A");
        }
        if(Modifier.isFinal(mods)){
            System.out.println("F");
        }
       /* Class superClass = obj.getSuperclass();
        System.out.println(superClass.getName());*/
       //интерфейсы
       /* Class [] interfaces = obj.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }*/
        //поля
    /*    Field [] fields = obj.getDeclaredFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            System.out.println("Name"+field.getName());
            System.out.println("Name"+fieldType.getName());
        }*/
        /*Constructor [] constructors = obj.getConstructors();
        for (Constructor constructor : constructors) {
            Class [] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }
            System.out.println();
        }*/
        /*Method [] methods = obj.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType().getName());
            Class [] paramTypes = method.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.println(paramType.getName());
            }
        }*/
        /*Class [] parameters = new Class[]{String.class, int.class};
        Method method = obj.getMethod("setMealType",parameters);
        Object [] arg = new Object[]{new String("Hoho"), new Integer(1)};
        Integer integer =(Integer) method.invoke(obj,arg);


*/
    }
}
