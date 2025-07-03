import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2)->j1[0] - j2[0]);
        
        int time = 0;
        int totalTime = 0;
        int index = 0;
        int jobCount = 0;
        
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        while(jobCount != jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.add(jobs[index]);
                index++;
            }

            if (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int reqTime = curr[0];
                int jobTime = curr[1];

                time += jobTime;
                totalTime += time - reqTime;
                jobCount ++;
            } else {
                time = jobs[index][0];
            }
        }
        
        return totalTime / jobs.length; 
        
    }
}