package dfsbfs;

import java.io.IOException;
import java.util.ArrayList;

public class No14502Gold4 {

    public static ArrayList<int []> combiList = new ArrayList<>();
    public static int[] tempCombi;

    public static void combi(int start, int depth, int n, int r) {
        if(depth == r){
            combiList.add(tempCombi.clone());
            return;
        }else {
            for (int i = start; i <= n; i++) {
                tempCombi[depth] = i;
                combi(i+1, depth+1,n ,r);
            }
        }
    }

    public static void main(String[] args) throws IOException {



        tempCombi = new int[c];
    }
}
