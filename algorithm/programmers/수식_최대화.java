package Algorithm.algorithm.programmers;

import java.util.*;

public class 수식_최대화 {

	ArrayList<Long> list;
	ArrayList<String> calList;
	boolean[] chk;
	String[] grade;
	String[] result;
	long answer;

	public long solution(String expression) {
		answer = 0;
		chk = new boolean[3];
		grade = new String[3];
		grade[0] = "-";
		grade[1] = "+";
		grade[2] = "*";
		result = new String[3];
		list = new ArrayList<>();
		calList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char temp = expression.charAt(i);
			if (temp == '-' || temp == '*' || temp == '+') {
				list.add(Long.parseLong(sb.toString()));
				sb = new StringBuilder();
				sb.append(temp);
				calList.add(sb.toString());
				sb = new StringBuilder();
			} else {
				sb.append(temp);
			}
		}
		list.add(Long.parseLong(sb.toString()));
		per(0);

		return answer;
		
	}

	public void per(int size) {

		if (size == 3) {
			ArrayList<Long> tempList = new ArrayList<>();
			ArrayList<String> tempCalList = new ArrayList<>();
			for (Long temp : list) {
				tempList.add(temp);
			}
			for (String temp : calList) {
				tempCalList.add(temp);
			}
			for (int i = 0; i < 3; i++) {
				int idx = 0;
				while (idx < tempCalList.size()) {
					String cal = tempCalList.get(idx);
					if (cal.equals(result[i])) {
						tempCalList.remove(idx);
						long left = tempList.remove(idx);
						long right = tempList.remove(idx);

						if (cal.equals("+")) {
							tempList.add(idx, left + right);
						} else if (cal.equals("-")) {
							tempList.add(idx, left - right);
						} else {
							tempList.add(idx, left * right);
						}
					} else {
						idx++;
					}
				}
			}
			answer = Math.max(answer, Math.abs(tempList.get(0)));

			return;
		}

		for (int i = 0; i < 3; i++) {
			if (!chk[i]) {
				result[size] = grade[i];
				chk[i] = true;
				per(size + 1);
				chk[i] = false;
			}
		}
	}
}