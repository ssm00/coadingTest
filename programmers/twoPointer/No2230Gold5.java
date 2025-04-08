package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2230Gold5 {



    //1 왼쪽 부터 right++ 하면서 차 구하기
    //2 차가 m보다 작으면 right++
    //3 차가 m보다 크면 ans = min , left++
    //핵심은 오름차순 정리를 하는거
    // 1 2 3 4 5
    static int n,m;
    static Long [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(bufferedReader.readLine());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = 0;
        long ans = Integer.MAX_VALUE;
        while (right < n && left < n) {
            Long temp = arr[right] - arr[left];
            if (temp < m) {
                right++;
            } else if (temp >= m) {
                ans = Math.min(ans, temp);
                left++;
            }
        }
        System.out.println(ans);
    }
}
