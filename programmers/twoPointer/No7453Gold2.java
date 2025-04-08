package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No7453Gold2 {

    //특정 값 구하기? sort 투포인터
    //배열이 4개임 모두 서치한다고 하면 n**4
    //두개로 합치고 모든 경우의 수 넣은다음에 투포인터
    //배열 2개로 나누고 투포인터 써서 값 찾으려면 right는 끝에서 시작해야함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n], B = new int[n], C = new int[n], D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        int [] ab = new int[n*n];
        int[] cd = new int[n*n];
        //123456
        //123456
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[i * n + j] = A[i] + B[j];
                cd[i * n + j] = C[i] + D[j];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        int left = 0;
        int right = n*n-1;
        long ans = 0;
        while(left < ab.length && right >= 0){
            if (ab[left] + cd[right] == 0) {
                long countLeft = 1;
                long countRight = 1;
                while (left + 1 < n*n && ab[left] == ab[left + 1]) {
                    countLeft++;
                    left++;
                }

                // 오른쪽 포인터에서 같은 값의 개수 세기
                while (right - 1 >= 0 && cd[right] == cd[right - 1]) {
                    countRight++;
                    right--;
                }
                // 조합의 수를 더함
                ans += countLeft * countRight;
                left++;
                right--;
            } else if (ab[left] + cd[right] > 0) {
                right--;
            }else if (ab[left] + cd[right] < 0) {
                left++;
            }
        }
        System.out.println(ans);
    }
}
