package dp;


//3 mod(모듈러 수)가 있는 경우 dp 고려  dfs아닐 가능성 큼
//최단 경로 갯수를 i,j에 저장하는데 최단 경로는 i-1,j의 최단경로 + i,j-1의 최단경로 두개 합친거임
//웅덩이는 0으로 표현해야하는데 처음부터 0으로 넣으면 dp도 원래 모두 0으로 초기화 되어있기 때문에 티가 안나서 모두 웅덩이로 처리됨 따라서 웅덩이는 -1로 했다가 -1이면 다시 0으로 바꾸기
public class Ex03 {

    public int solution(int col, int row, int[][] puddles) {
        int mod = 1000000007;
        int[][] dp = new int[row+1][col+1];

        dp[1][1] = 1;

        //웅덩이 추가
        for (int[] p : puddles) {
            int col1 = p[0];
            int row1 = p[1];
            dp[row1][col1] = -1;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (i == 1 && j == 1) continue;  // 시작점 스킵
                //웅덩이
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                // 이코드는 작성하면 안됨 i나 j 1에 웅덩이가 있는경우 그 이후는 모두 갈수 있는길이 없으므로 0
//                if (i == 1 || j == 1) {
//                    dp[i][j] = 1;
//                    continue;
//                }
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        Ex03 ex03 = new Ex03();
        int[][] map = {{2,2}};
        System.out.println(ex03.solution(4,3, map));
    }
}
