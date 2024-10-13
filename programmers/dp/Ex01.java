package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 5, 55, 555, 5555 의 List<Set>을 만든다음 4번의 경우 3,1 2,2, 1,3 의 set에 포함된 숫자로 +-*/를 진행하여 숫자를 만들어 넣은뒤 정답이 어떤 리스트에 포함되어있는지 확인하기
// 결론은 4번째는 1+3, 2+2, 3+1 으로 만들어 진다
public class Ex01 {

    public int solution(int n, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        for (int i = 1; i < 9; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                // 3 , 33, 333, 만드는법
                sum = sum * 10 + n;
            }
            dp.get(i).add(sum);
        }

        for (int i = 1; i < 9; i++) {
            // 4일때 1,3 2,2, 3,1 이런식으로 모든 조합을 계산하고 싶으면 for j<i 로 가능
            for (int j = 1; j < i; j++) {
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < 9; i++) {
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        System.out.println(ex01.solution(5, 12));
    }

}
