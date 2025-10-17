package core.collections;

import java.util.Set;
import java.util.TreeSet;

public class Tree {
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(8);
        System.out.println(treeSet);
        treeSet.forEach(System.out::println);
        System.out.println(treeSet.iterator().next());
        System.out.println(treeSet.iterator().next());
        for (Integer i : treeSet) {
            System.out.print(i);
        }
        treeSet.forEach(System.out::println);
    }
}
