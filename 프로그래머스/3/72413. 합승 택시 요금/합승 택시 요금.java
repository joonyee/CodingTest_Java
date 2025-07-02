import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] f : fares) {
            graph[f[0]].add(new int[]{f[1], f[2]});
            graph[f[1]].add(new int[]{f[0], f[2]});
        }

        int[] fromS = dijkstra(n, s, graph);
        int[] fromA = dijkstra(n, a, graph);
        int[] fromB = dijkstra(n, b, graph);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++)
            min = Math.min(min, fromS[i] + fromA[i] + fromB[i]);

        return min;
    }

    int[] dijkstra(int n, int start, List<int[]>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] > dist[cur[0]]) continue;

            for (int[] next : graph[cur[0]]) {
                if (dist[next[0]] > cur[1] + next[1]) {
                    dist[next[0]] = cur[1] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        return dist;
    }
}
