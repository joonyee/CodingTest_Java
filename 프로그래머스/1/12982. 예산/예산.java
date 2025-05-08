import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        
        // 1. 부서 수, 금액 오름차순 정렬한 배열
        int answer = 0;
        Arrays.sort(d);
        
        // 3.예산이 신청금액보다 클 때까지 신청 금액을 차례로 제외
        for(int s : d){
            if(budget >= s){
                budget -= s;
                answer++;
            }
        }
        return answer;
    }
}