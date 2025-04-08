package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2613Gold2 {

    //숫자 한개 선택
    // 20이면 20보다 작을때 까지 그룹으로 묶음, 그룹개수 > target low = mid+1; ans = mid
    // 20이면 20보다 작을때 까지 그룹으로 묶음, 그룹개수 <= target high = mid-1;
    // 어케샘 그룹 개수? 그룹에 포함된 공 개수는 0보다 커야함
    // low 는 arr 최대값 부터 시작해야함 (최소 1개는 묶어야되니까)
    // 어케샘 그룹 개수? for i -> if (sum < mid) sum += i else cnt++ cnt는 1부터 시작

    // 합이 최소일때 이기 때문에 그리고 소트가 안되어 있기 때문에 그룹이 m개보다 작아도 최소가 될 수 있음
    // 공유기 설치는 중간에 끊고 들어가서 사이에 들어가면 무조건 작아지는데 이건 합이 최소일때라 m개 가 아닐수도있음
    // 5,4 : 1,2,1,2,1 3개로 만들기 가능임

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int target = Integer.parseInt(line[1]);
        String line2[] = br.readLine().split(" ");
        int [] arr = new int[n];
        int low = -1;
        int high = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line2[i]);
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if(countGroup(arr, mid) <= target){
                ans = mid;
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        System.out.println(ans);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum > low){
                target--;
                sum = arr[i];
                sb.append(cnt).append(" ");
                cnt = 1;
            } else {
                cnt++;
            }

            if(target == n-i) break;
        }

        while (target-- > 0){
            sb.append(cnt).append(" ");
            cnt = 1;
        }
        System.out.println(sb.toString());
    }

    public static int countGroup(int arr[], int mid) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= mid) {
                sum += arr[i];
            }else{
                sum = arr[i];
                cnt++;
            }
        }
        return cnt;
    }

    //5 4 : 1,2,1,2,1 cnt = 3, 1,2,1,2,1 [1,2,1,2,1]
    public static void printGroup(int arr[], int mid, int target) {
        int sum = 0;
        int cnt = 1;
        int assestNum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= mid) {
                sum += arr[i];
                assestNum++;
            }else{
                sb.append(assestNum).append(" ");
                assestNum = 1;
                sum = arr[i];
                cnt++;
            }
        }
        sb.append(assestNum);


    }
}
