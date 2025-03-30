import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        // 1. 결과 배열, 기능별 완료 날짜 배열
        List<Integer> result = new ArrayList<>();
        int n = progresses.length;
        int[] completionDays = new int[n];
        
        // 2. 각 작업의 완료 날짜를 계산
        for (int i = 0; i < n; i++) {
            // (남은 진도 + 속도 - 1) / 속도로 올림 처리
            completionDays[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }
        
        // 3. 배포 처리
        int index = 0;  // 첫 번째 작업을 기준으로 시작
        result.add(1);  // 첫 번째 기능을 배포 그룹에 추가
        
        for (int i = 1; i < n; i++) {  // 두 번째 기능부터 시작
            // 3.1 첫 번째 배포 작업의 완료 날짜
            if (completionDays[i] <= completionDays[index]) {
                // 3.1.1 배포일이 같으면 같이 배포
                result.set(result.size() - 1, result.get(result.size() - 1) + 1);
            } else {
                // 3.1.2 배포일이 다르면 새로운 배포가 시작
                result.add(1);  // 새로운 배포 그룹 추가
                index = i;  // 새로운 배포 기준을 현재 작업으로 설정
            }
        }
        
        // 4. List를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
