package interviews.yandex;

import java.util.*;
import java.util.stream.Collectors;

public class TopWords {
    List<String> topWords(List<String> list, int k) {
        Map<String, Integer> dict = new HashMap<>();

        list.forEach(x -> {
            if (dict.containsKey(x)) {
                dict.put(x, dict.get(x) + 1);
            } else {
                dict.put(x, 1);
            }
        });

        List<Map.Entry<String, Integer>> result = new ArrayList();
        dict.entrySet().forEach(result::add);

        return result.stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).limit(k)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
