package musalasoft;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortOrders {
    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sotrOrder, int X) {
        items.sort((o1, o2) -> {
            if (sotrOrder == 1) {
                return o1.get(sortParameter).compareTo(o2.get(sortParameter));
            } else {
                return -o1.get(sortParameter).compareTo(o2.get(sortParameter));
            }
        });
        return items.subList(0,X).stream().map(x -> x.get(0)).collect(Collectors.toList());
    }
}
