package dfsbfs;


import java.util.LinkedList;
import java.util.Queue;

public class Ex05 {

    static char map[][] = new char[101][101];

    public int solution(int[][] rectangle, int X, int Y, int itemX, int itemY) {
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];
            drawMap(x1*2, y1*2, x2*2, y2*2);
        }
        return bfs(X*2,Y*2,itemX*2,itemY*2);
    }

    public static int bfs(int x, int y, int itemX, int itemY) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{x, y, 0});
        int xArr[]={-1,1,0,0};
        int yArr[]={0,0,-1,1};
        boolean[][] visited = new boolean[101][101];
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            Integer x1 = poll[0];
            Integer y1 = poll[1];
            Integer count = poll[2];
            if (x1 == itemX && y1 == itemY) {
                return count/2;
            }
            for (int i = 0; i < 4; i++) {
                int nextX=x1+xArr[i];
                int nextY=y1+yArr[i];
                if(nextY<0||nextX<0||nextY>=map.length||nextX>=map[0].length)
                    continue;
                if(visited[nextY][nextX]==true||map[nextY][nextX]!='2')
                    continue;
                visited[nextY][nextX] = true;
                q.add(new Integer[]{nextX, nextY, count + 1});
            }
        }
        return 0;
    }

    //테두리는 2
    public void drawMap(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                //다른 도형의 안쪽이였으면 그냥 안쪽임 pass
                if(map[j][i]=='1') continue;
                map[j][i] = '1';
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    map[j][i] = '2';
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
