package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2011Gold5 {


    //dp 정의 dp[3] 3번째 자리일때 나올 수 있는 암호의 개수
    //경우의 수 는 +=
    //dp[2] = dp[1]
    //if charat(i-1)+charAt(i) >= 10 &&  charat(i-1)+charAt(i) <26 dp[i] += dp[i+1]
    // 0 < if charat(i-1)+charAt(i) < 10 무조건 dp[i] += dp[i-1]
    static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int dp[] = new int[str.length() + 1];
        dp[0] = 1;
        //dp 12511
        //str 2511
        for (int i = 1; i < dp.length; i++) {
            int one = str.charAt(i - 1) - '0';
            if(one >= 1 && one <= 9){
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }
            int two = str.charAt(i - 2) - '0';
            if (two == 0) {
                continue;
            }
            int full = two * 10 + one;
            if (full >= 10 && full <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[str.length()]);
    }
}
