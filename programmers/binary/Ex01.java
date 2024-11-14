package binary;

import java.util.Arrays;

// times[times.length-1]이 long이 나올수 있으므로 명시적으로 타입캐스팅 하기
public class Ex01 {

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long ans = 0;
        long start = 1;
        long mid = 0;
        long end = (long)times[times.length - 1] * n;
        long sum;

        while (start <= end) {
            mid = (start + end) / 2;
            sum = 0;
            for (int time : times) {
                long canHandlePeopleNum = mid / time;
                sum += canHandlePeopleNum;
            }
            if (sum >= n) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        int[] a = {7, 10};
        long solution = ex01.solution(6, a);
        System.out.println(solution);
    }

}
