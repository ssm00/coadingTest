package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No10816Silver4 {


    //lower bound upper bound
    //

    //1224567
    //2
    public static int lowerBound(int [] arr, int target) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    //1224567
    //2
    public static int upperBound(int arr[], int target) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if(arr[mid] <= target){
                low = mid+1;
            }else {
                high = mid;
            }

        }
        return high;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] b = br.readLine().split(" ");
        int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(b[i]);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        String [] d = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(d[i]);
            sb.append(upperBound(arr, target) - lowerBound(arr, target));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
