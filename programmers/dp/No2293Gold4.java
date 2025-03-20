package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2293Gold4 {

    //점화식
    //dp[i] 합이 i 일때 가능한 경우의 수
    //arr 1 2 3 4 5 6
    //코인 1 2
    //총 경우의 수 -> dp[i-모든coin[j]]의 경우의 수 합 이러면 중복을 계산 못함
    //dp[j] = dp[j] + dp[i-coin[i]] 경우의 수 는 +1을 안해줌 그냥 냅색이랑 다르게

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int target = Integer.parseInt(line[1]);
        int coin[] = new int[n];
        int dp[] = new int[target + 1];
        for (int i = 0; i < coin.length; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        //01234
        dp[0] = 1;
        for (int i = 0; i < coin.length; i++){
            for (int j = coin[i]; j <= target; j++) {
                dp[j] = dp[j] + dp[j - coin[i]];
            }
        }
        System.out.println(dp[target]);
    }
}
