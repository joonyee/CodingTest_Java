import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int [][] direction = {
            {0, 1}, // U
            {0, -1}, // D
            {1, 0}, // R
            {-1, 0} // L
        };
        
        int x = 0, y = 0;
        
        Set<String> visited = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            int dx = x, dy = y; // 현재 좌표
            char c = dirs.charAt(i);
            
            if (c == 'U') {
                dy++;
            } else if (c == 'D') {
                dy--;
            } else if (c == 'R') {
                dx++;
            } else if (c == 'L') {
                dx--;
            }
            
            if (dx < -5 || dx > 5 || dy < -5 || dy > 5) {
                continue;
            }
            
            visited.add("" + x + y + dx + dy);
            visited.add("" + dx + dy + x + y);
            
            x = dx;
            y = dy;
        }
        
        // 경로 개수
        return visited.size() / 2;
    }
}
