

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725 {
	/*
	 * 트리의 부모 찾기
	 * https://www.acmicpc.net/problem/11725
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		int[] par = new int[N+1];
		
		Queue<Integer> que = new LinkedList<Integer>();
		int root = 1;
		que.add(root);
		par[root] = root;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			for (int nxt : adjList[cur]) {
				if (par[nxt] == 0) {
					par[nxt] = cur;
					que.add(nxt);
				}
			}
		}
				
		for (int i = 2; i <= N; i++) {
			bw.write(par[i]+"\n");
		}

		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
