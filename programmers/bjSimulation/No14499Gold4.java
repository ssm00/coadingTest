package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No14499Gold4 {

    public static int n;
    public static int m;
    public static int x;
    public static int y;
    public static int [][]map;
    public static int[] mRow = {0, 0, -1, 1};
    public static int[] mCol = {1, -1, 0, 0};

    public static int[][] dice = new int[4][3];

    public static void rollDice(int d) {
        // 동
        if (d == 1) {
            int temp = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = temp;
        }
        // 서
        if (d == 2) {
            int temp = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = dice[3][1];
            dice[3][1] = temp;
        }
        // 북
        if (d == 3) {
            int temp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = temp;
        }
        // 남
        if (d == 4) {
            int temp = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = dice[0][1];
            dice[0][1] = dice[3][1];
            dice[3][1] = temp;
        }
    }
    
    
    //1234 동서남북
    //2차원 배열은 copy안됨
    public static void go(int d) {
        //1 map 바깥인지 확인
        //1 바닥이 0 이면 주사위의 바닥의 숫자가 바닥으로 복사
        //2 바닥이 0이 아니면 바닥에서 -> 주사위 바닥으로 복사 칸은 0
        //이동할때마다 주사위 상단 출력
        int nextRow = mRow[d - 1] + x;
        int nextCol = mCol[d - 1] + y;
        if (nextRow >= n || nextRow < 0 || nextCol >= m || nextCol < 0) {
            return;
        }
        rollDice(d);
        if (map[nextRow][nextCol] == 0) {
            map[nextRow][nextCol] = dice[3][1];

        }else {
            dice[3][1] = map[nextRow][nextCol];
            map[nextRow][nextCol] = 0;
        }
        x =nextRow;
        y =nextCol;
        System.out.println(dice[1][1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        x = Integer.parseInt(s[2]);
        y = Integer.parseInt(s[3]);
        int k = Integer.parseInt(s[4]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line [] = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        String[] kLine = bufferedReader.readLine().split(" ");
        for (int i = 0; i < kLine.length; i++) {
            go(Integer.parseInt(kLine[i]));
        }
    }
}
