import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        Map<Character, Integer> map = new HashMap();

        for (String key : keymap) {

            for (int i = 0; i < key.length(); i++) {

                char charAt = key.charAt(i);
                Integer orDefault = map.getOrDefault(charAt, 9999);

                if (i + 1 < orDefault) {
                    map.put(charAt, i + 1);
                }
            }
        }

        int[] answerArrays = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {

            int count = 0;

            String target = targets[i];

            for (int j = 0; j < target.length(); j++) {

                char charAt = target.charAt(j);

                Integer orDefault = map.getOrDefault(charAt, -1);

                if (orDefault == -1) {
                    count = -1;
                    break;
                }

                count += orDefault;
            }

            answerArrays[i] = count;

        }
        return answerArrays;
    }
}