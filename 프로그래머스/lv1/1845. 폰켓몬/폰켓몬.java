import java.util.*;

class Solution {
    public int solution(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        long count = list.stream().distinct().count();

        return nums.length / 2 >= count ? (int) count :  nums.length/2;
    }
}