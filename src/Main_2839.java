

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2839 {
	/*
	 * 설탕 배달
	 * https://www.acmicpc.net/problem/2839
	 */

	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int[] d = new int[N+1];
		for (int i = 1; i <= N; i++) {
			d[i] = -1;
		}
		
		for (int i = 1; i <= N; i++) {
			
			int i3 = i-3;
			int i5 = i-5;
			int d3 = Integer.MAX_VALUE;
			int d5 = Integer.MAX_VALUE;
			
			if (i3 >= 0) {
				if (d[i3]!= -1) {
					d3 = d[i3]+1;
				}
			}
			if (i5 >= 0) {
				if (d[i5] != -1) {
					d5 = d[i5]+1;	
				}
			}
			if (d3 == Integer.MAX_VALUE && d5 == Integer.MAX_VALUE) continue;
			d[i] = Math.min(d3, d5);
		}
		
		bw.write(d[N]+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
