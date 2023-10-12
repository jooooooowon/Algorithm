package Algorithm.algorithm.programmers;

public class 모음사전 {
	static String[] wordArr = { "A", "E", "I", "O", "U" };
	static int count;
	public static int solution(String word) {
		int answer = 0;
		count = 0;
		answer = dfs(new StringBuilder(), word);
		return answer;
	}

	private static int dfs(StringBuilder sb, String word) {
		if (sb.toString().equals(word)) {
			System.out.println(sb.toString());
			return count;
		}
		count++;
		if (sb.length() == 5) {
			return 0;
		}
		for (int i = 0; i < wordArr.length; i++) {
			sb.append(wordArr[i]);
			int answer = dfs(sb, word);
			if(answer != 0) {
				return answer;
			}
			sb.deleteCharAt(sb.length() - 1);
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(solution("AAAAE"));
		System.out.println(solution("AAAE"));
		System.out.println(solution("I"));
		System.out.println(solution("EIO"));
	}
}
