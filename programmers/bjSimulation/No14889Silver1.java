package bjSimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No14889Silver1 {

    public static int[][] map;
    public static ArrayList<int []> combiList = new ArrayList<>();
    public static int n;
    public static int r;
    public static int[] tempCombi;
    public static void combi(int start, int depth) {
        if(depth == r){
            combiList.add(tempCombi.clone());
            return;
        }else {
            for (int i = start; i <= n; i++) {
                tempCombi[depth] = i;
                combi(i+1, depth+1);
            }
        }
    }

    public static int ansValue = Integer.MAX_VALUE;
    public static void calculate(){
        for (int[] possibleTeamMember : combiList) {
            int [] oppositeTeamMember = new int[possibleTeamMember.length];
            int index = 0;
            for (int i = 1; i <=n; i++) {
                boolean isPossible = false;
                for(int member :possibleTeamMember){
                    if(member == i) {
                        isPossible = true;
                        break;
                    }
                }
                if(!isPossible){
                    oppositeTeamMember[index++] = i;
                }
            }
            int myTeamScore = 0;
            for (int member : possibleTeamMember) {
                for(int otherMemeber : possibleTeamMember){
                    if(otherMemeber == member) continue;
                    myTeamScore += map[member][otherMemeber];
                }
            }
            int otherTeamScore = 0;
            for (int member : oppositeTeamMember) {
                for(int otherMemeber : oppositeTeamMember){
                    if(otherMemeber == member) continue;
                    otherTeamScore += map[member][otherMemeber];
                }
            }
            ansValue = Math.min(ansValue, Math.abs(myTeamScore - otherTeamScore));
        }
    }


    public static void main(String[] args) throws IOException {
        //조합을 구해 10명이면 2개의 팀으로 나눠 8명 8c4를 해 1,2,3,4 조합 리스트를 만들어
        //그다음에 그 팀과 그팀의 오포사이트팀 점수를 구해 그리고 차를 구한다음에 min에 저장해놔
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        r = n/2;
        tempCombi = new int[n/2];
        map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(line[j-1]);
            }
        }
        combi(1,0);
        calculate();
        System.out.println(ansValue);

    }
}
