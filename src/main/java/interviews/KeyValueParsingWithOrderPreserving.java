package interviews;


import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * input:  "a=1,b=2,a=3,c=4"
 * <p>
 * output:
 * a -> [1, 3]
 * b -> [2]
 * c -> [4]
 */
public class KeyValueParsingWithOrderPreserving {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> parse("a=1,b=2,a=3"));
        executorService.submit(() -> parse("a=1,a=2,a=3"));
        executorService.submit(() -> parse("a=1,b=2,a=3,c=4,b=5"));
        executorService.submit(() -> parse(" a = 1 ,  b=2 ,c =3 "));
        executorService.submit(() -> parse("a=,b=2,c="));
        executorService.submit(() -> parse("=1,a=2"));
        executorService.submit(() -> parse("a=1,b,c=3"));
        executorService.submit(() -> parse("a=1=2,b=3"));
        executorService.submit(() -> parse(""));
        executorService.submit(() -> parse(null));


        try {
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static Map<String, List<String>> parse(String input) {
        final LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        Arrays.stream(input.split(",")).forEach(pair -> {
            String[] pairArray = pair.split("=");
            String key = pairArray[0];
            String value = pairArray[1];
            Optional.ofNullable(map.get(key)).ifPresentOrElse(list -> list.add(value), () -> {
                List<String> list = new ArrayList<>();
                list.add(value);
                map.put(key, list);
            });
        });
        System.out.println(map);
        return null;
    }
}

