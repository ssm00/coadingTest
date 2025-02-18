package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No3190Gold4 {

    public static int map [][];
    public static int time = 0;
    public static int nowD = 0;
    
    // 오, 아래, 왼쪽, 위
    public static int[] mRow = {0,1,0,-1};
    public static int[] mCol = {1,0,-1,0};
    public static boolean flag = false;

    //시계방향으로
    public static ArrayList<int []> bug = new ArrayList<>();

    public static void changeHead (String d){
        //오른쪽
        if (d.equals("D") ) {
            nowD = (nowD+1)%4;
        } else if (d.equals("L")) {
            //왼쪽
            nowD = (nowD+3)%4;
        }
    }

    public static boolean collisionBody(int nextRow, int nextCol) {
        for (int[] body : bug) {
            int bodyRow = body[0];
            int bodyCol = body[1];
            if (bodyRow == nextRow && bodyCol == nextCol) {
                return true;
            }
        }
        return false;
    }

    public static void go() {
        //0 머리꺽기
        //1 머리 다음칸
        //2 벽 부딫히면 끝, 몸과 부딫히면 끝
        //3 사과 있으면 사과 먹기, 꼬리 그대로
        //3 사과 없으면 꼬리 움직이기
        //머리 꺽기
        time++;

        //머리 다음칸
        int nextRow = bug.get(0)[0] + mRow[nowD];
        int nextCol = bug.get(0)[1] + mCol[nowD];
        //2
        if(nextRow >= map.length || nextRow <= 0 || nextCol >= map.length || nextCol <=0 || collisionBody(nextRow, nextCol)){
            flag = true;
            return;
        }
        //3 사과있으면
        if (map[nextRow][nextCol] == 2) {
            map[nextRow][nextCol] = 0;
            bug.add(0, new int[]{nextRow, nextCol});
        }else{
            bug.add(0, new int[]{nextRow, nextCol});
            bug.remove(bug.size() - 1);
        }

    }

    public static class Command{
        int time;
        String d;

        public Command(int time, String d) {
            this.time = time;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        int n =Integer.parseInt(line);
        String line2 = bufferedReader.readLine();
        int k =Integer.parseInt(line2);
        map = new int[n+1][n+1];
        for (int i = 0; i < k; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            map[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 2;
        }
        String line3 = bufferedReader.readLine();
        int l = Integer.parseInt(line3);
        Queue<Command> c = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            int time = Integer.parseInt(s[0]);
            String d = s[1];
            c.add(new Command(time, d));
        }
        bug.add(new int[] {1,1});
        while (!flag) {
            Command peek = c.peek();
            if (peek != null && peek.time == time) {
                changeHead(peek.d);
                go();
                c.poll();
            } else {
                go();
            }
        }
        System.out.println(time);
    }

}
