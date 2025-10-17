package spring.applicationContext;

public class TestBean {
    private String name;

    public TestBean(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
