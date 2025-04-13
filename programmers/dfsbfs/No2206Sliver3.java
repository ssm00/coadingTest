package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No2206Sliver3 {

    // 벽나오면? 두 방법 모두 가능 근데 1. 깨고 가기, 안깨고 가기 가 흐름 상 더 자연스러움
    // 1. 깨고가기 (벽 이미 부쉈냐 -> 1. 부쉈으면 돌아가기 2. 부수고 가기) 2. 돌아가기 (1. 벽 부수고?, 2. 벽 안부수고)
    // 1. 벽 이미 부쉈냐? (1. 돌아가기 ) 2. 안부쉈으면 (1. 부수고 가기, 2. 돌아가기)

    static int[] mRow = {0, 0, 1, - 1};
    static int[] mCol= {1, -1, 0, 0};

    public static int bfs(int[][] map, boolean [][][] visited) {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(1, 1,0, 1));
        //0이 안부순 세계의 visited, 1이 부순 세계의 visited ,, 1,1은 모두 지나간걸로 해야함
        visited[1][1][0] = true;
        visited[1][1][1] = true;
        while (!q.isEmpty()) {
            Position now = q.poll();
            int time = now.time;
            if (now.row == map.length - 1 && now.col == map[0].length - 1) {
                return now.time;
            }
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + mRow[i];
                int nextCol = now.col + mCol[i];
                if (nextRow > map.length-1 || nextRow < 1 || nextCol > map[0].length-1 || nextCol < 1) {
                    continue;
                }
                // 벽이면?
                if (map[nextRow][nextCol] == 1) {
                    //1 벽 이미 부쉈냐?
                    if (now.wall == 1) {
                        //못감 돌아가기
                        continue;
                    //안부쉈으면
                    }else{
                        //1 부수고 가기, 안부수고는 못감 벽이니 까
                        if(visited[nextRow][nextCol][1]) continue;
                        visited[nextRow][nextCol][1] = true;
                        q.add(new Position(nextRow, nextCol, 1, time + 1));
                    }
                }else{
                    if(!visited[nextRow][nextCol][now.wall]){
                        visited[nextRow][nextCol][now.wall] = true;
                        q.add(new Position(nextRow, nextCol, now.wall, time + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static class Position{
        int row;
        int col;
        int wall;
        int time;
        public Position(int row, int col, int wall, int time){
            this.row = row;
            this.col = col;
            this.wall = wall;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);
        int[][] map = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i+1][j+1] = line.charAt(j) - '0';
            }
        }
        boolean visited[][][] = new boolean [row+1][col+1][2];

        int ans = bfs(map, visited);
        System.out.println(ans);

    }
}
