package alten;

import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
    public static int computeClosestToZero(int[] ts) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        if (ts.length == 0) {
            return 0;
        }

        int res = ts[0];
        for (int i = 1; i < ts.length; i++) {
            if (Math.abs(ts[i]) < Math.abs(res)) {
                res = ts[i];
            } else if (Math.abs(ts[i]) == Math.abs(res)) {
                if (ts[i] > 0) {
                    res = ts[i];
                }
            }
        }
        return res;
    }
}
