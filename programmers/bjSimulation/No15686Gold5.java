package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No15686Gold5 {

    public static int[][] map;
    public static ArrayList<int []> chickenCom = new ArrayList<>();
    public static ArrayList<int []> chickenArr = new ArrayList<>();
    public static int n;
    public static int r;
    public static int com[];
    public static void combi(int start, int depth){
        if (depth == r) {
            chickenCom.add(com.clone());
            return;
        }else{
            for (int i = start; i < n; i++) {
                com[depth] = i;
                combi(i+1, depth+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int mapL = Integer.parseInt(line[0]);
        r = Integer.parseInt(line[1]);
        map = new int[mapL][mapL];
        com = new int[r];
        for (int i = 0; i < mapL; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                if(Integer.parseInt(arr[j])==2) chickenArr.add(new int[]{i, j});
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        n = chickenArr.size();

        combi(0,0);
        int minimunDist = 99999;
        for (int[] chicken : chickenCom) {
            int combiDist = 0;
            for (int i = 0; i < mapL; i++) {
                for (int j = 0; j < mapL; j++) {
                    if(map[i][j] == 1){
                        int minDist = 99999;
                        for (int chickenPoint : chicken) {
                            int[] points = chickenArr.get(chickenPoint);
                            int row = points[0];
                            int col = points[1];
                            minDist = Math.min(minDist, Math.abs(i-row) + Math.abs(j-col));
                        }
                        combiDist += minDist;
                    }
                }
            }
            minimunDist = Math.min(minimunDist, combiDist);
        }
        System.out.println(minimunDist);
    }
}
