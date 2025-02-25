package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No16637Gold3 {



    public static int ans = Integer.MIN_VALUE;
    public static int n;
    public static List<Integer> numberList = new ArrayList<>();
    public static List<Character> operList = new ArrayList<>();

    //dfs로 노드별 2개 묶기, 안묶기로 계산해서 depth에서 값이 맞으면 ans
    //처음에는 숫자 1개 그냥 넘겨도 연산이 괄호 있음없음이라 없음에서 똑같이 계산되서 가능
    public static void dfs(int opIndex, int currentValue) {
        if (opIndex >= operList.size()) {
            ans = Math.max(ans, currentValue);
            return;
        } else {
            int nextValue = calculate(currentValue, numberList.get(opIndex + 1), operList.get(opIndex));
            dfs(opIndex + 1, nextValue);
            if (opIndex + 1 < operList.size()) {
                int bracketResult = calculate(numberList.get(opIndex + 1), numberList.get(opIndex + 2), operList.get(opIndex + 1));
                int calculate = calculate(currentValue, bracketResult, operList.get(opIndex));
                dfs(opIndex + 2, calculate);
            }
        }

    }

    public static int calculate(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: return 0;
        }
    }
    //dfs(0,0,0)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        for (int i = 0; i < n; i++) {
            char c = line.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                operList.add(c);
            } else {
                numberList.add(Character.getNumericValue(c));
            }
        }
        dfs(0, numberList.get(0));
        System.out.println(ans);
    }


}
