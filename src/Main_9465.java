

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9465 {
	/*
	 * 스티커
	 * https://www.acmicpc.net/problem/9465
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st, st1;
		
		int T = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= T; ti++) {
			int n = Integer.parseInt(br.readLine());
			int[][] tile = new int[n+1][2];
			int[][] d = new int[n+1][2];
			
			st = new StringTokenizer(br.readLine());
			st1 = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				tile[i][0] = Integer.parseInt(st.nextToken());
				tile[i][1] = Integer.parseInt(st1.nextToken());
			}
			
			d[1][0] = tile[1][0];
			d[1][1] = tile[1][1];
			
			for (int i = 2; i <= n; i++) {
				d[i][0] = Math.max(d[i-1][1], d[i-2][1])+tile[i][0];
				d[i][1] = Math.max(d[i-1][0], d[i-2][0])+tile[i][1];
			}
			
			bw.write(Math.max(d[n][0], d[n][1])+"\n");
		}
				
		br.close();
		bw.flush();
		bw.close();
	}

}
