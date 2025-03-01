package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No7576Gold5 {


    static int map[][];
    static int n,k;
    static int [] mRow = {-1,1,0,0};
    static int [] mCol= {0,0,1,-1};
    static int ans = 0;
    static Queue<Position> q = new LinkedList<>();

    public static void go(){
        while (!q.isEmpty()) {
            Position nowPos = q.poll();
            ans = Math.max(ans, nowPos.time);
            for (int i = 0; i < 4; i++) {
                int nextRow = nowPos.row + mRow[i];
                int nextCol = nowPos.col + mCol[i];
                if (nextRow < 0 || nextRow >= k || nextCol < 0 || nextCol >= n || map[nextRow][nextCol] != 0) {
                    continue;
                }
                map[nextRow][nextCol] = 1;
                q.add(new Position(nextRow, nextCol, nowPos.time+1));
            }
        }
    }
    public static class Position{
        int row;
        int col;
        int time;

        public Position(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        k = Integer.parseInt(split[1]);
        map = new int[k][n];
        for (int i = 0; i < k; i++) {
            String[] split2 = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split2[j]);
            }
        }
        int check = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    check++;
                }
            }
        }
        if (check == 0) {
            System.out.println(0);
        }else {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        q.add(new Position(i, j, 0));
                    }
                }
            }
            go();
            int check2 = 0;
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0) {
                        check2++;
                    }
                }
            }
            if (check2 == 0) {
                System.out.println(ans);
            }else {
                System.out.println(-1);}
            }
    }
}
