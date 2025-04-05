package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1477Gold4 {


    //1. 처음 맨끝 불가능
    //2. 휴게소 없는 부분의 길이 최소가 되도록
    //3. cal 휴게소 개수 > target low = mid+1
    //4. cal 휴게소 개수  <= target high = mid-1 and =
    // cal 휴게소 길이 안에 들어가면 설치, 안들어가면 있으면 그거 선택

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int addRestAreaNum = Integer.parseInt(line1[1]);
        int maxLen = Integer.parseInt(line1[2]);
        String[] line2 = br.readLine().split(" ");
        int arr[] = new int[n + 2];
        arr[0] = 0;
        arr[n+1] = maxLen;
        for (int i = 0; i < n; i++) {
            arr[i+1] = Integer.parseInt(line2[i]);
        }
        Arrays.sort(arr);
        int low =  1;
        int high = maxLen;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(calRestAreaNum(arr, mid) <= addRestAreaNum){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        System.out.println(ans);
    }

    public static int calRestAreaNum(int arr[], int mid) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int distance = arr[i] - arr[i-1];
            // 이미 기존 휴게소 간격이 mid 이하인 경우는 추가 필요 없음
            if (distance > mid) {
                // 구간을 mid 간격으로 나누기 위해 필요한 휴게소 수
                count += (distance - 1) / mid;
            }
        }
        return count;
    }

}
