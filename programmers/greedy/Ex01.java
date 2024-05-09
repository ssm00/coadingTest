package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex01 {

    public int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> students = new ArrayList<Integer>();
        for(int i=1; i<=n; i++){
            students.add(i);
        }
        List<Integer> lost1 = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserve1 = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        lost1.sort(Integer::compareTo);
        reserve1.sort(Integer::compareTo);
        for (Integer i : reserve1) {
            if (lost1.contains(i)) {
                lost1.remove(i);
                reserve1.remove(i);
            }
        }
        students.removeAll(lost1);
        for (Integer i : lost1) {
            if (reserve1.contains(i - 1)) {
                reserve1.remove(Integer.valueOf(i - 1));
                students.add(Integer.valueOf(i - 1));
            } else if (reserve1.contains(i + 1)) {
                reserve1.remove(Integer.valueOf(i + 1));
                students.add(Integer.valueOf(i + 1));
            }
        }
        return students.size();
    }

    public static void main(String[] args) {
        int[] list1 = {2,3,4};
        int[] list2 = {2,3};
        int n = 5;
        Ex01 ex01 = new Ex01();
        int solution = ex01.solution(n, list1, list2);
        System.out.println(solution);


    }
}
