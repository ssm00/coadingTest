package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No20922Silver1  {


    public static int n;
    public static int k;
    public static int arr[];
    public static int checkArr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        k = Integer.parseInt(split[1]);
        String[] split2 = bufferedReader.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < split2.length; i++) {
            arr[i] = Integer.parseInt(split2[i]);
        }
        checkArr = new int[100001];

        //카운트 리스트 만들고 right++ 하면서 중복 몇개인지 체크 한다음에 k이상이면 left 올리고
        int left = 0;
        int right = 0;
        int len = 0;
        int ans = 0;
        while (right < n) {
            if (checkArr[arr[right]] >= k) {
                checkArr[arr[left++]]--;
                len--;
            } else if (checkArr[arr[right]] < k) {
                checkArr[arr[right++]]++;
                len++;
                ans = Math.max(ans, len);
            }
        }
        System.out.println(ans);
    }
}
