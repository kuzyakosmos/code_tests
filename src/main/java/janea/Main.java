package janea;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> a_values = new ArrayList<>();
        a_values.add(2);
        a_values.add(5);
        a_values.add(4);
        a_values.add(3);

        ArrayList<Integer> a_keys = new ArrayList<>();
        a_keys.add(0);
        a_keys.add(1);
        a_keys.add(2);
        a_keys.add(3);

        for (int i = 0; i < 6; i++) {
            double a_value = 0;
            if (a_keys.contains(i)) {
                a_value = a_values.get(a_keys.indexOf(i));
            }
            System.out.println(a_value);
        }
    }
}
