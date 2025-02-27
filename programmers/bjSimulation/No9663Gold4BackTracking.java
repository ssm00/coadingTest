package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9663Gold4BackTracking {
    static boolean[][] isDead;  // 퀸을 놓을 수 없는 위치를 표시
    static int n;
    static int count = 0;

    public static void markDead(int row, int col) {
        // 같은 행 죽이기
        for(int j = 0; j < n; j++) {
            isDead[row][j] = true;
        }

        // 같은 열 죽이기
        for(int i = 0; i < n; i++) {
            isDead[i][col] = true;
        }

        // 대각선 죽이기 (왼쪽 위에서 오른쪽 아래)
        int r = row, c = col;
        while(r < n && c < n) {
            isDead[r++][c++] = true;
        }
        r = row; c = col;
        while(r >= 0 && c >= 0) {
            isDead[r--][c--] = true;
        }

        // 대각선 죽이기 (오른쪽 위에서 왼쪽 아래)
        r = row; c = col;
        while(r < n && c >= 0) {
            isDead[r++][c--] = true;
        }
        r = row; c = col;
        while(r >= 0 && c < n) {
            isDead[r--][c++] = true;
        }
    }

    public static void dfs(int depth) {
        if(depth == n) {
            count++;
            return;
        }

        // 현재 행에서 살아있는 칸 찾기
        for(int j = 0; j < n; j++) {
            if(!isDead[depth][j]) {
                boolean[][] tempDead = new boolean[n][n];
                // 현재 상태 저장
                for(int i = 0; i < n; i++) {
                    tempDead[i] = isDead[i].clone();
                }

                markDead(depth, j);  // 새로운 퀸의 영향 표시
                dfs(depth + 1);

                // 상태 복구
                isDead = tempDead;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isDead = new boolean[n][n];
        dfs(n);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isDead[i][j] == true) {
                    ans++;
                }
                System.out.println(isDead[i][j]);
            }
        }
        System.out.println(ans);
    }
}