import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {

        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        if (notDivisible(arrayB, gcdA) && answer < gcdA) answer = gcdA;
        if (notDivisible(arrayA, gcdB) && answer < gcdB) answer = gcdB;

        return answer;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    public boolean notDivisible(int[] arr, int num){
        return Arrays.stream(arr).noneMatch(n -> n % num == 0);
    }
}