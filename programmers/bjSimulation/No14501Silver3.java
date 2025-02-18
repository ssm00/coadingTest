package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No14501Silver3 {



    //앞에서 부터 선택 했을때 안했을때 dfs로 max저장

    public static int map[][];
    public static int n;
    public static int ans = Integer.MIN_VALUE;

    public static void find(int nowMoney, int date) {
        if (date >= n) {
            ans = Math.max(ans, nowMoney);
            return;
        }
        if(date+map[date][0] <= n){
            find(nowMoney + map[date][1], date + map[date][0]);
        }
        find(nowMoney, date +1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        find(0,0);
        System.out.println(ans);
    }
}
