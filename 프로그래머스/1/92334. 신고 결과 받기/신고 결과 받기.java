import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 결과 배열 초기화
        int[] answer = new int[id_list.length];
        // 중복 제거를 위한 Set 생성
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        // id 별로 신고당한 횟수 저장
        Map<String, Integer> reportCounts = new HashMap<>();
        
        // id 별로 신고당한 횟수 0으로 초기화
        // for (String id : id_list) {
        //     reportCounts.put(id, 0);
        // }
        
        for (String r : reportSet) {
            String reported = r.split(" ")[1];
            reportCounts.put(reported, reportCounts.getOrDefault(reported, 0) + 1);
        }
        
        
        // 신고 대상의 신고 횟수가 k 이상일 때, 신고자에게 알림 증가
        for (String r : reportSet) {
            String reporter = r.split(" ")[0];
            String reported = r.split(" ")[1];
            
            if (reportCounts.get(reported) >= k) {
                int index = Arrays.asList(id_list).indexOf(reporter);
                // for (int i = 0; i < id_list.length; i++) {
                //     if (id_list[i].equals(reporter)) answer[i] ++;
                // }
                answer[index]++;
            }
        }
        
        return answer;
    }
}
