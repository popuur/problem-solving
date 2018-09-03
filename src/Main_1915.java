

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1915 {
	
	/*
	 * 가장 큰 정사각형
	 * https://www.acmicpc.net/problem/1915
	 */
	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][m+1];
		int[][] d = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = s.charAt(j-1)-'0';
			}
		}
		
		
		int result = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 1) {
					d[i][j] = Math.min(d[i-1][j],  Math.min(d[i-1][j-1], d[i][j-1]))+1;
				}
				result = Math.max(result, d[i][j]);
			}
		}
		
		
		bw.write(result*result+"\n");
		
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
