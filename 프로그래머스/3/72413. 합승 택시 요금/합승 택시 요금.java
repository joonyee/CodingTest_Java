import java.util.*;

class Solution {
    Map<Integer, List<int[]>> graph = new HashMap<>();
     
    public int solution(int n, int s, int a, int b, int[][] fares) {
        drawGraph(fares, n);
        return lowCostTaxi(n, s, a, b);
    }
    
    //그래프 그림
    void drawGraph(int[][] fares, int n){
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] fare : fares){
            graph.get(fare[0]).add(new int[] {fare[1], fare[2]});
            graph.get(fare[1]).add(new int[] {fare[0], fare[2]});
        }
    }
    
    int lowCostTaxi(int n, int s, int a, int b){
        int[] costS = dijkstra(n, s);
        int[] costA = dijkstra(n, a);
        int[] costB = dijkstra(n, b);
        
        int min = Integer.MAX_VALUE;
        
        for(int i=1; i<=n; i++){
            min = Math.min(min, costS[i] + costA[i] + costB[i]);
        }
        return min;
    }
    
    int[] dijkstra(int n, int s){
        Queue<int[]> queue = new PriorityQueue<>((a1, a2)-> a1[1] - a2[1]);
        
        queue.offer(new int[] {s, 0});
        
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        cost[s] = 0;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curNode = curr[0];
            int curCost = curr[1];
            
            for (int[] node: graph.get(curNode)) {
                int nextNode = node[0];
                int nextCost = node[1];
                
                // 현재 노드 최소비용 + 다음 노드로 가는 비용
                // < 다음 노드의 최소비용
                if (curCost + nextCost < cost[nextNode]) {
                    cost[nextNode] = curCost + nextCost;
                    queue.offer(new int[] {nextNode, cost[nextNode]});
                }   
            }
        }
        return cost;
    }
}