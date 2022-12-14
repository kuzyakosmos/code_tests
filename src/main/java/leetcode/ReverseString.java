package leetcode;

@LeetcodeNumber(number = 206)
public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
//        char[] s = {'h', 'e', 'l', 'l', 'o'};
        char[] s = {'1', '2', '3', '4'};
        reverseString.reverseString(s);
        for (char c : s) {
            System.out.print(c + " ");
        }
    }

    public void reverseString(char[] s) {
        int i = 0;
        int l = s.length;
        while (l / 2 > i) {
            System.out.println("i = " + i);
            char t = s[l - i - 1];
            s[l - i - 1] = s[i];
            s[i] = t;
            i++;
        }
    }
}
