

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_11437 {

	/*
	 * LCA
	 * https://www.acmicpc.net/problem/11437
	 * 
	 */
	
	static int[] DEP;
	static int[][] PAR;
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		/*
		 * N(2 �� N �� 50,000)���� �������� �̷���� Ʈ���� �־�����. Ʈ���� �� ������ 1������ N������ ��ȣ�� �Ű��� ������, ��Ʈ�� 1���̴�.
		 * �� ����� �� M(1 �� M �� 10,000)���� �־����� ��, �� ����� ���� ����� ���� ������ �� ������ ����Ѵ�.
		 */
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] NODE = new ArrayList[N+1];
		for (int i = 1; i <= N; i++){
			NODE[i] = new ArrayList<Integer>();
		}
		
		PAR = new int[N+1][17];
	    DEP = new int[N+1];
		boolean[] VISIT = new boolean[N+1];
		
		StringTokenizer ST;
		for (int i = 1; i < N; i++){
			ST = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(ST.nextToken());
			int b = Integer.parseInt(ST.nextToken());
			
			NODE[a].add(b);
			NODE[b].add(a);
		}
		
		
	
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(1);
		while(!stk.isEmpty()){
			int edge = stk.pop();
			if (VISIT[edge]) continue;
			
			VISIT[edge] = true;
			for (int next : NODE[edge]){
				if (VISIT[next]) continue;
				
				PAR[next][0] = edge;
				DEP[next] = DEP[edge]+1;
				stk.push(next);
			}
			
		}
		
		for (int k = 1; k < 17; k++){
			for (int i = 1; i <= N; i++){
				PAR[i][k] = PAR[PAR[i][k-1]][k-1];
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= M; i++){
			ST = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(ST.nextToken());
			int b = Integer.parseInt(ST.nextToken());
			
			bw.write(lca(a, b)+"\n");
		}
				
		br.close();
		bw.flush();
		bw.close();
	}
	
	static int lca(int a, int b){
		if (DEP[a] < DEP[b]){
			int temp = a;
			a = b;
			b = temp;
		}
		
		int diff = DEP[a] - DEP[b];
		int res;
		int k = 0;
		
		while (diff != 0){
			res = diff%2;
			diff = diff/2;
			if (res == 1){
				a = PAR[a][k];
			}
			k++;
		}
		if (a == b) return a;
		
		for (int i = 16; i >= 1; i--){
			if (PAR[a][i] != PAR[b][i]){
				a = PAR[a][i];
				b = PAR[b][i];
			}
		}
		
		return PAR[a][0];
		
	}

}
