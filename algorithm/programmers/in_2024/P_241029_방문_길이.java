package Algorithm.algorithm.programmers.in_2024;

import java.util.*;
public class P_241029_방문_길이 {
  public int solution(String dirs) {
    int answer = 0;
    int[][] arr = new int[11][11];
    Map<Character,Integer> map =
    Map.of('U',0,
    'D',1,
    'R',2,
    'L',3);

    // x,y -> x,y
    boolean[][][][] visited = new boolean[11][11][11][11];
    int[] dirY = {1,-1,0,0};
    int[] dirX = {0,0,1,-1};
    int x = 5;
    int y = 5;

    for(int i = 0 ; i < dirs.length(); i++){
      // System.out.println("y : " + y + ", x : " + x);
      int tempIdx = map.get(dirs.charAt(i));
      // System.out.println(tempIdx);
      int nextY = y + dirY[tempIdx];
      int nextX = x + dirX[tempIdx];
      if(nextY < 11 && nextY >= 0 && nextX < 11 && nextX >= 0){
        // System.out.println("i : " + i + ", dirs : " + dirs.charAt(i));
        // System.out.println("x : " + x + ", y : " + y);
        // System.out.println("nextX : " + nextX + ", nextY : " + nextY);
        if(!visited[y][x][nextY][nextX]){
          answer++;
        }
        visited[y][x][nextY][nextX] = true;
        visited[nextY][nextX][y][x] = true;
        y = nextY;
        x = nextX;
      }
    }
    return answer;
  }
}
