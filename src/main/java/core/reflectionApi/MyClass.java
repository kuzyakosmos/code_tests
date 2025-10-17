package core.reflectionApi;

import javax.management.Attribute;
import java.lang.reflect.Method;
import java.util.List;

//у каждого класса есть:
//name
//packageName
//listOfAttributes
//listOfMethods

//Любой класс - это экземпляр(объект) класса Class
//Class - это служебный класс, экземпляры которого (Java классы) хранят
//конкретную информацию о конкретном классе

public class MyClass {
    String name;
    String packageName;
    List<Attribute> attributes;
    List<Method> methods;

    public static void main(String[] args) {
        //способы получить досутп к объекту класса Class
        Class a = MyClass.class;

        MyClass myClass = new MyClass();
        Class b = myClass.getClass();

        try {
            Class c = Class.forName("core.reflectionApi.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
