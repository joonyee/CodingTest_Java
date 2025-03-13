class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String first = String.valueOf(a) + String.valueOf(b);
        String second = String.valueOf(b) + String.valueOf(a);

        if(Integer.parseInt(first)>Integer.parseInt(second)){
            answer = Integer.parseInt(first);
        }else{
            answer = Integer.parseInt(second);
        }
        return answer;
    }
}