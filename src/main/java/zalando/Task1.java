package zalando;

class Task1 {
    static String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = 0;

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            } else if (occurrences[i] == best_res && best_char > (int)'a' + i) best_char = (char)((int)'a' + i);
        }

        return Character.toString(best_char);
    }

    public static void main(String[] args) {
        System.out.println(solution("bbbbhellaaaa"));
        System.out.println(fixed("bbbbhellaaaa"));
    }
    public static String fixed(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int best_res = 0;

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char) ((int) 'a' + i);
                best_res = occurrences[i];
            }
        }
        return Character.toString(best_char);
    }
}