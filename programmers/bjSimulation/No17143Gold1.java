package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No17143Gold1 {




    public static ArrayList<Shark> [][] map;
    public static int ans;
    public static int myRow = 0;
    public static int myCol = 0;
    public static int [] mRow = {1,-1,0,0};
    public static int [] mCol= {0,0,1,-1};


    public static class Shark{
        int row;
        int col;
        int speed;
        int direction;
        int size;

        public Shark(int row, int col, int speed, int direction, int size) {
            this.row = row;
            this.col = col;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }

    //3 상어 움직이기 (벽 부딫히면 방향 바꾸기)
    public static void moveShark() {
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                ArrayList<Shark> sharkList = map[i][j];
                if (sharkList.size() == 0) {
                    continue;
                }
                Shark shark = sharkList.get(0);
                //위 아래 왼 오
                if(shark.direction == 1 || shark.direction == 2){
                    int nexRow = shark.speed % ((map.length-1) * 2);
                    map[nexRow][j].add(shark);
                    if((shark.speed / map.length) % 2 != 0){
                        if (shark.direction == 1) {
                            shark.direction = 2;
                        } else {
                            shark.direction = 1;
                        }
                    }
                }
                if (shark.direction == 3 || shark.direction == 4) {
                    int nextCol = shark.speed % ((map[0].length-1) * 2);
                    map[i][nextCol].add(shark);
                    if((shark.speed / map[0].length) % 2 != 0){
                        if (shark.direction == 3) {
                            shark.direction = 4;
                        } else {
                            shark.direction = 3;
                        }
                    }
                }
                map[i][j].remove(shark);
            }
        }
    }

    //1 사람 오른쪽 이동
    //2 상어 잡기
    //3 상어 움직이기 (벽 부딫히면 방향 바꾸기)
    //4 상어 끼리 먹기
    //상어 - 크기, 속도, 방향
    //ans = 상어 크기


    public static void eatShark() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                ArrayList<Shark> sharkList = map[i][j];
                if (sharkList.size() == 2) {
                    Shark shark1 = sharkList.get(0);
                    Shark shark2 = sharkList.get(1);
                    if (shark1.size > shark2.size) {
                        sharkList.remove(shark2);
                    } else {
                        sharkList.remove(shark1);
                    }
                }
            }
        }
    }


    public static void go() {
        //1
        myCol += 1;
        //2 상어 잡기
        for (int i = 1; i < map.length; i++) {
            ArrayList<Shark> sharkList = map[i][myCol];
            if (sharkList.size() >=1) {
                ans += sharkList.get(0).size;
                sharkList.remove(0);
                break;
            }
        }
        //3 상어 움직이기
        moveShark();
        //4 상어 끼리 잡아먹기
        eatShark();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        int r = Integer.parseInt(f[0]);
        int c = Integer.parseInt(f[1]);
        int m = Integer.parseInt(f[2]);
        map = new ArrayList[r + 1][c + 1];
        for(int i = 0; i <= r; i++) {
            for(int j = 0; j <= c; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            String[] sh = br.readLine().split(" ");
            int row = Integer.parseInt(sh[0]);
            int col = Integer.parseInt(sh[1]);
            map[row][col].add(new Shark(Integer.parseInt(sh[0]), Integer.parseInt(sh[1]), Integer.parseInt(sh[2]), Integer.parseInt(sh[3]), Integer.parseInt(sh[4])));
        };
        while (myCol < c) {
            go();
        }
        System.out.println(ans);
    }
}
