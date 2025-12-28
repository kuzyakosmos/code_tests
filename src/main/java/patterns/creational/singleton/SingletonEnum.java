package patterns.creational.singleton;

public enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("I'm a singleton!!!");
    }
}
