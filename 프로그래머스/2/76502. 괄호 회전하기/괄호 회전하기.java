import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int N = s.length();
        
        Stack<Character> stack = new Stack<>();

        // x만큼 회전 실행
        for(int i = 0 ; i < N ; i++){
            stack.clear();
            // 각각의 괄호의 경우에 따라 올바른지 확인(올바르면 비움)
            for(int j = 0 ; j < N ; j++){
                if(!stack.isEmpty()){
                    if(stack.peek() == '(' && s.charAt(j) == ')'){
                        stack.pop();
                    }
                    else if(stack.peek() == '[' && s.charAt(j) == ']'){
                        stack.pop();
                    }
                    else if(stack.peek() == '{' && s.charAt(j) == '}'){
                        stack.pop();
                    }
                    else
                        stack.push(s.charAt(j));
                }
                else
                    stack.push(s.charAt(j));
            }
            // 괄호가 모두 올바른 경우 answer에 추가
            if(stack.isEmpty()){
                answer++;
            }
            // 괄호 회전(첫번째를 뒤에 붙임)
            char data = s.charAt(0);
            s = s.substring(1, N);
            s += data;
        }
        return answer;
    }
}