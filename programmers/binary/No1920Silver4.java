package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1920Silver4 {

    static  int arr[];
    public static int bs(int target) {
        int lo = 0;
        int high = arr.length-1;
        while (lo <= high) {
            int mid = (lo + high) / 2;
            if (arr[mid] > target) {
                high = mid-1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else if (arr[mid] == target) {
                return 1;
            }
        }
        return 0;
    }

    // 1 3 4 6 8 9
    // 7
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String second [] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(second[i]);
        }
        int m = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        String fourth [] = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(fourth[i]);
            int ans = bs(num);
            System.out.println(ans);
        }
    }
}
