class Solution {

    private int N;
    private int[] apeachTarget;
    private int[] lionTarget;
    private int max = 0;
    private int[] answer;
    public int[] solution(int n, int[] info) {
        N = n;
        apeachTarget = info;
        lionTarget = new int[11];

        dfs(0, lionTarget);
        System.out.println(max);

        return max == 0 ? new int[]{-1} : answer;

    }

    private void dfs(int depth, int[] lionTarget) {

        if (depth == N) {
            int score = getDiffScore(lionTarget);
            if (score >= max) {
                max = score;
                answer = lionTarget.clone();
            }
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (apeachTarget[i] < lionTarget[i]) break;

            lionTarget[i]++;
            dfs(depth + 1, lionTarget);
            lionTarget[i]--;
        }

    }

    private int getDiffScore(int[] lionTarget) {

        int apeachScore = 0;
        int lionScore = 0;

        for (int i = 0; i < 10; i++) {
            if (lionTarget[i] > apeachTarget[i]) lionScore += (10 - i);
            else {
                if(apeachTarget[i] != 0) apeachScore += (10 - i);
            }
        }

        return apeachScore > lionScore ? 0 : lionScore - apeachScore;

    }


}