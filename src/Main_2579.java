

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2579 {
	
	/*
	 * 계단오르기 
	 * https://www.acmicpc.net/problem/2579
	 */
	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer ST;
		
		int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		
		int[][] d = new int[N+1][3];
		d[1][1] = cost[1];
		d[1][2] = cost[1];
		d[2][1] = d[1][2] + cost[2];
		d[2][2] = cost[2];
		
		for (int i = 3; i <= N; i++) {
			d[i][1] = d[i-1][2] + cost[i];
			d[i][2] = Math.max(d[i-2][1], d[i-2][2]) + cost[i];
			
		}

		
		int result = Math.max(d[N][1], d[N][2]);
		bw.write(result+"\n");
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
