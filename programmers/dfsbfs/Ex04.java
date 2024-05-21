package dfsbfs;

//visited의 유무로 dfs/bfs판단 가능하다 이문제 같은 경우 길찾기와 다르게 한번 쓴 단어가 있다면 visited를 체크
// bfs로 문제를 푸는 경우 다른 곳에서 사용가능한 단어가 체크되어 못 쓰는 경우가 생길 수 있으므로 dfs로 푸는게 맞다
// 요약 뿌리를 내릴때 다른곳의 노드가 다음 뿌리로 다른곳에서 또 사용될 수 있는 경우 dfs사용
public class Ex04 {

    public int answer = 999999;
    public boolean visited [];

    public int solution(String begin, String target, String[] words) {
        //visited가 새로생성되는 경우 visited기준으로 dfs밖에서 for룹 실행
        for (int i = 0; i < words.length; i++) {
            if (myCompare(begin, words[i]) == begin.length() - 1) {
                visited = new boolean[words.length];
                visited[i] = true;
                dfs(words[i], target, words, 1);
            }
        }
        if (answer == 999999) {
            return 0;
        }else {
            return answer;
        }
    }

    //중간에 끝날수 있는 경우 처음에 break컨디션 추가
    public void dfs(String now, String target, String [] words, int count) {
        //break 컨디션 중간에 조건 일치하면 끝내면됨
        if (now.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (myCompare(now, words[i]) == now.length() - 1 && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }

    private static int myCompare(String a, String b) {
        int count = 0;
        //1개빼고 다맞는거
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String a = "hit";
        String b = "cog";
        String [] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Ex04 ex04 = new Ex04();
        int solution = ex04.solution(a, b, words);
        System.out.println(solution);
    }

}
