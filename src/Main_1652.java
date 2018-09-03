

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1652 {
	/*
	 * 누울 자리를 찾아라
	 * https://www.acmicpc.net/problem/1652
	 * 
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == '.') {
					map[i][j+1] = 1;
				} else {
					map[i][j+1] = 0;
				}
			}
		}
		
		
		int horizon = 0;
		for (int i = 1; i <= N; i++) {
			int check = 0;
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1) {
					check++;
				} else {
					if (check >= 2) {
						horizon++;
					}
					check = 0;
				}
			}
			if (check >= 2) {
				horizon++;
			}
		}
		
		int vertical = 0;
		for (int i = 1; i <= N; i++) {
			int check = 0;
			for (int j = 1; j <= N; j++) {
				if (map[j][i] == 1) {
					check++;
				} else {
					if (check >= 2) {
						vertical++;
					}
					check = 0;
				}
			}
			if (check >= 2) {
				vertical++;
			}
		}
		
		bw.write(horizon+" "+vertical+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
