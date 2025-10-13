package interviews.yandex;

import java.util.Arrays;

/**
 * Дан список целых чисел, повторяющихся элементов в списке нет.
 * Нужно преобразовать это множество в строку,
 * сворачивая соседние по числовому ряду числа в диапазоны.
 *
 * Примеры:
 * - [1, 4, 5, 2, 3, 9, 8, 11, 0] => "0-5,8-9,11"
 * - [1, 4, 3, 2] => "1-4"
 * - [1, 4] => "1,4"
 */
public class CompressArray {
    public String compress(int[] array) {
        int n = array.length;

        if (n == 0) {
            return "";
        } else if (n == 1) {
            return(String.valueOf(array[0]));
        }

        Arrays.sort(array);
        StringBuilder result = new StringBuilder();

        int start = 0;
        int prev = 0;
        int count = 1;
        for (int i = 1; i <= n; i++) {
            if (i != n && array[i] == array[prev] + 1) {
                prev = i;
                count++;
            } else if (count > 1) {
                if (start > 0) {
                    result.append(String.format(",%s-%s", array[start], array[prev]));
                } else {
                    result.append(String.format("%s-%s", array[start], array[prev]));
                }
                start = i;
                prev = i;
                count = 1;
            } else {
                if (start > 0) {
                    result.append(String.format(",%s", array[start]));
                } else {
                    result.append(String.format("%s", array[start]));
                }
                start = i;
                prev = i;
                count = 1;
            }
        }
        return result.toString();
    }
}
