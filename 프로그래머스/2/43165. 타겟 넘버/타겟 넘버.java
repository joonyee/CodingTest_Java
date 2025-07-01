import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        //dfs호출해서 경우의 수 구하기
        return dfs(numbers, 0, target, 0);
    }
    
    int dfs(int[] numbers, int index, int target, int cur){
        if(index == numbers.length){
            return (cur == target) ? 1 : 0;
        }
    
        // 경우의 수
        int sum = 0;
        // +와 -의 경우 모두 고려
        sum += dfs(numbers, index + 1, target, cur + numbers[index]);
        sum += dfs(numbers, index + 1, target, cur - numbers[index]);
        
        return sum;
    }
}