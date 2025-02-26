package bjSimulation;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

class Position {
    int x;
    int y;
    int dist;
    Position(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class No16236Gold3 {

    public static int mySize = 2;
    public static int time = 0;
    public static int[][] map;

    static int N;
    static int remain = 2;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    public static Position now;
    public static boolean[][] visited;

    public static int bfs() {
        PriorityQueue<Position> q = new PriorityQueue<>(
                new Comparator<Position>(){
                    @Override
                    public int compare(Position o1, Position o2) {
                        if (o1.dist == o2.dist && o1.y == o2.y) {
                            return o1.x - o2.x;
                        } else if (o1.dist == o2.dist) {
                            return o1.y - o2.y;
                        } else {
                            return o1.dist - o2.dist;
                        }
                    }
                }
        );

        q.add(now);
        visited[now.y][now.x] = true;
        while (!q.isEmpty()) {
            Position c = q.poll();
            
            //끝내는 조건
            if(map[c.y][c.x] != 0 && map[c.y][c.x] < mySize){
                map[c.y][c.x] = 0;
                now.x = c.x;
                now.y = c.y;
                return c.dist;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = c.x + dx[i];
                int nextY = c.y + dy[i];
                if(nextY < 0 || nextX <0 || nextY >= N || nextX >= N) continue;
                if(map[nextY][nextX] != 0 && map[nextY][nextX] > mySize) continue;
                if(visited[nextY][nextX]) continue;
                q.add(new Position(nextX, nextY, c.dist+1));
                
                //bfs 넣자마자 true로바꾸기
                visited[nextY][nextX] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        map = new int[n][n];
        N = n;
        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            String[] s = line.split(" ");
            for (int j = 0; j < s.length; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (Integer.parseInt(s[j]) == 9) {
                    now = new Position(j, i,0);
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            visited = new boolean[n][n];
            int cnt = bfs();
            if (cnt == -1) {
                break;
            }
            time += cnt;
            remain--;
            if (remain < 1) {
                mySize++;
                remain = mySize;
            }
        }
        System.out.println(time);
    }
}
