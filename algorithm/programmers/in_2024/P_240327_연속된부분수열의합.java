package Algorithm.algorithm.programmers.in_2024;

public class P_240327_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        int start = 0;
        int end = 0;
        int add = sequence[0];
        while (start <= end) {
            if (add < k) {
                if (end + 1 < sequence.length) {
                    add += sequence[++end];
                } else {
                    break;
                }
            } else if (add == k) {
                if (end - start < answer[1] - answer[0]) {
                    answer[1] = end;
                    answer[0] = start;
                }
                if (end + 1 < sequence.length) {
                    add += sequence[++end];
                }else{
                    break;
                }
            }else{
                add -= sequence[start++];
            }
        }
        return answer;
    }
}
