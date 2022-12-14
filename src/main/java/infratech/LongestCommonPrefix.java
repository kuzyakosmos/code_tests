package infratech;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
//        System.out.println("Result is " + longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println("Prefix is " + longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println("Prefix is " + longestCommonPrefix.longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {

            if (prefix.length() > strs[i].length()) {
                prefix = prefix.substring(0, strs[i].length());
            }

            for (int j = 0; j < prefix.length(); j++) {
                if (prefix.charAt(j) == strs[i].charAt(j)) {
                } else {
                    prefix = strs[i].substring(0, j);
                    break;
                }
                if (strs[i].length() - 1 == j) {
                    break;
                }
            }
        }
        return prefix;
    }
}
