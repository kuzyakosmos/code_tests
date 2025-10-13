package interviews.zalando;

public class Task23 {
    public int solution(String[] E) {
        int n = E.length;
        int max = 0;

        for (int i = 0; i < 10; i++)
            for (int j = i + 1; j < 10; j++) {
                //create all pairs of days one by one like 01, 02, 03, 04, 05..... 89
                String sb = i + "" + j;
                int out = 0;
                for (int k = 0; k < n; k++) {

                    String inp = E[k];

                    if (inp.matches(".*[" + sb.toString() + "].*")) {
                        out++;
                    }

                }
                if (out > max) {
                    max = out;
                }
            }

        return max;
    }
}
