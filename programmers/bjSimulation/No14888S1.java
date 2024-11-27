package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No14888S1 {

    static ArrayList<int []> allPerm = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void solution(int [] numbers, int [] operations) {
        int[] output = new int[operations.length];
        boolean[] visited = new boolean[operations.length];
        permutation(output, operations, visited, 0, operations.length, operations.length);
        for (int i = 0; i < allPerm.size(); i++) {
            int [] operPerm = allPerm.get(i);
            int temp = numbers[0];
            for (int j = 0; j < operPerm.length; j++) {
                int a = numbers[j+1];
                if (operPerm[j] == 0) {
                    temp = temp + a;
                } else if (operPerm[j] == 1) {
                    temp = temp - a;
                }else if(operPerm[j] == 2){
                    temp = temp * a;
                } else if (operPerm[j] == 3) {
                    temp = temp / a;
                }
            }
            max = Math.max(temp, max);
            min = Math.min(temp, min);
        }
    }

    static void permutation(int [] output, int[] operations, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            allPerm.add(output.clone());
            return;
        }
        for(int i=0; i<n; i++){
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = operations[i];
                permutation(output, operations, visited, depth + 1, n, r);
                visited[i] = false;
                output[depth] = 0;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String secondLine = br.readLine();
        String token [] = secondLine.split(" ");
        int [] numbers = new int[n];
        for (int i = 0; i < token.length; i++) {
            numbers[i] = Integer.parseInt(token[i]);
        }
        String thirdLine = br.readLine();
        String [] tk = thirdLine.split(" ");
        int [] operations = new int[n-1];
        int index = 0;
        for (int i = 0; i < tk.length; i++) {
            int num = Integer.parseInt(tk[i]);
            for (int j = 0; j < num; j++) {
                operations[index] = i;
                index++;
            }
        }
        //0 부터 + - * /
        solution(numbers, operations);
        System.out.println(max + " " + min);
    }

}
