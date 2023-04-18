import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(String word) {

        List<String> list = new ArrayList<>();
        String[] alphabet = new String[5];
        alphabet[0] = "A";
        alphabet[1] = "E";
        alphabet[2] = "I";
        alphabet[3] = "O";
        alphabet[4] = "U";

        int count = 0;

        for (int i = 0; i < 5; i++) {

            list.add(alphabet[i]);

            for (int j = 0; j < 5; j++) {

                list.add(alphabet[i] + alphabet[j]);

                for (int k = 0; k < 5; k++) {

                    list.add(alphabet[i] + alphabet[j] + alphabet[k]);

                    for (int l = 0; l < 5; l++) {

                        list.add(alphabet[i] + alphabet[j] + alphabet[k] + alphabet[l]);

                        for (int m = 0; m < 5; m++) {
                            list.add(alphabet[i] + alphabet[j] + alphabet[k] + alphabet[l] + alphabet[m]);
                        }
                    }
                }
            }
        }

        List<String> collect = list.stream().distinct().sorted().collect(Collectors.toList());

        return collect.indexOf(word) + 1;
    }
}