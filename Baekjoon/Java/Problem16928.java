package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16928 {
	public static void main(String[] args) throws IOException {
		Queue<Node> queue = new LinkedList<Node>();
		// 1 ~ 6
		int[] vector = {1, 2, 3, 4, 5, 6};
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] board = new int[101];
		boolean[] visited = new boolean[101];
		Arrays.fill(board, 0);
		Arrays.fill(visited, false);
		for(int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			board[u] = v;
		}
		// start
		queue.add(new Node(1, 0));
		visited[1] = true;
		// go
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for(int v : vector) {
				int np = n.p + v;
				if(np > 100) continue;
				if(visited[np]) continue;
				if(np == 100) {
					System.out.println(n.count + 1);
					return;
				}
				// 평범한 칸
				if(board[np] == 0) {
					visited[np] = true;
					queue.add(new Node(np, n.count + 1));
				}
				// 뱀 또는 사다리
				else {
					visited[board[np]] = true;
					queue.add(new Node(board[np], n.count + 1));
				}
			}
		}
	}
	
	static class Node{
		int p;
		int count;
		Node(int p, int count){
			this.p = p;
			this.count = count;
		}
	}
}
