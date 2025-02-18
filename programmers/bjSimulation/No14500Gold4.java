package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No14500Gold4 {

    public static int n;
    public static int m;

    public static int[][] map;



    //제일 큰수부터 모든 5가지 테트로미노 * 4방향 * 위치 4  max구하기
    //제일 큰수부터 dfs 4칸 max구하기 depth 정해져있으니까 dfs

    public static int ans = Integer.MIN_VALUE;

    public static int[] row = {0, 0, 1, -1};
    public static int[] col = {1, -1, 0, 0};
    public static boolean[][] visited;
    public static void find(boolean [][]visited, int depth, int nowRow, int nowCol, int nowTotal){
        if (depth == 3) {
            ans = Math.max(ans, nowTotal);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextMoveRow = nowRow + row[i];
            int nextMoveCol = nowCol + col[i];
            if (nextMoveRow >= n || nextMoveRow < 0 || nextMoveCol >= m || nextMoveCol < 0) {
                continue;
            }
            if(visited[nextMoveRow][nextMoveCol] == true){
                continue;
            }
            if(depth == 1) {
                visited[nextMoveRow][nextMoveCol] = true;
                find(visited, depth + 1, nowRow, nowCol, nowTotal + map[nextMoveRow][nextMoveCol]);
                visited[nextMoveRow][nextMoveCol] = false;
            }
            visited[nextMoveRow][nextMoveCol] = true;
            find(visited, depth + 1, nextMoveRow, nextMoveCol, nowTotal + map[nextMoveRow][nextMoveCol]);
            visited[nextMoveRow][nextMoveCol] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String [] line2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(line2[j]);
                map[i][j] = input;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int nowInt = map[i][j];
                visited[i][j] = true;
                find(visited, 0, i, j, nowInt);
            }
        }
        System.out.println(ans);
    }
}
