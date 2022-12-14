package luxoft;

import java.util.*;

public class ConvertString {
    public static void main(String[] args) {
        String s = "Freedom"; //eedfmor OR
        String s1 = "Freedomzz"; //eezzdfmor
        System.out.println(convert(s));
        System.out.println(convert(s1));
        System.out.println(convert("fd"));
    }

    static String convert(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        Arrays.sort(arr);
        StringBuilder single = new StringBuilder();
        StringBuilder pair = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                pair.append(arr[i]);
                pair.append(arr[i]);
                i++;
            } else single.append(arr[i]);
        }
        return pair.append(single).toString();
    }
}
