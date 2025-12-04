package leetcode;

@LeetcodeNumber(number = 3, level = Level.MEDIUM)
public class LongestSubstringWithoutRepeatingCharacters {
    //Given a string s, find the length of the longest substring without repeating characters.
    /**
     * Решение задачи "Longest Substring Without Repeating Characters" (LeetCode #3)
     * с использованием массива для ASCII символов.
     *
     * <p>Алгоритм:
     * - Используется подход "скользящее окно" (sliding window).
     * - Массив {@code index[128]} хранит последний индекс появления каждого символа.
     * - Левый указатель {@code left} сдвигается при обнаружении повторного символа.
     *
     * <p>⚠️ Тонкость при хранении индексов:
     * 1. Если хранить **реальные индексы символов** (т.е. {@code index[c] = right}),
     *    что кажется более логичным, то при вычислении нового {@code left} нужно делать:
     *       {@code left = Math.max(left, index[c] + 1)}.
     *    Важно: массив нужно инициализировать значениями {@code -1},
     *    иначе 0 будет считаться индексом первого элемента, а не "пустым" значением.
     *    Например:
     *    <pre>{@code
     *    int[] index = new int[128];
     *    Arrays.fill(index, -1);
     *    }</pre>
     *
     * 2. Если хранить **"следующую допустимую позицию"** (т.е. {@code index[c] = right + 1}),
     *    то можно оставлять массив инициализированным нулями, и вычислять:
     *       {@code left = Math.max(left, index[c])}.
     *
     * <p>Оба подхода эквивалентны, главное — быть последовательным.
     *
     * <p>Пример вызова:
     * <pre>{@code
     * String s = "abcadefghijk";
     * int result = lengthOfLongestSubstring(s); // вернёт 11
     * }</pre>
     *
     * @param s входная строка (только ASCII)
     * @return длина самой длинной подстроки без повторяющихся символов
     */

    static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int longest = 0;
        int[] charIndex = new int[128];
        System.out.println();
        for (int right = 0, left = 0; right < length; right++) {

            //переставляем l на nextIndex если буква на r уже встречалась
            left = Math.max(charIndex[s.charAt(right)], left);

            //сравниваем длину текущего отрезка с longest
            longest = Math.max(longest, right - left + 1);
            //где в последний раз встречался символ s.charAt(right)
            charIndex[s.charAt(right)] = right;
            System.out.println(String.format("left=%s, right=%s, longest=%s, nextIndex for %s=%s", left, right, longest, s.charAt(right), charIndex[s.charAt(right)]));
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcadefghijk"));
    }
}
