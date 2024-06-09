package dfsbfs;

import java.util.ArrayList;
import java.util.Collections;

public class Ex06_1 {


    static ArrayList<String> list = new ArrayList<>();
    static boolean visited[];

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN ", tickets);
        String[] answer = {};
        Collections.sort(list);
        answer = list.get(0).split(" ");
        return answer;
    }

    //나의 사고 -> String arraylist에 now 포함되어있다
    //dfs 파라미터에 now를 넘겨도된다.
    public void dfs(int depth, String now, String path, String tickets[][]) {
        if (depth == tickets.length) {
            list.add(path);
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] != true && now.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + tickets[i][1]+" ", tickets);
                visited[i] = false;
            }
        }
    }



    public static void main(String[] args) {
        String a[][] = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String b[][] = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        Ex06_1 ex061 = new Ex06_1();
        String[] solution = ex061.solution(b);
        System.out.println(solution.length);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }
}
