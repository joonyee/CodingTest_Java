import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // bfs를 위한 큐 초기화
        Queue<WordState> queue = new ArrayDeque<>();
        // 방문 여부를 담을 visited
        boolean[] visited = new boolean[words.length];
        // 처음 단어를 큐에 넣음
        queue.add(new WordState(0, begin));
        
        // bfs 실행
        while(!queue.isEmpty()){
            WordState cur = queue.remove();
            if(cur.word.equals(target)) return cur.cnt;
            
            for(int i=0; i<words.length; i++){
                // 방문하지 않았고 현재 단어와 한 글자 다르다면
                if(!visited[i] && getDiffCount(cur.word, words[i]) == 1){
                    // 방문 여부를 등록
                    visited[i] = true;
                    // 변환 횟수 +1하여 큐에 삽입
                    queue.add(new WordState(cur.cnt +  1, words[i]));
                }
            }
        }
        
        return 0;
    }
    
    // 두 단어를 비교하여 다른 문자의 수를 구하는 함수
    int getDiffCount(String word, String target){
        int diffCount = 0;
        for(int i = 0; i<word.length(); i++){
            if(word.charAt(i) != target.charAt(i)) diffCount++;
        }
        
        return diffCount;
    }
    
    // 데이터의 구조 클래스
    class WordState{
        int cnt; //단어 변환 횟수
        String word; //현재 단어
        
        WordState(int cnt, String word){
            this.cnt = cnt;
            this.word = word;
        }
    }
}