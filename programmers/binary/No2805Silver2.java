package binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2805Silver2 {


    //나무를 잘라야하는 최적의 길이를 구해야함
    //특정 값 찾기임
    //특정 값으로 조건을 만족할수있냐?
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first [] = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int target = Integer.parseInt(first[1]);
        arr = new int[n];
        String second [] = br.readLine().split(" ");
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(second[i]);
            maxlen = Math.max(arr[i], maxlen);
        }
        int low=0;
        int high = maxlen;
        int ans = 0;
        //01234567890
        //
        while (low <= high) {
            int mid = (low + high) / 2;
            long getWoodLen = calculateWoodLen(mid);
            if (getWoodLen < target) {
                high = mid - 1;
            } else if(getWoodLen > target){
                low = mid + 1;
                ans = Math.max(mid, ans);
            } else if (getWoodLen == target) {
                ans = Math.max(mid, ans);
                break;
            }
        }
        System.out.println(ans);
    }

    static long calculateWoodLen(int num) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= num){
                continue;
            }
            sum += arr[i] - num;
        }
        return sum;
    }
}
