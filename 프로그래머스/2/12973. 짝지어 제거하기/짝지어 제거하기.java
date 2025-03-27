import java.util.*;

class Solution
{
    public int solution(String s)
    {
         // 1. 선언부
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            // 2. 초기화
            char c = s.charAt(i);
            
            // 3. 구현: 스택이 비어있지 않고 같은 알파벳이면 제거
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        
        // 4. 결과 : 짝이 맞으면 1, 안맞으면 0 리턴
        if(stack.isEmpty()){
            return 1;
        }else return 0;
    }
}