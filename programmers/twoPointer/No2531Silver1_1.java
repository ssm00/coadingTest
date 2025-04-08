package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2531Silver1_1 {
    static int n, d, k, c;
    static int[] sushi;
    static int[] eat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        d = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());
        c = Integer.valueOf(st.nextToken());
        sushi = new int[n];
        eat = new int[d+1];
        for(int i = 0; i < n; i++) {
            sushi[i] = Integer.valueOf(br.readLine());
        }
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if(eat[sushi[i]] > 0){
                eat[sushi[i]] += 1;
            }else {
                eat[sushi[i]] += 1;
                cnt++;
            }
        }
        int ans = 0;
        if (checkB()) {
            ans = cnt+ 1;
        }else {
            ans = cnt;
        }
        for (int i = 1; i <= sushi.length - k; i++) {
            if (eat[sushi[i - 1]] == 1) {
                cnt--;
            }
            eat[sushi[i-1]] -= 1;
            if(eat[sushi[i+k-1]]==0){
                cnt++;
            }
            eat[sushi[i+k-1]] += 1;
            int temp = cnt;
            if (checkB()) {
                temp +=1;
            }
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }

    static boolean checkB() {
        if (eat[c] == 0) {
            return true;
        }
        return false;
    }
}
