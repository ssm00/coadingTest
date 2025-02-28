package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1025Gold5 {



    //등차수열이란?
    //1,3,5,7,9
    //열1,2,3,4,5
    static int n, m;
    static int[][] table;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        table = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                table[i][j] = line.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int di = -n; di < n; di++) {
                    for (int dj = -m; dj < m; dj++) {
                        if (di == 0 && dj == 0) {
                            continue;
                        }
                        int newRow = i;
                        int newCol = j;
                        int num = 0;
                        //공차0일수도 있음
                        while (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                            num = num * 10 + table[newRow][newCol];
                            int root = (int) Math.sqrt(num);
                            if (Math.pow(root, 2) == num) {
                                ans = Math.max(ans, num);
                            }
                            newRow += di;
                            newCol += dj;
                        }
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
