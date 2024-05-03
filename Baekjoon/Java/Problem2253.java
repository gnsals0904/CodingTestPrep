package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2253 {
	static int N, M;
	static boolean[][] visited;
	static int[] vector = {-1, 0, 1};
	static int result = -1;
	static Queue<Node> queue = new LinkedList<Node>();
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1][N + 1];
		boolean chk = false;
		for(int i = 0; i < M; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp == 2) chk = true;
			Arrays.fill(visited[temp], true);
		}
		
		Arrays.fill(visited[1], true);
		Arrays.fill(visited[2], true);
		
		queue.add(new Node(2, 1));
		bfs();
		if(chk) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
//		System.out.println(Arrays.toString(visited));
	}
	
	static void bfs() {
		int time = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			time++;
			for(int i = 0; i < size; i++) {
				Node node = queue.poll();
//				System.out.println("this node idx : "+node.idx);
				if(node.idx == N) {
					result = time;
					return;
				}
				for(int v : vector) {
					int next_jump = node.pre_jump + v;
					if(next_jump <= 0) continue;
					int next_idx = node.idx + next_jump;
					if(next_idx <= 0 || next_idx > N) continue;
					if(visited[next_idx][next_jump]) continue;
					visited[next_idx][next_jump] = true;
					queue.add(new Node(next_idx, next_jump));
				}
			}

		}
	}
	
	
	static class Node{
		int pre_jump;
		int idx;
		Node(int idx, int pre_jump){
			this.idx = idx;
			this.pre_jump = pre_jump;
		}
	}
}
