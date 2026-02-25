package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

@LeetcodeNumber(number = 394, level = Level.MEDIUM)
public class DecodeString {

    public static void main(String[] args) {
        decodeString("\"3[a]2[bc]\"");
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Queue<String> deque = new ArrayDeque<>();

        // как стек
//        d.push(1);
//        d.pop();

        // как очередь
//        d.offer(1);
//        d.poll();

        return null;
    }
}
