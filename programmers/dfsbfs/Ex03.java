package dfsbfs;

import org.w3c.dom.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


//bfs는 visited처리를 q에 넣기 직전에 하는 습관을 들이자 (효율성)
public class Ex03 {

    class Node {
        int row;
        int col;
        int count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
    static int answer = -1;
    static boolean[][] visited;
    static int[] mrow = {-1, 1, 0, 0};
    static int[] mcol = {0, 0, -1, 1};

    public int solution(int [][] a) {
        visited = new boolean[a.length][a[0].length];
        bfs(0, 0, a);
        return answer;
    }

    public int bfs(int row, int col, int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0,1));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (poll.row == maps.length - 1 && poll.col == maps[0].length - 1) {
                return answer = poll.count;
            }
            Node node1 = new Node(poll.row+1,poll.col, poll.count+1);
            Node node2 = new Node(poll.row-1,poll.col, poll.count+1);
            Node node3 = new Node(poll.row,poll.col+1, poll.count+1);
            Node node4 = new Node(poll.row,poll.col-1, poll.count+1);
            Node[] nodes = {node1, node2, node3, node4};

            for (int i = 0; i < 4; i++) {
                Node node = nodes[i];
                if (canMove(node, visited, maps)) {
                    visited[node.row][node.col] = true;
                    q.add(node);
                }
            }
        }
        return answer;
    }

    public boolean canMove(Node node, boolean[][] visited, int[][] maps) {
        if (node.row >= 0 && node.row < visited.length && node.col >= 0 && node.col < visited[0].length && !visited[node.row][node.col] && maps[node.row][node.col] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        Ex03 ex03 = new Ex03();
        System.out.println(ex03.solution(a));
    }
}
