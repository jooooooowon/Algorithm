package Algorithm.algorithm.programmers.in_2024;

import java.util.*;
public class P_240719_불량사용자 {
  String[] userIdArr;
  String[] bannedIdArr;
  int bannedLen;
  int userLen;
  boolean[] visited;
  Set<Integer> setIds = new HashSet<>();

  public int solution(String[] user_id, String[] banned_id) {
    this.userIdArr = user_id;
    this.bannedIdArr = banned_id;
    this.userLen = userIdArr.length;
    this.bannedLen = bannedIdArr.length;
    visited = new boolean[bannedLen];

    tracking(0,0);
    // System.out.println(setIds.toString());
    return setIds.size();
  }

  private void tracking(int userIdIdx, int userIdSet){
    // System.out.println("userIdIdx : " + userIdIdx + " , userIdSet : " + userIdSet);
    if(userIdIdx >= userLen) {
      // System.out.println(Arrays.toString(visited));
      // System.out.println(userIdSet);
      if(setIds.contains(userIdSet)){
        return ;
      }
      for(boolean visit : visited){
        if(!visit) return;
      }
      setIds.add(userIdSet);
      return;
    }

    String userId = userIdArr[userIdIdx];
    for(int i = 0 ; i < bannedLen; i++){
      if(visited[i]){
        continue;
      }
      String bannedId =bannedIdArr[i];
      if(userId.length() != bannedId.length()){
        continue;
      }
      boolean tf = true;
      for(int j = 0 ; j < bannedId.length(); j++){
        if(bannedId.charAt(j) != '*' && bannedId.charAt(j) != userId.charAt(j)){
          tf = false;
          break;
        }
      }
      if(tf){
        // System.out.println("test : " + (userIdIdx));
        visited[i] = true;
        tracking(userIdIdx + 1, userIdSet | (1 << userIdIdx));
        visited[i] = false;
      }
    }
    tracking(userIdIdx + 1, userIdSet);

    return ;
  }

}
