import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        // 배열 정렬(비교를 위함)
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        // 참가자와 완주자 차례로 비교
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        // 차례대로 비교 후 불일치가 없을 경우 마지막 해당
        return participant[participant.length - 1];
    }
}