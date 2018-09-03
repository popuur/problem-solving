

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {
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
			
			int result = binarySearch(A, m);
			bw.write(result+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	static int binarySearch (int[] A, int m) {
		
		
		int lo = 0;
		int hi = A.length-1;
		
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			
			if (A[mid] > m) {
				hi = mid-1;
			} else if (A[mid] < m) {
				lo = mid+1;
			} else {
				return 1;
			}			
		}
		return 0;
	}
	
	
}
