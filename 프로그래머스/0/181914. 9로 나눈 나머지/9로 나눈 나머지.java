class Solution {
    public int solution(String number) {
        int answer = 0;
        int sum = 0;
        
        for(int i=0; i<number.length(); i++){
            char a = number.charAt(i);
            int b = a - '0';
            
            sum += b;
        }
        answer = sum % 9;
        return answer;
    }
}