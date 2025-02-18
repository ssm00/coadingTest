package bjSimulation;

import java.util.Scanner;

public class Permutation {

    public static int ans[];
    public static int arr[];

    public static int n;
    public static int r;

    public static void p(boolean[] visited, int depth){
        if(depth==r){
            for(int a :ans) System.out.print(a+" ");
            System.out.println();
            return;
        }else {
            for (int i = 0; i < arr.length; i++) {
                if(visited[i] == false) {
                    visited[i] = true;
                    ans[depth] = arr[i];
                    p(visited, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();  // 3
        r = scanner.nextInt();  // 2

        scanner.nextLine();  // 버퍼 비우기
        ans = new int[r];
        arr = new int[n];  // 크기를 n으로 설정
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();  // 3 6 9 를 하나씩 입력받음
        }
        boolean[] visited = new boolean[arr.length];
        p(visited, 0);
    }
}
