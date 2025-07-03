import java.util.*;

class Solution {
    //그래프 변수 선언
    Map<Integer, List<int[]>> graph = new HashMap<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        drawGraph(fares, n);
        return lowCostTaxi(n, s, a, b);
    }
    
    //drawGraph함수
    public void drawGraph(int[][] fares, int n){
        for(int i = 1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] fare : fares){
            graph.get(fare[0]).add(new int[] {fare[1], fare[2]});
            graph.get(fare[1]).add(new int[] {fare[0], fare[2]});
        }
    }
    
    public int lowCostTaxi(int n, int s, int a, int b){
        int[] costS = dijkstra(n, s);
        int[] costA = dijkstra(n, a);
        int[] costB = dijkstra(n, b);
        
        int min = Integer.MAX_VALUE;
        
        for(int i=1; i<=n; i++){
            min = Math.min(min, costS[i] + costA[i] + costB[i]);
        }
        return min;
    }
    
    public int[] dijkstra(int n, int s){
        
        Queue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        queue.offer(new int[] {s, 0});
        
        int[] cost = new int[n+1];
		    Arrays.fill(cost, Integer.MAX_VALUE);
		    cost[s] = 0;
        
        while(!queue.isEmpty()){
        int[] cur = queue.poll();
        int curNode = cur[0];
        int curCost = cur[1];
        
        for(int[] nodeInfo : graph.get(curNode)){
            int nextNode = nodeInfo[0];
            int nextCost = nodeInfo[1];
            
            if(curCost + nextCost < cost[nextNode]){
                queue.offer(new int[] {nextNode, curCost + nextCost});
                cost[nextNode] = curCost + nextCost;
            }
        }
    }
    return cost;
  }   
}