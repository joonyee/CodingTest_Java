class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        // 라운드 진행 후 부여받은 번호가 같을 때 종료
        for(answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}

// 메모
// (n-1번 n번)->n/2번
//     1번  2번  3번  4번
//     12   34   56  78
// 1라운드 4-3   7-8
// 2라운드 12중 하나랑 4   -1번
//        56중 하나랑 7   -2번
// 3라운드 4랑 7