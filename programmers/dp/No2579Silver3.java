package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2579Silver3 {

    //dp[i]는? i번째 올때 최대 점수
    //이전에 조건이 있는 경우?
    //연속 3개이상 밟을 수 없는 경우의 점화식을 다시 생각한다, if를 넣을수는 없음


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];
        //0123
        for (int i = 1; i < n+1; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        dp[0] = 0;
        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        //점화식 -> dp[i] = dp[i-3] + arr[i-1], dp[i-2]
        //12345
        for (int i = 3; i < n+1; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i-1], dp[i - 2]) + arr[i];
        }
        System.out.println(dp[n]);
    }
}
