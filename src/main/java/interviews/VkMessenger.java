package interviews;

import java.util.HashSet;
import java.util.Set;

public class VkMessenger {


    public static void main(String[] args) {
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
    }
    /**
     * Поиск двух чисел в массиве, сумма которых равна заданному числу
     * <p>
     * Напиши функцию, принимающую массив из положительных неупорядоченных чисел первым аргументом
     * и положительное число вторым аргументом. Функция должна возвращать true, если в массиве
     * есть 2 числа, которые в сумме дают 2-й аргумент.
     * <p>
     * Input:  ([10, 15, 3, 7], 17)
     * Output: true
     */
    public static boolean hasPairWithSum(int[] numbers, int target) {
        //Реализовать
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(target - numbers[i])) {
                return true;
            }
            set.add(numbers[i]);
        }

        return false;
    }


    /**
     * Более формальное название — approximate string matching (нахождение приблизительного соответствия строк).
     * Требуется проверить, является ли первая строка подпоследовательностью второй.
     * <p>
     * Input: 'car', 'cartwheel'
     * Output: true
     * <p>
     * Input: 'cwhl', 'cartwheel'
     * Output: true
     * <p>
     * Input: 'cwhee', 'cartwheel'
     * Output: true
     * <p>
     * Input: 'cartwheel', 'cartwheel'
     * Output: true
     * <p>
     * Input: 'cwheeel', 'cartwheel'
     * Output: false
     * <p>
     * Input: 'lw', 'cartwheel'
     * Output: false
     * <p>
     * Input: 'zb', 'cartwheel'
     * Output: false
     */
    public static boolean fuzzySearch(String origin, String target) {
        // Реализовать
        char[] originArr = origin.toCharArray();
        char[] targetArr = target.toCharArray();

        int j = 0;

        for (int i = 0; i < origin.length(); i++) {

            while (j < target.length()) {
                if (originArr[i] == targetArr[j]) {
                    j++;
                    break;
                }
                j++;

                if (j == targetArr.length && i != originArr.length - 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
