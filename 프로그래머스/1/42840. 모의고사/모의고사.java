
import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[] answerCnt = {0, 0, 0};
        
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i++) {
            if (a[i%a.length] == answers[i]) {
                answerCnt[0] ++;
            }
            if (b[i%b.length] == answers[i]) {
                answerCnt[1] ++;
            }
            if (c[i%c.length] == answers[i]) {
                answerCnt[2] ++;
            }
        }
        
        int max = answerCnt[0];
        if (max < answerCnt[1]) {
            max = answerCnt[1];
        }
        if (max < answerCnt[2]) {
            max = answerCnt[2];
        }
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (max == answerCnt[i]) {
                answerList.add(i+1);
            }
        }
        
        return answerList;
    }
}
