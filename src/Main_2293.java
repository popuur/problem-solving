

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2293 {
	public static void main(String[] args) throws IOException {
		/*
		 * 동전 1
		 * https://www.acmicpc.net/problem/2293
		 */

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		

		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		
		int[][] d = new int[n+1][k+1];
		
	
		int result = 0;
		d[0][0] = 1;
		for(int i = 1; i <= n; i++) {
			for (int j = 0 ; j <= k; j++) {
				if (i == 0 && j == 0) continue;
				if (j-a[i] < 0) {
					d[i][j] = d[i-1][j];
				} else {
					d[i][j] = d[i-1][j]+d[i][j-a[i]];
				}
				
			}
		}
		
		bw.write(d[n][k]+"\n");
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
