import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        // 맵의 크기 n x m (세로 x 가로)
        int lenN = maps.length;
        int lenM = maps[0].length;
        
        int[][] moves = {
            {-1, 0}, //상
            {1, 0}, //하
            {0, -1}, //좌
            {0, 1} //우
        };
        
        // 방문할 좌표를 담는 큐
        Deque<int[]> queue = new ArrayDeque<>();
        
        // 방문 여부를 담을 배열
        boolean[][] visited = new boolean[lenN][lenM];
        // 방문한 경우 true
        visited[0][0] = true;
        
        // 시작점 0,0 넣기
        queue.offer(new int[]{0, 0, 1});
        
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            int n = curr[0]; //세로
            int m = curr[1]; //가로
            int dist = curr[2];
            
            for(int[] move : moves){
                int dn = n + move[0];
                int dm = m + move[1];
                    
                // 범위 확인
                if(dn<0 || dm<0 || dn>= lenN || dm>= lenM) continue;
                
                // 길, 벽 확인
                if(maps[dn][dm] == 0) continue;
                
                // 방문 여부 확인
                if(visited[dn][dm]) continue;
                
                // 도착지점 확인
                if(dn == lenN -1 && dm == lenM-1) return dist +1;
                
                queue.offer(new int[] {dn, dm, dist + 1});
                visited[dn][dm] = true;
            }
        }
        return -1;
        
    } 
}