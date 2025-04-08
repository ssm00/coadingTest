package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1012Silver2 {



    //dfs로 1찾으면 일단 cnt++ 하고 먹은 dfs 는 2로 바꾸기

    static int [] mRow = {0,0,1,-1};
    static int [] mCol = {1,-1,0,0};

    public static void dfs(int [][] map, int row, int col) {
        //end 조건
        if (map[row][col] != 1) {
            return;
        }else {
            for (int i = 0; i <4; i++) {
                map[row][col] = 2;
                int nextRow = row + mRow[i];
                int nextCol = col + mCol[i];
                if(nextRow < 0 || nextRow > map.length-1 || nextCol < 0 || nextCol > map[0].length-1){
                    continue;
                }
                dfs(map, nextRow, nextCol);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            String[] split = br.readLine().split(" ");
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[1]);
            int cabbageNum = Integer.parseInt(split[2]);
            int map[][] = new int [row][col];
            int ans = 0;
            for (int m = 0; m < cabbageNum; m++) {
                String[] line2 = br.readLine().split(" ");
                map[Integer.parseInt(line2[0])][Integer.parseInt(line2[1])] = 1;
            }
            for (int m = 0; m < map.length; m++) {
                for (int n = 0; n < map[0].length; n++) {
                    if (map[m][n] == 1) {
                        ans += 1;
                        dfs(map, m, n);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
