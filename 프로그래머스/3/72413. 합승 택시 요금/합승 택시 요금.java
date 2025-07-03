import java.util.*;

class Solution {
    //그래프 전역변수
    Map<Integer, List<int[]>> graph = new HashMap<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        drawGraph(fares, n);
        return lowCostTaxi(n, s, a, b);
    }
    
    //그래프 초기화 함수
    public void drawGraph(int[][] fares, int n){
        // 지점은 1번부터 있음
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        //양방향 고려
        for(int[] fare : fares){
            graph.get(fare[0]).add(new int[] {fare[1], fare[2]});
            graph.get(fare[1]).add(new int[] {fare[0], fare[2]});
        }
    }
    
    // 최소 택시 요금 함수
    public int lowCostTaxi(int n, int s, int a, int b){
        //s, a, b 지점 각각의 거리
        int[] costS = dijkstra(n, s);
        int[] costA = dijkstra(n, a);
        int[] costB = dijkstra(n, b);
        
        int min = Integer.MAX_VALUE;
        
        // 이동 거리 합의 최소값
        for(int i = 1; i<=n; i++){
            min = Math.min(min, costS[i] + costA[i] + costB[i]);
        }
        return min;
    }
    
    //다익스트라 함수 - 최단거리 탐색
    public int[] dijkstra(int n, int s){
        
        //우선순위 큐 활용
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
