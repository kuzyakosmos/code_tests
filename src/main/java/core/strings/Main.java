package core.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;



public class Main {
    public static void main(String[] args) {
//        String a = "abcdef";
//        System.out.println(a.charAt(2));
//        System.out.println(a.substring(0,0));

        Map<String, Integer> instr = new HashMap<>();
        instr.put("w",2);
        instr.put("w",2);
        Function<Integer, Integer> wf = x -> x*x;
//"wfwe".replace()

        String string1 = "HeapString";
        String string2 = new String("HeapString");
        String string3 = string2.intern();
        System.out.println(string1 == string2.intern());
//        string.intern();

    }
}
