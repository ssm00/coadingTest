package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1484Gold4 {

    public static void main(String[] args) throws IOException {
        // 15
        // 4
        // 8 64 - ? = 15?
        // 1 4 9 16 25 ?
        // sort는 어차피 되어있음
        // 리스트 마지막에 0 더하기 해
        // 투포인터 < arr.size
        // 100,000의 제곱 까지 list 그 이상이면 가장작은 차가 십만 이상이 나옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int [] arr = new int[100001];
        for (int i = 1; i <= 100000; i++) {
            arr[i] = i;
        }
        int left = 1;
        int right = 1;
        ArrayList<Integer> ansList = new ArrayList<>();
        while (left < arr.length && right < arr.length) {
            if (arr[right] * arr[right] - arr[left] * arr[left] == target) {
                ansList.add(arr[right]);
                left++;
            } else if (arr[right] * arr[right] - arr[left] * arr[left] > target) {
                left++;
            } else if (arr[right] * arr[right] - arr[left] * arr[left] < target) {
                right++;
            }
        }
        if (ansList.size() == 0) {
            System.out.println(-1);
        }else {
            ansList.sort((o1, o2) -> o1-o2);
            for (int i = 0; i < ansList.size(); i++) {
                System.out.println(ansList.get(i));
            }
        }
    }
}
