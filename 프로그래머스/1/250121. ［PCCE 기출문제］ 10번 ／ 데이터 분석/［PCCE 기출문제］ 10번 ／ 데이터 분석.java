import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIndex = getIndex(ext);
        int sortIndex = getIndex(sort_by);

        return Arrays.stream(data)
                .filter(arr -> arr[extIndex] < val_ext)
                .sorted(Comparator.comparingInt(o -> o[sortIndex]))
                .toArray(int[][]::new);
    }

    private int getIndex(String key) {
        return switch (key) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> throw new IllegalArgumentException("Invalid key: " + key);
        };
    }
}
