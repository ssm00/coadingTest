package dp;

//당신은 n x m 크기의 격자에 있습니다. 각 칸에는 점수가 적혀 있습니다. 당신은 왼쪽 위 모서리(0,0)에서 시작하여 오른쪽 아래 모서리(n-1, m-1)까지 이동해야 합니다. 이동은 오직 오른쪽이나 아래쪽으로만 가능합니다.

import java.util.Scanner;

public class Simple2Dp {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }


        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
