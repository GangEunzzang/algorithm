import java.util.Arrays;

class Solution {

    private int castTime;
    private int healOfSeconds;
    private int additionalHeal;
    private int nowHealth;
    private int maxHealth;
    private int continueSuccess;
    private int[] attackArr;

    public int solution(int[] bandage, int health, int[][] attacks) {

        castTime = bandage[0];
        healOfSeconds = bandage[1];
        additionalHeal = bandage[2];
        nowHealth = health;
        maxHealth = health;
        attackArr = new int[attacks[attacks.length-1][0] + 1];

        for (int[] attack : attacks) {
            attackArr[attack[0]] = attack[1];
        }

        for (int i = 0; i < attackArr.length; i++) {
            if (attackArr[i] == 0) {
                if (++continueSuccess >= castTime) {
                    continueSuccess = 0;
                    changeHealth(additionalHeal);
                }
                changeHealth(healOfSeconds);
                continue;
            }

            // 해당 시간에 공격이 있을 경우
            continueSuccess = 0;
            changeHealth(-attackArr[i]);

            if (nowHealth <= 0) {
                return -1;
            }
        }

        return nowHealth;
    }


    private void changeHealth(int heal) {
        nowHealth = nowHealth + heal > maxHealth ? maxHealth : nowHealth + heal;
    }
}