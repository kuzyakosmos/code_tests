package patterns.solid;

public class SingleResponsibility {
    //    Плохой пример:
    class Kitchen {
        void cookFood() {
            class Kithcen {
                void potBoilWater() {
                    System.out.println("Boiling water");
                }

                void ovenBake() {
                    System.out.println("Baking in the oven");
                }
            }
        }
    }

    //    Хороший пример:
    class Pot {
        void boilWater() {
            System.out.println("Boiling water");
        }
    }
    class Oven {
        void bake() {
            System.out.println("Baking in the oven");
        }
    }
}

