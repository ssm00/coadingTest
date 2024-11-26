package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2578Silver {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int bingoNum = 0;

    public static int solution(int[][] matrix, int[][] mc) {
        //1 mc 순서 대로 matrix 지우기
        //2 빙고 확인하기
        //다시 1
        for (int i = 0; i < mc.length; i++) {
            for (int j = 0; j < mc[0].length; j++) {
                int deleteThis = mc[i][j];
                del(matrix, deleteThis);
                boolean isBingo = checkBingo(matrix);
                if (isBingo) {
                    return (i * 5) + j+1;
                }
            }
        }
        return -1;
    }

    public static boolean checkBingo(int [][] matrix) {
        //가로
        for (int i = 0; i < 5; i++) {
            int eachCount = 0;
            if (matrix[i][0] == -1) {
                for (int j = 0; j < 5; j++) {
                    if (matrix[i][j] != -1) {
                        eachCount = 0;
                        break;
                    } else {
                        eachCount++;
                    }
                }
                if (eachCount == 5) {
                    bingoNum++;
                }
            }
        }

        //세로
        for (int i = 0; i < 5; i++) {
            int eachCount = 0;
            if (matrix[0][i] == -1) {
                for (int j = 0; j < 5; j++) {
                    if (matrix[j][i] != -1) {
                        eachCount = 0;
                        break;
                    } else {
                        eachCount++;
                    }
                }
                if (eachCount == 5) {
                    bingoNum++;
                }
            }
        }

        //대각선
        if (matrix[0][0] == -1) {
            int eachNum = 0;
            for (int i = 0; i < 5; i++) {
                if (matrix[i][i] != -1) {
                    eachNum = 0;
                    break;
                } else {
                    eachNum++;
                }
            }
            if (eachNum == 5) {
                bingoNum++;
            }
        }
        if (matrix[0][4] == -1) {
            int eachNum = 0;
            for (int i = 0; i < 5; i++) {
                if (matrix[i][4-i] != -1) {
                    eachNum = 0;
                    break;
                } else {
                    eachNum++;
                }
            }
            if (eachNum == 5) {
                bingoNum++;
            }
        }
        if (bingoNum >= 3) {
            bingoNum = 0;
            return true;
        } else {
            bingoNum = 0;
            return false;
        }
    }

    public static void del(int[][] matrix, int num) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == num) {
                    matrix[i][j] = -1;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[5][5];
        int[][] mc = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            String[] token = line.split(" ");
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = Integer.parseInt(token[j]);
            }
        }
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            String[] token = line.split(" ");
            for (int j = 0; j < 5; j++) {
                mc[i][j] = Integer.parseInt(token[j]);
            }
        }
        int solution = solution(matrix, mc);
        System.out.println(solution);
    }


}
