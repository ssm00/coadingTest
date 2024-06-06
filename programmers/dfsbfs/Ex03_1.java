package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Ex03_1 {

    public int solution(int[][] map) {

        int bfs = bfs(map, 0, 0);
        return bfs;
    }

    public int bfs(int [][] map, int nowX, int nowY) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{nowX, nowY, 0});
        int[] xArr = {0, 0, -1, +1};
        int[] yArr = {-1, 1, 0, 0};
        boolean visited[][] = new boolean[map.length][map[0].length];
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            Integer x = poll[0];
            Integer y = poll[1];
            Integer count = poll[2];
            if (y == map.length && x == map[0].length) {
                return count;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = x + xArr[i];
                int nextY = y + yArr[i];
                if (nextX < 0 || nextY < 0 || nextX > map[0].length || nextY > map.length) {
                    continue;
                }
                if (visited[nextY][nextX] == true) {
                    continue;
                }
                visited[nextY][nextX] = true;
                q.add(new Integer[]{nextX, nextY, count + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        Ex03 ex03 = new Ex03();
        System.out.println(ex03.solution(a));
    }
}
