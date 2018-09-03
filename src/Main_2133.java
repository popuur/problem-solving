

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2133 {
	public static void main(String[] args) throws IOException {
		/*
		 * 타일 채우기
		 * https://www.acmicpc.net/problem/2133
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		long[] d = new long[N+1];
		d[0] = 1;
		d[1] = 0;
		if (N > 1) {
			for (int i = 2; i <= N; i+=2) {
				d[i] = d[i-2] * 3;
				for (int j = 4; j <= i; j += 2) {
					d[i] += (2 * d[i-j]);
				}
			}
		}
		
		bw.write(d[N]+"\n");
			
		
		br.close();
		bw.flush();
		bw.close();
	}

}
