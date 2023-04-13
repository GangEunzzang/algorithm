import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        Map<String, Integer> mapOfTerms = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();


        for (String term : terms) {
            mapOfTerms.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]) * 28);
        }


        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String yyyyMMdd = privacy.split(" ")[0];
            String termsType = privacy.split(" ")[1];

            if (getValueOfDate(yyyyMMdd) + mapOfTerms.get(termsType) <= getValueOfDate(today)) {
                resultList.add(i + 1);
            }
        }
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getValueOfDate(String yyyyMMdd) {
        int intOfYYYY = Integer.parseInt(yyyyMMdd.substring(2, 4)) * 12 * 28;
        int intOfMM = Integer.parseInt(yyyyMMdd.substring(5, 7)) * 28;
        int intOfDD = Integer.parseInt(yyyyMMdd.substring(8, 10));

        return intOfYYYY + intOfMM + intOfDD;
    }
}