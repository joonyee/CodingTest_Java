class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        int index = is_prefix.length();
        
        if(my_string.length() >= is_prefix.length() && 
           my_string.substring(0,index).equals(is_prefix)){
            answer = 1;
        }
        return answer;
    }
}