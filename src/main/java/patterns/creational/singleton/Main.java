package patterns.creational.singleton;

public class Main {
    public static void main(String[] args) {
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.doSomething();
    }
}
