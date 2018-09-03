

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1149 {
	/*
	 * boj 1149 RGB 거리
	 */

	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer ST;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][4];
		int[][] d = new int[N+1][4];
	
		for (int i = 1; i <= N; i++) {
			ST = new StringTokenizer(br.readLine());
			
			map[i][1] = Integer.parseInt(ST.nextToken());
			map[i][2] = Integer.parseInt(ST.nextToken());
			map[i][3] = Integer.parseInt(ST.nextToken());
			
		}
		d[1][1] = map[1][1];
		d[1][2] = map[1][2];
		d[1][3] = map[1][3];
		
		for (int i = 2; i <= N; i++) {
			d[i][1] = Math.min(d[i-1][2], d[i-1][3]) + map[i][1];
			d[i][2] = Math.min(d[i-1][1], d[i-1][3]) + map[i][2];
			d[i][3] = Math.min(d[i-1][1], d[i-1][2]) + map[i][3];
		}
		
		int result = Integer.MAX_VALUE;
		
		for (int i = 1; i <= 3; i++) {
			result = Math.min(d[N][i], result);
		}
		
		bw.write(result+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
