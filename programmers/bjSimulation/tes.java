package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class tes {
    public static Gear[] gearSets;

    public static class Gear {
        public int[] status;
        public int gearNum;

        public Gear(int[] initStatus, int gearNum) {
            status = initStatus;
            this.gearNum = gearNum;
        }

        public void rotateMe(int lastDirection) {
            // 시계로 돌리기
            int myDirection = 0;
            if (lastDirection == -1) {
                myDirection = 1;
                for (int i = 0; i < status.length; i++) {
                    if (i == 0) {
                        status[i] = status[status.length - 1];
                    } else {
                        status[i] = status[i - 1];
                    }
                }
                //반 시계로 돌리기
            } else if (lastDirection == 1) {
                myDirection = -1;
                for (int i = 0; i < status.length; i++) {
                    if (i == status.length-1) {
                        status[i] = status[0];
                    } else {
                        status[i] = status[i + 1];
                    }
                }
            }
            rotateBeside(myDirection);
        }

        public void rotateBeside(int direction) {
            int left = gearNum - 1;
            int right = gearNum + 1;

            if (left >= 0) {
                Gear leftGear = gearSets[left];
                //다르면 반대 방향 회전
                if (this.status[6] != leftGear.status[2]) {
                    leftGear.rotateMe(direction);
                }
            }
            if (right < gearSets.length) {
                Gear rightGear = gearSets[right];
                //다르면 반대 방향 회전
                if (this.status[2] != rightGear.status[6]) {
                    rightGear.rotateMe(direction);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gearSets = new Gear[4];

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            String[] split = line.split("");
            int[] array = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            gearSets[i] = new Gear(array, i);
        }

        int rotateNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < rotateNum; i++) {
            int[] status = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int gearNum = status[0] - 1;
            int direction = status[1];
            if (direction == 1) {
                direction = -1;
            } else if (direction == -1) {
                direction = 1;
            }
            gearSets[gearNum].rotateMe(direction);
        }

        int point = 0;
        if (gearSets[0].status[0] == 1) point += 1;
        if (gearSets[1].status[0] == 1) point += 2;
        if (gearSets[2].status[0] == 1) point += 4;
        if (gearSets[3].status[0] == 1) point += 8;

        System.out.println(point);
    }
}