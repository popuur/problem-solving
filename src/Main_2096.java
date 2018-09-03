

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2096 {
	/*
	 * 내려가기
	 */
	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer ST;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][3];
		
		for (int i =1 ; i <= N; i++) {
			ST = new StringTokenizer(br.readLine());
			
			map[i][0] = Integer.parseInt(ST.nextToken());
			map[i][1] = Integer.parseInt(ST.nextToken());
			map[i][2] = Integer.parseInt(ST.nextToken());
		}
			
		int[][] dmin = new int[N+1][3];
		int[][] dmax = new int[N+1][3];
		
		
		dmin[1][0] = map[1][0];
		dmin[1][1] = map[1][1];
		dmin[1][2] = map[1][2];
		
		
		dmax[1][0] = map[1][0];
		dmax[1][1] = map[1][1];
		dmax[1][2] = map[1][2];

		int max = 0;
		int min = 0;
		
		if (N == 1) {
			max = Math.max(dmax[1][0], Math.max(dmax[1][1], dmax[1][2]));
			min = Math.min(dmin[1][0], Math.min(dmin[1][1], dmin[1][2]));
		} else {
			
			for (int i = 2; i <= N; i++) {
				dmax[i][0] = Math.max(dmax[i-1][0], dmax[i-1][1]) + map[i][0];
				dmax[i][1] = Math.max(dmax[i-1][0], Math.max(dmax[i-1][1], dmax[i-1][2])) + map[i][1];
				dmax[i][2] = Math.max(dmax[i-1][1], dmax[i-1][2]) + map[i][2];
				
				dmin[i][0] = Math.min(dmin[i-1][0], dmin[i-1][1]) + map[i][0];
				dmin[i][1] = Math.min(dmin[i-1][0], Math.min(dmin[i-1][1], dmin[i-1][2])) + map[i][1];
				dmin[i][2] = Math.min(dmin[i-1][1], dmin[i-1][2]) + map[i][2];
			}
			
			
			max = Math.max(dmax[N][0], Math.max(dmax[N][1], dmax[N][2]));
			min = Math.min(dmin[N][0], Math.min(dmin[N][1], dmin[N][2]));
		}
		bw.write(max+" "+min+"\n");	
		br.close();
		bw.flush();
		bw.close();
	}

}
