package Algorithm.algorithm.programmers.in_2024;

public class P_240425_피보나치수 {
  public int solution(int n) {
    int[] arr = new int[n + 1];
    final int MOD = 1234567;
    arr[1] = 1;
    for (int i = 2; i <= n; i++) {
      arr[i] = arr[i - 1] % MOD + arr[i - 2] % MOD;
    }
    return arr[n] % MOD;
  }

}
