package collections;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "fewf");
        map.put(2, "fewf");
        map.put(3, "fewf");
        map.put(4, "fewf");
        map.put(5, "fewf");
        map.put(6, "fewf");

        System.out.println(map);

        map.forEach((x, y) -> System.out.println(x));

        List list = new ArrayList<String>();

        Set<Integer> treeSet = new LinkedHashSet<>();
        treeSet.add(1);
        treeSet.add(1);

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        Collection collection = map.values();
        collection.iterator().next();

    }
}
