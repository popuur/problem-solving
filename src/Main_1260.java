

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1260 {

	static int N, M, V;
	static ArrayList<Integer>[] A;
	static BufferedReader br;
	static BufferedWriter bw;
	static boolean[] Visited;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer ST = new StringTokenizer(br.readLine());

		N = Integer.parseInt(ST.nextToken());
		M = Integer.parseInt(ST.nextToken());
		V = Integer.parseInt(ST.nextToken());

		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		Visited = new boolean[N+1];

		for (int i = 1; i <= M; i++) {
			ST = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(ST.nextToken());
			int b = Integer.parseInt(ST.nextToken());
			
			if (a < 1 || b < 1 || a > N || b > N) continue;

			A[a].add(b);
			A[b].add(a);
		}
	
		for (int i = 1; i <= N; i++) {
			Collections.sort(A[i], new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					if (o1 < o2) {
						return -1;
					} else if (o2 > o1) {
						return 1;
					} else {
						return 0;
					}
				}
					
			});
		}
			
				
		dfs(V);
		Arrays.fill(Visited, false);
		bfs(V);
	
	
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void dfs (int s) throws IOException {
		
		Stack<Integer> stk = new Stack<>();
		stk.push(s);
		Visited[s] = true;
		bw.write(s+" ");
		
		while (!stk.isEmpty()) {
			boolean flag = true;
			int cur = stk.peek();
			
			for(int next : A[cur]) {
				
				if (!Visited[next]) {
					Visited[next] = true;
					flag = false;
					
					bw.write(next+" ");
					stk.push(next);
					break;
				}
			}
			if (flag) {
				int p = stk.pop();
			}
		}
		bw.write("\n");
	}


	static void bfs (int s) throws IOException {

		Queue<Integer> que = new LinkedList<Integer>();
		que.add(s);
		Visited[s] = true;
		while (!que.isEmpty()) {
			
			int cur = que.poll();
			
			bw.write(cur+" ");
			for (int next : A[cur]) {
				if (!Visited[next]) {
					Visited[next] = true;
					
					que.add(next);
				}
			}
				
		}
		bw.write("\n");
	}
	
}
