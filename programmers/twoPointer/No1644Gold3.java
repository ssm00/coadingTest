package twoPointer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class No1644Gold3 {

    //일단 연속된 수에서 특정 값찾기? -> 투포인터
    //소수 리스트 만든다음에 투포인터로 값 찾으면 됨
    //target보다 작으면 right++ , 
    //target 크면 left++
    //같으면 ans = ++, left++
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean [] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if(isPrime[i]){
                for (int j = i*i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                prime.add(i);
            }
        }
        prime.add(0);
        int left = 0;
        int right = 0;
        int ans = 0;
        int sum = 0;
        while (left < prime.size() && right < prime.size()) {
            if (sum < n) {
                sum += prime.get(right++);
            } else if (sum == n) {
                sum -= prime.get(left++);
                ans++;
            } else if (sum > n) {
                sum -= prime.get(left++);
            }
        }
        System.out.println(ans);
    }
}
