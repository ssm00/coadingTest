package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No14503Gold5 {


    //그냥 탐색 dfs말고

    public static int direction;
    public static int col;
    public static int row;
    public static int [][] map;
    public static boolean status = true;

    public static int []mRow = {-1,0,1,0};
    public static int []mCol = {0,1,0,-1};
    public static int ans = 0;

    public static void go() {
        //1. 현재칸
        if (map[row][col] == 0) {
            map[row][col] = 2;
            ans++;
        }
        //check
        int t = 0;
        for (int i = 0; i < 4; i++) {
            int nextRow = row+mRow[i];
            int nextCol = col+mCol[i];
            if (map[nextRow][nextCol] != 0) {
                t++;
            }
        }
        //2 빈칸 없는 경우
        if(t==4){
            //2.1
            int backRow = row+mRow[(direction+2)%4];
            int backCol = col+mCol[(direction+2)%4];
            if (map[backRow][backCol] != 1) {
                row = backRow;
                col = backCol;
                //2.2
            }else if(map[backRow][backCol] == 1){
                status = false;
                return;
            }
        }else{
            //3
            //3.1
            direction = (direction + 3) % 4;
            int nextRow = row+mRow[direction];
            int nextCol = col+mCol[direction];
            //3.2
            if (map[nextRow][nextCol] == 0) {
                row = nextRow;
                col = nextCol;
                map[nextRow][nextCol] = 2;
                ans++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fLine = br.readLine().split(" ");
        int n = Integer.parseInt(fLine[0]);
        int m = Integer.parseInt(fLine[1]);
        String[] pos = br.readLine().split(" ");
        row = Integer.parseInt(pos[0]);
        col = Integer.parseInt(pos[1]);
        direction = Integer.parseInt(pos[2]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        while (status) {
            go();
        }
        System.out.println(ans);
    }
}
