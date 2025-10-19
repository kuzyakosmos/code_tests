package patterns.oop;

public class Main {

    class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        public int makeSound(int i) {
            System.out.println("Some generic animal sound");
            return i;
        }

        public int makeSound() {
            System.out.println("Some generic animal sound");
            return 0;
        }

        public static void info() {
            System.out.println("This is an animal");
        }
    }

    class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        @Override
        public int makeSound() {
            System.out.println("Woof");
            return 0;
        }
    }
}
