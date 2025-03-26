
import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        //수포자의 정답 패턴 정의
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3,3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] answerCnt = new int[3];
        ArrayList<Integer> result = new ArrayList<>();
        
        int count = 0;
        //정답 배열과 비교하여 정답일 경우 점수 계산
        for(int i=0; i<answers.length; i++){
            if(answers[i] == arr1[i%5]){
                answerCnt[0]++;
            }
        }
        for(int i=0; i<answers.length; i++){
            if(answers[i] == arr2[i%8]){
                answerCnt[1]++;
            }
        }
        for(int i=0; i<answers.length; i++){
            if(answers[i] == arr3[i%10]){
                answerCnt[2]++;
            }
        }
        //가장 높은 점수를 받은 사람 리턴
        int max = Math.max(answerCnt[0], Math.max(answerCnt[1], answerCnt[2]));
        
        for(int i=0; i<3; i++){
            if(max == answerCnt[i]){
                result.add(i+1);
            }
        }
        
        return result;
    }
}
