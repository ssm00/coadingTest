package dfsbfs;


import java.util.ArrayList;

public class Ex06 {

    public static ArrayList<String> ans = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0] == "ICN") {
                boolean[] visited = new boolean[tickets.length];
                ArrayList<String> order = new ArrayList<>();
                order.add("ICN");
                order.add(tickets[i][1]);
                visited[i] = true;
                dfs(order, visited, tickets);
                visited[i] = false;
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    public void dfs(ArrayList<String> order, boolean [] visited, String[][] tickets) {
        if (order.size() == visited.length+1) {
            checkOrderbyAsc(order);
        }
        for (int i = 0; i < tickets.length; i++) {
            String departure = tickets[i][0];
            String nowLast = order.get(order.size() - 1);
            if (departure.equals(nowLast)&& visited[i] == false) {
                order.add(tickets[i][1]);
                visited[i] = true;
                dfs(order, visited, tickets);
                visited[i] = false;
            }
        }
    }

    public void checkOrderbyAsc(ArrayList<String> order) {
        if (ans.size() == 0) {
            ans.clear();
            ans.addAll(order);
        } else {
            for (int i = 0; i < order.size(); i++) {
                String newStation = order.get(i);
                String existingStation = ans.get(i);
                for (int j = 0; j < 3; j++) {
                    if (newStation.charAt(j) < existingStation.charAt(j)) {
                        ans.clear();
                        ans.addAll(order);
                        return;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        String a[][] = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String b[][] = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        Ex06 ex06 = new Ex06();
        String[] solution = ex06.solution(a);
        System.out.println(solution.length);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }


}



