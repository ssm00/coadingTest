package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2110Gold4 {

    // 공유기 최대 거리 마지막 - 처음, 최소거리 1
    // 공유기 최대거리부터 줄여서 이분 탐색으로 가능한 거리 모두 탐색 하기
    // 이분탐색 , 거리 mid일때 들어가는 공유기 개수가 target보다 크면 low = mid+1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] line = br.readLine().split(" ");
        int n= Integer.parseInt(line[0]);
        int target = Integer.parseInt(line[1]);
        int arr[] = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int low = 1;
        int high = arr[arr.length-1];
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(calculateRouterNum(arr,mid) < target){
                high = mid-1;
            }else{
                result = mid;
                low = mid+1;
            }
        }
        System.out.println(result);
    }

    public static int calculateRouterNum(int[] arr, int len) {
        int temp = arr[0];
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - temp >= len) {
                temp = arr[i];
                cnt++;
            } else {
                continue;
            }
        }
        return cnt;
    }
}
