package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No10942Gold4 {

    //팰린드롬?
    //문제가 1,000,000개 매 문제에 풀때 마다 loop면 시간초과
    //dp정의 dp[i][j] i시작 j 끝일때 팰린드롬 이냐 아니냐
    //점화식 -> dp[i][j] 일때
    //길이 1일때 for i<n dp[i][i] = true
    //길이 2일때 for i<n if arr[i] == arr[i+1] dp[i][i+1] = true
    //길이 3이상 for i<n for j=i+3 if arr[i] == arr[j]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[n + 1][n + 1];

        //1
        for (int i = 1; i < arr.length; i++) {
            dp[i][i] = true;
        }
        //2
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                dp[i][i + 1] = true;
            }
        }

        //132314
        //3
        for (int len = 3; len < arr.length; len++) {
            for (int i = 1; i < arr.length - len + 1; i++) {
                int j = i+len-1;
                if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }

        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (dp[S][E]) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);
    }
}
