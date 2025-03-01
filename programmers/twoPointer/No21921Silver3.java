package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21921Silver3 {




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int a[] = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int ans = 0;
        int cnt = 0;
        int temp = 0;
        while (right <= n) {
            if (right - left < s) {
                temp += a[right++];
            } else if (right - left == s) {
                if (ans < temp) {
                    ans = temp;
                    cnt = 1;
                } else if (ans == temp) {
                    ans = temp;
                    cnt++;
                }
                temp -= a[left++];
                temp += a[right++];
            }
        }
        if (ans == 0) {
            System.out.println("SAD");
        }else {
            System.out.println(ans);
            System.out.println(cnt);
        }
    }
}
