import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        List<String> playerList = new ArrayList<>();
        Map<String, Integer> ranking = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            String curPlayer = players[i];
            playerList.add(curPlayer);
            ranking.put(curPlayer, i);
        }

        for (String winPlayer : callings) {
            int curRank = ranking.get(winPlayer);
            String losePlayer = playerList.get(curRank-1);

            ranking.put(winPlayer, curRank-1);
            ranking.put(losePlayer, ranking.get(losePlayer)+1);

            swap(playerList, curRank-1, curRank);
        }

        return playerList.toArray(String[]::new);
    }

    private void swap(List<String> list, int swap1, int swap2) {
        String temp = list.get(swap1);
        list.set(swap1, list.get(swap2));
        list.set(swap2, temp);
    }
}