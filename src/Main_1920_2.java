

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_2 {
	/*
	 * 수 찾기
	 * https://www.acmicpc.net/problem/1920
	 */
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer ST;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		ST = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(ST.nextToken());
			
		}
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];

		ST = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int m = Integer.parseInt(ST.nextToken());
			
			if (Arrays.binarySearch(A, m) >= 0) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
			
			
			
		}
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	
}
