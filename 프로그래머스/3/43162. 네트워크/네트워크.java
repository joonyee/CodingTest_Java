class Solution {
    boolean[] visit;
    int[][] computer;

    void dfs(int now) {
        visit[now] = true; // 현재 노드 방문
        for (int i = 0; i < computer[now].length; i++) {
            // 연결 and 방문하지 않은 노드일 경우
            if (computer[now][i] == 1 && !visit[i]) {
                dfs(i); // 해당 노드를 방문
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visit = new boolean[n]; // 방문여부 배열 선언

        for (int i = 0; i < n; i++) {
            if (!visit[i]) { // 방문하지 않은 노드일 경우 해당 노드를 시작으로 DFS
                dfs(i);
                answer++; //DFS로 연결된 노드들을 모두 방문하면서 네트워크 개수 증가
            }
        }
        return answer;
    }
}