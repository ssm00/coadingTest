package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1806Gold4 {


    //1. 누적합을 만듬
    //2. 투포인터로 왼쪽부터 가면서 left right차를 구함
    //3. 차가 작으면 right ++ 차가 만약에 같으면 right-left-1 가 길이임 ans = min하고 right++,
    //4 차가 크면 left++


    //1,2,3,4,5 -> 9
    //1,3,6,10,15

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        int arr[] = new int[n+1];
        String[] line2 = br.readLine().split(" ");
        //누적합 만들기
        for (int i = 0; i < n; i++) {
            arr[i+1] = arr[i] + Integer.parseInt(line2[i]);
        }
        //1234
        //013610
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        while (left < n && right <= n) {
            int temp = arr[right] - arr[left];
            if (temp < s) {
                right++;
            } else if (temp >= s) {
                ans = Math.min(ans, right - left);
                left++;
            }
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
