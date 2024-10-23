package Algorithm.algorithm.programmers.in_2024;

public class P_241021_혼자서_하는_틱택토 {
  public int solution(String[] board) {
    int answer = -1;
    int[][] arr = new int[3][3];
    int oCount = 0;
    int xCount = 0;
    for(int i = 0 ; i < 3 ; i++){
      String str = board[i];
      for(int j = 0 ; j < 3 ; j++){
        if(str.charAt(j) == 'O'){
          arr[i][j] = 1;
          oCount++;
        }else if(str.charAt(j) == 'X'){
          arr[i][j] = -1;
          xCount++;
        }
      }
    }
    if(!(oCount - xCount == 0 || oCount - xCount == 1)) return 0;

    int[][] tempArr = new int[3][3];

    int lineO = 0;
    int lineX = 0;
    for(int i = 0 ; i < 3 ; i++){
      int temp = 0;
      temp += arr[i][0];
      temp += arr[i][1];
      temp += arr[i][2];
      if(temp == 3){
        tempArr[i][0] = 1;
        tempArr[i][1] = 1;
        tempArr[i][2] = 1;
      }else if(temp == -3){
        tempArr[i][0] = -1;
        tempArr[i][1] = -1;
        tempArr[i][2] = -1;
      }
      temp = 0;
      temp += arr[0][i];
      temp += arr[1][i];
      temp += arr[2][i];
      if(temp == 3){
        tempArr[0][i] = 1;
        tempArr[1][i] = 1;
        tempArr[2][i] = 1;
      }else if(temp == -3){
        tempArr[i][0] = -1;
        tempArr[i][1] = -1;
        tempArr[i][2] = -1;
      }
    }
    if(arr[0][0] + arr[1][1] + arr[2][2] == 3){
      tempArr[0][0] = 1;
      tempArr[1][1] = 1;
      tempArr[2][2] = 1;
    }
    if(arr[0][2] + arr[1][1] + arr[2][0] == 3){
      tempArr[0][2] = 1;
      tempArr[1][1] = 1;
      tempArr[2][0] = 1;
    }
    if(arr[0][0] + arr[1][1] + arr[2][2] == -3){
      tempArr[0][0] = -1;
      tempArr[1][1] = -1;
      tempArr[2][2] = -1;
    }
    if(arr[0][2] + arr[1][1] + arr[2][0] == -3){
      tempArr[0][2] = -1;
      tempArr[1][1] = -1;
      tempArr[2][0] = -1;
    }
    for(int i = 0 ; i < 3 ; i++){
      for(int j = 0; j < 3; j++){
        if(tempArr[i][j] == 1){
          lineO++;
        }else if(tempArr[i][j] == -1){
          lineX++;
        }
      }
    }
    // for(int[] temp : tempArr){
    //     System.out.println(Arrays.toString(temp));
    // }
    // System.out.println("lineO : " + lineO);
    // System.out.println("lineX : " + lineX);
    if((lineO >= 3 && lineX >= 3) || (lineO >= 3 && oCount - xCount != 1) || (lineX >= 3 && oCount != xCount)){
      return 0;
    }
    return 1;
  }
}
