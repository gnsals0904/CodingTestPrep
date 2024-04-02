package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * [G3] BJ 2252 줄 세우기
 * 메모리 : 62728 KB
 * 시간 : 540 ms
 * 코드 길이 : 2196 B
 * 아이디어 : 학생들의 관계는 정점과 edge를 이용해서 유향 그래프로 표현할 수 있다.
 * 이때 위상정렬을 사용하면 편리하게 관계를 정리해서 출력할 수 있기 때문에 위상정렬을 사용하였다.
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/12015">
 *
 */
public class Problem2252 {
	public static void main(String[] args) throws IOException {
		// 입력 받기
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// N 명의 학생들의 진입차수를 저장한다
		int[] indegrees = new int[N + 1];
		Arrays.fill(indegrees, 0);
		// 중복저장을 막기 위해서 Set 을 사용한다.
		// sets => 나한테 연결된 애들만 저장
		Set<Integer>[] sets = new HashSet[N + 1];
		// sets2 => 내가 어디로 연결이 되어 있는지를 저장
		Set<Integer>[] sets2 = new HashSet[N + 1];
		for(int i = 0; i < N + 1; i++) {
			sets[i] = new HashSet<Integer>();
			sets2[i] = new HashSet<Integer>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// A -> B
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// 각 관계를 정리한다.
			sets[B].add(A);
			sets2[A].add(B);
		}
		// 위상 정렬
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<Integer>();
		// 진입차수를 계산해서 저장한다
		for(int i = 1; i < N + 1; i++) {
			indegrees[i] = sets[i].size();
			// 진입차수가 0이면 큐에 넣기
			if(indegrees[i] == 0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int v = queue.poll();
			// result 에 추가한다.
			result.add(v);
			// v 와 연결된 애들의 진입 차수를 전부 1 씩 줄인다
			for(int v2 : sets2[v]) {
				indegrees[v2]--;
				// 진입차수가 0이 되었다면 큐에 넣기
				if(indegrees[v2] == 0) {
					queue.add(v2);
				}
			}
		}
		// 결과를 출력한다.
		StringBuilder sb = new StringBuilder();
		for(int r : result) {
			sb.append(r).append(" ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
