package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2503Silver3 {

    public static boolean[] impossible = new boolean[1000];


    public static void go(String num, int strike, int ball) {
        for (int i = 123; i < impossible.length; i++) {
            if (impossible[i] == false) {
                int strikeCnt = 0;
                int ballCnt = 0;

                for (int j = 0; j < 3; j++) {
                    if (num.charAt(j) == String.valueOf(i).charAt(j)) {
                        strikeCnt++;
                    } else if (num.charAt(j) == String.valueOf(i).charAt((j+1)%3) || num.charAt(j) == String.valueOf(i).charAt((j+2)%3)) {
                        ballCnt++;
                    }
                }
                if (strike != strikeCnt || ball != ballCnt) {
                    impossible[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < 1000; i++) {
            if (i < 123) {
                impossible[i] = true;
                continue;
            }
            String iString = String.valueOf(i);
            //char비교할때 무조건 ''
            if(iString.charAt(0) == '0' || iString.charAt(1) == '0' || iString.charAt(2) == '0'){
                impossible[i] = true;
                continue;
            }
            if(iString.charAt(0) == iString.charAt(1) || iString.charAt(1) == iString.charAt(2) ||iString.charAt(0) == iString.charAt(2)){
                impossible[i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            String num = line[0];
            int strike = Integer.parseInt(line[1]);
            int ball = Integer.parseInt(line[2]);
            go(num, strike, ball);
        }

        int ans = 0;
        for (int i = 0; i < impossible.length; i++) {
            if (!impossible[i]) {
                ans++;
            }
        }
        System.out.println(ans);

    }
}
