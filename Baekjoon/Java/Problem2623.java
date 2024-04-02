package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * [G3] BJ 2623 음악프로그램
 * 메모리 : 12908 KB
 * 시간 : 112 ms
 * 코드 길이 : 2283 B
 * 아이디어 : 가수 출연 순서 관계는 정점과 edge를 이용해서 유향 그래프로 표현할 수 있다.
 * 이때 위상정렬을 사용하면 편리하게 관계를 정리해서 출력할 수 있기 때문에 위상정렬을 사용하였다.
 *
 * @author 김훈민
 * @see <a href="https://www.acmicpc.net/problem/2623">
 *
 */
public class Problem2623 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 나에게 연결된 vertex
		Set<Integer>[] sets = new HashSet[N + 1];
		// 내가 연결된 vertex
		Set<Integer>[] sets2 = new HashSet[N + 1];
		for(int i = 0; i < N + 1; i++) {
			sets[i] = new HashSet<Integer>();
			sets2[i] = new HashSet<Integer>();
		}
		// 입력 받기
		for(int i = 0; i < M; i++) {
			// 1 -> 4 -> 3
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] numlist = new int[num];
			for(int j = 0; j < num; j++) {
				numlist[j] = Integer.parseInt(st.nextToken());
			}
			// 정점과 연결된 정점들 표현
			for(int j = 0; j < num; j++) {
				if(j >= 1) sets[numlist[j]].add(numlist[j - 1]);
				if(j < num - 1) sets2[numlist[j]].add(numlist[j + 1]);
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<>();
		// 나에게 연결된 vertex의 개수만큼 indegree table을 채운다
		int[] indegree = new int[N + 1];
		for(int i = 1; i < N + 1; i++) {
			indegree[i] = sets[i].size();
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		// 위상 정렬 시작
		while(!queue.isEmpty()) {
			int v = queue.poll();
			result.add(v);
			// 나와 연결된 정점의 진입 차수 1씩 감소
			for(int nv : sets2[v]) {
				indegree[nv]--;
				// 진입 차수가 0이면 큐에 넣기
				if(indegree[nv] == 0) {
					queue.add(nv);
				}
			}
		}
		// 위상 정렬이 완료되었는지 체크
		if(result.size() != N) {
			// 완료되지않은 상태
			System.out.println(0);
			return;
		}
		// 완료되었다면
		StringBuilder sb = new StringBuilder();
		for(int r : result) {
			sb.append(r).append("\n");
		}
		System.out.println(sb);
	}
}
