import java.util.*;

class Solution {
    int answer;
    
    public int solution(int n, int[][] wires) {
        answer = n;
        
        // 데이터를 넣을 그래프 생성
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // 키와 빈 리스트 넣기
        for(int i=1; i<= n; i++){
            graph.put(i, new ArrayList<>());
        }
        // 양방향 데이터 반영
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);       
        }
        
        // dfs 탐색
        boolean[] visited = new boolean[n+1];
        dfs(graph, visited, 1, n);
            
        return answer;
    }
    
    
    int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int cur, int n){
        int count = 1;
        // 방문 표시(무한루프 방지)
        visited[cur] = true;
        
        for(int next : graph.get(cur)){
            if(!visited[next]){
                count += dfs(graph, visited, next, n);
            }
        }
        
        // 정답값 업데이트
        answer = Math.min(answer, Math.abs(n - count * 2));
        
        return count;   
    }   
}