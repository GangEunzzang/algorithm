import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> userReportsMap = new HashMap<>();  // 유저가 신고 한 사람 list
        Map<String, Integer> userIdToMailCountMap = new HashMap<>(); // 받을 메일 수 count
        Set<String> distinctReport = new HashSet<>(List.of(report));
        int[] answer = new int[id_list.length];

        for (String s : distinctReport) {
            String[] splitOfS = s.split(" ");
            String userId = splitOfS[0]; // 신고한 유저
            String reportedUserId = splitOfS[1]; // 신고당한 유저

            userReportsMap.putIfAbsent(userId,new HashSet<String>(){{add(reportedUserId);}});
            userReportsMap.get(userId).add(reportedUserId);
            userIdToMailCountMap.put(reportedUserId, userIdToMailCountMap.getOrDefault(reportedUserId, 0) +1);
        }

        for (String reportedUserId : userIdToMailCountMap.keySet()) {
            Integer count = userIdToMailCountMap.get(reportedUserId);

            if (count >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (userReportsMap.containsKey(id_list[i]) && userReportsMap.get(id_list[i]).contains(reportedUserId)) {
                        answer[i]++;
                    }
                }
            }
        }
        
        return answer;
    }
}