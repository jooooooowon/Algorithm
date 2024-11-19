package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_241119_PCCP_동영상재생기 {
  public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

    String[] videoLenArr = video_len.split(":");
    int videoLen = Integer.parseInt(videoLenArr[0]) * 60 + Integer.parseInt(videoLenArr[1]);
    String[] posArr = pos.split(":");
    int position = Integer.parseInt(posArr[0]) * 60 + Integer.parseInt(posArr[1]);
    String[] opStartArr = op_start.split(":");
    int opStart = Integer.parseInt(opStartArr[0]) * 60 + Integer.parseInt(opStartArr[1]);
    String[] opEndArr = op_end.split(":");
    int opEnd = Integer.parseInt(opEndArr[0]) * 60 + Integer.parseInt(opEndArr[1]);
    for(int i = 0 ; i < commands.length; i++){
      if(position >= opStart && position <= opEnd){
        position = opEnd;
      }
      if(commands[i].equals("next")){
        position += 10;
      }
      if(commands[i].equals("prev")){
        position -= 10;
      }
      if(position >= videoLen){
        position = videoLen;
      }else if(position <= 0){
        position = 0;
      }
    }

    if(position >= opStart && position <= opEnd){
      position = opEnd;
    }
    StringBuilder sb = new StringBuilder();
    sb.append((position / 60) < 10 ? "0" + position / 60 : position / 60);
    sb.append(":");
    sb.append((position % 60) < 10 ? "0" + position % 60 : position % 60);

    return sb.toString();
  }
}
