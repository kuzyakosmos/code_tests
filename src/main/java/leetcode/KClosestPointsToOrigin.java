package leetcode;

import java.util.*;

//todo в литкоде не засабмитил
@LeetcodeNumber(number = 973, level = Level.MEDIUM)
public class KClosestPointsToOrigin {
    public void main(String[] args) {

        // 1️⃣ Базовый кейс
        int[][] points1 = {{1, 3}, {-2, 2}};
        int k1 = 1;
        print(kClosest(points1, k1));
        // ожидаемо: [[-2, 2]]

        // 2️⃣ Несколько ближайших
        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;
        print(kClosest(points2, k2));
        // ожидаемо: любые 2 из [[3,3], [-2,4]]

        // 3️⃣ k == количество точек
        int[][] points3 = {{1, 1}, {2, 2}, {3, 3}};
        int k3 = 3;
        print(kClosest(points3, k3));
        // ожидаемо: все точки

        // 4️⃣ Точки с одинаковым расстоянием
        int[][] points4 = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int k4 = 2;
        print(kClosest(points4, k4));
        // ожидаемо: любые 2

        // 5️⃣ Есть точка в начале координат
        int[][] points5 = {{0, 0}, {5, 5}, {-1, -1}};
        int k5 = 1;
        print(kClosest(points5, k5));
        // ожидаемо: [[0, 0]]

        // 6️⃣ Отрицательные координаты
        int[][] points6 = {{-3, -3}, {-2, -2}, {-1, -1}};
        int k6 = 2;
        print(kClosest(points6, k6));
        // ожидаемо: [[-1,-1], [-2,-2]]

        // 7️⃣ k = 0
        int[][] points7 = {{1, 2}, {3, 4}};
        int k7 = 0;
        print(kClosest(points7, k7));
        // ожидаемо: []

        // 8️⃣ Одна точка
        int[][] points8 = {{7, 7}};
        int k8 = 1;
        print(kClosest(points8, k8));
        // ожидаемо: [[7,7]]

        // 9️⃣ Большие координаты (проверка overflow)
        int[][] points9 = {{10000, 10000}, {1, 1}};
        int k9 = 1;
        print(kClosest(points9, k9));
        // ожидаемо: [[1,1]]

        // 🔟 Несортированный ввод
        int[][] points10 = {{10, 10}, {1, 1}, {2, 2}, {3, 3}};
        int k10 = 2;
        print(kClosest(points10, k10));
        // ожидаемо: [[1,1], [2,2]]

        int[][] point11 = {{0, 1}, {1, 0}};
        int k11 = 2;
        print(kClosest(point11, k10));

    }

    private int[][] kClosest(int[][] points, int k) {
        TreeMap<Double, List<int[]>> distanceMap = new TreeMap<>();

        for (int[] point : points) {
            double distance = distance(point);
            if (distanceMap.containsKey(distance)) {
                distanceMap.get(distance).add(point);
            } else {
                List<int[]> pointsList = new ArrayList<>();
                pointsList.add(point);
                distanceMap.put(distance, pointsList);
            }
        }

        int[][] result = new int[k][2];

        int i = 0;
        while (i < k) {
            var entry = distanceMap.pollFirstEntry();
            if (entry != null) {
                for (int[] point : entry.getValue()) {
                    result[i] = point;
                    i++;
                    if (i == k - 1) return result;
                }
            }
        }
        return result;
    }

    private static double distance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }

    private static void print(int[][] res) {
        System.out.print("[ ");
        for (int[] p : res) {
            System.out.print(Arrays.toString(p) + " ");
        }
        System.out.println("]");
    }
}
