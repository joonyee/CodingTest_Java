import java.util.*;

class Solution {
    // 소수를 담을 set
    Set<Integer> primeSet;
    
    public int solution(String numbers) {
        primeSet = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        backtrack(numbers, visited, "");
        return primeSet.size();
    }
    
    // 백트래킹 함수
    void backtrack(String numbers, boolean[] visited, String cur){
        // 현재 문자열 숫자가 있다면
        if(cur.length() != 0){
            // 숫자로 변환하고 소수 여부 확인
            int n = Integer.parseInt(cur);
            if(isPrime(n)) primeSet.add(n);
        }
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                // i = 0일 때
                //backtrack("17", [false, false], "")
                //backtrack("17", [true, true], "17")
                backtrack(numbers, visited, cur + numbers.charAt(i));
                visited[i] = false;
            }
        }   
    }
    
    // 소수 확인 함수
    boolean isPrime(int num){
        // 0, 1인 경우 소수 아님
        if(num < 2) return false;
        // 2부터 대칭 약수까지 소수 확인
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}