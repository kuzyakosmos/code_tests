//Unfortunately, I didn't have enough time to finish.
// I will attach this code here
// so that you can understand the course of my thoughts.

package vacuumlabs;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private final String SYNONYMS = "synonyms";
    private final String DIFFERENT = "different";

//    public static void main(String[] args) {
//        try {
//            File inputFile = new File("/Users/aleksandrkuznecov/Downloads/example.in");
//            FileReader fileReader = new FileReader(inputFile);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            File outputFile = new File("/Users/aleksandrkuznecov/Downloads/result.out");
//            FileWriter fileWriter = new FileWriter(outputFile);
//
//            int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
//
//            for (int i = 0; i < numberOfTestCases; i++) {
//
//                int dictionaryLength = Integer.parseInt(bufferedReader.readLine());
//                UnionFind uf = new UnionFind(dictionaryLength);
//
//                for (int j = 0; j < dictionaryLength; j++) {
//                    String pair = bufferedReader.readLine();
//                    String s = bufferedReader.readLine();
//                    uf.union(s.split(" ")[0], s.split(" ")[1]));
//                }
//
//                int numberOfQueries = Integer.parseInt(bufferedReader.readLine());
//                for (int j = 0; j < numberOfQueries; j++) {
//                    String s = bufferedReader.readLine();
//                    fileWriter.write(uf.areSynonyms(s.split(" ")[0], s.split(" ")[1]));
//                }
//            }
//
//            bufferedReader.close();
//            fileReader.close();
//            fileWriter.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}

//class UnionFind {
//    private HashMap<String, Integer> root;
//
//    public UnionFind(int size) {
//        root = new HashMap<>(size);
//
//        for (int i = 0; i < size; i++) {
//            root[i] = i;
//        }
//    }
//
//    public int find(int x) {
//        while (x != root[x]) {
//            x = root[x];
//        }
//        return x;
//    }
//
//    public void union(int x, int y) {
//        int rootX = find(x);
//        int rootY = find(y);
//        if (rootX != rootY) {
//            root[rootY] = rootX;
//        }
//    }
//
//    public String areSynonyms(String x, String y) {
//        if (find(x) == find(y)) {
//            return "synonyms";
//        } else {
//           return  "different";
//        }
//    }
//}
