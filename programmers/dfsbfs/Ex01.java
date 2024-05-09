package dfsbfs;

public class Ex01 {
    int answer = 0;

    public void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (target == sum) {
                answer++;
            }
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        int b = 3;
        Ex01 ex01 = new Ex01();
        int solution = ex01.solution(a, b);
        System.out.println(solution);
    }
}
