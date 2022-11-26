package leetcode;

@LeetcodeNumber(number = 1971, level = Level.MEDIUM)
public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        DisjointSetUnion set = new DisjointSetUnion(n);
        for (int[] edge : edges) {
            set.union(edge[0], edge[1]);
        }

        return set.areConnected(start, end);
    }
}

class DisjointSetUnion {
    private final int[] parent;

    public DisjointSetUnion(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public boolean areConnected(int u, int v) {
        return find(u) == find(v);
    }

    public void union(int u, int v) {
        if (u != v) {
            int a = find(u);
            int b = find(v);
            parent[a] = b;
        }
    }

    private int find(int u) {
        int x = u;
        while (x != parent[x]) {
            x = parent[x];
        }

        parent[u] = x;
        return x;
    }
}
