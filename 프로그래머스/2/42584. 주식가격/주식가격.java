import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        //1. 정답 배열 선언
        int[] answer = new int[prices.length];

         //2. 주식의 가격마다 떨어짐 여부 확인
        for (int i = 0; i < prices.length; i++) {
            //2.1 0초로 초기화
            int seconds = 0;
            for (int j = i + 1; j < prices.length; j++) {
                seconds++; // 우선 1초 증가
                if (prices[i] > prices[j]) {
                    break; // 가격이 떨어지면 중단
                }
            }
            //3. 정답 배열에 시간 추가
            answer[i] = seconds;
        }
        return answer;
    }
}