package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1463Silver3 {

    // 3을 표현하는건? 2를표현에서 1더한거, 1표현에서 3을 곱한거, 4?
    //점화식 dp는? 12일때 12를 1로 만드는데 필요한 연산의 최솟값
    //12? 3으로 나누기, 2로 나누기, 1빼기 일때의 최소값
    //12 점화식 dp4 +1, dp6+1, dp11 + 1 min


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[n]);
    }

}
