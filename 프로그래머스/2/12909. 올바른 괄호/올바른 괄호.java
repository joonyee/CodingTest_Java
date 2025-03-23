class Solution {
    public boolean solution(String s) {
        int openCount = 0;
        int closeCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount == 0) {
                    return false;  // 열린 괄호가 없으면 올바르지 않은 괄호
                }
                openCount--;
            }
        }
        
        return openCount == 0;
    }
}
