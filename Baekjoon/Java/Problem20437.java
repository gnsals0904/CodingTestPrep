package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem20437 {
	static int[] numsAlpha = new int[26];
	static List<Queue<Integer>> queueList = new ArrayList<>(26);
	static int K;

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < 26; i++) {
			queueList.add(new LinkedList<Integer>());
		}
		StringBuilder sb = new StringBuilder();
		for (int testcase = 0; testcase < t; testcase++) {
			resetAll();
			String sen = br.readLine();
			K = Integer.parseInt(br.readLine());
			boolean chk = false;
			int min_result = Integer.MAX_VALUE;
			int max_result = Integer.MIN_VALUE;
			for (int i = 0; i < sen.length(); i++) {
			    int sen_num = sen.charAt(i) - 'a';
			    queueList.get(sen_num).add(i);
				numsAlpha[sen_num]++;
				if (numsAlpha[sen_num] == K) {
					chk = true;
					int temp = i - queueList.get(sen_num).poll() + 1;
					min_result = Math.min(min_result, temp);
					max_result = Math.max(max_result, temp);
					numsAlpha[sen_num]--;
				}
			}
			if (!chk) {
				sb.append(-1).append("\n");
			} else {
				sb.append(min_result).append(" ").append(max_result).append("\n");
			}
		}
		System.out.print(sb);
	}

	static void resetAll() {
		for (int i = 0; i < 26; i++) {
			numsAlpha[i] = 0;
			queueList.get(i).clear();
		}
	}
}
	

