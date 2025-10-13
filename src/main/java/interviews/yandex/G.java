package interviews.yandex;

import java.util.*;

import static interviews.yandex.G.compareDistances;

public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] cities = new int[n][2];
        //множество непроверенных городов
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cities[i][0] = scanner.nextInt();
            cities[i][1] = scanner.nextInt();
            nodes.add(new Node(i));
        }

        int limit = scanner.nextInt();
        int cityFrom = scanner.nextInt();
        int cityTo = scanner.nextInt();
        cityFrom--;
        cityTo--;

        //заполняем значения от начальной точки
        nodes.forEach(x -> x.distance = distance(cities, limit, 0, x.number));
        nodes.get(cityFrom).visited = true;

        //пока еще остались непосещенные точки
        while (nodes.stream().anyMatch(x -> !x.visited)) {
            //находим ближайшую непосещенную точку
            int from = nodes.stream().filter(x -> !x.visited).min(Node::compareTo).get().number;
            nodes.get(from).visited = true;
            nodes.stream().filter(x -> !x.visited).forEach(node -> {
                int newDistance = sumDistances(distance(cities, limit, from, node.number), nodes.get(from).distance);
                //если расстояние через город from меньше - то тогда подставляем его
                if (compareDistances(node.distance, newDistance) == 1) node.distance = newDistance;
            });
        }

        //результат
        System.out.println(nodes.get(cityTo).distance);
    }

    //если до города нельзя доехать на одной заправке, то distance = -1
    static int distance(int[][] cities, int k, int from, int to) {
        if (cities[from] == cities[to]) return 0;
        return Math.abs(cities[from][0] - cities[to][0]) + Math.abs(cities[from][1] - cities[to][1]) > k ? -1 : 1;
    }

    //если хотя бы до одного города нельзя доехать на одной заправке, то distance = -1
    static int sumDistances(int x, int y) {
        if (x < 0 || y < 0) {
            return -1;
        } else return x + y;
    }

    //если до x нельзя доехать, то дистанция до x будет больше (бесконечность)
    public static int compareDistances(int x, int y) {
        if (x < 0 && y < 0) {
            return 0;
        } else if (x < 0) {
            return 1;
        } else if (y < 0) {
            return -1;
        }
        return Integer.compare(x, y);
    }
}

class Node implements Comparable<Node> {
    int number;
    int distance;
    boolean visited;

    public Node(int number) {
        this.number = number;
        distance = -1;
        visited = false;
    }

    @Override
    public int compareTo(Node o) {
        return compareDistances(this.distance, o.distance);
    }
}
