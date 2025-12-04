package core.collections.streamApi;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C", "D", "E");

        list.parallelStream();
        list.stream().parallel();
    }
}
