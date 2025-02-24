package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class No2589gold5 {


    //bfs로 모든 칸 확인 후 ans에 최대값 갱신
    //돌아가는거 날리기 어케 계산? -> bfs는 애초에 최단경로 visited때문에 돌아가는거 무시

    //물이면 1 땅이면 0
    public static boolean visited[][];
    public static int map[][];
    public static int ans = Integer.MIN_VALUE;
    public static int n;
    public static int m;

    public static int []mRow = {1, -1, 0, 0};
    public static int[] mCol = {0, 0, 1, -1};

    public static class Position {
        int row;
        int col;
        int time;

        public Position(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void go(Position start) {
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(start);
        visited[start.row][start.col] = true;
        while (!q.isEmpty()) {
            Position poll = q.poll();
            ans = Math.max(ans, poll.time);
            for (int i = 0; i < 4; i++) {
                int nextRow = poll.row + mRow[i];
                int nextCol = poll.col + mCol[i];
                if (nextRow >= n || nextRow < 0 || nextCol >= m || nextCol < 0 || map[nextRow][nextCol] == 1 || visited[nextRow][nextCol]) {
                    continue;
                }
                visited[nextRow][nextCol] = true;
                q.add(new Position(nextRow, nextCol, poll.time+1));
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        n = Integer.parseInt(f[0]);
        m = Integer.parseInt(f[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'W') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    go(new Position(i,j,0));
                }
            }
        }
        System.out.println(ans);
    }
}
