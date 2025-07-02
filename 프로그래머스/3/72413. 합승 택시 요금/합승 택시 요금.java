import java.util.*;

class Solution {
    
    Map<Integer, List<int[]>> graph = new HashMap<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        drawGraph(fares, n);
        return lowCostTaxi(n, s, a, b);
    }
    
    public void drawGraph(int[][] fares, int n) {
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] fare: fares) {
            graph.get(fare[0]).add(new int[] {fare[1], fare[2]});
            graph.get(fare[1]).add(new int[] {fare[0], fare[2]});
        }
    }
    
    public int lowCostTaxi(int n, int s, int a, int b) {
        
        int[] costsS = dijkstra(n, s);
        int[] costsA = dijkstra(n, a);
        int[] costsB = dijkstra(n, b);
            
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, costsS[i] + costsA[i] + costsB[i]);
        }
        
        return min;
    }
    
    public int[] dijkstra(int n, int s) {
        
        Queue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        queue.offer(new int[] {s, 0});
        
        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[s] = 0;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNode = curr[0];
            int currCost = curr[1];
            
            for (int[] nodeInfo: graph.get(currNode)) {
                int nextNode = nodeInfo[0];
                int nextCost = nodeInfo[1];
                
                if (currCost + nextCost < costs[nextNode]) {
                    queue.offer(new int[] {nextNode, currCost + nextCost});
                    costs[nextNode] = currCost + nextCost;
                }
            }
        }
        
        return costs;
    }
}