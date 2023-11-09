class Solution {

    public static void main(String[] args) {
        new Solution().solution(new int[]{0,1,1}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
    }

    private int[] picks;
    private String[] minerals;
    private int maxLen;
    private int minAnswer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        this.picks = picks;
        this.minerals = minerals;
        maxLen = minerals.length;

        dfs(0, 0);
        return minAnswer;
    }

    private void dfs(int idx, int count) {
        if (idx >= maxLen || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
            minAnswer = Math.min(minAnswer, count);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if(picks[i] == 0) continue;

            picks[i]--;

            int maxIdx = Math.min(idx + 5, maxLen);
            int tmpCount = count;

            for (int j = idx; j < maxIdx; j++) {
                // 다이아 곡괭이
                if (i == 0) tmpCount++;

                // 철 곡괭이
                if (i == 1) {
                    if (minerals[j].equals("diamond")) tmpCount += 5;
                    else tmpCount++;
                }

                // 돌 곡괭이
                if (i == 2) {
                    if(minerals[j].equals("diamond")) tmpCount += 25;
                    if(minerals[j].equals("iron")) tmpCount += 5;
                    if(minerals[j].equals("stone")) tmpCount ++;
                }
            }

            dfs(maxIdx, tmpCount);
            picks[i]++;
        }
    }
}