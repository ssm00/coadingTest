package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class No1916Gold5 {

    //다익스트라다 dist[1,2,3,4] if(dist[now.end] < now.cost)continue, for nextNode : now.end { if(dist[nextNode.idx] < now.cost + next.cost) dist[nextNOde.idx] = now.cost+next.cost q.add(next.idx, dist[next.idx])


    public static class Node implements Comparable<Node>{
        int end;
        int cost;
        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    static int dist[];
    static void dijkstra(int start, ArrayList<ArrayList<Node>> map){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        while (!q.isEmpty()) {
            Node now = q.poll();
            int nowEnd = now.end;
            int nowCost = now.cost;
            if(dist[nowEnd] < nowCost) continue;
            for(Node nextNode : map.get(nowEnd)){
                if(dist[nextNode.end] > nextNode.cost + nowCost){
                    dist[nextNode.end] = nextNode.cost + nowCost;
                    q.add(new Node(nextNode.end, nextNode.cost + nowCost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> map = new ArrayList<ArrayList<Node>>();
        map.add(new ArrayList<>());
        for (int i = 0; i < city; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < bus; i++) {
            String[] split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            int cost = Integer.parseInt(split[2]);
            map.get(start).add(new Node(end, cost));
        }
        dist = new int [city+1];
        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        dijkstra(start, map);
        System.out.println(dist[end]);
    }
}
