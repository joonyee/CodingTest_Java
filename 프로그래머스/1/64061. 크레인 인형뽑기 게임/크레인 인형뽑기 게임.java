import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int move : moves){
            int index = move -1;
            int dollNo = 0;
            //인형 꺼내고 0 넣기
            for(int i=0;i<board.length;i++){
                if(board[i][index] != 0){
                    dollNo = board[i][index];
                    board[i][index] = 0;
                    break;
                }
            }
            if(dollNo == 0 ) continue;
            
            if(stack.isEmpty()){
                stack.push(dollNo);
            }else{
                //마지막에 넣은 것과 같은경우
                if(stack.peek() == dollNo){
                    stack.pop();
                    answer+=2;
                }else{
                    stack.push(dollNo);
                }
            }
            
        }
        
        return answer;
    }
}
