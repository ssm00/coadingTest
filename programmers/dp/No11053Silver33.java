package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11053Silver33 {


    //lis
    //dp 정의 : dp[i]일때 i일때 가장 긴 길이 저장
    //dp 점화식
    //dp[i] = for j = i j>=0; j++; if dp[i]<dp[j] dp[i] = dp[j]
    // 1 2 6 3 4
    // 1 2 3 3 4

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] line = (bufferedReader.readLine().split(" "));
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i+1] = Integer.parseInt(line[i]);
        }
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            ans = Math.max(dp[i], ans);
        }
        System.out.println(ans);
    }
}
