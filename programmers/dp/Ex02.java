package dp;


import java.util.Map;
// 최대 합 구하기
// 근데 경로를 지나면서 쌓이는 경우 dp사용
// 2차원 배열 그려보고 값 넣어보기
// 점화식 써보기
// 이문제 삼각형의 경우 맨 끝은 triangle의 해당자리 + dp의 전자리
// 맨끝이 아닌경우 triangle의 해당자리 + dp의 두가지 경로에서 오는 값중 큰값
public class Ex02 {
    public int solution(int[][] triangle) {

        int length = triangle.length;
        int[][] dp = new int[length][length];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + triangle[i][0];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < triangle[triangle.length-1].length; i++) {
            ans = Math.max(ans, dp[triangle.length - 1][i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        int[][] t = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(ex02.solution(t));
    }
}
