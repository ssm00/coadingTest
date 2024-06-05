package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

//프로그래머스 아이템 줍기 복기
//2배로 만드는 이유 확인 하기, bfs만드는 법 확인하기

public class Ex05_1 {

    public char[][] map = new char[101][101];

    public int solution(int[][] a, int x, int y, int itemX, int itemY) {
        for (int i = 0; i < a.length; i++) {
            int x1 = a[i][0];
            int y1 = a[i][1];
            int x2 = a[i][2];
            int y2 = a[i][3];
            drawMap(x1*2, y1*2, x2*2, y2*2);
        }
        int ans = bfs(x*2, y*2, itemX*2, itemY*2);
        return ans/2;
    }

    public int bfs(int x, int y, int itemX, int itemY) {
        Queue<Integer[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        q.add(new Integer[]{x, y, 0});
        int[] arrX = {0, 0, -1, 1};
        int[] arrY = {-1, 1, 0, 0};
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            Integer nowX = poll[0];
            Integer nowY = poll[0];
            Integer count = poll[0];
            if (nowX == itemX && nowY == itemY) {
                return count;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + arrX[i];
                int nextY = nowY + arrY[i];
                if (nextX < 0 || nextY < 0 || nextX > 100 || nextY > 100) {
                    continue;
                }
                visited[nextY][nextX] = true;
                q.add(new Integer[]{nextX, nextY, count + 1});
            }
        }
        return 0;
    }

    public void drawMap(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if(map[j][i]=='1') continue;
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    map[j][i] = '2';
                } else {
                    map[j][i] = '1';
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] a = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int charX = 1;
        int chary = 3;
        int itemX = 7;
        int itemY = 8;
        Ex05 ex05 = new Ex05();
        int solution = ex05.solution(a, charX, chary, itemX, itemY);
        System.out.println(solution);
    }

}
