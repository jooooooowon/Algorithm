package Algorithm.algorithm.programmers;

import java.util.HashSet;
import java.util.Set;

public class Jwon_20230906_P_후보키 {
	static int col;
	static int row;
	static boolean[] chk;
	static Set<Integer> candidatekeys = new HashSet<>();
	
	public int solution(String[][] relation) {
		col = relation.length;
		row = relation[0].length;
		for (int i = 1; i <= row; i++) {
			chk = new boolean[row];
			combination(i, 0,relation);
		}
		return candidatekeys.size();
	}

	private static void combination(int num, int count, String[][] relation) {
		if (num == count) {
			int bit = 0;
			for (int i = 0; i < row; i++) {
				if (chk[i]) {
					bit |= 1 << (row - i);
				}
			}
			
			for(int temp : candidatekeys) {
				if((bit & temp) == temp) {
					return ;
				}
			}
			
			HashSet<String> set = new HashSet<>();
			for(int i = 0 ; i < col; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j = 0 ; j < row ; j++) {
					if(chk[j]) {
						sb.append(relation[i][j]);
					}
				}
				set.add(sb.toString());
			}
			if(set.size() != col) {
				return ;
			}
			candidatekeys.add(bit);
		}

		for (int i = 0; i < row; i++) {
			if (!chk[i]) {
				chk[i] = true;
				combination(num, count + 1, relation);
				chk[i] = false;
			}
		}

	}

	public static void main(String[] args) {

	}
}
