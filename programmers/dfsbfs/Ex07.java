package dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Ex07 {

    public static int[] addX = {1,0,-1,0};
    public static int[] addY = {0,-1,0,1};


    public int solution(int[][] gamedBoard, int[][] table) {
        int ans = 0;

        int len = gamedBoard.length;

        //빈칸 구하기 위해서 1으로 바꾸기
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (gamedBoard[i][j] == 1) {
                    gamedBoard[i][j] = 0;
                } else {
                    gamedBoard[i][j] = 1;
                }
            }
        }
        boolean[][] visitedTable = new boolean[len][len];
        boolean[][] visitedBoard = new boolean[len][len];

        ArrayList<ArrayList<Point>> tableList = new ArrayList<>();
        ArrayList<ArrayList<Point>> boardList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (!visitedTable[i][j] && table[i][j] == 1) {
                    bfs(new Point(i, j), visitedTable, table, tableList);
                }
                if (!visitedBoard[i][j] && gamedBoard[i][j] == 1) {
                    bfs(new Point(i, j), visitedBoard, gamedBoard, boardList);
                }
            }
        }
        ans = compareBlock(tableList, boardList, ans);

        return ans;
    }


    public int compareBlock(ArrayList<ArrayList<Point>> tableBlocks, ArrayList<ArrayList<Point>> boardBlocks, int answer) {
        Boolean[] visited = new Boolean[tableBlocks.size()];
        for (int i = 0; i < tableBlocks.size(); i++) {
            for (int j = 0; j < boardBlocks.size(); j++) {
                if (tableBlocks.get(i).size() != boardBlocks.get(j).size() || visited[j]) {
                    continue;
                }
                if (isFit(tableBlocks.get(i), boardBlocks.get(j))) {
                    visited[i] = true;
                    answer += boardBlocks.get(j).size();
                    break;
                }
            }
        }
        return answer;
    }

    public boolean isFit(ArrayList<Point> tablePoints, ArrayList<Point> blockPoints) {
        Collections.sort(blockPoints);

        //360도 회전
        for (int i = 0; i < 4; i++) {
            Collections.sort(tablePoints);
            //위치 0,0 으로 보정
            int curX = tablePoints.get(0).x;
            int curY = tablePoints.get(0).y;
            for(int j=0; j<tablePoints.size(); j++){
                tablePoints.get(j).x -= curX;
                tablePoints.get(j).y -= curY;
            }
            int curXb = blockPoints.get(0).x;
            int curYb = blockPoints.get(0).y;
            for (int j = 0; j < blockPoints.size(); j++) {
                blockPoints.get(j).x -= curXb;
                blockPoints.get(j).y -= curYb;
            }
            boolean check = true;
            for(int j=0; j<blockPoints.size(); j++){
                if (blockPoints.get(j).x != tablePoints.get(j).x || blockPoints.get(j).y != tablePoints.get(j).y) {
                    check = false;
                    break;
                }
            }
            if(check){
                return true;
            }
            else{
                //90도 회전시키기. x, y -> y, -x
                for(int j=0; j<tablePoints.size(); j++){
                    int temp = tablePoints.get(j).x;
                    tablePoints.get(j).x = tablePoints.get(j).y;
                    tablePoints.get(j).y = -temp;
                }
            }
        }
        return false;
    }



    public void bfs(Point point,boolean[][] visited, int[][] board, ArrayList<ArrayList<Point>> list) {
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        ArrayList<Point> subList = new ArrayList<>();

        while (!q.isEmpty()) {
            Point poll = q.poll();
            int x = poll.x;
            int y = poll.y;
            for (int i = 0; i < 4; i++) {
                if (x + addX[i] > 0 || y + addY[i] > 0 || x + addX[i] >= board.length || y + addY[i] >= board.length) {
                    continue;
                }
                if (!visited[x + addX[i]][y + addY[i]] && board[x + addX[i]][y + addY[i]] == 1) {
                    visited[x + addX[i]][y + addY[i]] = true;
                    q.add(new Point(x + addX[i], y + addY[i]));
                    subList.add(new Point(x + addX[i], y + addY[i]));
                }
            }
        }
        list.add(subList);
    }

    public static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int t) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point o) {
            int res = Integer.compare(this.x, o.x);
            if(res==0){
                res = Integer.compare(this.y, o.y);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int b[][] = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int t[][] = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};
        Ex07 ex07 = new Ex07();
        int solution = ex07.solution(b, t);
        System.out.println(solution);
    }
}
