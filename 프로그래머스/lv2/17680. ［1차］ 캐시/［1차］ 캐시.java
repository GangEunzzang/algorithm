import java.util.*;

class Solution {

    private static final int CACHE_HIT = 1;
    private static final int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {

        Queue<String> queue = new LinkedList();

        int executionTime = 0;

        for (int i = 0; i < cities.length; i++) {

            String city = cities[i].toLowerCase();

            if (queue.contains(city)) {
                executionTime += CACHE_HIT;
                queue.remove(city);
                queue.add(city);
            } else if (!queue.contains(city)) {
                executionTime += CACHE_MISS;
                queue.add(city);
            }

            if (queue.size() > cacheSize) {
                queue.poll();
            }
        }
        return executionTime;
    }
}