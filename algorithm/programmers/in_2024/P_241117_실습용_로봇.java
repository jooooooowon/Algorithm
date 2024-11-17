package Algorithm.algorithm.programmers.in_2024;

public class P_241117_실습용_로봇 {
  public int[] solution(String command) {
    int[] answer = new int[2];
    int y = 0;
    int x = 0;
    int dir = 0;
    int[] dirY = {1,0,-1,0};
    int[] dirX = {0,1,0,-1};

    for(int i = 0 ; i < command.length(); i++){
      char ch = command.charAt(i);
      if(ch == 'R'){
        dir = (dir + 1) % 4;
      }else if(ch == 'L'){
        dir = (dir - 1 + 4) % 4;
      }

      if(ch == 'G'){
        y = y + dirY[dir];
        x = x + dirX[dir];
      }else if(ch == 'B'){
        y = y + dirY[(dir + 2) % 4];
        x = x + dirX[(dir + 2) % 4];
      }
    }
    answer[0] = x;
    answer[1] = y;
    return answer;
  }
}
