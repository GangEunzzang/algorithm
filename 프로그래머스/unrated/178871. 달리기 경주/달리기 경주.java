import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i+1);
        }

        for (String calling : callings) {
            int callingRank = (rank.get(calling)) -1;
            rank.put(calling, (rank.get(calling)) - 1);
            rank.put(players[callingRank-1], (rank.get(players[callingRank-1])) + 1);

            String temp = players[callingRank];
            players[callingRank] = players[callingRank-1];
            players[callingRank-1] = temp;
        }

        return players;
    }
}



