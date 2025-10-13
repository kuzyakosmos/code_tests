package interviews.zalando;

public class Task3 {
    public static void main(String[] args) {
        findCount("2121");
    }
    public static void findCount(String S) {
        int sum = 0;
        int count = 0;
        System.out.println();
        for (int i = 0; i < S.length(); i++) {
            System.out.println(S.charAt(i) );
            sum += S.charAt(i) - 48;
        }
        int remainToAdd = (3 - sum) % 3;
        if (remainToAdd == 0){
            // no changes needed for input number
            count++;
        }
        for (int i = 0; i < S.length(); i++) {
            int current = S.charAt(i) - 48;
            for (int j = 0; j <= 9; j++) {
                if (j == current)
                    continue;
                if ((j - current - remainToAdd) % 3 == 0)
                    count++;
            }
        }
        System.out.println(count);
    }
}
