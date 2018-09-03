

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11052 {
	/*
	 * 붕어빵 판매하기
	 * https://www.acmicpc.net/problem/11052
	 */
	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer ST;
		
		int N = Integer.parseInt(br.readLine());
		ST = new StringTokenizer(br.readLine());
		
		int[] p = new int[N+1];
		int[] d = new int[N+1];
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(ST.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				d[i] = Math.max(d[i], d[i-j]+p[j]);
			}
		}
		
		bw.write(d[N]+"\n");	
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
