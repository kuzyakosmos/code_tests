package interviews.janea;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'cosine_similarity' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a_keys
     *  2. DOUBLE_ARRAY a_values
     *  3. INTEGER_ARRAY b_keys
     *  4. DOUBLE_ARRAY b_values
     */

    public static double cosine_similarity(List<Integer> a_keys, List<Double> a_values, List<Integer> b_keys, List<Double> b_values) {
        int length = Math.max(a_keys.size(), b_keys.size());

        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for (int i = 0; i < length; i++) {
            double a_value = 0;
            if (a_keys.contains(i)) {
                a_value = a_values.get(a_keys.indexOf(i));
            }

            double b_value = 0;
            if (b_keys.contains(i)) {
                b_value = b_values.get(b_keys.indexOf(i));
            }

            dotProduct += a_value * b_value;
            normA += Math.pow(a_value, 2);
            normB += Math.pow(b_value, 2);
        }

        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> a_keys = List.of(1, 2, 3, 4);
//        List<Double> a_values = List.of(12.0, 212.4, 4.6, 21.87);
        List<Double> a_values = List.of(1.0, 1.0, 1.0, 1.0);
        List<Integer> b_keys = List.of(1, 2, 3, 4);
//        List<Double> b_values = List.of(32.5, 4.8, 23.89, 23.54);
        List<Double> b_values = List.of(1.0, 1.0, 1.0, 1.0);

        System.out.println(Result.cosine_similarity(a_keys, a_values, b_keys, b_values));

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int a_keysCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a_keys = IntStream.range(0, a_keysCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int a_valuesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Double> a_values = IntStream.range(0, a_valuesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Double::parseDouble)
                .collect(toList());

        int b_keysCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> b_keys = IntStream.range(0, b_keysCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int b_valuesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Double> b_values = IntStream.range(0, b_valuesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Double::parseDouble)
                .collect(toList());

        double result = Result.cosine_similarity(a_keys, a_values, b_keys, b_values);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
