package dfsbfs;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No11724Silver2 {

    //1-2-3, 4,5
    //dfs 
    //for dfs 1부터 visited 공유, dfs 맨마지막오면 그냥 return for돌릴때 dfs 끝나면 ans++

    static int ans = 0;
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> map;
    static void dfs(int index) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        for (Integer next : map.get(index)) {
            dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int nodeNum = Integer.parseInt(line[0]);
        int edgeNum = Integer.parseInt(line[1]);
        map = new ArrayList<>();
        visited = new boolean[nodeNum + 1];
        for (int i = 0; i <= nodeNum; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < edgeNum; i++) {
            String line2[] = br.readLine().split(" ");
            int start = Integer.parseInt(line2[0]);
            int end = Integer.parseInt(line2[1]);
            map.get(start).add(end);
            map.get(end).add(start);
        }
        for (int i = 1; i <= nodeNum; i++) {
            if (!visited[i]) {
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
