package hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class practiceUnionFind {
	
	/*
	 * 5/27 Pro시험 Union Find로 만들어봄
	 * 미로에서 만나기
	 */
	
	static int N;
	static int[][] group;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		int[][] map = new int [N+1][N+1];
		group = new int [N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int val = Integer.parseInt(st.nextToken());
				
				map[i][j] = val;
				group[i][j] = (i-1)*N+j;
			}
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				
				if (map[i][j] == 0) {
					
				}
			}
		}
		
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	void union (int a, int b) {
		
		int pa = find(a);
		int pb = find(b);
		
		if (pa == pb) {
			return;
		}
		
		int ai = a/N + 1;
		int aj = a%N;
		group[ai][aj] = b;
		
	}	
	
	int find (int a) {
		int ai = a/N + 1;
		int aj = a%N;
		
		if(group[ai][aj] == a) {
			return a;
		}
	
		return group[ai][aj] = find(group[ai][aj]);
	}
	
	

}
