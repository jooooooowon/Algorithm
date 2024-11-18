package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_241118_석유시추 {
  int[][] landSeqArr;
  int[][] land;
  int n;
  int m;
  Map<Integer, Integer> map = new HashMap<>();
  public int solution(int[][] land) {
    int answer = 0;
    n = land.length;
    m = land[0].length;
    this.land = land;
    landSeqArr = new int[n][m];
    int seq = 1;
    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < m ; j++){
        if(land[i][j] == 1 && landSeqArr[i][j] == 0){
          Queue<Node> queue = new LinkedList<>();
          queue.offer(new Node(i,j));
          int temp = 1;
          landSeqArr[i][j] = seq;
          while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int k = 0 ; k < 4; k++){
              int nextY = node.y + dirY[k];
              int nextX = node.x + dirX[k];
              if(nextY < n && nextY >= 0 && nextX < m && nextX >= 0
                      && land[nextY][nextX] == 1 && landSeqArr[nextY][nextX] == 0){
                queue.offer(new Node(nextY,nextX));
                landSeqArr[nextY][nextX] = seq;
                temp++;
              }
            }
          }
          map.put(seq,temp);
          seq++;
          // dfs(i,j,seq++);
        }
      }
    }
//         for(int[] temp : landSeqArr){
//             System.out.println(Arrays.toString(temp));
//         }
//         System.out.println(map.toString());

    for(int i = 0 ; i < m ; i++){
      Set<Integer> set = new HashSet<>();
      for(int j = 0 ; j < n ; j++){
        if(landSeqArr[j][i] != 0){
          set.add(landSeqArr[j][i]);
        }
      }
      int temp = 0;
      if(!set.isEmpty()){
        for(int key : set){
          temp += map.get(key);
        }
      }
      answer = Math.max(answer, temp);
    }

    return answer;
  }
  class Node{
    int y;
    int x;
    Node(int y, int x){
      this.y = y;
      this.x = x;
    }
  }
  int[] dirY = {1,-1,0,0};
  int[] dirX = {0,0,1,-1};
  void dfs(int y, int x, int seq){
    map.put(seq, map.getOrDefault(seq,0) + 1);
    landSeqArr[y][x] = seq;
    for(int i = 0 ; i < 4 ; i++){
      int nextY = y + dirY[i];
      int nextX = x + dirX[i];
      if(nextY < n && nextY >= 0 && nextX < m && nextX >= 0
              && land[nextY][nextX] == 1 && landSeqArr[nextY][nextX] == 0){
        dfs(nextY, nextX, seq);
      }
    }
  }
}
