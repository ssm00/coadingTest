package dfsbfs;

public class Ex02 {

    public int answer;

    public int solution(int n, int[][] computers) {

        boolean[] check = new boolean[computers.length];
        for (int i = 0; i < computers.length; i++) {
            if (check[i] == false) {
                answer++;
                dfs(i,check,computers);
            }
        }
        return answer;
    }


    //뿌리 하나 내리기
    //갔는지 안갔는지 확인하기 위해 check가 필요함
    public void dfs(int i, boolean[] check, int [][] computer) {
        check[i] = true;
        for (int j = 0; j < computer[0].length; j++) {
            if (i != j && computer[i][j] == 1 && check[j]==false) {
                dfs(j,check,computer);
            }
        }
    }


    public static void main(String[] args) {
        int n =3;
        int[][] a = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        Ex02 ex02 = new Ex02();
        int solution = ex02.solution(n, a);
        System.out.println(solution);
    }
}
