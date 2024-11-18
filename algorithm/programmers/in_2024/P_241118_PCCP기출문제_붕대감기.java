package Algorithm.algorithm.programmers.in_2024;

public class P_241118_PCCP기출문제_붕대감기 {
  public int solution(int[] bandage, int health, int[][] attacks) {
    int answer = 0;
    int max = health;
    int successCnt = 0;
    int time = 0;

    for(int i = 0 ; i < attacks.length; i++){
      int plusHeal = attacks[i][0] - time - 1;
      health += plusHeal * bandage[1] + (plusHeal / bandage[0]) * bandage[2];
      health = Math.min(health, max);
      health -= attacks[i][1];

      if(health <= 0){
        return -1;
      }
      time = attacks[i][0];
    }
    return health;
  }
}
