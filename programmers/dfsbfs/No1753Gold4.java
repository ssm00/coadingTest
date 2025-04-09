package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1753Gold4 {

    public static class Node implements Comparable<Node> {
        int end;
        int cost;


        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static ArrayList<Node> [] graph;

    static int[] dijkstra(int nodeNum, int startIndex) {
        //boolean check[] = new boolean[nodeNum + 1];
        int[] dist = new int[nodeNum + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[startIndex] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startIndex, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nextNode = now.end;
            int nowCost = now.cost;
//            if(check[now.end]){
//                continue;
//            }
//            check[now.end] = true;
            if(nowCost > dist[now.end]){
                continue;
            }
            for (Node node : graph[nextNode]) {
                if (nowCost + node.cost < dist[node.end]) {
                    dist[node.end] = nowCost + node.cost;
                    pq.add(new Node(node.end, nowCost + node.cost));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //정점의 개수, 간선의 개수
        String[] split = bf.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int startIndex = Integer.parseInt(bf.readLine());


        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++)  {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0 ; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }
        int[] dist = dijkstra(n, startIndex);
        for (int i = 1; i < dist.length; i++){
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }
}
