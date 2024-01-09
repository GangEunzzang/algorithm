import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * 두 사람이 선물을 주고 받았으면 이번달까지 선물을 더 많이 준 사람이 다음달에 선물을 하나 받는다
     * 기록이 없거나, 같다면 선물지수가 큰  사람이 선물을 받음
     * 선물 지수 = 이번달까지 자신이 친구들에게 준 선물 수 - 받은 수
     * 선물지수까지 일치하면 선물 x
     * <p>
     * 선물을 가장 많이 받을 친구 선물의 수
     * <p>
     * gifts[0] = 선물 준 친구
     * gifts[1] = 선물 받은 친구
     * <p>
     * friends <= 50 친구들 이름
     */
    public int solution(String[] friends, String[] gifts) {

        Map<String, Integer> giverGiftCount = new HashMap<>(); // 선물 준 개수
        Map<String, Integer> receiverGiftCount = new HashMap<>(); // 선물 받은 개수
        Map<String, Integer> friendsGiftCounts = new HashMap<>(); // 친구 > 친구 선물 준 개수

        for (String gift : gifts) {
            String from = gift.split(" ")[0];
            String to = gift.split(" ")[1];

            giverGiftCount.put(from, giverGiftCount.getOrDefault(from, 0) + 1);
            receiverGiftCount.put(to, receiverGiftCount.getOrDefault(to, 0) + 1);
            friendsGiftCounts.put(gift, friendsGiftCounts.getOrDefault(gift, 0) + 1);
        }


        int max = 0;

        for (int i = 0; i < friends.length; i++) {
            int tmp = 0;
            String friendI = friends[i];

            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                String friendJ = friends[j];

                Integer iToj = friendsGiftCounts.getOrDefault(friendI + " " + friendJ, 0);
                Integer jToi = friendsGiftCounts.getOrDefault(friendJ + " " + friendI, 0);

                if (iToj > jToi) tmp++;
                if (iToj != jToi) continue;
                
                Integer iGiftCount = giverGiftCount.getOrDefault(friendI, 0) - receiverGiftCount.getOrDefault(friendI, 0);
                Integer jGiftCount = giverGiftCount.getOrDefault(friendJ, 0) - receiverGiftCount.getOrDefault(friendJ, 0);
                if (iGiftCount > jGiftCount) tmp++;

            }


            max = Math.max(tmp, max);

        }

        return max;
    }
}