class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int len = nums.length;

        // 세 개의 수를 선택
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    // 세 수의 합이 소수인지 확인
                    if (isPrime(nums[i] + nums[j] + nums[k])) {
                        answer ++;
                    }
                }
            }
        }   
        
        return answer;
    }
    
    // 2부터 n의 제곱근까지 나누어 소수인지 여부 확인
    // 약수는 대칭성을 가짐. n의 제곱근을 기준으로 짝을 이루어 그 이상은 확인 필요X(6X6=36)
    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
