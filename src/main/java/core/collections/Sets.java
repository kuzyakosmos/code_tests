package core.collections;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        //10s536ms
        Set<String> hashSet = new HashSet<>();
        //11s330ms
        Set<String> linkedHashSet = new HashSet<>();
        //11s826
        Set<String> treeSet = new HashSet<>();

        int i = 0;
        while (i < 2000000000) {
            treeSet.add("KLnlkn");
            i++;
        }
        System.out.println(treeSet.size());
    }
}
