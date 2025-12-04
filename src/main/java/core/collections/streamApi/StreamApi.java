package core.collections.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5);
//        listOfNumbers.stream().forEach(number ->
//                System.out.println(number + " " + Thread.currentThread().getName())
//        );

        listOfNumbers.parallelStream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );

        Collection<String> collection = new ArrayList<>();

        //Intermediate methods
        //filter - отработает как фильтр, вернет значения, которые подходят под заданное условие
        collection.stream().filter("e22"::equals).count();
        //sorted - отсортирует элементы в естественном порядке; можно использовать Comparator
        collection.stream().sorted().collect(Collectors.toList());
        //limit - лимитирует вывод по тому, количеству, которое вы укажете
        collection.stream().limit(10).collect(Collectors.toList());
        //skip - пропустит указанное вами количество элементов
        collection.stream().skip(3).findFirst().orElse("4");
        //distinct - найдет и уберет элементы, которые повторяются; вернет элементы без повторов
        collection.stream().distinct().collect(Collectors.toList());
        //peek - выполнить действие над каждым элементом элементов, вернет стрим с исходными элементами
        collection.stream().map(x -> x + "ewf").peek((e) -> System.out.print("," + e)).collect(Collectors.toList());
        //map - выполнит действия над каждым элементом; вернет элементы с результатами функций
        Stream.of("3", "4", "5").map(Integer::parseInt).map(x -> x + 10).forEach(System.out::println);
        //mapToInt, mapToDouble, mapToLong - cработает как map, только вернет числовой stream
        collection.stream().mapToInt(s -> Integer.parseInt(s.toString())).toArray();
        //flatMap, flatMapToInt, flatMapToDouble, flatMapToLong - сработает как map, но преобразует один элемент в ноль, один или множество других
        collection.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray();

        //Terminal methods
        //findFirst - вернет элемент, соответствующий условию, который стоит первым	collection.stream().findFirst().orElse("10")
        //findAny - вернет любой элемент, соответствующий условию	collection.stream().findAny().orElse("10")
        //collect - соберет результаты обработки в коллекции и не только	collection.stream().filter((s) -> s.contains("10")).collect(Collectors.toList())
        //count	посчитает и выведет, сколько элементов, соответствующих условию	collection.stream().filter("f5"::equals).count()
        //anyMatch	True, когда хоть один элемент соответствует условиям	collection.stream().anyMatch("f5"::equals)
        //noneMatch	True, когда ни один элемент не соответствует условиям	collection.stream().noneMatch("b6"::equals)
        //allMatch	True, когда все элементы соответствуют условиям	collection.stream().allMatch((s) -> s.contains("8"))
        //min	найдет самый маленький элемент, используя переданный сравнитель	collection.stream().min(String::compareTo).get()
        //max	найдет самый большой элемент, используя переданный сравнитель	collection.stream().max(String::compareTo).get()
        //forEach	применит функцию ко всем элементам, но порядок выполнения гарантировать не может	set.stream().forEach((p) -> p.append("_2"));
        //forEachOrdered	применит функцию ко всем элементам по очереди, порядок выполнения гарантировать может	list.stream().forEachOrdered((p) -> p.append("_nv"));
        //toArray	приведет значения стрима к массиву	collection.stream().map(String::toLowerCase).toArray(String[]::new);
        //reduce	преобразует все элементы в один объект	collection.stream().reduce((c1, c2) -> c1 + c2).orElse(0)

    }
}
