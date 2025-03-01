package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2531Silver1 {

    static int n, d, k, c;
    static int[] sushi;
    static int[] eated;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        d = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());
        c = Integer.valueOf(st.nextToken());
        sushi = new int[n];
        eated = new int[d + 1];
        // 스시 종류 번호 배열에 넣기
        for(int i = 0; i < n; i++) {
            sushi[i] = Integer.valueOf(br.readLine());
        }
        int windowSize = 0;
        int eatCnt= 0;
        for (int i = 0; i < k; i++) {
            if (eated[sushi[i]] == 0) {
                eatCnt++;
            }
            eated[sushi[i]]++;
        };
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            eated[sushi[i-1]]--;
            if (eated[sushi[i - 1]] == 0) {
                eatCnt--;
            }
            if(eated[sushi[(i+k-1)%n]] == 0){
                eated[sushi[(i+k-1)%n]]++;
                eatCnt++;
            } else if (eated[sushi[(i+k-1) % n]] > 0 ) {
                eated[sushi[(i+k-1) % n]]++;
            }
            int current = eatCnt;
            if (eated[c] == 0) {
                current++;
            }
            ans = Math.max(ans, current);
        }
        System.out.println(ans);
    }
}
