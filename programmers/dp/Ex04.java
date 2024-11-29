package dp;


import java.util.Arrays;

public class Ex04 {

    public int solution(String[] arr) {

        String operArr[] = new String[201];
        int numArr[] = new int[201];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                numArr[i/2] = Integer.parseInt(arr[i]);
            } else {
                operArr[(i+1)/2] = arr[i];
            }
        }
        int max_dp[][] = new int[201][201];
        int min_dp[][] = new int[201][201];
        for (int i = 0; i < 101; i++) {
            Arrays.fill(max_dp[i], Integer.MIN_VALUE);
            Arrays.fill(min_dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < numArr.length; i++) {
            max_dp[i][i] = numArr[i];
            min_dp[i][i] = numArr[i];
        }

        for (int operLength = 2; operLength < numArr.length; operLength++) {
            for (int start = 1; start < numArr.length - operLength + 1 ; start++) {
                int last = start + operLength - 1;
                for(int k = start; k<last; k++){
                    if (operArr[k - 1].equals("+")) {
                        max_dp[start][last] = Math.max(max_dp[start][last], max_dp[start][k] + max_dp[k + 1][last]);
                        min_dp[start][last] = Math.min(min_dp[start][last], min_dp[start][k] + min_dp[k + 1][last]);
                    } else {
                        max_dp[start][last] = Math.max(max_dp[start][last], max_dp[start][k] - min_dp[k + 1][last]);
                        min_dp[start][last] = Math.min(min_dp[start][last], min_dp[start][k] - max_dp[k + 1][last]);
                    }
                }
            }
        }
        return max_dp[1][arr.length + 1];
    }

    public static void main(String[] args) {
        Ex04 ex04 = new Ex04();
        System.out.println(ex04.solution(new String[]{"1", "-", "3", "+", "5", "-", "8"}));
    }

}
