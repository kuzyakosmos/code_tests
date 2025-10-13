package interviews.yandex;

import java.util.*;

//Вначале из имеющихся точек нужно построить граф. Для этого переберем все пары точек и,
//если расстояние между ними меньше заданного ограничения, добавим в граф ребро между вершинами.
//После построения графа запустим поиск в ширину из города, откуда Петя начинает свое путешествие.
//Как только он достигнет точки назначения, завершим наш алгоритм и выведем количество пройденных нами ребер.
//Если алгоритм завершился, а мы так и не достигли пункта назначения, то он недостижим из исходного города,
//поэтому следует вывести -1. Общая сложность описанного алгоритма — $O(n^2)$, где $n$ — число городов.
public class BadTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] cities = new int[n][2];
        //множество непроверенных городов
        for (int i = 0; i < n; i++) {
            cities[i][0] = scanner.nextInt();
            cities[i][1] = scanner.nextInt();
        }

        int limit = scanner.nextInt();
        int cityFrom = scanner.nextInt();
        int cityTo = scanner.nextInt();
        cityFrom--;
        cityTo--;

        Graph graph = new Graph();

        for (int i = 0; i < n; i++) {
            List<Vertex> vertexList = new ArrayList<>();
            graph.getAdjVertices().put(new Vertex(i), vertexList);
            for (int j = 0; j < n; j++) {
                if (distance(cities, limit, i, j) == 1) vertexList.add(new Vertex(j));
            }
        }
        graph.getAdjVertices().forEach((x, y) -> System.out.println(x + "" + y));
        System.out.println("depth is " + bfs(graph, cityFrom, cityTo));
    }

    static int distance(int[][] cities, int limit, int from, int to) {
        if (cities[from] == cities[to]) return 0;
        return Math.abs(cities[from][0] - cities[to][0]) + Math.abs(cities[from][1] - cities[to][1]) > limit ? -1 : 1;
    }

    static int bfs(Graph graph, int start, int end) {
        int n = graph.getAdjVertices().size();
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[n];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        int depth = 1;
        int prevLevelCount = 1;
        int nextLevelCount = 0;
        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            start = queue.poll();
            //prevLevelCount-- когда обнулим - можно переходить на след уровень
            if (prevLevelCount == 0) {
                prevLevelCount = nextLevelCount;
                nextLevelCount = 0;
                depth++;
            }
//            System.out.print(start + " ");

            for (Vertex vertex : graph.getAdjVertices().get(new Vertex(start))) {
                int label = vertex.label;
                if (!visited[label]) {
                    if (label == end) return depth;
                    visited[label] = true;
                    queue.add(label);
                    nextLevelCount++;  //nextLevelCount - количество элементов на уровне
                }
            }
            prevLevelCount--;
        }
        return -1;
    }
}

class Vertex {
    int label;

    Vertex(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return label == vertex.label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}

class Graph {
    private final Map<Vertex, List<Vertex>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }
}