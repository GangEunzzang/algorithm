class Solution {

    private int max;
    private boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return max;
    }

    private void dfs(int fatigue, int[][] dungeons, int count) {
        max = Math.max(count, max);

        for (int i = 0; i < dungeons.length; i++) {
            int[] dungeon = dungeons[i];
            if (visited[i] || dungeon[0] > fatigue)continue;

            visited[i] = true;
            dfs(fatigue - dungeon[1], dungeons, count + 1);
            visited[i] = false;
        }
    }
}