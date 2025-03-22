package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2512Silver2 {

    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] second = br.readLine().split(" ");
        arr = new int [n];
        int high = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(second[i]);
            high = Math.max(high, arr[i]);
        }
        int low = 0;
        int totalBudget = Integer.parseInt(br.readLine());
        int ans = 0;
        while (low <= high) {
            int mid = (low+high) / 2;
            int totalPrice = calculatePrice(mid);
            if (totalPrice > totalBudget) {
                high = mid -1;
            } else if (totalPrice <= totalBudget) {
                low = mid + 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }

    public static int calculatePrice(int price) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if(price >= arr[i]){
                ans += arr[i];
            }else{
                ans += price;
            }
        }
        return ans;
    }
}
