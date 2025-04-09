package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2343Silver1 {


    // 총합 / 2
    // for로 돌면서 mid보다 커지면 다음부터 넣기
    // 개수가 주어진 개수보다 크면 high = mid

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int arr[] = new int[n];
        String line2[] = br.readLine().split(" ");
        int maxValue = 0;
        int low = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line2[i]);
            maxValue += arr[i];
            low = Math.max(low, arr[i]);
        }
        int high = maxValue;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int need = 1;
            int hold = 0;
            for (int i = 0; i < n; i++) {
                if (hold + arr[i] > mid) {
                    hold = arr[i];
                    need++;
                } else {
                    hold += arr[i];
                }
            }
            if(need > m){
                low = mid+1;
            }else if(need <= m){
                high = mid-1;
                ans = Math.min(ans, mid);
            }
        }
        System.out.println(ans);
    }
}
