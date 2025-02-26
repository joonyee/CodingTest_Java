class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int multiple = 2 * a * b;
        String plus = a + "" + b;
        
        if(Integer.parseInt(plus)>multiple){
            answer = Integer.parseInt(plus);
        }else{
            answer = multiple;
        }
        return answer;
    }
}