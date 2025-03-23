package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No12865Gold5 {


    static class Item{
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

    }

    static int n;
    static int handleWeight;


    //냅색 알고리즘
    //재사용 가능한 경우 ? -> 앞에서 부터
    //재사용 불가능한 경우 뒤에서 부터
    //dp[i]는 가방 무게가 i일때 최대 벨류
    // for(int i=0, coin.len; i++)
    //for(int j=len, j>coin[i]; j--)
    //
    // 가방 무게 7
    // 0 1 2 3 4 5 6 7
    // 0 0 0 0 0 0 0 0
    // 1번 물건 무게 6 가치 13
    // 2번 물건 무게 4 가치 8
    // 0 1 2 3 4 5 6 7 8
    // 0 0 0 0 8 8 8 8 16
    
    //개수 무제한인 경우
    //for i=0 i<coin.len
    //for j=coin[i] j<len; j++
    // dp[j] =max dp[j], dp[j-coin[i]]

    //개수 제한 있는 경우
    //for i=0; i<coin.len
    //for j=dp.len j>coin[i] j--
    // dp[j] = max dp[j], coin[i]+dp[j-coin[i]]

    //개수 제한 있는 경우 무게, 가치 있는 냅색
    //결국 무게 20 일때 무게 5인 가방 -> 20일때 vs 15일때 + 5가방
    //for i=0; i<bag.len
    //for j=dp.len j>=bag[i].weight j--
    // dp[j] = max dp[j], dp[j-bag[i].weight] + bag[i].value

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        n = Integer.parseInt(first[0]);
        handleWeight = Integer.parseInt(first[1]);
        int dp[] = new int[handleWeight+1];
        Item [] items = new Item[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int weight = Integer.parseInt(line[0]);
            int value = Integer.parseInt(line[1]);
            items[i] = new Item(weight, value);
        }
        for (int i = 0; i < items.length; i++) {
            for (int j = dp.length - 1; j >= items[i].weight; j--) {
                dp[j] = Math.max(dp[j], dp[j-items[i].weight] + items[i].value);
            }
        }
        System.out.println(dp[dp.length-1]);
    }
}
